/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.requests;

import item.Item;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import sessions.UserSession;

/**
 *
 * @author Ricky
 */
@ManagedBean  (name = "cartReq")
@RequestScoped
public class CartRequestController implements Serializable {

    /**
     * Creates a new instance of CartRequestController
     */
      
    @ManagedProperty (value = "#{viewReq.viewableItem}")
    Item vi;
    @EJB
    UserSession us;
    
    public CartRequestController() {
    }
    
    public void setVi(Item vi) {
        this.vi = vi;
    }
    
    public Item getVrc() {
        return vi;
    }
    
    public void addItemToCart() { 
        if(!us.getObjCart().contains(vi))
            us.addItemToCart(vi);
    }
    
    public void removeItemFromCart(Item id) {
        us.getObjCart().remove(id);
    }
    
    public int getCartAmount() {
        return us.getCartAmount();
    }
}
