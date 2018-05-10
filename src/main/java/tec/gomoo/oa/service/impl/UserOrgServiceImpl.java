package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.UserOrgMapper;
import tec.gomoo.oa.model.UserOrg;
import tec.gomoo.oa.service.UserOrgService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */

@Service
@Transactional
public class UserOrgServiceImpl extends BaseServiceImpl<UserOrg> implements UserOrgService {

    private final UserOrgMapper userOrgMapper;

    @Autowired
    public UserOrgServiceImpl(UserOrgMapper userOrgMapper) {
        this.userOrgMapper = userOrgMapper;
    }

    @Override
    public BaseMapper<UserOrg> getMapper() {
        return userOrgMapper;
    }
}
