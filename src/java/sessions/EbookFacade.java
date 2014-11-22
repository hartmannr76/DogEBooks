/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.EbookEntity;
import entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import item.EBook;
import item.Item;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;

/**
 *
 * @author
 * Piotr
 */
@Stateless
public class EbookFacade extends AbstractFacade<EbookEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EbookFacade() {
        super(EbookEntity.class);
    }
    
     public List<EBook> getAllEbooks()
    {
         List<EbookEntity> listOfEbooks = this.findAll();
         List<EBook> listOfEbooksAsObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfEbooks.size(); i++)
         {
             EbookEntity x = listOfEbooks.get(i);
             
             EBook ebookToBeAddedToList = convertToEbook(x);
             listOfEbooksAsObjects.add(ebookToBeAddedToList);
         }
        
         
         return listOfEbooksAsObjects;
    }
     
     public void createBook(EBook e) 
    {
         EbookEntity ee = new EbookEntity();
         
         ee.setAvailableCopies(e.getAvailableCopies());
         ee.setIsbn(e.getISBN());
         ee.setEdition(e.getEdition());
         ee.setDigitalRightsInformation(e.getDigitalRightsInformation());
         
         ItemEntity ie = new ItemEntity();
         ie.setIdItem(e.getItemId().intValue());
         ee.setItemEntity(ie);
         ee.setItemId(e.getItemId().intValue());
         
         create(ee);
    }
    
      public void removeEBook(EBook e)
    {
        EbookEntity ae = getEntityByItemId(e.getItemId().intValue());
        remove(ae);
    }
      
     public EbookEntity getEntityByItemId(int initId)
     {
         List<EbookEntity> listOfBooks = this.findAll();
         EbookEntity entityToBeReturned = null;
         
         
          for(int i = 0; i < listOfBooks.size(); i++)
         {
             EbookEntity x = listOfBooks.get(i);
             
             if(x.getItemId().intValue() == initId)
                   entityToBeReturned = x;
             
         }
         
          return entityToBeReturned;
     }
     
     
     public EBook convertToEbook(EbookEntity e)
    {
        ItemEntity i = e.getItemEntity();
        EBook ebookToBeReturned = new EBook(i.getItemName(), i.getIdItem(), i.getItemImage(), i.getType(), i.getBookSubject(), i.getAuthor(), e.getIsbn(), i.getNumberOfLikes(), i.getNumberOfDislikes(), i.getAvailableCopies(), i.getLibraryCopies(), i.getDateAdded());
        ebookToBeReturned.setPublisher(i.getPublisher());
        ebookToBeReturned.setDescription(i.getDescription());
        return ebookToBeReturned;
    }
     
     
}
