package com.starbucks.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="transaction")
public class TransactionResp {
	
	@Column(name = "TRAN_ID")
	private Long tranID;
		
	@Column(name = "CUST_ID")
	private Long custID;
	
	@Column(name = "CUST_NAME")
	private String custName;
	
	@Column(name = "TOTAL_TRAN_AMOUNT")
	private BigDecimal totalTranAmount;

	@Column(name = "TRAN_DATETIME")
	private Date tranDateTime;

	@Column(name = "ITEM_TYPE")
	protected String itemType;
	
	@Column(name = "ORDER_ITEM")
	protected String orderItem;
	
	@XmlElement(name="order_item")
	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}
	
	
	@Column(name = "STARS")
	private Long stars;

	@XmlElement(name="tran_id")
	public Long getTranID() {
		return tranID;
	}

	public void setTranID(Long tranID) {
		this.tranID = tranID;
	}

	@XmlElement(name="cust_id")
	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	@XmlElement(name="cust_name")
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@XmlElement(name="total_trans_amount")
	public BigDecimal getTotalTranAmount() {
		return totalTranAmount;
	}

	public void setTotalTranAmount(BigDecimal totalTranAmount) {
		this.totalTranAmount = totalTranAmount;
	}

	@XmlElement(name="tran_datetime")
	public Date getTranDateTime() {
		return tranDateTime;
	}

	public void setTranDateTime(Date tranDateTime) {
		this.tranDateTime = tranDateTime;
	}
	
	@XmlElement(name="item_type")
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@XmlElement(name="stars")
	public Long getStars() {
		return stars;
	}

	public void setStars(Long stars) {
		this.stars = stars;
	}
		
}


