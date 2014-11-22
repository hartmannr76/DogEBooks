/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.StaffaccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import stf.StaffAccount;

/**
 *
 * @author Ricky
 */
@Stateless
public class StaffaccountFacade extends AbstractFacade<StaffaccountEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffaccountFacade() {
        super(StaffaccountEntity.class);
    }
    public List<StaffAccount> getAllStaff()
    {
         List<StaffaccountEntity> listOfStaff = this.findAll();
         List<StaffAccount> listOfStaffAsObjects = new ArrayList();
         
         
         for(int i = 0; i < listOfStaff.size(); i++)
         {
             StaffaccountEntity x = listOfStaff.get(i);
             
             StaffAccount staffAccountToBeAddedToList = convertToStaff(x);
             listOfStaffAsObjects.add(staffAccountToBeAddedToList);
         }
        
         
         return listOfStaffAsObjects;
    }
     
     public StaffAccount convertToStaff(StaffaccountEntity s)
     {
         StaffAccount staff = new StaffAccount(s.getUserName(), s.getUserEmail(), s.getUserPassword(), s.getUserMobileNumber(), s.getPermissionsLevel(), s.getIdStaffAccount());

         return staff;
     }
    
}
