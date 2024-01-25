package com.hitek.payapp.payload;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayAppAccountReq {

    /**
     * 판매자 회원 아이디
     */
    private String payAppId;

    /**
     * 상품명
     */
    private String goodName;

    /**
     * 상품 금액
     */
    private double price;

    /**
     * 수신 핸드폰
     */
    private String recvPhone;

    /**
     * 메모
     */
    private String memo;

    /**
     * 피드백 URL
     */
    private String feedBackUrl;

    /**
     * 추가 값1
     */
    private String val1;

    /**
     * 추가 값2
     */
    private String val2;

    /**
     * SMS 발송 여부
     */
    private boolean sendSms;

    /**
     * 정기 결제 타입 ( Month,Week,Day )
     */
    private String reBillCycleType;

    /**
     * 월 정기결제 결제일 (1~31,90:말일)
     */
    private String reBillCycleMonth;

    /**
     * 정기결제 만료일 (yyyy-mm-dd)
     */
    private String reBillExpire;

    @Builder
    public PayAppAccountReq(String payAppId, String goodName, double price, String recvPhone, String memo, boolean sendSms) {
        this.payAppId = payAppId;
        this.goodName = goodName;
        this.price = price;
        this.recvPhone = recvPhone;
        this.memo = memo;
        this.sendSms = sendSms;
    }
}
