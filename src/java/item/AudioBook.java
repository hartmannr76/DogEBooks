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
public class AudioBook extends Item {
    
    private int durationOfBook;
    private String ISBN;
    private int edition;
    private int numberOfParts;
    private String sampleOfBookDownloadURL;
    private String excerptOfBookDownloadURL;
    private boolean burnToCD;
    private boolean transferToDevice;
    private boolean transferToAppleDevice;
    private boolean publicPerformance;
    private boolean fileSharing;
    private boolean peerToPeerUsage;
    private String digitalRights;
    private int AUDIOBOOK = 2;
    
    public AudioBook(String itemName, int bookId, String bookImg, int itemType, int itemCategory, String author, String initISBN, int initDurationOfBook, String initSample, String initExcerpt, int initLikes, int initDislikes, int initAvailable, int initLibrary, Date dateAdded)
	{
                super(itemName, bookId, bookImg, itemType, itemCategory, author, initLikes, initDislikes, initLibrary, initAvailable, dateAdded);
		ISBN = initISBN;
		durationOfBook = initDurationOfBook;
		sampleOfBookDownloadURL = initSample;
		excerptOfBookDownloadURL = initExcerpt;

                this.setItemType(AUDIOBOOK);
                 
        }
    public AudioBook(String itemName, String bookImg, int itemType, int itemCategory, String author, String initISBN, String initExcerpt, int initLikes, int initDislikes, int initAvailable, int initLibrary, Date dateAdded)
	{
                super(itemName, bookImg, itemType, itemCategory, author, initLibrary, initAvailable);
		ISBN = initISBN;
		excerptOfBookDownloadURL = initExcerpt;

                this.setItemType(AUDIOBOOK);
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
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the edition
     */
    public int getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(int edition) {
        this.edition = edition;
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
     * @return the sampleOfBookDownloadURL
     */
    public String getSampleOfBookDownloadURL() {
        return sampleOfBookDownloadURL;
    }

    /**
     * @param sampleOfBookDownloadURL the sampleOfBookDownloadURL to set
     */
    public void setSampleOfBookDownloadURL(String sampleOfBookDownloadURL) {
        this.sampleOfBookDownloadURL = sampleOfBookDownloadURL;
    }

    /**
     * @return the exerceptOfBookDownloadURL
     */
    public String getExcerptOfBookDownloadURL() {
        return excerptOfBookDownloadURL;
    }

    /**
     * @param exerceptOfBookDownloadURL the exerceptOfBookDownloadURL to set
     */
    public void setExcerptOfBookDownloadURL(String exerceptOfBookDownloadURL) {
        this.excerptOfBookDownloadURL = exerceptOfBookDownloadURL;
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
     * @return the transferToAppleDevice
     */
    public boolean isTransferToAppleDevice() {
        return transferToAppleDevice;
    }

    /**
     * @param transferToAppleDevice the transferToAppleDevice to set
     */
    public void setTransferToAppleDevice(boolean transferToAppleDevice) {
        this.transferToAppleDevice = transferToAppleDevice;
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
