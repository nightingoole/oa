package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.RoleOrgMapper;
import tec.gomoo.oa.model.RoleOrg;
import tec.gomoo.oa.service.RoleOrgService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class RoleOrgServiceImpl extends BaseServiceImpl<RoleOrg> implements RoleOrgService {

    private final RoleOrgMapper roleOrgMapper;

    @Autowired
    public RoleOrgServiceImpl(RoleOrgMapper roleOrgMapper) {
        this.roleOrgMapper = roleOrgMapper;
    }

    @Override
    public BaseMapper<RoleOrg> getMapper() {
        return roleOrgMapper;
    }
}
