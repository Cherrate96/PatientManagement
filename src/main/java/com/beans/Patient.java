package com.beans;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	private Integer pId;
	private String pFirstName;
	private String pLastName;
	private String pgender;
	private Long pContactNumber;

	public Patient() {
		super();
	}

	public Patient(Integer pId, String pFirstName, String pLastName, String pgender, Long pContactNumber) {
		super();
		this.pId = pId;
		this.pFirstName = pFirstName;
		this.pLastName = pLastName;
		this.pgender = pgender;
		this.pContactNumber = pContactNumber;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpFirstName() {
		return pFirstName;
	}

	public void setpFirstName(String pFirstName) {
		this.pFirstName = pFirstName;
	}

	public String getpLastName() {
		return pLastName;
	}

	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}

	public String getPgender() {
		return pgender;
	}

	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public Long getpContactNumber() {
		return pContactNumber;
	}

	public void setpContactNumber(Long pContactNumber) {
		this.pContactNumber = pContactNumber;
	}

	@Override
	public String toString() {
		return "Patient [pId=" + pId + ", pFirstName=" + pFirstName + ", pLastName=" + pLastName + ", pgender="
				+ pgender + ", pContactNumber=" + pContactNumber + "]";
	}
		
}
