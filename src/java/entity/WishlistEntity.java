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
@Table(name = "wishlistitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WishlistEntity.findAll", query = "SELECT w FROM WishlistEntity w"),
    @NamedQuery(name = "WishlistEntity.findByIdWishlistItem", query = "SELECT w FROM WishlistEntity w WHERE w.idWishlistItem = :idWishlistItem"),
    @NamedQuery(name = "WishlistEntity.findByDateAddedToWishlist", query = "SELECT w FROM WishlistEntity w WHERE w.dateAddedToWishlist = :dateAddedToWishlist"),
    @NamedQuery(name = "WishlistEntity.findByLendingPeriodOfItem", query = "SELECT w FROM WishlistEntity w WHERE w.lendingPeriodOfItem = :lendingPeriodOfItem"),
    @NamedQuery(name = "WishlistEntity.findByFormatOfItem", query = "SELECT w FROM WishlistEntity w WHERE w.formatOfItem = :formatOfItem")})
public class WishlistEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idWishlistItem")
    private Integer idWishlistItem;
    @Column(name = "dateAddedToWishlist")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAddedToWishlist;
    @Column(name = "lendingPeriodOfItem")
    private Integer lendingPeriodOfItem;
    @Size(max = 45)
    @Column(name = "formatOfItem")
    private String formatOfItem;
    @JoinColumn(name = "item_id", referencedColumnName = "idItem")
    @ManyToOne
    private ItemEntity itemId;
    @JoinColumn(name = "user_id", referencedColumnName = "idUserLibraryCode")
    @ManyToOne
    private UseraccountEntity userId;

    public WishlistEntity() {
    }

    public WishlistEntity(Integer idWishlistItem) {
        this.idWishlistItem = idWishlistItem;
    }

    public Integer getIdWishlistItem() {
        return idWishlistItem;
    }

    public void setIdWishlistItem(Integer idWishlistItem) {
        this.idWishlistItem = idWishlistItem;
    }

    public Date getDateAddedToWishlist() {
        return dateAddedToWishlist;
    }

    public void setDateAddedToWishlist(Date dateAddedToWishlist) {
        this.dateAddedToWishlist = dateAddedToWishlist;
    }

    public Integer getLendingPeriodOfItem() {
        return lendingPeriodOfItem;
    }

    public void setLendingPeriodOfItem(Integer lendingPeriodOfItem) {
        this.lendingPeriodOfItem = lendingPeriodOfItem;
    }

    public String getFormatOfItem() {
        return formatOfItem;
    }

    public void setFormatOfItem(String formatOfItem) {
        this.formatOfItem = formatOfItem;
    }

    public ItemEntity getItemId() {
        return itemId;
    }

    public void setItemId(ItemEntity itemId) {
        this.itemId = itemId;
    }

    public UseraccountEntity getUserId() {
        return userId;
    }

    public void setUserId(UseraccountEntity userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWishlistItem != null ? idWishlistItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WishlistEntity)) {
            return false;
        }
        WishlistEntity other = (WishlistEntity) object;
        if ((this.idWishlistItem == null && other.idWishlistItem != null) || (this.idWishlistItem != null && !this.idWishlistItem.equals(other.idWishlistItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WishlistEntity[ idWishlistItem=" + idWishlistItem + " ]";
    }
    
}