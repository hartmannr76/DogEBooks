/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import item.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricky
 */
public class UserWishlist {
    
    protected List<Item> wishlistItems;
    
    public UserWishlist() {
        wishlistItems = new ArrayList<Item>();
    }
    
    public void addItemToWishlist(Item item) {
        wishlistItems.add(item);
    }
    
    public void removeItemFromWishlist(Item item) {
        wishlistItems.remove(item);
    }
}
