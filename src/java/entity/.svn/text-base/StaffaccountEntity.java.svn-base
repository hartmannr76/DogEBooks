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
@Table(name = "staffaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffaccountEntity.findAll", query = "SELECT s FROM StaffaccountEntity s"),
    @NamedQuery(name = "StaffaccountEntity.findByIdStaffAccount", query = "SELECT s FROM StaffaccountEntity s WHERE s.idStaffAccount = :idStaffAccount"),
    @NamedQuery(name = "StaffaccountEntity.findByUserName", query = "SELECT s FROM StaffaccountEntity s WHERE s.userName = :userName"),
    @NamedQuery(name = "StaffaccountEntity.findByUserEmail", query = "SELECT s FROM StaffaccountEntity s WHERE s.userEmail = :userEmail"),
    @NamedQuery(name = "StaffaccountEntity.findByUserPassword", query = "SELECT s FROM StaffaccountEntity s WHERE s.userPassword = :userPassword"),
    @NamedQuery(name = "StaffaccountEntity.findByUserMobileNumber", query = "SELECT s FROM StaffaccountEntity s WHERE s.userMobileNumber = :userMobileNumber"),
    @NamedQuery(name = "StaffaccountEntity.findByPermissionsLevel", query = "SELECT s FROM StaffaccountEntity s WHERE s.permissionsLevel = :permissionsLevel")})
public class StaffaccountEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idStaffAccount")
    private Integer idStaffAccount;
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
    @Column(name = "permissionsLevel")
    private Integer permissionsLevel;
    @OneToMany(mappedBy = "authorId")
    private Collection<StaffmessageEntity> staffmessageEntityCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<StaffmessagehistoryEntity> staffmessagehistoryEntityCollection;

    public StaffaccountEntity() {
    }

    public StaffaccountEntity(Integer idStaffAccount) {
        this.idStaffAccount = idStaffAccount;
    }

    public Integer getIdStaffAccount() {
        return idStaffAccount;
    }

    public void setIdStaffAccount(Integer idStaffAccount) {
        this.idStaffAccount = idStaffAccount;
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

    public Integer getPermissionsLevel() {
        return permissionsLevel;
    }

    public void setPermissionsLevel(Integer permissionsLevel) {
        this.permissionsLevel = permissionsLevel;
    }

    @XmlTransient
    public Collection<StaffmessageEntity> getStaffmessageEntityCollection() {
        return staffmessageEntityCollection;
    }

    public void setStaffmessageEntityCollection(Collection<StaffmessageEntity> staffmessageEntityCollection) {
        this.staffmessageEntityCollection = staffmessageEntityCollection;
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
        hash += (idStaffAccount != null ? idStaffAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffaccountEntity)) {
            return false;
        }
        StaffaccountEntity other = (StaffaccountEntity) object;
        if ((this.idStaffAccount == null && other.idStaffAccount != null) || (this.idStaffAccount != null && !this.idStaffAccount.equals(other.idStaffAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StaffaccountEntity[ idStaffAccount=" + idStaffAccount + " ]";
    }
    
}
