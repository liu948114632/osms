package com.itecheasy.printMethod;

/**
 * @Auther: liteng
 * @Date: 2018/7/26 09:37
 * @Description:
 */
public class CustomerException extends RuntimeException {



    private String retCd ;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public CustomerException(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public CustomerException() {
        super();
    }

    public CustomerException(String message) {
        super(message);
        msgDes = message;
    }



    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }
}
