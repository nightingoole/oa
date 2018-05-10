package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.UserRoleMapper;
import tec.gomoo.oa.model.UserRole;
import tec.gomoo.oa.service.UserRoleService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public BaseMapper<UserRole> getMapper() {
        return userRoleMapper;
    }
}
