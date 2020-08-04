package com.hundsun.login.dataobject;

import java.math.BigDecimal;

public class WeeklyinfoDO extends WeeklyinfoDOKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.rpstatus
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer rpStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_done
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer modifyDone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_wait
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer modifyWait;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_cycle_exceed
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer modifyCycleExceed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_bkg
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer modifyBkg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_bkg_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private BigDecimal modifyBkgProp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_bkg_auto
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer modifyBkgAuto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_bkg_auto_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private BigDecimal modifyBkgAutoProp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_autotest
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer modifyAutotest;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_autotest_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private BigDecimal modifyAutotestProp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_case_fb
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer modifyCaseFb;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.modify_case_nfb
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer modifyCaseNfb;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_effective
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsEffective;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_severe
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsSevere;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_normal
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsNormal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_other
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsOther;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_autotast
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsAutotast;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_case_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsCaseReview;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_design_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsDesignReview;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_require_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsRequireReview;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbweeklyinfo.bugs_wait_handle
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    private Integer bugsWaitHandle;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.status
     *
     * @return the value of tbweeklyinfo.status
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getStatus() {
        return rpStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.status
     *
     * @param status the value for tbweeklyinfo.status
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setStatus(Integer status) {
        this.rpStatus = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_done
     *
     * @return the value of tbweeklyinfo.modify_done
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getModifyDone() {
        return modifyDone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_done
     *
     * @param modifyDone the value for tbweeklyinfo.modify_done
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyDone(Integer modifyDone) {
        this.modifyDone = modifyDone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_wait
     *
     * @return the value of tbweeklyinfo.modify_wait
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getModifyWait() {
        return modifyWait;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_wait
     *
     * @param modifyWait the value for tbweeklyinfo.modify_wait
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyWait(Integer modifyWait) {
        this.modifyWait = modifyWait;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_cycle_exceed
     *
     * @return the value of tbweeklyinfo.modify_cycle_exceed
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getModifyCycleExceed() {
        return modifyCycleExceed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_cycle_exceed
     *
     * @param modifyCycleExceed the value for tbweeklyinfo.modify_cycle_exceed
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyCycleExceed(Integer modifyCycleExceed) {
        this.modifyCycleExceed = modifyCycleExceed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_bkg
     *
     * @return the value of tbweeklyinfo.modify_bkg
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getModifyBkg() {
        return modifyBkg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_bkg
     *
     * @param modifyBkg the value for tbweeklyinfo.modify_bkg
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyBkg(Integer modifyBkg) {
        this.modifyBkg = modifyBkg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_bkg_prop
     *
     * @return the value of tbweeklyinfo.modify_bkg_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public BigDecimal getModifyBkgProp() {
        return modifyBkgProp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_bkg_prop
     *
     * @param modifyBkgProp the value for tbweeklyinfo.modify_bkg_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyBkgProp(BigDecimal modifyBkgProp) {
        this.modifyBkgProp = modifyBkgProp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_bkg_auto
     *
     * @return the value of tbweeklyinfo.modify_bkg_auto
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getModifyBkgAuto() {
        return modifyBkgAuto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_bkg_auto
     *
     * @param modifyBkgAuto the value for tbweeklyinfo.modify_bkg_auto
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyBkgAuto(Integer modifyBkgAuto) {
        this.modifyBkgAuto = modifyBkgAuto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_bkg_auto_prop
     *
     * @return the value of tbweeklyinfo.modify_bkg_auto_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public BigDecimal getModifyBkgAutoProp() {
        return modifyBkgAutoProp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_bkg_auto_prop
     *
     * @param modifyBkgAutoProp the value for tbweeklyinfo.modify_bkg_auto_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyBkgAutoProp(BigDecimal modifyBkgAutoProp) {
        this.modifyBkgAutoProp = modifyBkgAutoProp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_autotest
     *
     * @return the value of tbweeklyinfo.modify_autotest
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getModifyAutotest() {
        return modifyAutotest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_autotest
     *
     * @param modifyAutotest the value for tbweeklyinfo.modify_autotest
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyAutotest(Integer modifyAutotest) {
        this.modifyAutotest = modifyAutotest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_autotest_prop
     *
     * @return the value of tbweeklyinfo.modify_autotest_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public BigDecimal getModifyAutotestProp() {
        return modifyAutotestProp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_autotest_prop
     *
     * @param modifyAutotestProp the value for tbweeklyinfo.modify_autotest_prop
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyAutotestProp(BigDecimal modifyAutotestProp) {
        this.modifyAutotestProp = modifyAutotestProp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_case_fb
     *
     * @return the value of tbweeklyinfo.modify_case_fb
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getModifyCaseFb() {
        return modifyCaseFb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_case_fb
     *
     * @param modifyCaseFb the value for tbweeklyinfo.modify_case_fb
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyCaseFb(Integer modifyCaseFb) {
        this.modifyCaseFb = modifyCaseFb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.modify_case_nfb
     *
     * @return the value of tbweeklyinfo.modify_case_nfb
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getModifyCaseNfb() {
        return modifyCaseNfb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.modify_case_nfb
     *
     * @param modifyCaseNfb the value for tbweeklyinfo.modify_case_nfb
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setModifyCaseNfb(Integer modifyCaseNfb) {
        this.modifyCaseNfb = modifyCaseNfb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_effective
     *
     * @return the value of tbweeklyinfo.bugs_effective
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsEffective() {
        return bugsEffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_effective
     *
     * @param bugsEffective the value for tbweeklyinfo.bugs_effective
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsEffective(Integer bugsEffective) {
        this.bugsEffective = bugsEffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_severe
     *
     * @return the value of tbweeklyinfo.bugs_severe
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsSevere() {
        return bugsSevere;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_severe
     *
     * @param bugsSevere the value for tbweeklyinfo.bugs_severe
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsSevere(Integer bugsSevere) {
        this.bugsSevere = bugsSevere;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_normal
     *
     * @return the value of tbweeklyinfo.bugs_normal
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsNormal() {
        return bugsNormal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_normal
     *
     * @param bugsNormal the value for tbweeklyinfo.bugs_normal
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsNormal(Integer bugsNormal) {
        this.bugsNormal = bugsNormal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_other
     *
     * @return the value of tbweeklyinfo.bugs_other
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsOther() {
        return bugsOther;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_other
     *
     * @param bugsOther the value for tbweeklyinfo.bugs_other
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsOther(Integer bugsOther) {
        this.bugsOther = bugsOther;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_autotast
     *
     * @return the value of tbweeklyinfo.bugs_autotast
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsAutotast() {
        return bugsAutotast;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_autotast
     *
     * @param bugsAutotast the value for tbweeklyinfo.bugs_autotast
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsAutotast(Integer bugsAutotast) {
        this.bugsAutotast = bugsAutotast;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_case_review
     *
     * @return the value of tbweeklyinfo.bugs_case_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsCaseReview() {
        return bugsCaseReview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_case_review
     *
     * @param bugsCaseReview the value for tbweeklyinfo.bugs_case_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsCaseReview(Integer bugsCaseReview) {
        this.bugsCaseReview = bugsCaseReview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_design_review
     *
     * @return the value of tbweeklyinfo.bugs_design_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsDesignReview() {
        return bugsDesignReview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_design_review
     *
     * @param bugsDesignReview the value for tbweeklyinfo.bugs_design_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsDesignReview(Integer bugsDesignReview) {
        this.bugsDesignReview = bugsDesignReview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_require_review
     *
     * @return the value of tbweeklyinfo.bugs_require_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsRequireReview() {
        return bugsRequireReview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_require_review
     *
     * @param bugsRequireReview the value for tbweeklyinfo.bugs_require_review
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsRequireReview(Integer bugsRequireReview) {
        this.bugsRequireReview = bugsRequireReview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbweeklyinfo.bugs_wait_handle
     *
     * @return the value of tbweeklyinfo.bugs_wait_handle
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public Integer getBugsWaitHandle() {
        return bugsWaitHandle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbweeklyinfo.bugs_wait_handle
     *
     * @param bugsWaitHandle the value for tbweeklyinfo.bugs_wait_handle
     *
     * @mbg.generated Sun Jun 30 22:32:31 GMT+08:00 2019
     */
    public void setBugsWaitHandle(Integer bugsWaitHandle) {
        this.bugsWaitHandle = bugsWaitHandle;
    }
}