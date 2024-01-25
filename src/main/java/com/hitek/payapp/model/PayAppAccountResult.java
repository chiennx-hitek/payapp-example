package com.hitek.payapp.model;

import lombok.Getter;

/**
 * 패이앱 결제요청 결과 
 * @author RED
 *
 */

@Getter
public class PayAppAccountResult
{
	/**
	 * 성공 실패 여부
	 */
	private boolean success;
	
	/**
	 * 실패시 오류 메시지
	 */
	private String errorMessage;
	
	/**
	 * 결제창 URL
	 */
	private String payUrl;

	/**
	 * QR URL
	 */
	private String qrUrl;
	
	/**
	 * 성공시 결제요청 번호
	 */
	private String mulNo;

	/**
	 * 성공시 정기 결제 요청 번호
	 */
	private String reBillNo;
	
	/**
	 * 에러 번호
	 */
	private String errNo;

	public PayAppAccountResult(boolean success, String errorMessage, String payUrl, String qrUrl, String mulNo, String errNo)
	{
		super ();
		this.success = success;
		this.errorMessage = errorMessage;
		this.payUrl = payUrl;
		this.qrUrl = qrUrl;
		this.mulNo = mulNo;
		this.errNo = errNo;
	}
}
