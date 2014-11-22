/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.NotificationhistoryEntity;
import entity.UseraccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import user.Notification;

/**
 *
 * @author
 * Piotr
 */
@Stateless
public class NotificationhistoryFacade extends AbstractFacade<NotificationhistoryEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificationhistoryFacade() {
        super(NotificationhistoryEntity.class);
    }
    
      public List<Notification> getAllNotifications()
    {
         List<NotificationhistoryEntity> listOfNotifications = this.findAll();
         List<Notification> listOfNotificationObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfNotifications.size(); i++)
         {
             NotificationhistoryEntity x = listOfNotifications.get(i);
             
            Notification notificationToBeAddedToList = convertToNotification(x);
             listOfNotificationObjects.add(notificationToBeAddedToList);
         }
        
         
         return listOfNotificationObjects;
    }
      
          public List<Notification> getAllNotificationsByUserId(int initUserId)
    {
         List<NotificationhistoryEntity> listOfNotifications = this.findAll();
         List<Notification> listOfNotificationObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfNotifications.size(); i++)
         {
            NotificationhistoryEntity x = listOfNotifications.get(i);
             
            Notification notificationToBeAddedToList = convertToNotification(x);
            
            if(notificationToBeAddedToList.getUserID() == initUserId)
            {
                  listOfNotificationObjects.add(notificationToBeAddedToList);
            }
         }
        
         
         return listOfNotificationObjects;
    }
      
          public void createNotification(Notification n) 
    {
       
         NotificationhistoryEntity nhe = new NotificationhistoryEntity();
         
         nhe.setHasItBeenSeen(n.getHasNotificationBeenSeen());
         nhe.setNotificationDate(n.getDateOfNotification());
         nhe.setNotificationText(n.getNotificationText());
         
         UseraccountEntity ue = new UseraccountEntity();
         ue.setIdUserLibraryCode(n.getUserID());
         nhe.setUserId(ue);

         create(nhe);
      
    }    
          
          public void removeNotification(int initId)
          {
              NotificationhistoryEntity ne = em.find(NotificationhistoryEntity.class, initId);
              remove(ne);
          }
          
          public void updateNotification(Notification n)
          {
              NotificationhistoryEntity nhe = em.find(NotificationhistoryEntity.class, n.getNotificationId());
              nhe.setHasItBeenSeen(n.getHasNotificationBeenSeen());
              nhe.setNotificationDate(n.getDateOfNotification());
              nhe.setNotificationText(n.getNotificationText());
              edit(nhe);
          }
          
          
      public Notification convertToNotification(NotificationhistoryEntity n)
      {
          Notification notificationToBeReturned = new Notification(n.getIdnotificationhistory(), n.getNotificationDate(), n.getNotificationText(), n.getHasItBeenSeen(), n.getUserId().getIdUserLibraryCode());
          return notificationToBeReturned;
      }
      
}
