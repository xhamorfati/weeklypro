package com.hundsun.login.error;

public enum EmBusinessError implements CommonError {

    //通用错误类型100001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOW_ERROR(10002,"未知错误"),
    //2000开头为用户相关错误
    USER_NOT_EXIST(20001,"用户不存在"),
    USER_PASSWORD_ERROR(20002,"密码错误"),
    SQL_ERROR(20003,"sql执行错误")
    ;

    private int errCode;
    private String errMsg;

    private EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    //改动通用错误的errMsg
    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
