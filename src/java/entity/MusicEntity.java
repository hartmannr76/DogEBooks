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
@Table(name = "music")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MusicEntity.findAll", query = "SELECT m FROM MusicEntity m"),
    @NamedQuery(name = "MusicEntity.findByIdMusic", query = "SELECT m FROM MusicEntity m WHERE m.idMusic = :idMusic"),
    @NamedQuery(name = "MusicEntity.findByDurationOfItem", query = "SELECT m FROM MusicEntity m WHERE m.durationOfItem = :durationOfItem"),
    @NamedQuery(name = "MusicEntity.findByNumberOfParts", query = "SELECT m FROM MusicEntity m WHERE m.numberOfParts = :numberOfParts"),
    @NamedQuery(name = "MusicEntity.findBySampleOfItemDownloadURL", query = "SELECT m FROM MusicEntity m WHERE m.sampleOfItemDownloadURL = :sampleOfItemDownloadURL"),
    @NamedQuery(name = "MusicEntity.findByExcerptOfItemDownloadURL", query = "SELECT m FROM MusicEntity m WHERE m.excerptOfItemDownloadURL = :excerptOfItemDownloadURL"),
    @NamedQuery(name = "MusicEntity.findByBurnToCd", query = "SELECT m FROM MusicEntity m WHERE m.burnToCd = :burnToCd"),
    @NamedQuery(name = "MusicEntity.findByTransferToDevice", query = "SELECT m FROM MusicEntity m WHERE m.transferToDevice = :transferToDevice"),
    @NamedQuery(name = "MusicEntity.findByTransferToAppleDevice", query = "SELECT m FROM MusicEntity m WHERE m.transferToAppleDevice = :transferToAppleDevice"),
    @NamedQuery(name = "MusicEntity.findByPublicPerformance", query = "SELECT m FROM MusicEntity m WHERE m.publicPerformance = :publicPerformance"),
    @NamedQuery(name = "MusicEntity.findByFileSharing", query = "SELECT m FROM MusicEntity m WHERE m.fileSharing = :fileSharing"),
    @NamedQuery(name = "MusicEntity.findByPeerToPeerUsage", query = "SELECT m FROM MusicEntity m WHERE m.peerToPeerUsage = :peerToPeerUsage")})
public class MusicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMusic")
    private Integer idMusic;
    @Column(name = "durationOfItem")
    private Integer durationOfItem;
    @Column(name = "numberOfParts")
    private Integer numberOfParts;
    @Size(max = 45)
    @Column(name = "sampleOfItemDownloadURL")
    private String sampleOfItemDownloadURL;
    @Size(max = 45)
    @Column(name = "excerptOfItemDownloadURL")
    private String excerptOfItemDownloadURL;
    @Size(max = 45)
    @Column(name = "burnToCd")
    private String burnToCd;
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

    public MusicEntity() {
    }

    public MusicEntity(Integer idMusic) {
        this.idMusic = idMusic;
    }

    public Integer getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(Integer idMusic) {
        this.idMusic = idMusic;
    }

    public Integer getDurationOfItem() {
        return durationOfItem;
    }

    public void setDurationOfItem(Integer durationOfItem) {
        this.durationOfItem = durationOfItem;
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

    public String getExcerptOfItemDownloadURL() {
        return excerptOfItemDownloadURL;
    }

    public void setExcerptOfItemDownloadURL(String excerptOfItemDownloadURL) {
        this.excerptOfItemDownloadURL = excerptOfItemDownloadURL;
    }

    public String getBurnToCd() {
        return burnToCd;
    }

    public void setBurnToCd(String burnToCd) {
        this.burnToCd = burnToCd;
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
        hash += (idMusic != null ? idMusic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusicEntity)) {
            return false;
        }
        MusicEntity other = (MusicEntity) object;
        if ((this.idMusic == null && other.idMusic != null) || (this.idMusic != null && !this.idMusic.equals(other.idMusic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MusicEntity[ idMusic=" + idMusic + " ]";
    }
    
}
