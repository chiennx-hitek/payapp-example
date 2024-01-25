package com.hitek.payapp.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class PayAppSubidRegistReq {

    /**
     * 판매자 회원 아이디
     */
    private String payAppId;

    /**
     * 부계정 아이디 (필수)
     */
    private String subUserId;

    /**
     * 부계정 비밀번호 (필수)
     */
    private String subPwd;


    /**
     * 부계정명 (필수)
     */
    private String subName;
}
