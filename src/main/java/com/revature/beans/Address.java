package com.revature.beans;

public class Address {

	private int addressId;
  private String line;
  private String city;
  private String state;
  private String country;
  private String postalCode;
  
	public Address() {
		super();
	}
	public Address(int addressId, String line, String city, String state, String country, String postalCode){
		super();
		this.addressId = addressId;
    this.line = line;
    this.addressId = addressId;
		this.state = state;
		this.country = country;
    this.postalCode = postalCode;
	}

  public int compareTo(Address that) {
    final int BEFORE = -1;
    final int EQUAL = -0;
    final int AFTER = 1;
    
    if(this == that) return EQUAL;
    if(this.getAddressId() < that.getAddressId()) return BEFORE;
    if(this.getAddressId() > that.getAddressId()) return AFTER;
    
    return EQUAL;
  }
	@Override
	public String toString() {
		return "Address [id=" + addressId + ", line=" + line + "addressId=" + addressId + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + "]"; 
	}

  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }
  public int getAddressId() {
    return addressId;
  }
  public void setLine(String line) {
    this.line = line;
  }
  public String getLine() {
    return line;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getState() {
    return state;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getCountry() {
    return country;
  }
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }
  public String getPostalCode() {
    return postalCode;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getCity() {
    return city;
  }
}
