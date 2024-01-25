package com.hitek.payapp.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PayAppCashStResult {
    /**
     * 성공 실패 여부
     */
    private boolean success;

    /**
     * 실패시 오류 메시지
     */
    private String errorMessage;


    /**
     * 발행번호
     */
    private String cashStNo;

    /**
     * 발행URL
     */
    private String cashStUrl;


    public PayAppCashStResult(boolean success, String errorMessage, String cashStNo, String cashStUrl) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.cashStNo = cashStNo;
        this.cashStUrl = cashStUrl;
    }
}
