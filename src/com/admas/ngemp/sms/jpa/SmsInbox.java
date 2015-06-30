package com.admas.ngemp.sms.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.james.mime4j.field.datetime.DateTime;

@Entity
@Table(name="sms_inbox")
public class SmsInbox implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9032902834294251178L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="ORG_CODE")
	private String orgCode;
	
	@Column(name="ROUTE")
	private Integer route;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="smsInbox")
	private List<RawMessages> rawMessages;

		
	@Column(name="MSG_ID")
	private String msgId;
	
	@Column(name="MSG_PUSH_ID")
	private String msgPushId;
	
	@Column(name="MSG_STATUS")
	private String msgStatus;
	
	@Column(name="SENT_ON")
	private DateTime sentOn;
	
	@Column(name="DELEVERED_ON")
	private DateTime deleveredOn;
	
	@Column(name="DEL_FLG")
	private String delFlg;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * @return the route
	 */
	public Integer getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Integer route) {
		this.route = route;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the rawMessages
	 */
	public List<RawMessages> getRawMessages() {
		return rawMessages;
	}

	/**
	 * @param rawMessages the rawMessages to set
	 */
	public void setRawMessages(List<RawMessages> rawMessages) {
		this.rawMessages = rawMessages;
	}

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the msgPushId
	 */
	public String getMsgPushId() {
		return msgPushId;
	}

	/**
	 * @param msgPushId the msgPushId to set
	 */
	public void setMsgPushId(String msgPushId) {
		this.msgPushId = msgPushId;
	}

	/**
	 * @return the msgStatus
	 */
	public String getMsgStatus() {
		return msgStatus;
	}

	/**
	 * @param msgStatus the msgStatus to set
	 */
	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	/**
	 * @return the sentOn
	 */
	public DateTime getSentOn() {
		return sentOn;
	}

	/**
	 * @param sentOn the sentOn to set
	 */
	public void setSentOn(DateTime sentOn) {
		this.sentOn = sentOn;
	}

	/**
	 * @return the deleveredOn
	 */
	public DateTime getDeleveredOn() {
		return deleveredOn;
	}

	/**
	 * @param deleveredOn the deleveredOn to set
	 */
	public void setDeleveredOn(DateTime deleveredOn) {
		this.deleveredOn = deleveredOn;
	}

	/**
	 * @return the delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg the delFlg to set
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	
}
