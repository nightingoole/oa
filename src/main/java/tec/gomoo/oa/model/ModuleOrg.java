package tec.gomoo.oa.model;

import xyz.frt.base.model.BaseEntity;

public class ModuleOrg extends BaseEntity {

    private Integer moduleId;

    private Integer orgId;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}