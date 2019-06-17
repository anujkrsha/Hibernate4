package com.dev.hibernate.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ADDRESS")
@Access(value=AccessType.FIELD)
public class Address {
	
	@Id
	@Column(name="Person_id",unique=true,nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters= {@Parameter(name="property",value="person")})
	private long id;
	
	@Column(name="AddressLine1")
	private String addressLine1;
	
	@Column(name="ZipCode")
	private String zipCode;
	
	@Column(name="City")
	private String city;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Person person;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", zipCode=" + zipCode + ", city=" + city + "]";
	}
	
}
