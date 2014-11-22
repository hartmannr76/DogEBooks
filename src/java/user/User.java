/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import item.Item;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ricky
 */
public class User {
    
    private int idUserLibraryCode = 0;
    private String username;
    private String password;
    private String userEmail = "";
    private String firstName;
    private String lastName;
    private String userMobileNumber = "";
    private String userProfileImage = "";
    private List<WishlistItem> wishlists;

    public User(int idUserLibraryCode, String username, String password, String firstName, String lastName, String userEmail) {
        this.idUserLibraryCode = idUserLibraryCode;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.wishlists = new ArrayList<WishlistItem>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void addItemIntoWishlist(WishlistItem item) {
        // Add to user session data first
        wishlists.add(item);
    }
    
    public void removeItemFromWishlist(WishlistItem item) {
        // Remove from user session data first
        wishlists.remove(item);
        
        // Remove from database
    }

    public int getIdUserLibraryCode() {
        return idUserLibraryCode;
    }

    public void setIdUserLibraryCode(int idUserLibraryCode) {
        this.idUserLibraryCode = idUserLibraryCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    /**
     * @param wishlists the wishlists to set
     */
    public void setWishlists(List<WishlistItem> wishlists) {
        this.wishlists = wishlists;
    }

    public List<WishlistItem> getWishlists() {
        return wishlists;
    }
    
    public List<Item> getWishlistItems() {
        List<Item> returnList = new ArrayList<Item>();
        for(WishlistItem wi : wishlists)
            returnList.add(wi.getItem());
        return returnList;
    }
    
}
