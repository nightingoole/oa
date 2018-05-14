package tec.gomoo.oa.form;

import xyz.frt.base.form.BaseFormEntity;

/**
 * @author phw
 * @date Created in 05-14-2018
 * @description
 *          面试流程表单对象
 */
public class OnboardingRequestForm extends BaseFormEntity {

    private String fullName;
    private String yearsOfExperience;

    private String personalWelcomeTime;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getPersonalWelcomeTime() {
        return personalWelcomeTime;
    }

    public void setPersonalWelcomeTime(String personalWelcomeTime) {
        this.personalWelcomeTime = personalWelcomeTime;
    }
}
