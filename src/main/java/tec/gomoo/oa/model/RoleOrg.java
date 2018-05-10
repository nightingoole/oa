package tec.gomoo.oa.model;

import xyz.frt.base.model.BaseEntity;

public class RoleOrg extends BaseEntity {

    private Integer roleId;

    private Integer orgId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

}