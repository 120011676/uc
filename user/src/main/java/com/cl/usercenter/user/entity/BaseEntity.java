package com.cl.usercenter.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss z", timezone = "GMT+8")
    private Date createDatetime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss z", timezone = "GMT+8")
    private Date updateDatetime;
    private Boolean enable;
}
