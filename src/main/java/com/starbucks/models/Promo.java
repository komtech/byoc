package com.starbucks.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 * CREATE TABLE `promo` (
  `PROMO_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PROMO_NAME` varchar(100) DEFAULT NULL,
  `PROMO_GOAL` bigint(20) DEFAULT NULL,
  `PROMO_STAR_REWARD` bigint(20) DEFAULT NULL,
  `PROMO_ACTIVE_FLAG` boolean DEFAULT 0,
  `PROMO_START_DATE` datetime NOT NULL,
  `PROMO_END_DATE` datetime NOT NULL,
  PRIMARY KEY (`PROMO_ID`)  
)
*/
@XmlRootElement
@Entity
@Table (name="PROMO")
public class Promo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROMO_ID")
	private Long promoID;
	
	@Column(name = "PROMO_NAME")
	private String promoName;
	
	@Column(name = "PROMO_GOAL")
	private Long promoGoal;
	
	@Column(name = "PROMO_STAR_REWARD")
	private Long PromoStarReward;
	
	@Column(name = "PROMO_ACTIVE_FLAG")
	private boolean promoFlag;
	
	@Column(name = "PROMO_START_DATE")
	private Date promoStartDate;
	
	@Column(name = "PROMO_END_DATE")
	private Date promoEndDate;
	
	@Column(name = "PROMO_PROGRESS")
	private Long promoProgress;
	
	//Getters and Setters

	@XmlElement(name="promo_progress")
	public Long getPromoProgress() {
		return promoProgress;
	}

	public void setPromoProgress(Long promoProgress) {
		this.promoProgress = promoProgress;
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

	@XmlElement(name="promo_flag")
	public boolean isPromoFlag() {
		return promoFlag;
	}

	public void setPromoFlag(boolean promoFlag) {
		this.promoFlag = promoFlag;
	}

	@XmlElement(name="promo_start")
	public Date getPromoStartDate() {
		return promoStartDate;
	}

	public void setPromoStartDate(Date promoStartDate) {
		this.promoStartDate = promoStartDate;
	}

	@XmlElement(name="promo_end")
	public Date getPromoEndDate() {
		return promoEndDate;
	}

	public void setPromoEndDate(Date promoEndDate) {
		this.promoEndDate = promoEndDate;
	}

	
		
}

