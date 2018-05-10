package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.ResourceMapper;
import tec.gomoo.oa.model.Resource;
import tec.gomoo.oa.service.ResourceService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

    private final ResourceMapper resourceMapper;

    @Autowired
    public ResourceServiceImpl(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    @Override
    public BaseMapper<Resource> getMapper() {
        return resourceMapper;
    }

}
