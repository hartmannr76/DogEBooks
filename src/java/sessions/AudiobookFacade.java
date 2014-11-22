/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.AudiobookEntity;
import entity.ItemEntity;
import item.AudioBook;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import item.AudioBook;

/**
 *
 * @author
 * Piotr
 */
@Stateless
public class AudiobookFacade extends AbstractFacade<AudiobookEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AudiobookFacade() 
    {
        super(AudiobookEntity.class);
    }
    
     public void createAudiobook(AudioBook a) 
    {
         AudiobookEntity ae = new AudiobookEntity();
         

         ae.setIsbn(a.getISBN());
         ae.setEdition(a.getEdition());
         ae.setDurationOfBook(a.getDurationOfBook());
         ae.setNumberOfParts(a.getNumberOfParts());
         ae.setSampleOfItemDownloadURL(a.getSampleOfBookDownloadURL());
         ae.setExerptOfItemDownloadURL(a.getExcerptOfBookDownloadURL());
         
         ItemEntity ie = new ItemEntity();
         ie.setIdItem(a.getItemId().intValue());
         ae.setItemId(ie);

         
         create(ae);
    }
    
    
    public List<AudioBook> getAllAudiobooks()
    {
         List<AudiobookEntity> listOfAudiobooks = this.findAll();
         List<AudioBook> listOfAudiobooksAsObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfAudiobooks.size(); i++)
         {
             AudiobookEntity x = listOfAudiobooks.get(i);
             
             AudioBook audioBookToBeAddedToList = convertToAudiobook(x);
             listOfAudiobooksAsObjects.add(audioBookToBeAddedToList);
         }
        
         
         return listOfAudiobooksAsObjects;
    }
    
      public void removeAudiobook(AudioBook a)
    {
        AudiobookEntity ae = getEntityByItemId(a.getItemId().intValue());
        remove(ae);
    }
      
     public AudiobookEntity getEntityByItemId(int initId)
     {
         List<AudiobookEntity> listOfAudiobooks = this.findAll();
         AudiobookEntity entityToBeReturned = null;
         
         
          for(int i = 0; i < listOfAudiobooks.size(); i++)
         {
             AudiobookEntity x = listOfAudiobooks.get(i);
             
             if(x.getItemId().getIdItem() == initId)
                   entityToBeReturned = x;
             
         }
         
          return entityToBeReturned;
     }
    
    
    public AudioBook convertToAudiobook(AudiobookEntity a)
    {
        ItemEntity i = a.getItemId();
        AudioBook audioBookToBeReturned = new AudioBook(i.getItemName(), i.getIdItem(), i.getItemImage(), i.getType(), i.getBookSubject(), i.getAuthor(), a.getIsbn(), a.getDurationOfBook(), a.getSampleOfItemDownloadURL(), a.getExerptOfItemDownloadURL(), i.getNumberOfLikes(), i.getNumberOfDislikes(), i.getAvailableCopies(), i.getLibraryCopies(), i.getDateAdded());
        audioBookToBeReturned.setDescription(i.getDescription());
       
        return audioBookToBeReturned;
    }
    
}
