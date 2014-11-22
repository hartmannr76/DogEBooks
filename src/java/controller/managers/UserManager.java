/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.managers;

import item.Item;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import sessions.*;
import stf.StaffAccount;
import user.Notification;
import user.User;
import user.WishlistItem;

/**
 *
 * @author Ricky
 */
@ManagedBean
@ApplicationScoped
@Stateless
public class UserManager {

    private HashMap allUsers;
    private HashMap staffUsers;
    private List <WishlistItem> userWishlist;
    private List <Notification> userNotifications;
            
    @EJB
    private UseraccountFacade userFacade;
    
    @EJB
    private WishlistFacade wishlistFacade;
    
    @EJB
    private NotificationhistoryFacade notificationHistoryFacade;
    
    @EJB
    private UsercheckouthistoryFacade uchf;
    
    @EJB
    private StaffaccountFacade saf;
    
   // @EJB
   // private NotificationFacade notificationFacade;
    
    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
    }
    
    // The list of users will need to be populated after everything has started
    // in order to allow the facades to initialize
    //
    // @ Piotr
    @PostConstruct
    public void init()
    {
        refreshUserList();
        refreshStaffUserList();
    }
    
    public void getUsersNotifications(int initUserId)
    {
        userNotifications = notificationHistoryFacade.getAllNotificationsByUserId(initUserId);
    }
    
    public List<WishlistItem> getUsersWishlist(int initUserId)
    {
        return getWishlistFacade().getAllWishlistItemsForUser(initUserId);    
    }
    
    public void refreshUserList() {
        allUsers  = new HashMap();
        List <User> listOfUsers = getUserFacade().getAllUserAccounts();
        
        for(int i = 0; i<listOfUsers.size();i++)
        {
            addToAllUsers(listOfUsers.get(i));
        }
    }
    
    public void refreshStaffUserList() {
        staffUsers  = new HashMap();
        List <StaffAccount> listOfUsers = saf.getAllStaff();
        
        for(int i = 0; i<listOfUsers.size();i++)
        {
            addToStaff(listOfUsers.get(i));
        }
    }
    
    public User doesUserExist(String nameToCheck, String passToCheck) {   
        if(allUsers.containsKey(nameToCheck)) {
            User u = (User)allUsers.get(nameToCheck);
            if(u.getPassword().equals(passToCheck)) {
                return u;
            }
        }
        return null;
    }
    
    public StaffAccount doesStaffExist(String nameToCheck, String passToCheck) {   
        if(staffUsers.containsKey(nameToCheck)) {
            StaffAccount sa = (StaffAccount)staffUsers.get(nameToCheck);
            if(sa.getUserPassword().equals(passToCheck)) {
                return sa;
            }
        }
        return null;
    }
    
    public User userPasswordRecovery(String nameToCheck) {
        if(allUsers.containsKey(nameToCheck)) {
            User u = (User)allUsers.get(nameToCheck);
            return u;
        }
        return null;
    }
    
    public void updateUser(User u) {
        User userToUpdate = findUserByID(u.getIdUserLibraryCode());
        userToUpdate = u;
    }
    
    public User findUserByID(int initID) 
    {
 
        Set<Map.Entry> s =  getAllUsers().entrySet();
       
        
       for(Map.Entry me : s)
       {
           User userAccount = (User)me.getValue();
           
           if(userAccount.getIdUserLibraryCode() == initID)
           {
               return userAccount;
           }
       }
            
        return null;
    }
    
    public void addToAllUsers(User u)
    {
        allUsers.put(u.getUsername(), u);
    }
    
    public void addToStaff(StaffAccount sa)
    {
        staffUsers.put(sa.getUserName(), sa);
    }
    
    

    /**
     * @return the allUsers
     */
    public HashMap getAllUsers() {
        return allUsers;
    }
    
    public HashMap getAllStaff() {
        return staffUsers;
    }

     public User getUserByName(String initName)
    {
        User useraccount = (User) allUsers.get(initName);
        return useraccount;
    }
    
    /**
     * @param allUsers the allUsers to set
     */
    public void setAllUsers(HashMap allUsers) {
        this.allUsers = allUsers;
    }
    
    public void createUser(User u) {
        getUserFacade().addUserAccount(u);
        refreshUserList();
    }

    /**
     * @return the userWishlist
     */
    public List<WishlistItem> getUserWishlist() {
        return userWishlist;
    }

    /**
     * @param userWishlist the userWishlist to set
     */
    public void setUserWishlist(List <WishlistItem> userWishlist) {
        this.setUserWishlist(userWishlist);
    }

    /**
     * @return the userFacade
     */
    public UseraccountFacade getUserFacade() {
        return userFacade;
    }

    /**
     * @param userFacade the userFacade to set
     */
    public void setUserFacade(UseraccountFacade userFacade) {
        this.userFacade = userFacade;
    }

    /**
     * @return the wishlistFacade
     */
    public WishlistFacade getWishlistFacade() {
        return wishlistFacade;
    }

    /**
     * @param wishlistFacade the wishlistFacade to set
     */
    public void setWishlistFacade(WishlistFacade wishlistFacade) {
        this.wishlistFacade = wishlistFacade;
    }

    public void checoutUser(List<Item> cart, User u) {
        uchf.processChecout(cart, u);
    }
    
    public List<Item> getUsersCheckouts(User u) {
        List<Item> returnList = uchf.getUsersCurrentCheckout(u);
        return returnList;
    }
    
    public void returnItem(Item i, User u) {
        uchf.processReturn(i, u);
    }
    
    public void addItemToWishlist(WishlistItem wli) {
        wishlistFacade.createWishlistItem(wli);
    }
    
    public void removeItemFromWishlist(WishlistItem wli) {
        wishlistFacade.removeWishlistItem(wli);
    }

    /**
     * @return the userNotifications
     */
    public List <Notification> getUserNotifications() {
        return userNotifications;
    }

    /**
     * @param userNotifications the userNotifications to set
     */
    public void setUserNotifications(List <Notification> userNotifications) {
        this.userNotifications = userNotifications;
    }
}
