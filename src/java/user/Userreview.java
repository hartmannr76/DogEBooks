/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author
 * Piotr
 */
public class Userreview 
{
    private int id;
    private int rating;
    private String review;
    private int itemId;
    private int userId;
    private int likeValue; //represents like system used, 1 is user likes, 0 neutral, -1 dislike

    
    public Userreview(int initRating, String initReview, int initItemId, int initUserId, int initLikeValue)
    {
       rating = initRating;
       review = initReview;
       itemId = initItemId;
       userId = initUserId;
       likeValue = initLikeValue;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the review
     */
    public String getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the likeValue
     */
    public int getLikeValue() {
        return likeValue;
    }

    /**
     * @param likeValue the likeValue to set
     */
    public void setLikeValue(int likeValue) {
        this.likeValue = likeValue;
    }
    
    
    
    
}
