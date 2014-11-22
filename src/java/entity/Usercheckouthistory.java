/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricky
 */
@Entity
@Table(name = "usercheckouthistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usercheckouthistory.findAll", query = "SELECT u FROM Usercheckouthistory u"),
    @NamedQuery(name = "Usercheckouthistory.findByIdUserCheckoutHistory", query = "SELECT u FROM Usercheckouthistory u WHERE u.idUserCheckoutHistory = :idUserCheckoutHistory"),
    @NamedQuery(name = "Usercheckouthistory.findByTimeOfCheckout", query = "SELECT u FROM Usercheckouthistory u WHERE u.timeOfCheckout = :timeOfCheckout"),
    @NamedQuery(name = "Usercheckouthistory.findByItemDueDate", query = "SELECT u FROM Usercheckouthistory u WHERE u.itemDueDate = :itemDueDate"),
    @NamedQuery(name = "Usercheckouthistory.findByFormatOfItem", query = "SELECT u FROM Usercheckouthistory u WHERE u.formatOfItem = :formatOfItem"),
    @NamedQuery(name = "Usercheckouthistory.findByItemReturnDate", query = "SELECT u FROM Usercheckouthistory u WHERE u.itemReturnDate = :itemReturnDate")})
public class Usercheckouthistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUserCheckoutHistory")
    private Integer idUserCheckoutHistory;
    @Column(name = "timeOfCheckout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfCheckout;
    @Column(name = "itemDueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemDueDate;
    @Column(name = "formatOfItem")
    private Integer formatOfItem;
    @Column(name = "itemReturnDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemReturnDate;
    @JoinColumn(name = "useraccount_id", referencedColumnName = "idUserLibraryCode")
    @ManyToOne
    private UseraccountEntity useraccountId;
    @JoinColumn(name = "item_id", referencedColumnName = "idItem")
    @ManyToOne
    private ItemEntity itemId;

    public Usercheckouthistory() {
    }

    public Usercheckouthistory(Integer idUserCheckoutHistory) {
        this.idUserCheckoutHistory = idUserCheckoutHistory;
    }

    public Integer getIdUserCheckoutHistory() {
        return idUserCheckoutHistory;
    }

    public void setIdUserCheckoutHistory(Integer idUserCheckoutHistory) {
        this.idUserCheckoutHistory = idUserCheckoutHistory;
    }

    public Date getTimeOfCheckout() {
        return timeOfCheckout;
    }

    public void setTimeOfCheckout(Date timeOfCheckout) {
        this.timeOfCheckout = timeOfCheckout;
    }

    public Date getItemDueDate() {
        return itemDueDate;
    }

    public void setItemDueDate(Date itemDueDate) {
        this.itemDueDate = itemDueDate;
    }

    public Integer getFormatOfItem() {
        return formatOfItem;
    }

    public void setFormatOfItem(Integer formatOfItem) {
        this.formatOfItem = formatOfItem;
    }

    public Date getItemReturnDate() {
        return itemReturnDate;
    }

    public void setItemReturnDate(Date itemReturnDate) {
        this.itemReturnDate = itemReturnDate;
    }

    public UseraccountEntity getUseraccountId() {
        return useraccountId;
    }

    public void setUseraccountId(UseraccountEntity useraccountId) {
        this.useraccountId = useraccountId;
    }

    public ItemEntity getItemId() {
        return itemId;
    }

    public void setItemId(ItemEntity itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserCheckoutHistory != null ? idUserCheckoutHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usercheckouthistory)) {
            return false;
        }
        Usercheckouthistory other = (Usercheckouthistory) object;
        if ((this.idUserCheckoutHistory == null && other.idUserCheckoutHistory != null) || (this.idUserCheckoutHistory != null && !this.idUserCheckoutHistory.equals(other.idUserCheckoutHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usercheckouthistory[ idUserCheckoutHistory=" + idUserCheckoutHistory + " ]";
    }
    
}
