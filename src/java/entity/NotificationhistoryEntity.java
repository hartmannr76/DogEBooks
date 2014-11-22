/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricky
 */
@Entity
@Table(name = "notificationhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificationhistoryEntity.findAll", query = "SELECT n FROM NotificationhistoryEntity n"),
    @NamedQuery(name = "NotificationhistoryEntity.findByIdnotificationhistory", query = "SELECT n FROM NotificationhistoryEntity n WHERE n.idnotificationhistory = :idnotificationhistory"),
    @NamedQuery(name = "NotificationhistoryEntity.findByHasItBeenSeen", query = "SELECT n FROM NotificationhistoryEntity n WHERE n.hasItBeenSeen = :hasItBeenSeen")})
public class NotificationhistoryEntity implements Serializable {
    @Column(name = "notificationDate")
    @Temporal(TemporalType.DATE)
    private Date notificationDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "notificationText")
    private String notificationText;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idnotificationhistory")
    private Integer idnotificationhistory;
    @Size(max = 45)
    @Column(name = "hasItBeenSeen")
    private String hasItBeenSeen;
    @JoinColumn(name = "user_id", referencedColumnName = "idUserLibraryCode")
    @ManyToOne
    private UseraccountEntity userId;
    @JoinColumn(name = "notification_id", referencedColumnName = "idNotification")
    @ManyToOne
    private NotificationEntity notificationId;

    public NotificationhistoryEntity() {
    }

    public NotificationhistoryEntity(Integer idnotificationhistory) {
        this.idnotificationhistory = idnotificationhistory;
    }

    public Integer getIdnotificationhistory() {
        return idnotificationhistory;
    }

    public void setIdnotificationhistory(Integer idnotificationhistory) {
        this.idnotificationhistory = idnotificationhistory;
    }

    public String getHasItBeenSeen() {
        return hasItBeenSeen;
    }

    public void setHasItBeenSeen(String hasItBeenSeen) {
        this.hasItBeenSeen = hasItBeenSeen;
    }

    public UseraccountEntity getUserId() {
        return userId;
    }

    public void setUserId(UseraccountEntity userId) {
        this.userId = userId;
    }

    public NotificationEntity getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(NotificationEntity notificationId) {
        this.notificationId = notificationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnotificationhistory != null ? idnotificationhistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationhistoryEntity)) {
            return false;
        }
        NotificationhistoryEntity other = (NotificationhistoryEntity) object;
        if ((this.idnotificationhistory == null && other.idnotificationhistory != null) || (this.idnotificationhistory != null && !this.idnotificationhistory.equals(other.idnotificationhistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NotificationhistoryEntity[ idnotificationhistory=" + idnotificationhistory + " ]";
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }
    
}
