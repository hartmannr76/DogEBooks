/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "useraccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UseraccountEntity.findAll", query = "SELECT u FROM UseraccountEntity u"),
    @NamedQuery(name = "UseraccountEntity.findByIdUserLibraryCode", query = "SELECT u FROM UseraccountEntity u WHERE u.idUserLibraryCode = :idUserLibraryCode"),
    @NamedQuery(name = "UseraccountEntity.findByUserName", query = "SELECT u FROM UseraccountEntity u WHERE u.userName = :userName"),
    @NamedQuery(name = "UseraccountEntity.findByUserEmail", query = "SELECT u FROM UseraccountEntity u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "UseraccountEntity.findByUserPassword", query = "SELECT u FROM UseraccountEntity u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "UseraccountEntity.findByUserMobileNumber", query = "SELECT u FROM UseraccountEntity u WHERE u.userMobileNumber = :userMobileNumber"),
    @NamedQuery(name = "UseraccountEntity.findByUserProfileImage", query = "SELECT u FROM UseraccountEntity u WHERE u.userProfileImage = :userProfileImage"),
    @NamedQuery(name = "UseraccountEntity.findByUserFirstName", query = "SELECT u FROM UseraccountEntity u WHERE u.userFirstName = :userFirstName"),
    @NamedQuery(name = "UseraccountEntity.findByUserLastName", query = "SELECT u FROM UseraccountEntity u WHERE u.userLastName = :userLastName")})
public class UseraccountEntity implements Serializable {
    @OneToMany(mappedBy = "useraccountId")
    private Collection<UserreviewhistoryEntity> userreviewhistoryEntityCollection;
    @OneToMany(mappedBy = "useraccountId")
    private Collection<Usercheckouthistory> usercheckouthistoryCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<NotificationhistoryEntity> notificationhistoryEntityCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<WishlistEntity> wishlistitemEntityCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUserLibraryCode")
    private Integer idUserLibraryCode;
    @Size(max = 45)
    @Column(name = "userName")
    private String userName;
    @Size(max = 45)
    @Column(name = "userEmail")
    private String userEmail;
    @Size(max = 45)
    @Column(name = "userPassword")
    private String userPassword;
    @Size(max = 45)
    @Column(name = "userMobileNumber")
    private String userMobileNumber;
    @Size(max = 45)
    @Column(name = "userProfileImage")
    private String userProfileImage;
    @Size(max = 45)
    @Column(name = "userFirstName")
    private String userFirstName;
    @Size(max = 45)
    @Column(name = "userLastName")
    private String userLastName;

    public UseraccountEntity() {
    }

    public UseraccountEntity(Integer idUserLibraryCode) {
        this.idUserLibraryCode = idUserLibraryCode;
    }

    public Integer getIdUserLibraryCode() {
        return idUserLibraryCode;
    }

    public void setIdUserLibraryCode(Integer idUserLibraryCode) {
        this.idUserLibraryCode = idUserLibraryCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserLibraryCode != null ? idUserLibraryCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UseraccountEntity)) {
            return false;
        }
        UseraccountEntity other = (UseraccountEntity) object;
        if ((this.idUserLibraryCode == null && other.idUserLibraryCode != null) || (this.idUserLibraryCode != null && !this.idUserLibraryCode.equals(other.idUserLibraryCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UseraccountEntity[ idUserLibraryCode=" + idUserLibraryCode + " ]";
    }

    @XmlTransient
    public Collection<NotificationhistoryEntity> getNotificationhistoryEntityCollection() {
        return notificationhistoryEntityCollection;
    }

    public void setNotificationhistoryEntityCollection(Collection<NotificationhistoryEntity> notificationhistoryEntityCollection) {
        this.notificationhistoryEntityCollection = notificationhistoryEntityCollection;
    }

    @XmlTransient
    public Collection<WishlistEntity> getWishlistitemEntityCollection() {
        return wishlistitemEntityCollection;
    }

    public void setWishlistitemEntityCollection(Collection<WishlistEntity> wishlistitemEntityCollection) {
        this.wishlistitemEntityCollection = wishlistitemEntityCollection;
    }

    @XmlTransient
    public Collection<Usercheckouthistory> getUsercheckouthistoryCollection() {
        return usercheckouthistoryCollection;
    }

    public void setUsercheckouthistoryCollection(Collection<Usercheckouthistory> usercheckouthistoryCollection) {
        this.usercheckouthistoryCollection = usercheckouthistoryCollection;
    }

    @XmlTransient
    public Collection<UserreviewhistoryEntity> getUserreviewhistoryEntityCollection() {
        return userreviewhistoryEntityCollection;
    }

    public void setUserreviewhistoryEntityCollection(Collection<UserreviewhistoryEntity> userreviewhistoryEntityCollection) {
        this.userreviewhistoryEntityCollection = userreviewhistoryEntityCollection;
    }
    
}
