package com.hitek.payapp.payload;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PayAppCashStCnReq {

    /**
     * 판매자 회원 아이디
     */
    private String payAppId;

    /**
     * 발행번호 (필수)
     */
    private String cashStNo;
}
