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
@Table(name = "ebook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EbookEntity.findAll", query = "SELECT e FROM EbookEntity e"),
    @NamedQuery(name = "EbookEntity.findByEdition", query = "SELECT e FROM EbookEntity e WHERE e.edition = :edition"),
    @NamedQuery(name = "EbookEntity.findByIsbn", query = "SELECT e FROM EbookEntity e WHERE e.isbn = :isbn"),
    @NamedQuery(name = "EbookEntity.findByItemId", query = "SELECT e FROM EbookEntity e WHERE e.itemId = :itemId"),
    @NamedQuery(name = "EbookEntity.findByAvailableCopies", query = "SELECT e FROM EbookEntity e WHERE e.availableCopies = :availableCopies"),
    @NamedQuery(name = "EbookEntity.findByLibraryCopies", query = "SELECT e FROM EbookEntity e WHERE e.libraryCopies = :libraryCopies")})
public class EbookEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Lob
    @Size(max = 65535)
    @Column(name = "digitalRightsInformation")
    private String digitalRightsInformation;
    @Column(name = "edition")
    private Integer edition;
    @Size(max = 45)
    @Column(name = "ISBN")
    private String isbn;
    @Id
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "availableCopies")
    private Integer availableCopies;
    @Column(name = "libraryCopies")
    private Integer libraryCopies;
    @JoinColumn(name = "item_id", referencedColumnName = "idItem", insertable = false, updatable = false)
    @OneToOne
    @PrimaryKeyJoinColumn
    private ItemEntity itemEntity;

    public EbookEntity() {
    }

    public EbookEntity(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDigitalRightsInformation() {
        return digitalRightsInformation;
    }

    public void setDigitalRightsInformation(String digitalRightsInformation) {
        this.digitalRightsInformation = digitalRightsInformation;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Integer getLibraryCopies() {
        return libraryCopies;
    }

    public void setLibraryCopies(Integer libraryCopies) {
        this.libraryCopies = libraryCopies;
    }

    public ItemEntity getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(ItemEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EbookEntity)) {
            return false;
        }
        EbookEntity other = (EbookEntity) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EbookEntity[ itemId=" + itemId + " ]";
    }
    
}
