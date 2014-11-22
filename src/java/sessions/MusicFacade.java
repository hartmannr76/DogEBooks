/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.ItemEntity;
import entity.MusicEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import item.Music;

/**
 *
 * @author
 * Piotr
 */
@Stateless
public class MusicFacade extends AbstractFacade<MusicEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MusicFacade() {
        super(MusicEntity.class);
    }
    
    
     public void createMusic(Music m) 
    {
         MusicEntity me = new MusicEntity();
         
         me.setDurationOfItem(m.getDurationOfBook());
         me.setNumberOfParts(m.getNumberOfParts());
         me.setSampleOfItemDownloadURL(m.getSampleOfItemDownloadURL());
         me.setExcerptOfItemDownloadURL(m.getExcerptOfItemDownloadURL());
         
         ItemEntity ie = new ItemEntity();
         ie.setIdItem(m.getItemId().intValue());
         me.setItemId(ie);

         
         create(me);
    }
    
          public void removeMusic(Music m)
    {
        MusicEntity me = getEntityByItemId(m.getItemId().intValue());
        remove(me);
    }
      
     public MusicEntity getEntityByItemId(int initId)
     {
         List<MusicEntity> listOfMusic = this.findAll();
         MusicEntity entityToBeReturned = null;
         
         
          for(int i = 0; i < listOfMusic.size(); i++)
         {
             MusicEntity x = listOfMusic.get(i);
             
             if(x.getItemId().getIdItem() == initId)
                   entityToBeReturned = x;
             
         }
         
          return entityToBeReturned;
     }
     
      public List<Music> getAllMusic()
    {
         List<MusicEntity> listOfMusic = this.findAll();
         List<Music> listOfMusicAsObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfMusic.size(); i++)
         {
             MusicEntity x = listOfMusic.get(i);
             
             Music musicToBeAddedToList = convertToMusic(x);
             listOfMusicAsObjects.add(musicToBeAddedToList);
         }
        
         
         return listOfMusicAsObjects;
    }
    
     public Music convertToMusic(MusicEntity m)
    {
        ItemEntity i = m.getItemId();
        Music musicToBeReturned = new Music(i.getItemName(), i.getIdItem(), i.getItemImage(), i.getType(), i.getBookSubject(), i.getAuthor(), i.getDigitalRights(), m.getSampleOfItemDownloadURL(), m.getExcerptOfItemDownloadURL(), m.getDurationOfItem(), i.getNumberOfLikes(), i.getNumberOfDislikes(), i.getLibraryCopies(), i.getAvailableCopies(), i.getDateAdded());

        return musicToBeReturned;
    }
      
      
}
