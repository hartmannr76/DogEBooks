/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.EbookEntity;
import entity.ItemEntity;
import entity.UseraccountEntity;
import entity.Usercheckouthistory;
import enums.ItemType;
import item.EBook;
import item.Item;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import user.User;

/**
 *
 * @author Ricky
 */
@Stateless
public class UsercheckouthistoryFacade extends AbstractFacade<Usercheckouthistory> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsercheckouthistoryFacade() {
        super(Usercheckouthistory.class);
    }
    
    public List<Item> getUsersCurrentCheckout(User u) {
        List<Item> returnList = new ArrayList<Item>();
        
        List<Usercheckouthistory> allList = findAll();
        
        //Current date
        Date date = new Date();
        
        for(Usercheckouthistory uch : allList) {
            if(uch.getUseraccountId().getIdUserLibraryCode() == u.getIdUserLibraryCode() &&
                    uch.getItemDueDate().after(date) && uch.getItemReturnDate() == null) {
                if(uch.getItemId().getType() == ItemType.EBOOK.getTypeId()) {
                    Item inputItem = convertToEbook(uch.getItemId().getEbookEntity());
                    inputItem.setDueDate(uch.getItemDueDate());
                    returnList.add(inputItem);
                }
                    
            }
        }
        
        return returnList;
    }
    
    public void processChecout(List<Item> i, User u) {
        for(Item it : i) {
            Usercheckouthistory ue = new Usercheckouthistory();
            
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 14);
            date = cal.getTime();
            ue.setItemDueDate(date);
            
            ItemEntity ie = new ItemEntity();
            ie.setIdItem(it.getItemId().intValue());
            ue.setItemId(ie);
            
            UseraccountEntity uae = new UseraccountEntity();
            uae.setIdUserLibraryCode(u.getIdUserLibraryCode());
            ue.setUseraccountId(uae);
            
            create(ue);
        }
    }
    
    public void processReturn(Item i, User u)
    {
        Usercheckouthistory ue = getUsercheckouthistoryEntityByItemAndUser(u.getIdUserLibraryCode(), i.getItemId().intValue());
        
                     //Current date
        Date date = new Date();
        
        ue.setItemReturnDate(date);
        em.merge(ue);
        
    }
    
    public Usercheckouthistory getUsercheckouthistoryEntityByItemAndUser(int initUser, int initItem)
    {
       
        List<Usercheckouthistory> allCheckoutList = findAll();
        Usercheckouthistory userCheckoutToBeReturned = null;
         
         
         for(int i = 0; i < allCheckoutList.size(); i++)
         {
             Usercheckouthistory ue = allCheckoutList.get(i);
             
     
             if(ue.getUseraccountId().getIdUserLibraryCode() == initUser && ue.getItemId().getIdItem() == initItem)
             {
                 userCheckoutToBeReturned = ue;
             }
    
        }
         
         return userCheckoutToBeReturned;

    }
    
    public EBook convertToEbook(EbookEntity e)
    {
        ItemEntity i = e.getItemEntity();
        EBook ebookToBeReturned = new EBook(i.getItemName(), i.getIdItem(), i.getItemImage(), i.getType(), i.getBookSubject(), i.getAuthor(), e.getIsbn(), i.getNumberOfLikes(), i.getNumberOfDislikes(), i.getAvailableCopies(), i.getLibraryCopies(), i.getDateAdded());
        ebookToBeReturned.setPublisher(i.getPublisher());
        return ebookToBeReturned;
    }
    
}
