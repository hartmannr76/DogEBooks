/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.StaffmessageEntity;
import entity.StaffmessagehistoryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import stf.StaffMessage;

/**
 *
 * @author
 * Piotr
 */
@Stateless
public class StaffmessagehistoryFacade extends AbstractFacade<StaffmessagehistoryEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffmessagehistoryFacade() {
        super(StaffmessagehistoryEntity.class);
    }
    
    public List<StaffMessage> getAllStaffMessages()
    {
         List<StaffmessagehistoryEntity> listOfStaffMessages = this.findAll();
         List<StaffMessage> listOfStaffMessageObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfStaffMessages.size(); i++)
         {
             StaffmessagehistoryEntity x = listOfStaffMessages.get(i);
             
             StaffMessage messageToBeAddedToList = convertToStaffMessage(x);
             listOfStaffMessageObjects.add(messageToBeAddedToList);
         }
        
         
         return listOfStaffMessageObjects;
    }
    
    public List<StaffMessage> getAllStaffMessagesByID(int initStaffId)
    {
         List<StaffmessagehistoryEntity> listOfStaffMessages = this.findAll();
         List<StaffMessage> listOfStaffMessageObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfStaffMessages.size(); i++)
         {
             StaffmessagehistoryEntity x = listOfStaffMessages.get(i);
             
             StaffMessage messageToBeAddedToList = convertToStaffMessage(x);
             
             if(messageToBeAddedToList.getUserReceivingMessageId() == initStaffId)
             {
                 listOfStaffMessageObjects.add(messageToBeAddedToList);
             }
         }
        
         
         return listOfStaffMessageObjects;
    }
    
    public StaffMessage convertToStaffMessage(StaffmessagehistoryEntity s)
    {

        StaffmessageEntity sme = s.getMessageId();
        StaffMessage message = new StaffMessage(sme.getIdStaffMessage(), sme.getTextOfMessage(), sme.getAuthorId().getUserName(), sme.getDateOfMessage(), sme.getAuthorId().getIdStaffAccount(), s.getUserId().getIdStaffAccount());

        return message;
    }
    
}
