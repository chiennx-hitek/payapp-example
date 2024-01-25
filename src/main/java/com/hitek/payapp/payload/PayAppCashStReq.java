package com.hitek.payapp.payload;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PayAppCashStReq {

    /**
     * 판매자 회원 아이디
     */
    private String payAppId;

    /**
     * 상품명 (필수)
     */
    private String goodName;

    /**
     * 구매자명 (필수)
     */
    private String buyerName;

    /**
     * 구매자 휴대폰
     */
    private String buyerTel1;

    /**
     * 구매자 이메일
     */
    private String buyerMail;

    /**
     * 휴대폰번호 또는 사업자번호 (필수)
     */
    private String idInfo;

    /**
     * 원거래시각 (필수)
     */
    private String tradTime;

    /**
     * 발행용도(0:소득공제용, 1:지출증빙용) (필수)
     */
    private String trCode;

    /**
     * 거래금액 (필수)
     */
    private String amtTot;

    /**
     * 공급가액 (필수)
     */
    private String amtSup;

    /**
     * 봉사료 (필수)
     */
    private String amtSvc;

    /**
     * 부가가치세 (필수)
     */
    private String amtTax;

    /**
     * 과세:TG01, 면세:TG02 (필수)
     */
    private String corpTaxType;
}
