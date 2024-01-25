package com.hitek.payapp.service;



import com.hitek.payapp.model.CommonResult;
import com.hitek.payapp.model.PayAppAccountResult;

import java.io.IOException;

public interface PayAppService {

    /**
     * 페이앱 결제 요청
     *
     * @param money
     * @return
     * @throws IOException
     */
    PayAppAccountResult requestAccount(double money) throws IOException;


    /**
     * 페이앱 결제 요청 취소
     *
     * @param mulNo : 취소 정보
     * @return
     * @throws IOException
     */
    CommonResult requestAccountCancel(String mulNo) throws IOException;
}
