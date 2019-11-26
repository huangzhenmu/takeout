package com.hzm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//规范与前端交互的数据格式
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
}
