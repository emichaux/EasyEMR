package edu.wayne.cs.raptor;

import java.util.List;

/**
 * Interface containing methods that serve user entities in the system
 * create/save user , retrieve user by id, name or all users (Need better
 * description wording )
 * 
 * TODO: method to void user or retire him/her from database. or delete all
 * together from database
 * 
 * @author Ramez
 * */

public interface IUserService {

	
	public void saveUser(User newUser);

	public User getUser(int userID);

	public User getUserByUsername(String username);
	
	public User getUserByFirstName(String _firstName);
	
	public User getUserByLastName(String _lastName);

	public List<User> getAllUsers();

	




	

}
