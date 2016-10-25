package com.currency.convetor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Currency")
public class Currency {
	@Id
	@Column(name="Country_code",length=3)
	private String country_code ;
	@Column(name="CurrencyName",length=25)
	private String currencyName ;
	@Column(name="Conversion_rate")
	private double conversion_rate ;
	
	
	//constructors
	public Currency() {	super();}
	public Currency(String country_code, String currencyName,
			double conversion_rate) {
		super();
		this.country_code = country_code;
		this.currencyName = currencyName;
		this.conversion_rate = conversion_rate;
	}



	public void setCurrencyName(String currencyName) {this.currencyName = currencyName;}
	public void setCountry_code(String country_code) {this.country_code = country_code;}
	public void setConversion_rate(double conversion_rate) {this.conversion_rate = conversion_rate;}
	

	public String getCurrencyName() {return currencyName;}
	public String getCountry_code() {return country_code;}
	public double getConversion_rate() {return conversion_rate;}
	

	
	
	
	
	
	
	

}
