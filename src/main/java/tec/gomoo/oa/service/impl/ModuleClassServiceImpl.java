package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.ModuleClassMapper;
import tec.gomoo.oa.model.ModuleClass;
import tec.gomoo.oa.service.ModuleClassService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class ModuleClassServiceImpl extends BaseServiceImpl<ModuleClass> implements ModuleClassService {

    private final ModuleClassMapper moduleClassMapper;

    @Autowired
    public ModuleClassServiceImpl(ModuleClassMapper moduleClassMapper) {
        this.moduleClassMapper = moduleClassMapper;
    }

    @Override
    public BaseMapper<ModuleClass> getMapper() {
        return moduleClassMapper;
    }


}
