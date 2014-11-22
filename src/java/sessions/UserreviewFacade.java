/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;


import entity.ItemEntity;
import entity.UseraccountEntity;
import entity.UserreviewhistoryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import user.Userreview;

/**
 *
 * @author
 * Piotr
 */
@Stateless
public class UserreviewFacade extends AbstractFacade<UserreviewhistoryEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserreviewFacade() {
        super(UserreviewhistoryEntity.class);
    }
    
    
     public void createUserreview(Userreview u) 
    {
        
     
         //check if this user has reviewed before
         UserreviewhistoryEntity hasItBeenReviewed = getEntity(u.getUserId(), u.getItemId());
         
         //has not been created case
         if(hasItBeenReviewed == null)
         {
             
         UserreviewhistoryEntity ure = new UserreviewhistoryEntity();    
             
         ure.setRating(u.getRating());
         ure.setReview(u.getReview());
 
         ItemEntity ie = new ItemEntity();
         ie.setIdItem(u.getItemId());
         ure.setItemId(ie);
         
         UseraccountEntity ue = new UseraccountEntity();
         ue.setIdUserLibraryCode(u.getUserId());
         ure.setUseraccountId(ue);
             
             create(ure);
         }
         
         //case where it has been created so we just need to update user review
         else
         {
         hasItBeenReviewed.setRating(u.getRating());
         hasItBeenReviewed.setReview(u.getReview());
         
         edit(hasItBeenReviewed);
         
         }
         
         
    }
    
          public void removeReview(Userreview u)
    {
        UserreviewhistoryEntity ue = em.find(UserreviewhistoryEntity.class, u.getId());
        remove(ue);
    }
         
          public UserreviewhistoryEntity getEntity(int initUserId, int initItemId)
          {
                List<UserreviewhistoryEntity> listOfReviews = this.findAll();
                UserreviewhistoryEntity entityToBeReturned = null;
         
         
          for(int i = 0; i < listOfReviews.size(); i++)
         {
             UserreviewhistoryEntity x = listOfReviews.get(i);
             
             if(x.getItemId().getIdItem() == initItemId && x.getUseraccountId().getIdUserLibraryCode() == initUserId)
                   entityToBeReturned = x;
             
         }
         
          return entityToBeReturned;
          }
          

     
      public List<Userreview> getUserReviews()
    {
         List<UserreviewhistoryEntity> listOfReview = this.findAll();
         List<Userreview> listOfReviewsAsObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfReview.size(); i++)
         {
             UserreviewhistoryEntity x = listOfReview.get(i);
             
             Userreview reviewToBeAddedToList = convertToReview(x);
             listOfReviewsAsObjects.add(reviewToBeAddedToList);
         }
        
         
         return listOfReviewsAsObjects;
    }
    
     public Userreview convertToReview(UserreviewhistoryEntity u)
    {
        ItemEntity ie = u.getItemId();
        UseraccountEntity ue = u.getUseraccountId();
        
        Userreview reviewToBeReturned = new Userreview(u.getRating(), u.getReview(), ie.getIdItem(), ue.getIdUserLibraryCode(), u.getLikeValue());
        
        return reviewToBeReturned;
    }
      
      
}
