/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stf;

/**
 *
 * @author
 * Piotr
 */
public class StaffAccount 
{

        private String userName;
        private String userEmail;
        private String userPassword;
        private String userMobileNumber;
        private int permissionsLevel;
        private int userID;
        
        public StaffAccount(String initName, String initEmail, String initPassword, String initMobile, int initPermissions, int initUserID)
        {
            userName = initName;
            userEmail = initEmail;
            userPassword = initPassword;
            userMobileNumber = initMobile;
            permissionsLevel = initPermissions;
            userID = initUserID;
        }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the userMobileNumber
     */
    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    /**
     * @param userMobileNumber the userMobileNumber to set
     */
    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    /**
     * @return the permissionsLevel
     */
    public int getPermissionsLevel() {
        return permissionsLevel;
    }

    /**
     * @param permissionsLevel the permissionsLevel to set
     */
    public void setPermissionsLevel(int permissionsLevel) {
        this.permissionsLevel = permissionsLevel;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
}
