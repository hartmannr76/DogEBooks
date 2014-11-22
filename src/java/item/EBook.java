/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.util.Date;

/**
 *
 * @author Piotr and Ricky
 */
public class EBook extends Item {
    private int edition;
    private String ISBN;
    private String digitalRightsInformation = "";
    private int EBOOK = 1;
    
    
    public EBook(String itemName, int bookId, String bookImg, int itemType, int itemCategory, String author, String ISBN, int initLikes, int initDislikes, int initAvailable, int initLibrary, Date dateAdded) {
        super(itemName, bookId, bookImg, itemType, itemCategory, author, initLikes, initDislikes, initLibrary, initAvailable, dateAdded);
        this.ISBN = ISBN;
        this.setItemType(EBOOK);
    }
    
    public EBook(String itemName, String bookImg, int itemType, int itemCategory, String author, String ISBN, int initAvailable, int initLibrary) {
        super(itemName, bookImg, itemType, itemCategory, author, initLibrary, initAvailable);
        this.ISBN = ISBN;
        this.setItemType(EBOOK);
    }
    
    public String getISBN() {
        return ISBN;
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
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the digitalRightsInformation
     */
    public String getDigitalRightsInformation() {
        return digitalRightsInformation;
    }

    /**
     * @param digitalRightsInformation the digitalRightsInformation to set
     */
    public void setDigitalRightsInformation(String digitalRightsInformation) {
        this.digitalRightsInformation = digitalRightsInformation;
    }

    /**
     * @return the EBOOK
     */
    public int getEBOOK() {
        return EBOOK;
    }

    /**
     * @param EBOOK the EBOOK to set
     */
    public void setEBOOK(int EBOOK) {
        this.EBOOK = EBOOK;
    }
}