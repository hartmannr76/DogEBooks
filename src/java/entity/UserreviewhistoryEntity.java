/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricky
 */
@Entity
@Table(name = "userreviewhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserreviewhistoryEntity.findAll", query = "SELECT u FROM UserreviewhistoryEntity u"),
    @NamedQuery(name = "UserreviewhistoryEntity.findByIdUserReviewHistory", query = "SELECT u FROM UserreviewhistoryEntity u WHERE u.idUserReviewHistory = :idUserReviewHistory"),
    @NamedQuery(name = "UserreviewhistoryEntity.findByRating", query = "SELECT u FROM UserreviewhistoryEntity u WHERE u.rating = :rating"),
    @NamedQuery(name = "UserreviewhistoryEntity.findByReview", query = "SELECT u FROM UserreviewhistoryEntity u WHERE u.review = :review"),
    @NamedQuery(name = "UserreviewhistoryEntity.findByLikeValue", query = "SELECT u FROM UserreviewhistoryEntity u WHERE u.likeValue = :likeValue")})
public class UserreviewhistoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUserReviewHistory")
    private Integer idUserReviewHistory;
    @Column(name = "rating")
    private Integer rating;
    @Size(max = 45)
    @Column(name = "review")
    private String review;
    @Column(name = "likeValue")
    private Integer likeValue;
    @JoinColumn(name = "useraccount_id", referencedColumnName = "idUserLibraryCode")
    @ManyToOne
    private UseraccountEntity useraccountId;
    @JoinColumn(name = "item_id", referencedColumnName = "idItem")
    @ManyToOne
    private ItemEntity itemId;

    public UserreviewhistoryEntity() {
    }

    public UserreviewhistoryEntity(Integer idUserReviewHistory) {
        this.idUserReviewHistory = idUserReviewHistory;
    }

    public Integer getIdUserReviewHistory() {
        return idUserReviewHistory;
    }

    public void setIdUserReviewHistory(Integer idUserReviewHistory) {
        this.idUserReviewHistory = idUserReviewHistory;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(Integer likeValue) {
        this.likeValue = likeValue;
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
        hash += (idUserReviewHistory != null ? idUserReviewHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserreviewhistoryEntity)) {
            return false;
        }
        UserreviewhistoryEntity other = (UserreviewhistoryEntity) object;
        if ((this.idUserReviewHistory == null && other.idUserReviewHistory != null) || (this.idUserReviewHistory != null && !this.idUserReviewHistory.equals(other.idUserReviewHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserreviewhistoryEntity[ idUserReviewHistory=" + idUserReviewHistory + " ]";
    }
    
}
