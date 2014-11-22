/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import enums.Category;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Piotr and Ricky
 */
public class Item implements Serializable {
    private String itemName;
    private String author;
    private int availableCopies;
    private int libraryCopies;
    private Vector<String> languagesOffered;
    private String publisher;
    private String itemSubject;
    private int numberOfLikes;
    private int numberOfDislikes;
    private String description;
    private Long itemId;
    private String aboutTheAuthor;
    private Date releaseDate;
    private int fileSize;
    private int itemType;
    private int itemCategory;
    private Vector<String> buyItNowLinks;
    private Vector<String> awards;
    private String itemImage;
    private Date dateAdded;
    private Date dueDate;
    private Date recievedDate;
    
    public Item(String itemName, int bookId, String bookImg, int itemType, int itemCategory, String author, int initNumberOfLikes, int initNumberOfDislikes, int initLibraryCopies, int initAvailableCopies, Date dateAdded) {
        this.itemName = itemName;
        this.itemId = new Long(bookId);
        this.itemImage = bookImg;
        this.itemType = itemType;
        this.author = author;
        this.dateAdded = dateAdded;
        
        numberOfLikes = initNumberOfLikes;
        numberOfDislikes = initNumberOfDislikes;
        libraryCopies = initLibraryCopies;
        availableCopies = initAvailableCopies;
        this.itemCategory = itemCategory;
    }
    
    public Item(String itemName, String bookImg, int itemType, int itemCategory, String author, int initLibraryCopies, int initAvailableCopies) {
        this.itemName = itemName;
        this.itemImage = bookImg;
        this.itemType = itemType;
        this.author = author;
        this.dateAdded = dateAdded;
        
        libraryCopies = initLibraryCopies;
        availableCopies = initAvailableCopies;
        this.itemCategory = itemCategory;
    }
    
    public Long getBookId() {
        return getItemId();
    }
    
    public String getBookImage() {
        return getItemImage();
    }
    
    public String getBigBookImage() {
        String imgToChange = getItemImage();
        String[] strBreak = imgToChange.split("\\.");
        strBreak[0] += ("_big");
        String bigFileName = "";
        
        int count = 0;
        for(String s : strBreak) {
            if(count != 0)
                bigFileName += "." + s;
            else
                bigFileName += s; 
            count++;
        }
        
        return bigFileName;
    }
    
    public int getItemType() {
        return itemType;
    }
    
    public String getAuthor() {
        return author;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the availableCopies
     */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * @param availableCopies the availableCopies to set
     */
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    /**
     * @return the libraryCopies
     */
    public int getLibraryCopies() {
        return libraryCopies;
    }

    /**
     * @param libraryCopies the libraryCopies to set
     */
    public void setLibraryCopies(int libraryCopies) {
        this.libraryCopies = libraryCopies;
    }

    /**
     * @return the languagesOffered
     */
    public Vector<String> getLanguagesOffered() {
        return languagesOffered;
    }

    /**
     * @param languagesOffered the languagesOffered to set
     */
    public void setLanguagesOffered(Vector<String> languagesOffered) {
        this.languagesOffered = languagesOffered;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the itemSubject
     */
    public String getItemSubject() {
        for (Category c : Category.values())
            if(c.getCategoryId() == this.getItemCategory())
                return c.getTextRep();
        return Category.ART_ANTIQUES_COLLECTIBLES.getTextRep();
    }

    /**
     * @param itemSubject the itemSubject to set
     */
    public void setItemSubject(String itemSubject) {
        this.itemSubject = itemSubject;
    }

    /**
     * @return the numberOfLikes
     */
    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    /**
     * @param numberOfLikes the numberOfLikes to set
     */
    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    /**
     * @return the numberOfDislikes
     */
    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    /**
     * @param numberOfDislikes the numberOfDislikes to set
     */
    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    public String getShortDescription() {
        if(description.length() < 300)
            return description;
        else
            return description.substring(0, 300) + "...";
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the itemId
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the aboutTheAuthor
     */
    public String getAboutTheAuthor() {
        return aboutTheAuthor;
    }

    /**
     * @param aboutTheAuthor the aboutTheAuthor to set
     */
    public void setAboutTheAuthor(String aboutTheAuthor) {
        this.aboutTheAuthor = aboutTheAuthor;
    }

    /**
     * @return the releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the fileSize
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    /**
     * @return the itemCategory
     */
    public int getItemCategory() {
        return itemCategory;
    }

    /**
     * @param itemCategory the itemCategory to set
     */
    public void setItemCategory(int itemCategory) {
        this.itemCategory = itemCategory;
    }

    /**
     * @return the buyItNowLinks
     */
    public Vector<String> getBuyItNowLinks() {
        return buyItNowLinks;
    }

    /**
     * @param buyItNowLinks the buyItNowLinks to set
     */
    public void setBuyItNowLinks(Vector<String> buyItNowLinks) {
        this.buyItNowLinks = buyItNowLinks;
    }

    /**
     * @return the awards
     */
    public Vector<String> getAwards() {
        return awards;
    }

    /**
     * @param awards the awards to set
     */
    public void setAwards(Vector<String> awards) {
        this.awards = awards;
    }

    /**
     * @return the itemImage
     */
    public String getItemImage() {
        return itemImage;
    }

    /**
     * @param itemImage the itemImage to set
     */
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
    
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * @param itemImage the itemImage to set
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getRecievedDate() {
        return recievedDate;
    }

    public void setRecievedDate(Date recievedDate) {
        this.recievedDate = recievedDate;
    }
    
    public void incrementLikes() {  this.numberOfLikes++;   }
    
    public void incrementDislikes() {  this.numberOfDislikes++;   }
    
    public void decrementLikes() {  this.numberOfLikes--;   }
    
    public void decrementDislikes() {  this.numberOfDislikes--;   }
}
