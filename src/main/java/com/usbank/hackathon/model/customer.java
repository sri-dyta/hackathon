package com.usbank.hackathon.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class customer {
	
	private String customerID;
	
	private String associatedEmail;
	
	@JsonProperty("name")
	private String prefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private String company;
	
	private Date dateOfBirth;
	
	private String taxID;
	
	private String governmentID;
	
	private String [] emails;
	
	private addresses []  addresses;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getAssociatedEmail() {
		return associatedEmail;
	}

	public void setAssociatedEmail(String associatedEmail) {
		this.associatedEmail = associatedEmail;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public String getGovernmentID() {
		return governmentID;
	}

	public void setGovernmentID(String governmentID) {
		this.governmentID = governmentID;
	}

	public String[] getEmails() {
		return emails;
	}

	public void setEmails(String[] emails) {
		this.emails = emails;
	}

	public addresses[] getAddresses() {
		return addresses;
	}

	public void setAddresses(addresses[] addresses) {
		this.addresses = addresses;
	}
	

}
