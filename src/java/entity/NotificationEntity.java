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
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationEntity.findAll", query = "SELECT n FROM NotificationEntity n"),
    @NamedQuery(name = "NotificationEntity.findByIdNotification", query = "SELECT n FROM NotificationEntity n WHERE n.idNotification = :idNotification"),
    @NamedQuery(name = "NotificationEntity.findByDateOfNoticatation", query = "SELECT n FROM NotificationEntity n WHERE n.dateOfNoticatation = :dateOfNoticatation")})
public class NotificationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNotification")
    private Integer idNotification;
    @Lob
    @Size(max = 65535)
    @Column(name = "notificationText")
    private String notificationText;
    @Column(name = "dateOfNoticatation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfNoticatation;
    @OneToMany(mappedBy = "notificationId")
    private Collection<NotificationhistoryEntity> notificationhistoryEntityCollection;

    public NotificationEntity() {
    }

    public NotificationEntity(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public Date getDateOfNoticatation() {
        return dateOfNoticatation;
    }

    public void setDateOfNoticatation(Date dateOfNoticatation) {
        this.dateOfNoticatation = dateOfNoticatation;
    }

    @XmlTransient
    public Collection<NotificationhistoryEntity> getNotificationhistoryEntityCollection() {
        return notificationhistoryEntityCollection;
    }

    public void setNotificationhistoryEntityCollection(Collection<NotificationhistoryEntity> notificationhistoryEntityCollection) {
        this.notificationhistoryEntityCollection = notificationhistoryEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotification != null ? idNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationEntity)) {
            return false;
        }
        NotificationEntity other = (NotificationEntity) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NotificationEntity[ idNotification=" + idNotification + " ]";
    }
    
}
