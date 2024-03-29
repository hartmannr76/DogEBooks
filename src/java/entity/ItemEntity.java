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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemEntity.findAll", query = "SELECT i FROM ItemEntity i"),
    @NamedQuery(name = "ItemEntity.findByIdItem", query = "SELECT i FROM ItemEntity i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "ItemEntity.findByItemName", query = "SELECT i FROM ItemEntity i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "ItemEntity.findByAuthor", query = "SELECT i FROM ItemEntity i WHERE i.author = :author"),
    @NamedQuery(name = "ItemEntity.findByAvailableCopies", query = "SELECT i FROM ItemEntity i WHERE i.availableCopies = :availableCopies"),
    @NamedQuery(name = "ItemEntity.findByLibraryCopies", query = "SELECT i FROM ItemEntity i WHERE i.libraryCopies = :libraryCopies"),
    @NamedQuery(name = "ItemEntity.findByPublisher", query = "SELECT i FROM ItemEntity i WHERE i.publisher = :publisher"),
    @NamedQuery(name = "ItemEntity.findByBookSubject", query = "SELECT i FROM ItemEntity i WHERE i.bookSubject = :bookSubject"),
    @NamedQuery(name = "ItemEntity.findByNumberOfLikes", query = "SELECT i FROM ItemEntity i WHERE i.numberOfLikes = :numberOfLikes"),
    @NamedQuery(name = "ItemEntity.findByNumberOfDislikes", query = "SELECT i FROM ItemEntity i WHERE i.numberOfDislikes = :numberOfDislikes"),
    @NamedQuery(name = "ItemEntity.findByDescription", query = "SELECT i FROM ItemEntity i WHERE i.description = :description"),
    @NamedQuery(name = "ItemEntity.findByAboutTheAuthor", query = "SELECT i FROM ItemEntity i WHERE i.aboutTheAuthor = :aboutTheAuthor"),
    @NamedQuery(name = "ItemEntity.findByReleaseDate", query = "SELECT i FROM ItemEntity i WHERE i.releaseDate = :releaseDate"),
    @NamedQuery(name = "ItemEntity.findByFileSize", query = "SELECT i FROM ItemEntity i WHERE i.fileSize = :fileSize"),
    @NamedQuery(name = "ItemEntity.findByItemSeries", query = "SELECT i FROM ItemEntity i WHERE i.itemSeries = :itemSeries"),
    @NamedQuery(name = "ItemEntity.findByType", query = "SELECT i FROM ItemEntity i WHERE i.type = :type")})
public class ItemEntity implements Serializable {
    @Column(name =     "releaseDate")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(name =     "dateAdded")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @OneToMany(mappedBy = "itemId")
    private Collection<UserreviewhistoryEntity> userreviewhistoryEntityCollection;
    @OneToMany(mappedBy = "itemId")
    private Collection<Usercheckouthistory> usercheckouthistoryCollection;
    @Column(name = "type")
    private Integer type;
    @OneToMany(mappedBy = "itemId")
    private Collection<MusicEntity> musicEntityCollection;
    @OneToMany(mappedBy = "itemId")
    private Collection<AudiobookEntity> audiobookEntityCollection;
    @OneToMany(mappedBy = "itemId")
    private Collection<WishlistEntity> wishlistitemEntityCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idItem")
    @EmbeddedId
    private Integer idItem;
    @Size(max = 45)
    @Column(name = "itemName")
    private String itemName;
    @Size(max = 45)
    @Column(name = "author")
    private String author;
    @Column(name = "availableCopies")
    private Integer availableCopies;
    @Column(name = "libraryCopies")
    private Integer libraryCopies;
    @Lob
    @Size(max = 65535)
    @Column(name = "languagesOffered")
    private String languagesOffered;
    @Size(max = 45)
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "bookSubject")
    private Integer bookSubject;
    @Column(name = "numberOfLikes")
    private Integer numberOfLikes;
    @Column(name = "numberOfDislikes")
    private Integer numberOfDislikes;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "aboutTheAuthor")
    private String aboutTheAuthor;
    @Column(name = "fileSize")
    private Integer fileSize;
    @Size(max = 45)
    @Column(name = "itemSeries")
    private String itemSeries;
    @Lob
    @Size(max = 65535)
    @Column(name = "itemImage")
    private String itemImage;
    @Lob
    @Size(max = 65535)
    @Column(name = "digitalRights")
    private String digitalRights;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "itemEntity")
    @PrimaryKeyJoinColumn
    private EbookEntity ebookEntity;

    public ItemEntity() {
    }

    public ItemEntity(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getLanguagesOffered() {
        return languagesOffered;
    }

    public void setLanguagesOffered(String languagesOffered) {
        this.languagesOffered = languagesOffered;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getBookSubject() {
        return bookSubject;
    }

    public void setBookSubject(Integer bookSubject) {
        this.bookSubject = bookSubject;
    }

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Integer getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public void setNumberOfDislikes(Integer numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAboutTheAuthor() {
        return aboutTheAuthor;
    }

    public void setAboutTheAuthor(String aboutTheAuthor) {
        this.aboutTheAuthor = aboutTheAuthor;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getItemSeries() {
        return itemSeries;
    }

    public void setItemSeries(String itemSeries) {
        this.itemSeries = itemSeries;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getDigitalRights() {
        return digitalRights;
    }

    public void setDigitalRights(String digitalRights) {
        this.digitalRights = digitalRights;
    }

    public EbookEntity getEbookEntity() {
        return ebookEntity;
    }

    public void setEbookEntity(EbookEntity ebookEntity) {
        this.ebookEntity = ebookEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntity)) {
            return false;
        }
        ItemEntity other = (ItemEntity) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItemEntity[ idItem=" + idItem + " ]";
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<MusicEntity> getMusicEntityCollection() {
        return musicEntityCollection;
    }

    public void setMusicEntityCollection(Collection<MusicEntity> musicEntityCollection) {
        this.musicEntityCollection = musicEntityCollection;
    }

    @XmlTransient
    public Collection<AudiobookEntity> getAudiobookEntityCollection() {
        return audiobookEntityCollection;
    }

    public void setAudiobookEntityCollection(Collection<AudiobookEntity> audiobookEntityCollection) {
        this.audiobookEntityCollection = audiobookEntityCollection;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @XmlTransient
    public Collection<UserreviewhistoryEntity> getUserreviewhistoryEntityCollection() {
        return userreviewhistoryEntityCollection;
    }

    public void setUserreviewhistoryEntityCollection(Collection<UserreviewhistoryEntity> userreviewhistoryEntityCollection) {
        this.userreviewhistoryEntityCollection = userreviewhistoryEntityCollection;
    }
    
}
