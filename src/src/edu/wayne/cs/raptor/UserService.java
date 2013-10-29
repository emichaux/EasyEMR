package edu.wayne.cs.raptor;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;

/** This class serves User entities in the system: Creating, retrieving Users
 * 
 *  If the user being searched for is not in database , fields will not populate, maybe 
 *  display an error/notification message 
 *  
 *  TODO: Password will not display after search is performed, if left blank, it's updated to blank in DB
 *  TODO: Still need to check for duplicates, null search fields and null create/add fields 
 *  TODO: Are we going to delete any users or void/retire users.
 *  TODO: Change user/patient/encounter/vitals scope to none instead of session
 *  
 * @author Muhammed, Ramez, Jackson, Tom
 *
 */

public class UserService implements IUserService, Serializable {

	
	private User newUser;
	private LoginBean login;
	private Session userSession;
	private Calendar calendar = Calendar.getInstance();
	
	private String searchUsername;   // the fields to search for user by 
	private String searchFirst;		// need to be reset after search ?
	private String searchLast;
	private boolean isCreating;
	private String encryptedPassword;
	
	private boolean errorPreventedInsert = false;
	
	private String myPassword;
	private List<User> usersList;
	
	
	public UserService(){
		newUser = new User();
		setCreating(true);
	}
	
	public void setLogin(LoginBean login){
		this.login=login;
	}
	
	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	
	public String getSearchUsername() {
		return searchUsername;
	}

	public void setSearchUsername(String searchUsername) {
		this.searchUsername = searchUsername;
	}

	public String getSearchFirst() {
		return searchFirst;
	}

	public void setSearchFirst(String searchFirst) {
		this.searchFirst = searchFirst;
	}

	public String getSearchLast() {
		return searchLast;
	}

	public void setSearchLast(String searchLast) {
		this.searchLast = searchLast;
	}

	public boolean isCreating() {
		return isCreating;
	}

	public void setCreating(boolean isCreating) {
		this.isCreating = isCreating;
	}
	
	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	
	public String userChangeOwnPassword(){
	//	setCreating(true);
		this.login.getSystemUser().setModifyingUser(this.login.getSystemUser().getUsername());
		this.login.getSystemUser().setLastModifiedDate(calendar.getTime());
		
		this.login.getSystemUser().setPassword(myPassword);
		//get the password right before the save...
		encryptedPassword = this.login.getSystemUser().getPassword();
		//mmmm salty. 
		encryptedPassword += "Raptor!";
		
		//close your eyes and click your heels once...
		encryptedPassword = DigestUtils.shaHex(encryptedPassword);
		//twice
		encryptedPassword = DigestUtils.shaHex(encryptedPassword);
		//thrice!
		encryptedPassword = DigestUtils.shaHex(encryptedPassword);
		
		
		//there's no place like home!  (in the database, Toto!)
		this.login.getSystemUser().setPassword(encryptedPassword);

		saveUser(this.login.getSystemUser());

        showErrorPane("Success!", "Record saved!");

		return "user_change_password";
		
	} 

	
	public String switchToUpdateInfo(){
		
		return "user_change_password";
	}
	
	public String cancel(){
		if(this.login.getSystemUser().getRoles().equals(Role.DOCTOR)){

			return "create";
		}
		
		if(this.login.getSystemUser().getRoles().equals(Role.ADMIN)){
			return "admin";
		}
		
		if(this.login.getSystemUser().getRoles().equals(Role.PHARMACIST)){
			return "pharm";
		}

        if(this.login.getSystemUser().getRoles().equals(Role.NURSE)){
            return "triage";
        }
		
		return "research";

		
	}
	
	/** Called on an Add User action */
	public String createUser()
	{
       if(this.login.getSystemUser().getRoles().equalsIgnoreCase("system administrator") ){
            newUser.setCreatingUser(this.login.getSystemUser().getUsername());
            newUser.setCreatedDate(calendar.getTime());
            newUser.setModifyingUser(this.login.getSystemUser().getUsername());
            newUser.setLastModifiedDate(calendar.getTime());

            //get the password right before the save...
            encryptedPassword = newUser.getPassword();
            //mmmm salty.
            encryptedPassword += "Raptor!";

            //close your eyes and click your heels once...
            encryptedPassword = DigestUtils.shaHex(encryptedPassword);
            //twice
            encryptedPassword = DigestUtils.shaHex(encryptedPassword);
            //thrice!
            encryptedPassword = DigestUtils.shaHex(encryptedPassword);


            //there's no place like home!  (in the database, Toto!)
            newUser.setPassword(encryptedPassword);

            //do the same encryption when a user attempts to log in and check the hashes against each other.

            saveUser(newUser);
            newUser = new User();
       }
        else{

           //can return an string I.E "noperms" and use that to display jsf error
           showErrorPane("Insufficient Permissions","Sorry, you do not have administrator access.");
           //return "noperms";

       }
            return "admin";
		
	}

	
	/** Called on an Update User action */
	public String updateUser()
	{
		setCreating(true);
		newUser.setModifyingUser(this.login.getSystemUser().getUsername());
		newUser.setLastModifiedDate(calendar.getTime()); 
		

		//get the password right before the save...
		encryptedPassword = newUser.getPassword();
		//mmmm salty. 
		encryptedPassword += "Raptor!";
		
		//close your eyes and click your heels once...
		encryptedPassword = DigestUtils.shaHex(encryptedPassword);
		//twice
		encryptedPassword = DigestUtils.shaHex(encryptedPassword);
		//thrice!
		encryptedPassword = DigestUtils.shaHex(encryptedPassword);
		
		
		//there's no place like home!  (in the database, Toto!)
		newUser.setPassword(encryptedPassword);
		
		
		saveUser(newUser);
		newUser = new User();
		
		return "admin";
	}
	
	/** Function to search for user by specified parameters */
	public String searchUser()
	{
		setCreating(false);
		if (!this.searchUsername.isEmpty())
			if ( getUserByUsername(this.searchUsername)!=null )
				setNewUser(getUserByUsername(this.searchUsername));			
		if(!this.searchLast.isEmpty())
			if ( getUserByLastName(this.searchLast)!=null )
				setNewUser(getUserByLastName(this.searchLast));	
		if(!this.searchFirst.isEmpty())
			if ( getUserByFirstName(this.searchFirst)!=null )
				setNewUser(getUserByFirstName(this.searchFirst));	
		return "admin";
	}
	
	/** Function to display all users in the system*/
	public String displayAllUsers(){
		setUsersList(getAllUsers());
		return "usersDisplay";
	
	}
	/** Navigate back to admin page and populate user parameters with selected user */
	public String selectUser(){
		setCreating(false);
		return "admin";
	}
	
	
	public String resetFields(){
		setSearchUsername("");
		setSearchFirst("");
		setSearchLast("");
		setCreating(true);
		setNewUser(new User());
		return "admin";
	}
	
	@Override
	public void saveUser(User newUser) {
	
		try
		{
			userSession = HibernateUtil.getSessionFactory().openSession();
			userSession.beginTransaction();
			userSession.saveOrUpdate(newUser);
			userSession.getTransaction().commit();
			userSession.close();
		}
		catch(Exception ex)
		{
            showErrorPane("Error", "Error in saving user.");
			errorPreventedInsert = true;
		}
		
		if(errorPreventedInsert == false)
		{
            showErrorPane("Success!", "User saved!");
		}
		errorPreventedInsert = false;
	}

	/** This method will return the user with the specified userID. 
	 *   This might not be needed from the point of view of a client but could be useful for us */
	@SuppressWarnings("unchecked")
	@Override
	public User getUser(int _userID) {
		try
		{
			userSession = HibernateUtil.getSessionFactory().openSession();
			userSession.beginTransaction();
		}
		catch(Exception ex)
		{
			//JOptionPane.showMessageDialog(null, "Database error in opening session or transaction. " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		List<User> result = userSession.createQuery("from User user where user.userID='" + _userID + "'").list();
		
		//is this commit really necessary since we are not inserting records?
		try
		{
			userSession.getTransaction().commit();
			userSession.close();
		}
		catch(Exception ex)
		{
			//JOptionPane.showMessageDialog(null, "Database error in committing transaction or closing session. " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		//should be only one result here since userID is a unique PK in the DB
		if(!result.isEmpty())
			return result.get(0);
		else
			return null;
	}

	/** This method will return the user with the specified username. */
	@Override
	public User getUserByUsername(String _username) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> result = userSession.createQuery("from User user where user.username='" + _username + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		//this field should be unique in the DB as well, so the result list should contain only one record.  
		if(!result.isEmpty())
			return result.get(0);
		return null;
	}
	
	/** This method will return the user with the specified first name. */
	@Override
	public User getUserByFirstName(String _firstName) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> firstNameResult = userSession.createQuery("from User user where user.firstName='" + _firstName + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		//this field should be unique in the DB as well, so the result list should contain only one record.  
		if(!firstNameResult.isEmpty())
			return firstNameResult.get(0);
		else
			return null;
	}
	
	/**  This method will return the user with the specified last name. */
	@Override
	public User getUserByLastName(String _lastName) {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> lastNameResult = userSession.createQuery("from User user where user.lastName='" + _lastName + "'").list();
		userSession.getTransaction().commit();
		userSession.close();
		
		//this field should be unique in the DB as well, so the result list should contain only one record.  
		if(!lastNameResult.isEmpty())
			return lastNameResult.get(0);
		else
			return null;
	}

	@Override
	public List<User> getAllUsers() {
		userSession = HibernateUtil.getSessionFactory().openSession();
		userSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> result = userSession.createQuery( "from User" ).list();
		userSession.getTransaction().commit(); 
		userSession.close();
		
		if(!result.isEmpty())
			return result;
		else
			return null;
	}

	public String getMyPassword() {
		return myPassword;
	}

	public void setMyPassword(String myPassword) {
		this.myPassword = myPassword;
	}


    private static void showErrorPane(String title, String message) {
        JOptionPane pane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = pane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }


	

}
