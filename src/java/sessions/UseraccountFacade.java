/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.UseraccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import user.User;


/**
 *
 * @author
 * Piotr
 */
@Stateless
public class UseraccountFacade extends AbstractFacade<UseraccountEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UseraccountFacade() {
        super(UseraccountEntity.class);
    }
    
    public  List<User> getAllUserAccounts()
    {
         List<UseraccountEntity> listOfUsers = this.findAll();
         List<User> listOfUsersAsAccountObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfUsers.size(); i++)
         {
             UseraccountEntity u = listOfUsers.get(i);
             
             User userAccountToBeAddedToList = convertToUserAccount(u);
             listOfUsersAsAccountObjects.add(userAccountToBeAddedToList);
         }
        
         
         return listOfUsersAsAccountObjects;
         
    }
    
    public void addUserAccount(User initUserToBeAdded)
    {
        /*em.createQuery("INSERT INTO Useraccount VALUES ( :idUserLibraryCode, :userName, :userEmail, :userPassword, :userMobile, :userProfileImage )")
                .setParameter("idUserLibraryCode", initUserToBeAdded.getIdUserLibraryCode())
                .setParameter("userName", initUserToBeAdded.getUsername())
                .setParameter("userEmail", initUserToBeAdded.getUserEmail())
                .setParameter("userPassword", initUserToBeAdded.getPassword())
                .setParameter("userMobile", initUserToBeAdded.getUserMobileNumber())
                .setParameter("userProfileImage", initUserToBeAdded.getUserProfileImage());
        */
        UseraccountEntity ue = new UseraccountEntity();
        ue.setIdUserLibraryCode(initUserToBeAdded.getIdUserLibraryCode());
        ue.setUserEmail(initUserToBeAdded.getUserEmail());
        ue.setUserFirstName(initUserToBeAdded.getFirstName());
        ue.setUserLastName(initUserToBeAdded.getLastName());
        ue.setUserMobileNumber(initUserToBeAdded.getUserMobileNumber());
        ue.setUserName(initUserToBeAdded.getUsername());
        ue.setUserPassword(initUserToBeAdded.getPassword());
        ue.setUserProfileImage(initUserToBeAdded.getUserProfileImage());
        create(ue);
    }
    
    public void deleteUserAccount(int initUseraccountID)
    {
        em.createNamedQuery("deleteByIdUserLibraryCode")
                .setParameter("idUserLibraryCode", initUseraccountID);    
    }
    
    public User convertToUserAccount(UseraccountEntity u)
    {
        User userAccount = new User(u.getIdUserLibraryCode(), u.getUserName(), u.getUserPassword(), u.getUserFirstName(), u.getUserLastName(), u.getUserEmail());
        userAccount.setUserMobileNumber(u.getUserMobileNumber());
        return userAccount;
    }
}
