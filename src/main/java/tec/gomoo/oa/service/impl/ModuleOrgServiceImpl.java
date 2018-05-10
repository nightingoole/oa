package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.ModuleOrgMapper;
import tec.gomoo.oa.model.ModuleOrg;
import tec.gomoo.oa.service.ModuleOrgService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class ModuleOrgServiceImpl extends BaseServiceImpl<ModuleOrg> implements ModuleOrgService {

    private final ModuleOrgMapper moduleOrgMapper;

    @Autowired
    public ModuleOrgServiceImpl(ModuleOrgMapper moduleOrgMapper) {
        this.moduleOrgMapper = moduleOrgMapper;
    }

    @Override
    public BaseMapper<ModuleOrg> getMapper() {
        return moduleOrgMapper;
    }

}
