package com.hitek.payapp.model;

public enum PayMethod {

    METHOD_CARD(1, "카드 결제"),
    PHONE_PAYMENT(2, "휴대폰 결제"),
    OVERSEAS_PAYMENT(3, "해외 결제"),
    FACE_TO_FACE(4, "대면 결제"),
    ACCOUNT_TRANSFER(6, "계좌 이체"),
    VIRTUAL_ACCOUNT(7, "가상 계좌"),
    KAKAO_PAY(15, "카카오페이"),
    NAVER_PAY(16, "네이버페이"),
    PAYMENT_MEMBER(17, "결제한 회원");

    private final int code;
    private final String text;

    PayMethod(final int code, final String text) {
        this.code = code;
        this.text = text;
    }

    public final int getCode() {
        return this.code;
    }

    public String getText() {
        return text;
    }

    public static PayMethod valueOf(int code) {
        for (PayMethod type : PayMethod.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException(PayMethod.class.getName() + " does not have value with code: " + code);
    }
}
