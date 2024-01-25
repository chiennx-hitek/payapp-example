package com.hitek.payapp.service;

import com.hitek.payapp.model.CommonResult;
import com.hitek.payapp.model.PayAppAccountResult;
import lombok.RequiredArgsConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PayAppServiceImpl implements PayAppService {

    private final HttpClient httpClient;

    @Value("${pay.app.api.url.root}")
    private String apiURL;

    @Value("${pay.app.user.id}")
    private String payAppId;

    @Value("${pay.app.link.key}")
    private String linkKey;

    @Value("${pay.app.req.feedback.url}")
    private String feedBackUrl;

    @Override
    public PayAppAccountResult requestAccount(double money) throws IOException {
        /*Check enough money*/
        var goodName = "라이브사주";
        var memo = "라이브사주";
        var recvPhone = "+8209898765";// sdt that, co ton tai tai nha mang Han Quoc

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("cmd", "payrequest"));
        urlParameters.add(new BasicNameValuePair("userid", payAppId));
        urlParameters.add(new BasicNameValuePair("goodname", goodName));
        urlParameters.add(new BasicNameValuePair("price", String.valueOf(money)));
        urlParameters.add(new BasicNameValuePair("currency", "krw"));
        urlParameters.add(new BasicNameValuePair("recvphone", recvPhone));
        urlParameters.add(new BasicNameValuePair("memo", memo));
        urlParameters.add(new BasicNameValuePair("smsuse", "y"));
        // 피드백 URL
        urlParameters.add(new BasicNameValuePair("feedbackurl", feedBackUrl));
        // 임의 변수 1
        urlParameters.add(new BasicNameValuePair("var1", UUID.randomUUID().toString()));
        // 임의 변수 2
        urlParameters.add(new BasicNameValuePair("var2", UUID.randomUUID().toString()));
        Map<String, String> mapData = this.getResponseData(urlParameters);
        String state = mapData.get("state");
        String errorMessage = mapData.get("errorMessage");
        String errNo = mapData.get("errno");
        if ("0".equals(state) && "40018".equals(errNo))
            throw new RuntimeException("휴대전화번호를 확인하세요."); // phone incorrect
        String mulNo = mapData.get("mul_no");
        String payUrl = mapData.get("payurl");
        String qrUrl = mapData.get("qrurl");
        return new PayAppAccountResult("1".equals(state), errorMessage, payUrl, qrUrl, mulNo, errNo);
    }

    @Override
    public CommonResult requestAccountCancel(String mulNo) throws IOException {
        var memo = "라이브사주";//replace your memo
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("cmd", "paycancel"));
        urlParameters.add(new BasicNameValuePair("userid", payAppId));
        urlParameters.add(new BasicNameValuePair("linkkey", linkKey));
        urlParameters.add(new BasicNameValuePair("mul_no", mulNo));
        urlParameters.add(new BasicNameValuePair("cancelmemo", memo));
        urlParameters.add(new BasicNameValuePair("feedbackurl", feedBackUrl));
        Map<String, String> mapData = this.getResponseData(urlParameters);
        return getCommonResult(mapData);
    }

    private Map<String, String> getResponseData(List<NameValuePair> urlParameters) throws IOException {
        var post = this.buildHttpPost(urlParameters);
        var response = httpClient.execute(post);
        // 결과를 받아온다.
        var rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = rd.readLine();
        rd.close();
        List<NameValuePair> parseList = URLEncodedUtils.parse(line, StandardCharsets.UTF_8);
        return parseList.stream().collect(Collectors.toMap(NameValuePair::getName, NameValuePair::getValue));
    }

    public HttpPost buildHttpPost(List<NameValuePair> urlParameters) {
        var post = new HttpPost(apiURL);
        /*add header*/
        post.setHeader("User-Agent", "PayApp Java Module");
        post.setEntity(new UrlEncodedFormEntity(urlParameters, StandardCharsets.UTF_8));
        return post;
    }

    private CommonResult getCommonResult(Map<String, String> mapData) {
        String state = mapData.get("state");
        String errorMessage = mapData.get("errorMessage");
        // 결과를 생성한다.
        return new CommonResult("1".equals(state), errorMessage);
    }
}
