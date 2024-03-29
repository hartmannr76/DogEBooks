/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stf;

import java.util.Date;

/**
 *
 * @author
 * Piotr
 */
public class StaffMessage 
{
    private int messageID;
    private String textOfMessage;
    private String nameOfSender;
    private Date dateOfMessage;
    private int idOfAuthor;
    private int userReceivingMessageId;
    

    public StaffMessage(int initID, String initText, String initSender, Date initDate, int initIdAuthor, int initUserId)
    {
        messageID = initID;
        textOfMessage = initText;
        nameOfSender = initSender;
        dateOfMessage = initDate;
        idOfAuthor = initIdAuthor;
        userReceivingMessageId = initUserId;
    }
            
    
    
    /**
     * @return the messageID
     */
    public int getMessageID() {
        return messageID;
    }

    /**
     * @param messageID the messageID to set
     */
    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    /**
     * @return the textOfMessage
     */
    public String getTextOfMessage() {
        return textOfMessage;
    }

    /**
     * @param textOfMessage the textOfMessage to set
     */
    public void setTextOfMessage(String textOfMessage) {
        this.textOfMessage = textOfMessage;
    }

    /**
     * @return the nameOfSender
     */
    public String getNameOfSender() {
        return nameOfSender;
    }

    /**
     * @param nameOfSender the nameOfSender to set
     */
    public void setNameOfSender(String nameOfSender) {
        this.nameOfSender = nameOfSender;
    }

    /**
     * @return the dateOfMessage
     */
    public Date getDateOfMessage() {
        return dateOfMessage;
    }

    /**
     * @param dateOfMessage the dateOfMessage to set
     */
    public void setDateOfMessage(Date dateOfMessage) {
        this.dateOfMessage = dateOfMessage;
    }

    /**
     * @return the idOfAuthor
     */
    public int getIdOfAuthor() {
        return idOfAuthor;
    }

    /**
     * @param idOfAuthor the idOfAuthor to set
     */
    public void setIdOfAuthor(int idOfAuthor) {
        this.idOfAuthor = idOfAuthor;
    }

    /**
     * @return the userReceivingMessageId
     */
    public int getUserReceivingMessageId() {
        return userReceivingMessageId;
    }

    /**
     * @param userReceivingMessageId the userReceivingMessageId to set
     */
    public void setUserReceivingMessageId(int userReceivingMessageId) {
        this.userReceivingMessageId = userReceivingMessageId;
    }
}
