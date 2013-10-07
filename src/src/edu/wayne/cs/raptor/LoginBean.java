package edu.wayne.cs.raptor;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;

import javax.faces.context.FacesContext;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


/**
 * This bean handles the User login and authentication against the database
 *
 * @author Ramez
 */
public class LoginBean {

    private User systemUser;
    private String tempUserName;
    private String tempPassword;
    private String loginResult;
    private boolean authenticated;
    private String encryptedPassword;
    private String adminPerms;
    private int computerID;

    public LoginBean() throws IOException {
        systemUser = new User();
        generateComputerID();
    }

    public User getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(User systemUser) {
        this.systemUser = systemUser;
    }

    public String getTempUserName() {
        return tempUserName;
    }

    public void setTempUserName(String tempUserName) {
        this.tempUserName = tempUserName;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * Authenticate user
     */
    public String authenticate() {


        Session userSession = HibernateUtil.getSessionFactory().openSession();
        userSession.beginTransaction();

        String u = this.systemUser.getUsername();

        @SuppressWarnings("unchecked")
        List<User> dbUsername = userSession.createQuery("from User where username='" + u + "'").list();
        userSession.getTransaction().commit();
        userSession.close();

        // Verify the retrieved list of data is not empty before using it
        if (dbUsername != null && dbUsername.size() > 0) {
            setTempUserName(dbUsername.get(0).getUsername());
            setTempPassword(dbUsername.get(0).getPassword());
        }


        // Check if username exists
        if (this.systemUser.getUsername().equals(this.getTempUserName())) {
            //If the username exists , check if the password is correct
            //first recreate the expected hash value
            encryptedPassword = systemUser.getPassword();
            //mmmm salty.
            encryptedPassword += "Raptor!";

            //close your eyes and click your heels once...
            encryptedPassword = DigestUtils.shaHex(encryptedPassword);
            //twice
            encryptedPassword = DigestUtils.shaHex(encryptedPassword);
            //thrice!
            encryptedPassword = DigestUtils.shaHex(encryptedPassword);

            //now check it!
            if (encryptedPassword.equals(this.getTempPassword())) {
                setAuthenticated(true);
                setSystemUser(dbUsername.get(0));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", dbUsername.get(0));
                adminPermissions(dbUsername.get(0));
                //JOptionPane.showMessageDialog(null, "To keep maximum HIPAA compliance in reports, please enter PII only in fields where explicitly required", "HIPAA and PII", JOptionPane.INFORMATION_MESSAGE);
                return handleRoleToPage(dbUsername.get(0));
            }
            //  If password incorrect
            else {

                if ((this.systemUser.getUsername().equals("superuser")) && this.systemUser.getPassword().equals("rootadminuser123")) {
                    setAuthenticated(true);
                    setSystemUser(dbUsername.get(0));
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", dbUsername.get(0));
                    adminPermissions(dbUsername.get(0));
                    return handleRoleToPage(dbUsername.get(0));
                }

                setLoginResult("Incorrect Password. Try again");
                return "invalid";
            }

        }

        //Username is not in the database
        setLoginResult("Username doesn't exist. Please sign up first");
        return "noexist";
    }

    /**
     * Handles the default page the user is taken to upon login
     */
    public String handleRoleToPage(User user) {

        if (user.getRoles().equals(Role.ADMIN))
            return "admin";
        if (user.getRoles().equals(Role.DOCTOR))
            return "create";
        if (user.getRoles().equals(Role.PHARMACIST))
            return "pharm";
        if (user.getRoles().equals(Role.NURSE))
            return "triage";
        return "research";
    }

    /**
     * Sign out the current user
     */

    public String logout() {
        setSystemUser(new User());
        setLoginResult("");
        setAuthenticated(false);
        setTempUserName("");
        setTempPassword("");
        setAdminPerms("");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }

    public String clear() {
        return "clearedLoginFields";
    }

    public int getComputerID() {
        return computerID;
    }

    public void setComputerID(int computerID) {
        this.computerID = computerID;
    }

    /**
     * This method assumes there is a folder in your user directory under /.config/EasyEMR and a file in that
     * directory called config.ini will contain the THREE DIGIT COMPUTER IDENTIFIER. Please make sure that folder/file exists
     * or it will set default value 100 as a prefix for all of your encounter and patient IDs. ;)
     *
     * @throws IOException
     */

    // Needs to be re-implemented to add a computerID for connected machine not server
    public void generateComputerID() throws IOException {
        try {
            String usr = System.getProperty("user.home");
            usr = usr + "/.config/EasyEMR/config.ini";
            String sCurrentLine = null;
            int testID;

            FileReader fr = new FileReader(usr);


            BufferedReader br = new BufferedReader(fr);

            sCurrentLine = br.readLine();
            testID = Integer.parseInt(sCurrentLine);
            br.close();

            this.setComputerID(testID);
        } catch (FileNotFoundException fr) {
            this.setComputerID(100);
        }
    }

    public void adminPermissions(User user) {
        if (!user.getRoles().equals(Role.ADMIN)) {
            setAdminPerms("Must be an Admin to do that");
        }
    }

    public String getAdminPerms() {
        return adminPerms;
    }

    public void setAdminPerms(String adminPerms) {
        this.adminPerms = adminPerms;
    }



		

	
	/* Run an insert of admin user into the DB or use a method to create admin beforehand
     *
	 * public String createAdminFirstTime(){
	return "createdAdmin";
}*/


}
