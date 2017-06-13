package com.starbucks.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*CREATE TABLE `customer` (
		  `CUST_ID` bigint(20) NOT NULL AUTO_INCREMENT,
		  `CUST_NAME` varchar(100) DEFAULT NULL,
		  `CUST_STAR_PURSE` bigint(20) DEFAULT NULL,
		  `REUSE_CUP_PURSE` bigint(20) DEFAULT NULL,
		  `TREES_PRESERVED` decimal(10,8) NOT NULL,
		  `CARBON_REDUCTION` decimal(10,8) NOT NULL,
		  PRIMARY KEY (`CUST_ID`)  
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
@XmlRootElement
@Entity
@Table (name="CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUST_ID")
	private Long custID;

	@Column(name = "CUST_NAME")
	private String custName;
	
	@Column(name = "CUST_STAR_PURSE")
	private Long custStarPurse;
	
	@Column(name = "REUSE_CUP_PURSE")
	private Long reuseCupPurse;
	
	@Column(name = "TREES_PRESERVED")
	private BigDecimal treesPreserved;
	
	@Column(name = "CARBON_REDUCTION")
	private BigDecimal carbonReduction;

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

	@XmlElement(name="cust_star_purse")
	public Long getCustStarPurse() {
		return custStarPurse;
	}

	public void setCustStarPurse(Long custStarPurse) {
		this.custStarPurse = custStarPurse;
	}

	@XmlElement(name="reuse_cup_purse")
	public Long getReuseCupPurse() {
		return reuseCupPurse;
	}

	public void setReuseCupPurse(Long custCupPurse) {
		this.reuseCupPurse = custCupPurse;
	}

	@XmlElement(name="trees_preserved")
	public BigDecimal getTreesPreserved() {
		return treesPreserved;
	}

	public void setTreesPreserved(BigDecimal treesPreserved) {
		this.treesPreserved = treesPreserved;
	}

	@XmlElement(name="carbon_reduced")
	public BigDecimal getCarbonReduction() {
		return carbonReduction;
	}

	public void setCarbonReduction(BigDecimal carbonReduction) {
		this.carbonReduction = carbonReduction;
	}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", custName=" + custName + ", custStarPurse=" + custStarPurse
				+ ", reuseCupPurse=" + reuseCupPurse + ", treesPreserved=" + treesPreserved + ", carbonReduction="
				+ carbonReduction + "]";
	}
		
}

