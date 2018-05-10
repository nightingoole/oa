package tec.gomoo.oa.model;

import xyz.frt.base.model.BaseEntity;

public class ModuleClass extends BaseEntity {

    private String className;

    private Integer pid;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}