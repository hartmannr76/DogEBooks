/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.managers;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import sessions.StaffaccountFacade;
import sessions.StaffmessagehistoryFacade;
import stf.StaffAccount;
import stf.StaffMessage;


/**
 *
 * @author Piotr
 */
@ManagedBean
@ApplicationScoped
@Stateless
public class StaffManager {

    private HashMap allStaff;
    private List <StaffMessage> staffMessages;
            
    @EJB
    private StaffaccountFacade staffAccountFacade;
    
    @EJB
    private StaffmessagehistoryFacade staffMessageFacade;
    

    
   // @EJB
   // private NotificationFacade notificationFacade;
    
    /**
     * Creates a new instance of UserManager
     */
    public StaffManager() 
    {
           
    }
    
    // The list of users will need to be populated after everything has started
    // in order to allow the facades to initialize
    //
    // @ Piotr
    @PostConstruct
    public void init()
    {
       initializeStaff();
        
    }
    
     public void initializeStaff()
     {
        setAllStaff(new HashMap());
        
        List <StaffAccount> listOfStaff = getStaffAccountFacade().getAllStaff();
        
        for(int i = 0; i<listOfStaff.size();i++)
        {
            addToAllStaff(listOfStaff.get(i));
        }
     }
    
     public void addToAllStaff(StaffAccount s)
    {
        getAllStaff().put(s.getUserName(), s);
    }
     
      public void getStaffAccountMessages(int initUserId)
    {
        setStaffMessages(getStaffMessageFacade().getAllStaffMessagesByID(initUserId));
    }

    /**
     * @return the allStaff
     */
    public HashMap getAllStaff() {
        return allStaff;
    }

    /**
     * @param allStaff the allStaff to set
     */
    public void setAllStaff(HashMap allStaff) {
        this.allStaff = allStaff;
    }

    /**
     * @return the staffMessages
     */
    public List <StaffMessage> getStaffMessages() {
        return staffMessages;
    }

    /**
     * @param staffMessages the staffMessages to set
     */
    public void setStaffMessages(List <StaffMessage> staffMessages) {
        this.staffMessages = staffMessages;
    }

    /**
     * @return the staffAccountFacade
     */
    public StaffaccountFacade getStaffAccountFacade() {
        return staffAccountFacade;
    }

    /**
     * @param staffAccountFacade the staffAccountFacade to set
     */
    public void setStaffAccountFacade(StaffaccountFacade staffAccountFacade) {
        this.staffAccountFacade = staffAccountFacade;
    }

    /**
     * @return the staffMessageFacade
     */
    public StaffmessagehistoryFacade getStaffMessageFacade() {
        return staffMessageFacade;
    }

    /**
     * @param staffMessageFacade the staffMessageFacade to set
     */
    public void setStaffMessageFacade(StaffmessagehistoryFacade staffMessageFacade) {
        this.staffMessageFacade = staffMessageFacade;
    }

}
