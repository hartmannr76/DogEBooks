/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import item.Item;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import user.User;

/**
 *
 * @author Ricky
 */
@ManagedBean (name="userSession")
@SessionScoped
@Stateless
public class UserSession {

    User user;   // Placeholder for the user stored in session
    int cart;   // Placeholder for the cart stored in session
    
    List<Item> objCart;
    List<Item> checkouts;
    
    /**
     * Creates a new instance of UserSession
     */
    public UserSession() {
        user = null;
        cart = 0;
        objCart = new ArrayList<Item>();
    }
    
    public void setUser(User iUser) {
        user = iUser;
        System.out.println(user);
    }
    
    public User getUser() {
        return user;
    }    
    
    public void upCartAmount() {
        cart++;
    }
    
    public List<Item> getObjCart() {
        return objCart;
    }
    
    public void setObjCart(List<Item> cart) {
        this.objCart = cart;
    }
    
    public void addItemToCart(Item iToAdd) {
        objCart.add(iToAdd);
    }
    
    public int getCartAmount() {
        return cart;
    }
    
    public void clearCart() {
        objCart.clear();
    }

    public List<Item> getCheckouts() {
        return checkouts;
    }

    public void setCheckouts(List<Item> checkouts) {
        this.checkouts = checkouts;
    }
}
