package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.ModuleMapper;
import tec.gomoo.oa.model.Module;
import tec.gomoo.oa.service.ModuleService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class ModuleServiceImpl extends BaseServiceImpl<Module> implements ModuleService {

    private final ModuleMapper moduleMapper;

    @Autowired
    public ModuleServiceImpl(ModuleMapper moduleMapper) {
        this.moduleMapper = moduleMapper;
    }

    @Override
    public BaseMapper<Module> getMapper() {
        return moduleMapper;
    }
}
