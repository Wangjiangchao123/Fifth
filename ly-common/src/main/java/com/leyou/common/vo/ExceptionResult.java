package com.leyou.common.vo;


import com.leyou.common.enums.ExceptionEnums;
import lombok.Data;

@Data
public class ExceptionResult {

    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnums em){
        this.status = em.getCode();
        this.message= em.getMsg();
        this.timestamp = System.currentTimeMillis();  //获取时间戳
    }
}
