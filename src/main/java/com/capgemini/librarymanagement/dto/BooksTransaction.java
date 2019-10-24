package com.capgemini.librarymanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookstransaction")
public class BooksTransaction {
	@Id
	@GeneratedValue
	@Column(name="transaction_id")
	private String transactionId;
	@Column(name="registration_id")
	private String registrationId;
	@Column(name="issue_date")
	private Date issueDate;
	@Column(name="return_date")
	private Date returnDate;
	@Column
	private Integer fine;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issue_date) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String return_date) {
		this.returnDate = returnDate;
	}
	public Integer getFine() {
		return fine;
	}
	public void setFine(Integer fine) {
		this.fine = fine;
	}
	
}
