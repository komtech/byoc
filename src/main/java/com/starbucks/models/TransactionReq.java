package com.starbucks.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="transaction")
public class TransactionReq {

//	@Column(name = "CUST_ID")
//	private Long custID;

	@Column(name = "CUST_NAME")
	private String custName;
	


	@Column(name = "TOTAL_TRAN_AMOUNT")
	private BigDecimal totalTranAmount;
	
	@Column(name = "ITEM_TYPE")
	protected String itemType;

	@Column(name = "ORDER_ITEM")
	protected String orderItem;
	
	@XmlElement(name="cust_name")
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
//	@XmlElement(name="cust_id")
//	public Long getCustID() {
//		return custID;
//	}
//
//	public void setCustID(Long custID) {
//		this.custID = custID;
//	}

	@XmlElement(name="total_trans_amount")
	public BigDecimal getTotalTranAmount() {
		return totalTranAmount;
	}

	public void setTotalTranAmount(BigDecimal totalTranAmount) {
		this.totalTranAmount = totalTranAmount;
	}
	
	@XmlElement(name="item_type")
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@XmlElement(name="order_item")
	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

		
}


