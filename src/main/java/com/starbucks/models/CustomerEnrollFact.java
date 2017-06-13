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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROMO_ID")
	private Long promoID;
	
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
	
	@Column(name = "PROMO_START_DATE")
	private Date promoStartDate;
	
	@Column(name = "PROMO_END_DATETIME")
	private Date promoEndDate;
	
	@XmlElement(name="promo_end")
	public Date getPromoEndDate() {
		return promoEndDate;
	}

	public void setPromoEndDate(Date promoEndDate) {
		this.promoEndDate = promoEndDate;
	}

	@Column(name = "CUST_ENROLL_DATE")
	public Date getCustEnrollDate() {
		return custEnrollDate;
	}

	public void setCustEnrollDate(Date custEnrollDate) {
		this.custEnrollDate = custEnrollDate;
	}

	@Column(name = "PROMO_ENROLL_STATUS")
	public String getPromoEnrollStatus() {
		return promoEnrollStatus;
	}

	@Column(name = "CUST_ENROLL_DATETIME")
	private Date custEnrollDate;
	
	@Column(name = "PROMO_PROGRESS")
	private Long promoProgres;
	
	//Getters and Setters

	@XmlElement(name="customer_id")
	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	@XmlElement(name="promo_status")
	public String isPromoEnrollStatus() {
		return promoEnrollStatus;
	}

	public void setPromoEnrollStatus(String promoEnrollStatus) {
		this.promoEnrollStatus = promoEnrollStatus;
	}

	@XmlElement(name="promo_progress")
	public Long getPromoProgres() {
		return promoProgres;
	}

	public void setPromoProgres(Long promoProgres) {
		this.promoProgres = promoProgres;
	}

	@XmlElement(name="promo_id")
	public Long getPromoID() {
		return promoID;
	}

	public void setPromoID(Long promoID) {
		this.promoID = promoID;
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

	@XmlElement(name="promo_star")
	public Long getPromoStarReward() {
		return PromoStarReward;
	}

	public void setPromoStarReward(Long promoStarReward) {
		PromoStarReward = promoStarReward;
	}


	@XmlElement(name="promo_start")
	public Date getPromoStartDate() {
		return promoStartDate;
	}

	public void setPromoStartDate(Date promoStartDate) {
		this.promoStartDate = promoStartDate;
	}
}

