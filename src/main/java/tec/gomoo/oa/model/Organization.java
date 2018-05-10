package tec.gomoo.oa.model;

import xyz.frt.base.model.BaseEntity;

public class Organization extends BaseEntity {

    private String orgName;

    private String pid;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}