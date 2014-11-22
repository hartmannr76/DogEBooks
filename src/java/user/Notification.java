/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.Date;

/**
 *
 * @author
 * Piotr
 */
public class Notification 
{
 
    private int notificationId;
    private Date dateOfNotification;
    private String notificationText;
    private String hasNotificationBeenSeen;
    private int userID;
    
    public Notification(int initNotificationId, Date initDate, String initText, String initSeen, int initUser)
    {
        notificationId = initNotificationId;
        dateOfNotification = initDate;
        notificationText = initText;
        hasNotificationBeenSeen = initSeen;
        userID = initUser;
    }
    
    
    /**
     * @return the notificationId
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * @param notificationId the notificationId to set
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * @return the dateOfNotification
     */
    public Date getDateOfNotification() {
        return dateOfNotification;
    }

    /**
     * @param dateOfNotification the dateOfNotification to set
     */
    public void setDateOfNotification(Date dateOfNotification) {
        this.dateOfNotification = dateOfNotification;
    }

    /**
     * @return the notificationText
     */
    public String getNotificationText() {
        return notificationText;
    }

    /**
     * @param notificationText the notificationText to set
     */
    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    /**
     * @return the hasNotificationBeenSeen
     */
    public String getHasNotificationBeenSeen() {
        return hasNotificationBeenSeen;
    }

    /**
     * @param hasNotificationBeenSeen the hasNotificationBeenSeen to set
     */
    public void setHasNotificationBeenSeen(String hasNotificationBeenSeen) {
        this.hasNotificationBeenSeen = hasNotificationBeenSeen;
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
