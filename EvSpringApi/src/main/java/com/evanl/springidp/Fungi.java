 package com.evanl.springidp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Each Entity class will have a Service, Service Implementation, Controller, and Repository class.

@Entity
@Table(name = "fungi")
public class Fungi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "fungusId")
	private long fungusId;
	@Column(name = "name", length = 256)
	private String name;
	@Column(name = "scientificName", length = 256)
	private String scientificName;
	@Column(name = "location", length = 256)
	private String location;
	@Column(name = "risk", length = 256)
	private String risk; //safe, caution, dangerous
	@Column(name = "characteristics", length = 1024)
	private String characteristics; //visual appearance

	public Fungi() {} //default constructor
	
	public Fungi( 
			long fungusId,
			String name, 
			String scientificName,
			String location,
			String risk,
			String characteristics) //overloaded constructor
	{
		this.fungusId = fungusId;
		this.name = name;
		this.scientificName = scientificName;
		this.location = location;
		this.risk = risk;
		this.characteristics = characteristics;
	}

	public long getFungusId() {return fungusId;}
	public String getName() {return name;}
	public String getScientificName() {return scientificName;}
	public String getLocation() {return location;}
	public String getRisk() {return risk;}
	public String getCharacteristics() {return characteristics;}
	
	public void setFungusId(long fungusId) {this.fungusId = fungusId;}
	public void setName(String name) {this.name = name;}
	public void setScientificName(String scientificName) {this.scientificName = scientificName;}
	public void setLocation(String location) {this.location = location;}
	public void setRisk(String risk) {this.risk = risk;}
	public void setCharacteristics(String characteristics) {this.characteristics = characteristics;}


}

