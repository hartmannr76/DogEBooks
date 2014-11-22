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
@Table(name = "audiobook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AudiobookEntity.findAll", query = "SELECT a FROM AudiobookEntity a"),
    @NamedQuery(name = "AudiobookEntity.findByIdAudioBook", query = "SELECT a FROM AudiobookEntity a WHERE a.idAudioBook = :idAudioBook"),
    @NamedQuery(name = "AudiobookEntity.findByDurationOfBook", query = "SELECT a FROM AudiobookEntity a WHERE a.durationOfBook = :durationOfBook"),
    @NamedQuery(name = "AudiobookEntity.findByEdition", query = "SELECT a FROM AudiobookEntity a WHERE a.edition = :edition"),
    @NamedQuery(name = "AudiobookEntity.findByIsbn", query = "SELECT a FROM AudiobookEntity a WHERE a.isbn = :isbn"),
    @NamedQuery(name = "AudiobookEntity.findByNumberOfParts", query = "SELECT a FROM AudiobookEntity a WHERE a.numberOfParts = :numberOfParts"),
    @NamedQuery(name = "AudiobookEntity.findBySampleOfItemDownloadURL", query = "SELECT a FROM AudiobookEntity a WHERE a.sampleOfItemDownloadURL = :sampleOfItemDownloadURL"),
    @NamedQuery(name = "AudiobookEntity.findByExerptOfItemDownloadURL", query = "SELECT a FROM AudiobookEntity a WHERE a.exerptOfItemDownloadURL = :exerptOfItemDownloadURL"),
    @NamedQuery(name = "AudiobookEntity.findByBurnToCD", query = "SELECT a FROM AudiobookEntity a WHERE a.burnToCD = :burnToCD"),
    @NamedQuery(name = "AudiobookEntity.findByTransferToDevice", query = "SELECT a FROM AudiobookEntity a WHERE a.transferToDevice = :transferToDevice"),
    @NamedQuery(name = "AudiobookEntity.findByTransferToAppleDevice", query = "SELECT a FROM AudiobookEntity a WHERE a.transferToAppleDevice = :transferToAppleDevice"),
    @NamedQuery(name = "AudiobookEntity.findByPublicPerformance", query = "SELECT a FROM AudiobookEntity a WHERE a.publicPerformance = :publicPerformance"),
    @NamedQuery(name = "AudiobookEntity.findByFileSharing", query = "SELECT a FROM AudiobookEntity a WHERE a.fileSharing = :fileSharing"),
    @NamedQuery(name = "AudiobookEntity.findByPeerToPeerUsage", query = "SELECT a FROM AudiobookEntity a WHERE a.peerToPeerUsage = :peerToPeerUsage")})
public class AudiobookEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAudioBook")
    private Integer idAudioBook;
    @Column(name = "durationOfBook")
    private Integer durationOfBook;
    @Column(name = "edition")
    private Integer edition;
    @Size(max = 45)
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "numberOfParts")
    private Integer numberOfParts;
    @Size(max = 45)
    @Column(name = "sampleOfItemDownloadURL")
    private String sampleOfItemDownloadURL;
    @Size(max = 45)
    @Column(name = "exerptOfItemDownloadURL")
    private String exerptOfItemDownloadURL;
    @Size(max = 45)
    @Column(name = "burnToCD")
    private String burnToCD;
    @Size(max = 45)
    @Column(name = "transferToDevice")
    private String transferToDevice;
    @Size(max = 45)
    @Column(name = "transferToAppleDevice")
    private String transferToAppleDevice;
    @Size(max = 45)
    @Column(name = "publicPerformance")
    private String publicPerformance;
    @Size(max = 45)
    @Column(name = "fileSharing")
    private String fileSharing;
    @Size(max = 45)
    @Column(name = "peerToPeerUsage")
    private String peerToPeerUsage;
    @JoinColumn(name = "item_id", referencedColumnName = "idItem")
    @ManyToOne
    private ItemEntity itemId;

    public AudiobookEntity() {
    }

    public AudiobookEntity(Integer idAudioBook) {
        this.idAudioBook = idAudioBook;
    }

    public Integer getIdAudioBook() {
        return idAudioBook;
    }

    public void setIdAudioBook(Integer idAudioBook) {
        this.idAudioBook = idAudioBook;
    }

    public Integer getDurationOfBook() {
        return durationOfBook;
    }

    public void setDurationOfBook(Integer durationOfBook) {
        this.durationOfBook = durationOfBook;
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

    public Integer getNumberOfParts() {
        return numberOfParts;
    }

    public void setNumberOfParts(Integer numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    public String getSampleOfItemDownloadURL() {
        return sampleOfItemDownloadURL;
    }

    public void setSampleOfItemDownloadURL(String sampleOfItemDownloadURL) {
        this.sampleOfItemDownloadURL = sampleOfItemDownloadURL;
    }

    public String getExerptOfItemDownloadURL() {
        return exerptOfItemDownloadURL;
    }

    public void setExerptOfItemDownloadURL(String exerptOfItemDownloadURL) {
        this.exerptOfItemDownloadURL = exerptOfItemDownloadURL;
    }

    public String getBurnToCD() {
        return burnToCD;
    }

    public void setBurnToCD(String burnToCD) {
        this.burnToCD = burnToCD;
    }

    public String getTransferToDevice() {
        return transferToDevice;
    }

    public void setTransferToDevice(String transferToDevice) {
        this.transferToDevice = transferToDevice;
    }

    public String getTransferToAppleDevice() {
        return transferToAppleDevice;
    }

    public void setTransferToAppleDevice(String transferToAppleDevice) {
        this.transferToAppleDevice = transferToAppleDevice;
    }

    public String getPublicPerformance() {
        return publicPerformance;
    }

    public void setPublicPerformance(String publicPerformance) {
        this.publicPerformance = publicPerformance;
    }

    public String getFileSharing() {
        return fileSharing;
    }

    public void setFileSharing(String fileSharing) {
        this.fileSharing = fileSharing;
    }

    public String getPeerToPeerUsage() {
        return peerToPeerUsage;
    }

    public void setPeerToPeerUsage(String peerToPeerUsage) {
        this.peerToPeerUsage = peerToPeerUsage;
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
        hash += (idAudioBook != null ? idAudioBook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AudiobookEntity)) {
            return false;
        }
        AudiobookEntity other = (AudiobookEntity) object;
        if ((this.idAudioBook == null && other.idAudioBook != null) || (this.idAudioBook != null && !this.idAudioBook.equals(other.idAudioBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AudiobookEntity[ idAudioBook=" + idAudioBook + " ]";
    }
    
}
