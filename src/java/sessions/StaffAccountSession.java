/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.ejb.Stateless;
import stf.StaffAccount;

/**
 *
 * @author Ricky
 */
@ManagedBean (name="staffSession")
@SessionScoped
@Stateless
public class StaffAccountSession {

    StaffAccount sa;
    /**
     * Creates a new instance of StaffAccountSession
     */
    public StaffAccountSession() {
        sa = null;
    }

    public StaffAccount getSa() {
        return sa;
    }

    public void setSa(StaffAccount sa) {
        this.sa = sa;
    }
}
