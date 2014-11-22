/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.ItemEntity;
import entity.UseraccountEntity;
import entity.WishlistEntity;
import item.Item;
import user.WishlistItem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author
 * Piotr
 */
@Stateless
public class WishlistFacade extends AbstractFacade<WishlistEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WishlistFacade() 
    {
        super(WishlistEntity.class);
    }
    
      public List<WishlistItem> getAllWishlistItems()
    {
         List<WishlistEntity> listOfWishlistItems = this.findAll();
         List<WishlistItem> listOfWishlistItemObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfWishlistItems.size(); i++)
         {
             WishlistEntity x = listOfWishlistItems.get(i);
             
            WishlistItem wishlistItemToBeAddedToList = convertToWishlistItem(x);
             listOfWishlistItemObjects.add(wishlistItemToBeAddedToList);
         }
        
         
         return listOfWishlistItemObjects;
    }
      
      public void createWishlistItem(WishlistItem w)
      {
         WishlistEntity we = new WishlistEntity();
         

         we.setDateAddedToWishlist(w.getDateAddedToWishlist());
         we.setFormatOfItem(w.getFormatOfItem());
         
         
         ItemEntity ie = new ItemEntity();
         ie.setIdItem(w.getItem().getItemId().intValue());
         we.setItemId(ie);
         
         UseraccountEntity ue = new UseraccountEntity();
         ue.setIdUserLibraryCode(w.getUserID());
         we.setUserId(ue);

         
         create(we);
      }
      
      public void removeWishlistItem(WishlistItem w)
    {
        WishlistEntity we = em.find(WishlistEntity.class, w.getWishlistID());
        remove(we);
    }
      
      
       public List<WishlistItem> getAllWishlistItemsForUser(int initUserId)
    {
         List<WishlistEntity> listOfWishlistItems = this.findAll();
         List<WishlistItem> listOfWishlistItemObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfWishlistItems.size(); i++)
         {
             
             WishlistEntity x = listOfWishlistItems.get(i);
             
            WishlistItem wishlistItemToBeAddedToList = convertToWishlistItem(x);
            
            if(wishlistItemToBeAddedToList.getUserID() == initUserId)
            {
             listOfWishlistItemObjects.add(wishlistItemToBeAddedToList);
            }
         }
        
         
         return listOfWishlistItemObjects;
    }
      
      public WishlistItem convertToWishlistItem(WishlistEntity w)
      {
          ItemEntity i = w.getItemId();
          Item item = new Item(i.getItemName(), i.getIdItem(), i.getItemImage(), i.getType(), i.getBookSubject(), i.getAuthor(), i.getNumberOfLikes(), i.getNumberOfDislikes(), i.getLibraryCopies(), i.getAvailableCopies(), i.getDateAdded());
          WishlistItem wishlistItem = new WishlistItem(w.getDateAddedToWishlist(), w.getFormatOfItem(), item, w.getUserId().getIdUserLibraryCode());
          wishlistItem.setWishlistID(w.getIdWishlistItem());
          
          return wishlistItem;
      }
    
}
