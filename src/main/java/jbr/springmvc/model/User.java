package jbr.springmvc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "userlist")
@XmlSeeAlso({ User.class })

@XmlType(propOrder = { "username", "password", "firstname", "lastname", "email", "address", "phone","userlist" })

public class User {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private int phone;
	private List<User> userlist;

	public String getUsername() {
		return username;
	}

	@XmlElement(name = "username")
	public void setUsername(String username) {
		System.out.println("username: " + username);
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	@XmlElement(name = "firstname")
	public void setFirstname(String firstname) {
		System.out.println("firstname: " + firstname);
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@XmlElement(name = "lastname")
	public void setLastname(String lastname) {
		System.out.println("lastname: " + lastname);
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	@XmlElement(name = "address")
	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	@XmlElement(name = "phone")
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	 

	public List<User> getUserlist() {
		return userlist;
	}
	
	@XmlElement(name = "users")
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", address=" + address + ", phone=" + phone + "]";
	}

}
