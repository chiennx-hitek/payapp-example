package com.hitek.payapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CommonResult {

    /**
     * 성공 실패 여부
     */
    private boolean success;

    /**
     * 실패시 오류 메시지
     */
    private String errorMessage;
}
