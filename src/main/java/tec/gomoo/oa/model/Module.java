package tec.gomoo.oa.model;

import xyz.frt.base.model.BaseEntity;

public class Module extends BaseEntity {

    private String moduleName;

    private Integer classId;

    private Integer pid;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}