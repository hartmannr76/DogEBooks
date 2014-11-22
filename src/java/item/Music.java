/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.util.Date;

/**
 *
 * @author Piotr
 */
public class Music extends Item {
   
    private int durationOfBook;
    private int numberOfParts;
    private String sampleOfItemDownloadURL;
    private String excerptOfItemDownloadURL;
    private boolean burnToCD;
    private boolean publicPerformance;
    private boolean fileSharing;
    private boolean transferToDevice;
    private boolean peerToPeerUsage;
    private String digitalRights;
    private int MUSIC = 3;
    
    public Music(String itemName, int bookId, String bookImg, int itemType, int itemCategory, String author, String initDigitalRights, String initSample, String initExcerpt, int initDuration, int initLikes, int initDislikes, int initLibraryCopies, int initAvailableCopies, Date dateAdded) 
	{
                super(itemName, bookId, bookImg, itemType, itemCategory, author, initLikes, initDislikes, initLibraryCopies, initAvailableCopies, dateAdded);
		digitalRights = initDigitalRights;
		sampleOfItemDownloadURL = initSample;
		excerptOfItemDownloadURL = initExcerpt;
		durationOfBook = initDuration;
                
                this.setItemType(MUSIC);   
           }

  

    /**
     * @return the durationOfBook
     */
    public int getDurationOfBook() {
        return durationOfBook;
    }

    /**
     * @param durationOfBook the durationOfBook to set
     */
    public void setDurationOfBook(int durationOfBook) {
        this.durationOfBook = durationOfBook;
    }

    /**
     * @return the numberOfParts
     */
    public int getNumberOfParts() {
        return numberOfParts;
    }

    /**
     * @param numberOfParts the numberOfParts to set
     */
    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    /**
     * @return the sampleOfItemDownloadURL
     */
    public String getSampleOfItemDownloadURL() {
        return sampleOfItemDownloadURL;
    }

    /**
     * @param sampleOfItemDownloadURL the sampleOfItemDownloadURL to set
     */
    public void setSampleOfItemDownloadURL(String sampleOfItemDownloadURL) {
        this.sampleOfItemDownloadURL = sampleOfItemDownloadURL;
    }

    /**
     * @return the excerptOfItemDownloadURL
     */
    public String getExcerptOfItemDownloadURL() {
        return excerptOfItemDownloadURL;
    }

    /**
     * @param excerptOfItemDownloadURL the excerptOfItemDownloadURL to set
     */
    public void setExcerptOfItemDownloadURL(String excerptOfItemDownloadURL) {
        this.excerptOfItemDownloadURL = excerptOfItemDownloadURL;
    }

    /**
     * @return the burnToCD
     */
    public boolean isBurnToCD() {
        return burnToCD;
    }

    /**
     * @param burnToCD the burnToCD to set
     */
    public void setBurnToCD(boolean burnToCD) {
        this.burnToCD = burnToCD;
    }

    /**
     * @return the transferToDevice
     */
    public boolean isTransferToDevice() {
        return transferToDevice;
    }

    /**
     * @param transferToDevice the transferToDevice to set
     */
    public void setTransferToDevice(boolean transferToDevice) {
        this.transferToDevice = transferToDevice;
    }

    /**
     * @return the publicPerformance
     */
    public boolean isPublicPerformance() {
        return publicPerformance;
    }

    /**
     * @param publicPerformance the publicPerformance to set
     */
    public void setPublicPerformance(boolean publicPerformance) {
        this.publicPerformance = publicPerformance;
    }

    /**
     * @return the fileSharing
     */
    public boolean isFileSharing() {
        return fileSharing;
    }

    /**
     * @param fileSharing the fileSharing to set
     */
    public void setFileSharing(boolean fileSharing) {
        this.fileSharing = fileSharing;
    }

    /**
     * @return the peerToPeerUsage
     */
    public boolean isPeerToPeerUsage() {
        return peerToPeerUsage;
    }

    /**
     * @param peerToPeerUsage the peerToPeerUsage to set
     */
    public void setPeerToPeerUsage(boolean peerToPeerUsage) {
        this.peerToPeerUsage = peerToPeerUsage;
    }

    /**
     * @return the digitalRights
     */
    public String getDigitalRights() {
        return digitalRights;
    }

    /**
     * @param digitalRights the digitalRights to set
     */
    public void setDigitalRights(String digitalRights) {
        this.digitalRights = digitalRights;
    }
}