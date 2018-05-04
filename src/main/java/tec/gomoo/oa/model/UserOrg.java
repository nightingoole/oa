package tec.gomoo.oa.model;


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