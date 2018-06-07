package Objects;

import java.sql.Date;

public class UserWithAddress {

	private int userId;
	private String userType;
	private String firstName;
	private String lastname;
	private int phonenumber;
	private String status;
	private Date dateOfBirth;
	private String photo;
	private String username;
	private int addressId;
	private String street;
	private int number;
	private String country;
	private String postalCode;
	private String description;
	private String location;
	
	public UserWithAddress(int userId, String userType, String firstName, String lastName, int phonenumber, String status,
			String photo, Date dateOfBirth, String userName, int addressID, String street, int number, String country, String postalCode, String description, String location) {

		this.setUserId(userId);
		this.userType = userType;
		this.firstName = firstName;
		this.lastname = lastName;
		this.phonenumber = phonenumber;
		this.setStatus(status);
		this.setPhoto(photo);
		this.dateOfBirth = dateOfBirth;
		this.setUserName(userName);
		this.addressId = addressID;
		this.setStreet(street);
		this.setNumber(number);
		this.country = country;
		this.setPostalCode(postalCode);
		this.setDescription(description);
		this.setLocation(location);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirsName(String firstName) {
		this.firstName = firstName;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status != null){
			this.status = status;
		}else{
			this.status = "";
		}
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		if (photo != null){
			this.photo = photo;
		}else{
			this.photo = "";
		}
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		if (username != null){
			this.username = username;
		}else{
			this.username = "";
		}
	}
	public String getDescription() {
		return description;
	}


	public String getLocation() {
		return location;
	}


	public void setDescription(String description) {
		if (description != null){
			this.description = description;
		}else{
			this.description = "";
		}
	}


	public void setLocation(String location) {
		if (location != null){
			this.location = location;
		}else{
			this.location = "";
		}
	}


	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		if (street != null){
			this.street = street;
		}else{
			this.street = "";
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		if (postalCode != null){
			this.postalCode = postalCode;
		}else{
			this.postalCode = "";
		}
	}
}

