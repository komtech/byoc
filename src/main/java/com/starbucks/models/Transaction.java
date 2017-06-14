package com.starbucks.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * CREATE TABLE `transaction` (
  `TRAN_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CUST_ID` bigint(20) NOT NULL,
  `TOTAL_TRAN_AMOUNT` decimal(10,8) NOT NULL,  
  `TRAN_DATETIME` datetime NOT NULL,
  `ITEM_TYPE` varchar(20) DEFAULT NULL,
  `STARS` bigint(20) NOT NULL,
  PRIMARY KEY (`TRAN_ID`),
  KEY `CUST_FK_idx` (`CUST_ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
@XmlRootElement
@Entity
@Table (name="TRANSACTION")
public class Transaction {

	@Override
	public String toString() {
		return "Transaction [tranID=" + tranID + ",  totalTranAmount=" + totalTranAmount
				+ ", tranDateTime=" + tranDateTime + ", itemType=" + itemType + ", stars=" + stars + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRAN_ID")
	private Long tranID;
	
	
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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


