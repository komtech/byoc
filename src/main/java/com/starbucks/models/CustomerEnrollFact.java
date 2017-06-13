package com.starbucks.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
CREATE TABLE `cust_promo_enroll_fact` (
  `PROMO_ID` bigint(20) NOT NULL,
  `CUST_ID` bigint(20) NOT NULL,
  `PROMO_NAME` varchar(100) DEFAULT NULL,
  `PROMO_GOAL` bigint(20) DEFAULT NULL,
  `PROMO_STAR_REWARD` bigint(20) DEFAULT NULL,
  `PROMO_ENROLL_STATUS` varchar(30) DEFAULT NULL,
  `CUST_ENROLL_DATETIME` datetime NOT NULL,
  `PROMO_END_DATETIME` datetime NOT NULL,
  `PROMO_PROGRESS` bigint(20) NOT NULL,
   PRIMARY KEY (`PROMO_ID`,`CUST_ID`), 
   KEY `CUST_FK_idx` (`CUST_ID`),
   CONSTRAINT `PROMO_FK` FOREIGN KEY (`PROMO_ID`) REFERENCES `promo` (`PROMO_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
   CONSTRAINT `CUST_FK2` FOREIGN KEY (`CUST_ID`) REFERENCES `customer` (`CUST_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
)
*/
@XmlRootElement
@Entity
@Table (name="cust_promo_enroll_fact")
public class CustomerEnrollFact {
	
	
	
	@Override
	public String toString() {
		return "CustomerEnrollFact [promoID=" + promoID + ", custID=" + custID + ", promoName=" + promoName
				+ ", promoGoal=" + promoGoal + ", PromoStarReward=" + PromoStarReward + ", promoEnrollStatus="
				+ promoEnrollStatus + ", custEnrollDateTime=" + custEnrollDateTime + ", promoEndDate=" + promoEndDate
				+ ", promoProgress=" + promoProgress + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUST_PROMO_ID")
	private Long custPromoID;
	
	@Column(name = "PROMO_ID")
	private Long promoID;
	
	@XmlElement(name="cust_promo_id")
	public Long getCustPromoID() {
		return custPromoID;
	}

	public void setCustPromoID(Long custPromoID) {
		this.custPromoID = custPromoID;
	}

	@Column(name = "CUST_ID")
	private Long custID;
	
	@Column(name = "PROMO_NAME")
	private String promoName;
	
	@Column(name = "PROMO_GOAL")
	private Long promoGoal;
	
	@Column(name = "PROMO_STAR_REWARD")
	private Long PromoStarReward;
	
	@Column(name = "PROMO_ENROLL_STATUS")
	private String promoEnrollStatus;
	
	@Column(name = "CUST_ENROLL_DATETIME")
	private Date custEnrollDateTime;
	
	@Column(name = "PROMO_END_DATETIME")
	private Date promoEndDate;
	
	@Column(name = "PROMO_PROGRESS")
	private Long promoProgress;

	@XmlElement(name="promo_id")
	public Long getPromoID() {
		return promoID;
	}

	public void setPromoID(Long promoID) {
		this.promoID = promoID;
	}

	@XmlElement(name="cust_id")
	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	@XmlElement(name="promo_name")
	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	@XmlElement(name="promo_goal")
	public Long getPromoGoal() {
		return promoGoal;
	}

	public void setPromoGoal(Long promoGoal) {
		this.promoGoal = promoGoal;
	}
	@XmlElement(name="promo_star_reward")
	public Long getPromoStarReward() {
		return PromoStarReward;
	}

	public void setPromoStarReward(Long promoStarReward) {
		PromoStarReward = promoStarReward;
	}

	@XmlElement(name="promo_enroll_status")
	public String getPromoEnrollStatus() {
		return promoEnrollStatus;
	}

	public void setPromoEnrollStatus(String promoEnrollStatus) {
		this.promoEnrollStatus = promoEnrollStatus;
	}

	@XmlElement(name="cust_enroll_datetime")
	public Date getCustEnrollDateTime() {
		return custEnrollDateTime;
	}

	public void setCustEnrollDateTime(Date custEnrollDateTime) {
		this.custEnrollDateTime = custEnrollDateTime;
	}

	@XmlElement(name="promo_end_date")
	public Date getPromoEndDate() {
		return promoEndDate;
	}

	public void setPromoEndDate(Date promoEndDate) {
		this.promoEndDate = promoEndDate;
	}

	@XmlElement(name="promo_progress")
	public Long getPromoProgress() {
		return promoProgress;
	}

	public void setPromoProgress(Long promoProgress) {
		this.promoProgress = promoProgress;
	}





}

