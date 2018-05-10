package tec.gomoo.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tec.gomoo.oa.dao.OrganizationMapper;
import tec.gomoo.oa.model.Organization;
import tec.gomoo.oa.service.OrganizationService;
import xyz.frt.base.dao.BaseMapper;
import xyz.frt.base.service.impl.BaseServiceImpl;

/**
 * @author phw
 * @date Created in 05-10-2018
 * @description
 */
@Service
@Transactional
public class OrganizationServiceImpl extends BaseServiceImpl<Organization> implements OrganizationService {

    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationMapper organizationMapper) {
        this.organizationMapper = organizationMapper;
    }

    @Override
    public BaseMapper<Organization> getMapper() {
        return organizationMapper;
    }
    
}
