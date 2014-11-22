/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricky
 */
@Entity
@Table(name = "staffmessage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffmessageEntity.findAll", query = "SELECT s FROM StaffmessageEntity s"),
    @NamedQuery(name = "StaffmessageEntity.findByIdStaffMessage", query = "SELECT s FROM StaffmessageEntity s WHERE s.idStaffMessage = :idStaffMessage"),
    @NamedQuery(name = "StaffmessageEntity.findByTextOfMessage", query = "SELECT s FROM StaffmessageEntity s WHERE s.textOfMessage = :textOfMessage"),
    @NamedQuery(name = "StaffmessageEntity.findByDateOfMessage", query = "SELECT s FROM StaffmessageEntity s WHERE s.dateOfMessage = :dateOfMessage")})
public class StaffmessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idStaffMessage")
    private Integer idStaffMessage;
    @Size(max = 45)
    @Column(name = "textOfMessage")
    private String textOfMessage;
    @Column(name = "dateOfMessage")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfMessage;
    @JoinColumn(name = "author_id", referencedColumnName = "idStaffAccount")
    @ManyToOne
    private StaffaccountEntity authorId;
    @OneToMany(mappedBy = "messageId")
    private Collection<StaffmessagehistoryEntity> staffmessagehistoryEntityCollection;

    public StaffmessageEntity() {
    }

    public StaffmessageEntity(Integer idStaffMessage) {
        this.idStaffMessage = idStaffMessage;
    }

    public Integer getIdStaffMessage() {
        return idStaffMessage;
    }

    public void setIdStaffMessage(Integer idStaffMessage) {
        this.idStaffMessage = idStaffMessage;
    }

    public String getTextOfMessage() {
        return textOfMessage;
    }

    public void setTextOfMessage(String textOfMessage) {
        this.textOfMessage = textOfMessage;
    }

    public Date getDateOfMessage() {
        return dateOfMessage;
    }

    public void setDateOfMessage(Date dateOfMessage) {
        this.dateOfMessage = dateOfMessage;
    }

    public StaffaccountEntity getAuthorId() {
        return authorId;
    }

    public void setAuthorId(StaffaccountEntity authorId) {
        this.authorId = authorId;
    }

    @XmlTransient
    public Collection<StaffmessagehistoryEntity> getStaffmessagehistoryEntityCollection() {
        return staffmessagehistoryEntityCollection;
    }

    public void setStaffmessagehistoryEntityCollection(Collection<StaffmessagehistoryEntity> staffmessagehistoryEntityCollection) {
        this.staffmessagehistoryEntityCollection = staffmessagehistoryEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStaffMessage != null ? idStaffMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffmessageEntity)) {
            return false;
        }
        StaffmessageEntity other = (StaffmessageEntity) object;
        if ((this.idStaffMessage == null && other.idStaffMessage != null) || (this.idStaffMessage != null && !this.idStaffMessage.equals(other.idStaffMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StaffmessageEntity[ idStaffMessage=" + idStaffMessage + " ]";
    }
    
}
