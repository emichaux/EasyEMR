package edu.wayne.cs.raptor;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Defines a User entity in the system.
 * 
 * @author Sarah Cosgrove
 * @version 1.0
 * @since 2012-10-23
 */
@Entity
@Table( name = "USERS")
public class User implements Serializable {

	/** A unique user identification number */
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int userID;

	/** User's (legal) first name */
    @Column(name = "firstName")
    private String firstName;
	
	/** User's (legal) last name */
    @Column(name = "lastName")
    private String lastName;
	
	/** Username for log in porpoises */
    @Column(name = "username")
    private String username;

	/** Password phrase */
    @Column(name = "password")
    private String password;
	
	/** Roles this user performs.  I.e. pharmacist, researcher, etc.  */
    @Column(name = "roles")
    private String roles;
	
	
	/** 
	 * metadata
	 */
	/** User that created this user */
    @Column(name = "creatingUser")
    private String creatingUser;

	/** Date this user was first created */
    @Column(name = "createdDate")
    private Date createdDate;
	
	/** User to last modify or update this user */
    @Column(name = "modifyingUser")
    private String modifyingUser;
	
	/** Date last modification of this user took place, creation counts as a modification */
    @Column(name = "lastModifiedDate")
    private Date lastModifiedDate;
	
	
	/** Default empty constructor */
	public User() {
	}
	
	public User(String fName, String lName, String username, String password){
		this.firstName = fName;
		this.lastName = lName;
		this.password = password;
		this.username = username;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	/** Retrieves the user name. This function returns the user's name */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the user name. This function sets the user's name to what is
	 * specified in the parameter.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** Retrieves the password. This function returns the user's password */
	public String getPassword() {
		return password;
	}

	/** Sets the password. This function sets the user password  */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getCreatingUser() {
		return creatingUser;
	}

	public void setCreatingUser(String creatingUser) {
		this.creatingUser = creatingUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifyingUser() {
		return modifyingUser;
	}

	public void setModifyingUser(String modifyingUser) {
		this.modifyingUser = modifyingUser;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}



}
