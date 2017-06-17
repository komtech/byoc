package com.starbucks.models;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="promo")
public class PromoReq {

	@Column(name = "CUST_NAME")
	private String custName;
	
	@Column(name = "PROMO_NAME")
	private String promoName;
	
	@XmlElement(name="cust_name")
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
		
	@XmlElement(name="promo_name")
	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
}


