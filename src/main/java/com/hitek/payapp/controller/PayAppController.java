package com.hitek.payapp.controller;


import com.hitek.payapp.model.CommonResult;
import com.hitek.payapp.model.PayAppAccountResult;
import com.hitek.payapp.model.PayAppResult;
import com.hitek.payapp.model.PayMethod;
import com.hitek.payapp.service.PayAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/payapp")
public class PayAppController {

    private final PayAppService service;


    @GetMapping("/request-payment")//    "Send payment request charge money, send from web browers: http:localhost:8080/erp-service/api/v1/payapp/request-payment?money=1000"
    public ResponseEntity<PayAppAccountResult> getRequestChargeMoney(@RequestParam int money) throws IOException {

        PayAppAccountResult result = service.requestAccount(money);
//        service.saveInvoice(chargeId, result.getMulNo());
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/payment-charge-money/success", // "Listen action payment, callback method"
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Void> listenActionPaymentCompleted(HttpServletRequest request) {
        Map<String, String[]> requestBodyMap = request.getParameterMap();
        Map<String, String> body = new HashMap<>();
        requestBodyMap.forEach((key, values) -> body.put(key, values[0]));
        log.info(String.format("------Body input: %s", body));
        int payState = Integer.parseInt(body.get("pay_state"));
        log.info(String.format("------Payment state = %d", payState));
        int payType = Integer.parseInt(body.get("pay_type"));
        log.info(String.format("------Payment type = %d", payType));
        var result = PayAppResult.builder()
            .mulNo(body.get("mul_no"))
            .payType(payType)
            .payState(payState)
            .cardName(body.get("card_name"))
            .build();
        if (PayMethod.VIRTUAL_ACCOUNT.getCode() == payType) {
            /*add vbank information*/
            result.setVbank(body.get("vbank"));
            result.setVbankno(body.get("vbankno"));
            result.setReqDate(body.get("reqdate"));
        }
//        userPaidService.sendNotificationSuccess(result);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/request-cancel/{mulNo}")
//    @ApiOperation(value = "Send payment request cancel")
    public ResponseEntity<CommonResult> paymentReqCancelAction(@PathVariable String mulNo) throws IOException {
        CommonResult result = service.requestAccountCancel(mulNo);
        return ResponseEntity.ok(result);
    }
}
