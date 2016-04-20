package com.test.database.model;

import android.text.TextUtils;

public class AddressInfo {

	private String addrDetail;
	private String addrPinyin;
	
	public AddressInfo() {
		// TODO Auto-generated constructor stub
	}

	public AddressInfo(String addrDetail, String addrPinyin) {
		super();
		this.addrDetail = addrDetail;
		this.addrPinyin = addrPinyin;
	}
	
	public String getAddrDetail() {
		if (TextUtils.isEmpty(addrDetail)) {
			return "";
		}
		return addrDetail;
	}

	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}

	public String getAddrPinyin() {
		if (TextUtils.isEmpty(addrPinyin)) {
			return "";
		}
		return addrPinyin;
	}

	public void setAddrPinyin(String addrPinyin) {
		this.addrPinyin = addrPinyin;
	}
	
	
}
