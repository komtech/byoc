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
	private Long promoStarReward;
	
	@Column(name = "PROMO_ACTIVE_FLAG")
	private Short promoActiveFlag;
	
	@Column(name = "PROMO_START_DATE")
	private Date promoStartDate;
	
	@Column(name = "PROMO_END_DATE")
	private Date promoEndDate;
	
	@Column(name = "CUST_ENROLL_DATETIME")
	private Date custEnrollDateTime;
	
	@Column(name = "CUST_ID")
	private Long custId;
	
	@Column(name = "PROMO_ENROLL_STATUS")
	private Short promoEnrollStatus;
	
	@Column(name = "PROMO_PROGRESS")
	private Long promoProgress;

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

	@XmlElement(name="promo_star_reward")
	public Long getPromoStarReward() {
		return promoStarReward;
	}

	public void setPromoStarReward(Long promoStarReward) {
		this.promoStarReward = promoStarReward;
	}

	@XmlElement(name="promo_active_flag")
	public Short getPromoActiveFlag() {
		return promoActiveFlag;
	}

	public void setPromoActiveFlag(Short promoActiveFlag) {
		this.promoActiveFlag = promoActiveFlag;
	}

	@XmlElement(name="promo_start_date")
	public Date getPromoStartDate() {
		return promoStartDate;
	}

	public void setPromoStartDate(Date promoStartDate) {
		this.promoStartDate = promoStartDate;
	}

	@XmlElement(name="promo_end_date")
	public Date getPromoEndDate() {
		return promoEndDate;
	}

	public void setPromoEndDate(Date promoEndDate) {
		this.promoEndDate = promoEndDate;
	}

	@XmlElement(name="cust_enrolled_datetime")
	public Date getCustEnrollDateTime() {
		return custEnrollDateTime;
	}

	public void setCustEnrollDateTime(Date custEnrollDateTime) {
		this.custEnrollDateTime = custEnrollDateTime;
	}

	@XmlElement(name="cust_id")
	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@XmlElement(name="promo_enrolled_status")
	public Short getPromoEnrollStatus() {
		return promoEnrollStatus;
	}

	public void setPromoEnrollStatus(Short promoEnrollStatus) {
		this.promoEnrollStatus = promoEnrollStatus;
	}

	@XmlElement(name="promo_progress")
	public Long getPromoProgress() {
		return promoProgress;
	}

	public void setPromoProgress(Long promoProgress) {
		this.promoProgress = promoProgress;
	}
	
}
