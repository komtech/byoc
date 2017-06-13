package com.starbucks.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@XmlRootElement(name="transaction")
//@Entity()
//@Table (name="TRANSACTION")
public class TransactionResp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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


