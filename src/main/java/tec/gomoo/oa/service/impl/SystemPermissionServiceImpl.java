package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.SystemPermissionMapper;
import tec.gomoo.oa.model.SystemPermission;
import tec.gomoo.oa.service.SystemPermissionService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class SystemPermissionServiceImpl extends BaseServiceImpl<SystemPermission> implements SystemPermissionService {

    private final SystemPermissionMapper systemPermissionMapper;

    @Autowired
    public SystemPermissionServiceImpl(SystemPermissionMapper systemPermissionMapper) {
        this.systemPermissionMapper = systemPermissionMapper;
    }

    @Override
    public BaseMapper<SystemPermission> getMapper() {
        return systemPermissionMapper;
    }
}
