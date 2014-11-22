/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.EbookEntity;
import entity.ItemEntity;
import item.EBook;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import item.Item;
import java.util.Date;
import javax.persistence.Query;


/**
 *
 * @author
 * Piotr
 */
@Stateless
public class ItemFacade extends AbstractFacade<ItemEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemFacade() {
        super(ItemEntity.class);
    }
    
    public List<Item> getAllItems()
    {
         List<ItemEntity> listOfItems = this.findAll();
         List<Item> listOfItemsAsObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfItems.size(); i++)
         {
             ItemEntity x = listOfItems.get(i);
             
             Item itemToBeAddedToList = convertToItem(x);
             listOfItemsAsObjects.add(itemToBeAddedToList);
         }
        
         
         return listOfItemsAsObjects;
    }
    
    public Item getItemByName(String initItemName)
    {
          List<ItemEntity> listOfItems = this.findAll();
          Item itemToBeReturned = null;
         
         
         for(int i = 0; i < listOfItems.size(); i++)
         {
             ItemEntity x = listOfItems.get(i);
             
             Item itemToBeAdded = convertToItem(x);
             
             if(itemToBeAdded.getItemName().equals(initItemName))
                    itemToBeReturned = itemToBeAdded;
         }
        
         
         return itemToBeReturned;
    }
    
    public void createItem(Item i) 
    {
       
         ItemEntity ie = new ItemEntity();
         ie.setItemName(i.getItemName());
         ie.setItemImage(i.getItemImage());
         ie.setType(i.getItemType());
         ie.setBookSubject(i.getItemCategory());
         ie.setAuthor(i.getAuthor());
         ie.setNumberOfLikes(i.getNumberOfLikes());
         ie.setNumberOfDislikes(i.getNumberOfDislikes());
         ie.setAvailableCopies(i.getAvailableCopies());
         ie.setLibraryCopies(i.getLibraryCopies());
         ie.setReleaseDate(i.getReleaseDate());
         ie.setDescription(i.getDescription());
         create(ie);         
    }
    
    public void removeItem(Item i)
    {
        ItemEntity ie = em.find(ItemEntity.class, i.getItemId().intValue());
        remove(ie);
    }
    
    public void updateItemInDatabase(Item i)
    {
        ItemEntity ie = em.find(ItemEntity.class, i.getItemId().intValue());
         ie.setItemName(i.getItemName());
         ie.setItemImage(i.getItemImage());
         ie.setType(i.getItemType());
         ie.setBookSubject(i.getItemCategory());
         ie.setAuthor(i.getAuthor());
         ie.setNumberOfLikes(i.getNumberOfLikes());
         ie.setNumberOfDislikes(i.getNumberOfDislikes());
         ie.setAvailableCopies(i.getAvailableCopies());
         ie.setLibraryCopies(i.getLibraryCopies());
         ie.setReleaseDate(i.getReleaseDate()); 
         edit(ie);
        
    }
    
    public Item convertToItem(ItemEntity i)
    {
        Item itemToBeReturned = new Item(i.getItemName(), i.getIdItem(), i.getItemImage(), i.getType(), i.getBookSubject(), i.getAuthor(), i.getNumberOfLikes(), i.getNumberOfDislikes(), i.getLibraryCopies(), i.getAvailableCopies(), i.getDateAdded());
        itemToBeReturned.setDescription(i.getDescription());
        return itemToBeReturned;
    }
    
}
