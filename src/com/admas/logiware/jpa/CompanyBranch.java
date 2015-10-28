package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.admas.logiware.dto.CompanyBranchDto;

@Entity
@Table(name="cust_comp_branch")
public class CompanyBranch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4190526634246757540L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="COMP_ID" ,nullable = false )
	private Integer compId;
	
	@Column(name="NAME" ,nullable = false )
	private String name;
	
	@Column(name="ADDRESS" ,nullable = false )
	private String address;
	
	@Column(name="CONTACT_NO" ,nullable = false )
	private String contactNo;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="DEL_FLAG")
	private Character delFlag;
	

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	public Character getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompBranch [id=" + id + ", compId=" + compId + ", name=" + name
				+ ", address=" + address + ", contactNo=" + contactNo
				+ ", emailId=" + emailId + "]";
	}
	
	public CompanyBranchDto _toDto(){
		CompanyBranchDto companyBranchDto = new CompanyBranchDto();
		companyBranchDto.setAddress(this.address);
		companyBranchDto.setCompId(this.compId);
		companyBranchDto.setContactNo(this.contactNo);
		companyBranchDto.setEmailId(this.emailId);
		companyBranchDto.setId(this.id);
		companyBranchDto.setName(this.name);
		return companyBranchDto;
	}
	

}
