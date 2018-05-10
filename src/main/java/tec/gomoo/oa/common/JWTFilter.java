package tec.gomoo.oa.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tec.gomoo.oa.model.Permission;
import tec.gomoo.oa.service.PermissionService;
import xyz.frt.base.util.AppConst;
import xyz.frt.base.util.BaseUtils;
import xyz.frt.base.util.JWTUtil;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author phw
 * @date Created in 04-09-2018
 * @description
 */
@Slf4j
@Component
public class JWTFilter extends AccessControlFilter {

    private final PermissionService permissionService;

    @Autowired
    public JWTFilter(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return getSubject(servletRequest, servletResponse) != null && getSubject(servletRequest, servletResponse).isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String requestToken = req.getHeader(AppConst.KEY_AUTHORIZATION);
        if (BaseUtils.isNullOrEmpty(requestToken)) {
            res.sendRedirect("/401");
            //out(servletResponse, JSON.toJSONString(JsonResult.error(401, "Token invalid, Try re-login.")));
            return false;
        }
        //Verify token
        try {
            Map<String, Object> map = JWTUtil.parserJwt(requestToken);
            Integer id = Integer.valueOf((String) map.get(AppConst.KEY_ID));
            if (BaseUtils.isNullOrEmpty(id)) {
                return false;
            }

            JWTToken token = new JWTToken(requestToken, req.getRemoteHost());
            SecurityUtils.getSubject().login(token);

            String uri = req.getRequestURI();
            if (uri.indexOf("/", 1) != -1) {
                String[] temps = uri.substring(uri.indexOf("/", 1), uri.length()).split("/");
                StringBuilder result = new StringBuilder();
                for (String str: temps) {
                    if (!BaseUtils.isNullOrEmpty(str)) {
                        str = BaseUtils.replaceInteger(str);
                        result.append("/").append(str);
                    }
                }
                uri = uri.substring(uri.indexOf("/", 0), uri.indexOf("/", 1)) + result.toString();
                log.info(uri);
            }

            String method = req.getMethod();
            log.info(method + ":" + uri);
            Permission permissionExample = new Permission();
            permissionExample.setUrl(uri);
            permissionExample.setMethod(method);
            List<Permission> permissions = permissionService.selectByConditions(permissionExample);
            if (BaseUtils.isNullOrEmpty(permissions)) {
                res.sendRedirect("/403");
                //out(servletResponse, JSON.toJSONString(JsonResult.error(403, "Access forbidden: Unknown request uri")));
                return false;
            }
            //获取当前操作需要的权限
            Permission permission = permissions.get(0);
            String init = permission.getInit();
            if (init.equals(AppConst.KEY_ANON)) {
                return true;
            } else if (init.equals(AppConst.KEY_LOGOUT)) {
                return true;
            } else if (init.equals(AppConst.KEY_AUTHC)) {
                if (SecurityUtils.getSubject().isAuthenticated()) {
                    return true;
                }
                res.sendRedirect("/401");
                //out(servletResponse, JSON.toJSONString(JsonResult.error(401, "Authenticated failed, Try re-login")));
                return false;
            } else if (init.startsWith("perms[") && init.endsWith("]")) {
                if (SecurityUtils.getSubject().isPermitted(init)) {
                    return true;
                }
                res.sendRedirect("/403");
                //out(servletResponse, JSON.toJSONString(JsonResult.error(403, "Access forbidden: You didn't have permission")));
                return false;
            } else {
                res.sendRedirect("/403");
                //out(servletResponse, JSON.toJSONString(JsonResult.error(403, "Unknown access control symbol")));
                return false;
            }


        } catch (Exception e) {
            res.sendRedirect("/401");
            //out(servletResponse, JSON.toJSONString(JsonResult.error(401, "Invalid token, Please login first.")));
            return false;
        }
    }

    /*private void out(ServletResponse res, String content) {
        try {
            PrintWriter out = res.getWriter();
            res.setContentType("application/json; charset=utf-8");
            out.println(content);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
