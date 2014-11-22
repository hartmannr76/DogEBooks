/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import item.Item;
import java.util.Date;

/**
 *
 * @author
 * Piotr
 */
public class WishlistItem 
{
    private Date dateAddedToWishlist;
    private String formatOfItem;
    private int wishlistID;
    private Item item;
    private int userID;
    
    public WishlistItem(Date initDate, String initFormat, Item initItem, int initAssociatedUserID)
    {
        dateAddedToWishlist = initDate;
        formatOfItem = initFormat;
        item = initItem;
        userID = initAssociatedUserID;
    }

    /**
     * @return the dateAddedToWishlist
     */
    public Date getDateAddedToWishlist() {
        return dateAddedToWishlist;
    }

    /**
     * @param dateAddedToWishlist the dateAddedToWishlist to set
     */
    public void setDateAddedToWishlist(Date dateAddedToWishlist) {
        this.dateAddedToWishlist = dateAddedToWishlist;
    }

    /**
     * @return the formatOfItem
     */
    public String getFormatOfItem() {
        return formatOfItem;
    }

    /**
     * @param formatOfItem the formatOfItem to set
     */
    public void setFormatOfItem(String formatOfItem) {
        this.formatOfItem = formatOfItem;
    }

    /**
     * @return the wishlistID
     */
    public int getWishlistID() {
        return wishlistID;
    }

    /**
     * @param wishlistID the wishlistID to set
     */
    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
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
