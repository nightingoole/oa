package tec.gomoo.oa.model;


import xyz.frt.base.model.BaseEntity;

public class UserOrg extends BaseEntity {

    private Integer userId;

    private Integer orgId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

}