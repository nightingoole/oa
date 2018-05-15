package tec.gomoo.oa.form;

import tec.gomoo.oa.config.ActivitiService;
import xyz.frt.base.form.BaseFormEntity;

/**
 * @author phw
 * @date Created in 05-14-2018
 * @description
 *          请假流程表单对象
 */
public class OnVocationRequestForm extends BaseFormEntity {

    private String username;
    private String department;
    private String startTime;
    private String endTime;
    private String reason;

    private String dprtAppOppo;
    private String mgrAppOppo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDprtAppOppo() {
        return dprtAppOppo;
    }

    public void setDprtAppOppo(String dprtAppOppo) {
        this.dprtAppOppo = dprtAppOppo;
    }

    public String getMgrAppOppo() {
        return mgrAppOppo;
    }

    public void setMgrAppOppo(String mgrAppOppo) {
        this.mgrAppOppo = mgrAppOppo;
    }

}
