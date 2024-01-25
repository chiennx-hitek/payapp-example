package com.hitek.payapp.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayAppAccountCancelReq {

    /**
     * 판매자 회원 아이디
     *//*
    private String payAppId;

    *//**
     * 연동 KEY (필수)
     *//*
    private String linkKey;*/

    /**
     * 결제요청번호 (필수)
     */
    private String mulNo;

    /**
     * 정기 결제 요청 번호
     *//*
    private String reBillNo;

    *//**
     * 결제요청취소 메모
     *//*
    private String cancelMemo;

    *//**
     * 결제요청취소 모드
     * (값이 ready 인 경우 결제요청 상태만 취소 가능)
     *//*
    private String cancelMode;*/
}
