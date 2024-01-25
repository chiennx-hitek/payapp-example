package com.hitek.payapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayAppResult {
    private String mulNo;

    private int payState;

    private int payType;

    private String cardName;

    private String vbankno;

    private String vbank;

    private String reqDate;
}
