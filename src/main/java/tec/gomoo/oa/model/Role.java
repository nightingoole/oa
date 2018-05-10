package tec.gomoo.oa.model;

import xyz.frt.base.model.BaseEntity;

public class Role  extends BaseEntity {

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

}