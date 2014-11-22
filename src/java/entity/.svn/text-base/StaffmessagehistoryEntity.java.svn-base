/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricky
 */
@Entity
@Table(name = "staffmessagehistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffmessagehistoryEntity.findAll", query = "SELECT s FROM StaffmessagehistoryEntity s"),
    @NamedQuery(name = "StaffmessagehistoryEntity.findByIdstaffmessagehistory", query = "SELECT s FROM StaffmessagehistoryEntity s WHERE s.idstaffmessagehistory = :idstaffmessagehistory")})
public class StaffmessagehistoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstaffmessagehistory")
    private Integer idstaffmessagehistory;
    @JoinColumn(name = "user_id", referencedColumnName = "idStaffAccount")
    @ManyToOne
    private StaffaccountEntity userId;
    @JoinColumn(name = "message_id", referencedColumnName = "idStaffMessage")
    @ManyToOne
    private StaffmessageEntity messageId;

    public StaffmessagehistoryEntity() {
    }

    public StaffmessagehistoryEntity(Integer idstaffmessagehistory) {
        this.idstaffmessagehistory = idstaffmessagehistory;
    }

    public Integer getIdstaffmessagehistory() {
        return idstaffmessagehistory;
    }

    public void setIdstaffmessagehistory(Integer idstaffmessagehistory) {
        this.idstaffmessagehistory = idstaffmessagehistory;
    }

    public StaffaccountEntity getUserId() {
        return userId;
    }

    public void setUserId(StaffaccountEntity userId) {
        this.userId = userId;
    }

    public StaffmessageEntity getMessageId() {
        return messageId;
    }

    public void setMessageId(StaffmessageEntity messageId) {
        this.messageId = messageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstaffmessagehistory != null ? idstaffmessagehistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffmessagehistoryEntity)) {
            return false;
        }
        StaffmessagehistoryEntity other = (StaffmessagehistoryEntity) object;
        if ((this.idstaffmessagehistory == null && other.idstaffmessagehistory != null) || (this.idstaffmessagehistory != null && !this.idstaffmessagehistory.equals(other.idstaffmessagehistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StaffmessagehistoryEntity[ idstaffmessagehistory=" + idstaffmessagehistory + " ]";
    }
    
}
