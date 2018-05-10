package tec.gomoo.oa.config;

import io.jsonwebtoken.SignatureException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.gomoo.oa.common.JWTToken;
import tec.gomoo.oa.model.Permission;
import tec.gomoo.oa.model.Role;
import tec.gomoo.oa.model.SystemPermission;
import tec.gomoo.oa.model.UserRole;
import tec.gomoo.oa.service.PermissionService;
import tec.gomoo.oa.service.RoleService;
import tec.gomoo.oa.service.SystemPermissionService;
import tec.gomoo.oa.service.UserRoleService;
import xyz.frt.base.util.AppConst;
import xyz.frt.base.util.BaseUtils;
import xyz.frt.base.util.JWTUtil;
import xyz.frt.base.util.UnauthorizedException;

import java.util.List;
import java.util.Map;

/**
 * @author phw
 * @date Created in 04-08-2018
 * @description
 */
@Service
public class MyShiroRealm extends AuthorizingRealm {

    private final UserRoleService userRoleService;

    private final RoleService roleService;

    private final SystemPermissionService systemPermissionService;

    private final PermissionService permissionService;

    @Autowired
    public MyShiroRealm(UserRoleService userRoleService, RoleService roleService, SystemPermissionService systemPermissionService, PermissionService permissionService) {
        this.userRoleService = userRoleService;
        this.roleService = roleService;
        this.systemPermissionService = systemPermissionService;
        this.permissionService = permissionService;
    }

    @Override
    public Class getAuthenticationTokenClass() {
        return JWTToken.class;//This realm only support JWTToken
    }

    /**
     * 重写Shiro获取用户信息的方法
     * @param authenticationToken token
     * @return 用户信息
     * @throws AuthenticationException e
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JWTToken jwtToken = (JWTToken) authenticationToken;
        String token = (String) jwtToken.getPrincipal();

        //Some problems
        Map<String, Object> map;
        try {
             map = JWTUtil.parserJwt(token);
        } catch (SignatureException e) {
            //e.printStackTrace();
            throw new UnauthorizedException(401, e.getMessage());
        }
        //Update user's token


        return new SimpleAuthenticationInfo(map, Boolean.TRUE, getName());
    }

    /**
     * 只用当用户需要检测权限的时候才会用到这个方法
     * @param principalCollection p
     * @return 身份信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Map<String, String>> list = principalCollection.asList();
        Map<String, String> dataMap = list.get(0);
        if (BaseUtils.isNullOrEmpty(dataMap)) {
            return null;
        }
        String userId = dataMap.get(AppConst.KEY_ID);
        UserRole userRoleExample = new UserRole();
        userRoleExample.setUserId(Integer.valueOf(userId));
        //为shiro添加角色信息和权限信息
        for (UserRole userRole: userRoleService.selectByConditions(userRoleExample)) {
            Integer roleId = userRole.getRoleId();
            Role role = roleService.selectByPrimaryKey(roleId);
            info.addRole(role.getRole());
            SystemPermission systemPermissionExample = new SystemPermission();
            systemPermissionExample.setRoleId(roleId);
            for (SystemPermission sp: systemPermissionService.selectByConditions(systemPermissionExample)) {
                Integer permissionId = sp.getPermissionId();
                Permission permission = permissionService.selectByPrimaryKey(permissionId);
                info.addStringPermission(permission.getInit());
            }
        }


        return info;
    }
}
