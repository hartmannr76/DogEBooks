/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.requests;

import controller.managers.ItemManager;
import controller.managers.UserManager;
import enums.Category;
import enums.ItemType;
import item.AudioBook;
import item.EBook;
import item.Item;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import stf.StaffAccount;
import user.User;

/**
 *
 * @author Ricky
 */
@ManagedBean (name = "adminReq")
@ViewScoped
public class AdminRequestController implements Serializable{

    boolean prepared = false;
    List<Item> displayList;
    @EJB
    ItemManager im;
    @EJB
    UserManager um;
    String message = "Welcome Admin!";
    String itemTitle;
    int itemISBN;
    String itemAuthor;
    String itemDescription;
    Category itemCategory;
    ItemType itemItemType;
    Date releaseDate;
    String publisher;
    int copiesAmount;
    int viewSet;
    UploadedFile itemImageLocation;
    UploadedFile audioExcerptLocation;
    private static final String bookImageDir = "/images/books";
    private static final String audiobookImageDir = "/images/audiobooks";
    private static final String excerptDir = "/excerpts";
    private String realPath;
    private Map<Long, Boolean> itemsToDelete = new HashMap<Long, Boolean>();
    private static final String locationImageDir = "http://localhost:8080/cse308/images/";
    private static final String excerptsDir = "http://localhost:8080/cse308/excerpts/";
    Item editingItem;
    

    /**
     * Creates a new instance of AdminRequestController
     */
    public AdminRequestController() {
        
    }
    
    @PostConstruct
    public void init() {
        if(getPageSet().equals("eBooks.xhtml") || getPageSet().equals("add-eBook.xhtml")) {
            prepareEBooks();
            viewSet = 1;
        }
        
        else if(getPageSet().equals("audioBooks.xhtml") || getPageSet().equals("add-audiobook.xhtml")) {
            prepareAudiobooks();
            viewSet = 2;
        }
        
        else if(getPageSet().equals("music.xhtml")) {
            prepareMusic();
            viewSet = 3;
        }
        else if(getPageSet().equals("edit-eBook.xhtml") || getPageSet().equals("edit-audiobook.xhtml")) {
            if(getPageSet().equals("edit-eBook.xhtml"))
                viewSet = 1;
            else if(getPageSet().equals("edit-audiobook.xhtml"))
                viewSet = 2;
            int id = 1;
            if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("itemId") != null)
                   id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("itemId"));
            editingItem = im.getItemById(id);
            itemCategory = getCategoryForObj(editingItem.getItemCategory());
        }
    }
    
    public String getPageSet(){
        String orig = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        String[] postSplit = orig.split("/");
        return postSplit[2];
    }
    
    public Category getCategoryForObj(int i){
        for(Category c : Category.values()){
            if(c.getCategoryId() == i)
                return c;
        }
        return Category.ART_ANTIQUES_COLLECTIBLES;
    }
    
    /*
     * Prepare pages
     */
    
    public void prepareEBooks() {
        displayList = im.getAdminItemList(1);
    }
    
    public void prepareAudiobooks() {
        displayList = im.getAdminItemList(2);
    }
    
    public void prepareMusic() {
        displayList = im.getAdminItemList(3);
    }
    
    /*
     * Administrator based interactive functions
     */
    
    public void addEBook() throws IOException {
        String fileName = FilenameUtils.getName(itemImageLocation.getName());
        byte[] bytes = itemImageLocation.getBytes();
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        this.realPath = sc.getRealPath(bookImageDir); // Acquire the actual path of the requested drectory
       
        /*
         * This chunk is for adjusting the size of the input image
         */
        InputStream in = new ByteArrayInputStream(bytes);
        BufferedImage bIm = ImageIO.read(in);
        
        byte[] outBytes = getThumbnail(bIm);      
        byte[] bigOutBytes = getBiggerImage(bIm);
        
        /*
         * We need to create a new file that contains the directory to output
         * as well as the name we request. We then need to write the file info
         * into the correct location.
         */
        // Write the small file to space
        File tempFile = new File(new File(realPath), fileName); 
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(outBytes);
        fos.close();
        
        // Write the big image to space
        File bigFile = new File(new File(realPath), getBigImageName(fileName)); 
        fos = new FileOutputStream(bigFile);
        fos.write(bigOutBytes);
        fos.close();
        EBook ebookToInsert = new EBook(itemTitle, locationImageDir+"books/"+tempFile.getName(), ItemType.EBOOK.getTypeId(), itemCategory.getCategoryId(), this.itemAuthor, Integer.toString(this.itemISBN), this.copiesAmount, this.copiesAmount);
        im.addItemToLibrary(ebookToInsert);
    }
    
    public void editEBook() throws IOException {
        if(itemImageLocation != null) {
            String fileName = FilenameUtils.getName(itemImageLocation.getName());
            byte[] bytes = itemImageLocation.getBytes();
            ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            this.realPath = sc.getRealPath(bookImageDir);

            /*
            * This chunk is for adjusting the size of the input image
            */
            InputStream in = new ByteArrayInputStream(bytes);
            BufferedImage bIm = ImageIO.read(in);

            byte[] outBytes = getThumbnail(bIm);      
            byte[] bigOutBytes = getBiggerImage(bIm);

            /*
            * We need to create a new file that contains the directory to output
            * as well as the name we request. We then need to write the file info
            * into the correct location.
            */
            // Write the small file to space
            File tempFile = new File(new File(realPath), fileName); 
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(outBytes);
            fos.close();

            // Write the big image to space
            File bigFile = new File(new File(realPath), getBigImageName(fileName)); 
            fos = new FileOutputStream(bigFile);
            fos.write(bigOutBytes);
            fos.close();
            
            editingItem.setItemImage(locationImageDir+"books/"+tempFile.getName());
        }
        if(getCategoryForObj(editingItem.getItemCategory()) != itemCategory) {
            editingItem.setItemCategory(itemCategory.getCategoryId());
        }
        
        EBook ebookToEdit = (EBook)editingItem;
        //im.addItemToLibrary(ebookToEdit);
    }
    
    public void addAudioook() throws IOException {
        String fileName = FilenameUtils.getName(itemImageLocation.getName());
        byte[] bytes = itemImageLocation.getBytes();
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        this.realPath = sc.getRealPath(audiobookImageDir); // Acquire the actual path of the requested drectory
       
        /*
         * This chunk is for adjusting the size of the input image
         */
        InputStream in = new ByteArrayInputStream(bytes);
        BufferedImage bIm = ImageIO.read(in);
        
        byte[] outBytes = getThumbnail(bIm);      
        byte[] bigOutBytes = getBiggerImage(bIm);
        
        /*
         * We need to create a new file that contains the directory to output
         * as well as the name we request. We then need to write the file info
         * into the correct location.
         */
        // Write the small file to space
        File tempFile = new File(new File(realPath), fileName); 
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(outBytes);
        fos.close();
        
        // Write the big image to space
        File bigFile = new File(new File(realPath), getBigImageName(fileName)); 
        fos = new FileOutputStream(bigFile);
        fos.write(bigOutBytes);
        fos.close();
        
        // Now we need to add the audio file
        String audioName = FilenameUtils.getName(audioExcerptLocation.getName());
        byte[] audioBytes = audioExcerptLocation.getBytes(); 
        
        this.realPath = sc.getRealPath(excerptDir); // Acquire the actual path of the requested drectory
        // Write the small file to space
        File audioFile = new File(new File(realPath), audioName); 
        fos = new FileOutputStream(audioFile);
        fos.write(audioBytes);
        fos.close();
       
        AudioBook audioBookToInset = new AudioBook(itemTitle, locationImageDir+"audiobooks/"+tempFile.getName(), ItemType.AUDIOBOOK.AUDIOBOOK.getTypeId(), itemCategory.getCategoryId(), this.itemAuthor, Integer.toString(this.itemISBN), excerptsDir+tempFile.getName(), 0, 0, this.copiesAmount, this.copiesAmount, new Date());
        im.addItemToLibrary(audioBookToInset);
    }
    
    public String deleteItems() {
        for(Long iL : itemsToDelete.keySet()) {
            if(itemsToDelete.get(iL) == true) {
                im.removeItemFromLibrary(iL.intValue());
            }            
        }
        return "";
    }
    
    
    
    public byte[] getBiggerImage(BufferedImage bim) throws IOException {
        // First create the thumbnail version
        BufferedImage outImg = new BufferedImage(100, 133, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = outImg.createGraphics();
        g.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g.drawImage(bim, 0, 0, 200, 267, null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(outImg, "jpg", baos);
        baos.flush();
        
        byte[] outBytes = baos.toByteArray();
        baos.close();
        return outBytes;
    }
    
    public byte[] getThumbnail(BufferedImage bim) throws IOException {
        // First create the thumbnail version
        BufferedImage outImg = new BufferedImage(100, 133, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = outImg.createGraphics();
        g.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g.drawImage(bim, 0, 0, 100, 133, null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(outImg, "jpg", baos);
        baos.flush();
        
        byte[] outBytes = baos.toByteArray();
        baos.close();
        return outBytes;
    }
    
    public String getBigImageName(String name) {
        String[] strBreak = name.split("\\.");
        strBreak[0] += ("_big");
        String bigFileName = "";
        
        int count = 0;
        for(String s : strBreak) {
            if(count != 0)
                bigFileName += "." + s;
            else
                bigFileName += s; 
            count++;
        }
        
        return bigFileName;
    }
    
    /*
     * Getters & Setters
     */
    
    public boolean isPrepared() {
        return prepared;  
    }
    
    public String getMessage() {
        return message;
    }
    
    public List<Item> getDisplayList() {
        return displayList;
    }

    public String getItemAuthor() {
        return itemAuthor;
    }

    public void setItemAuthor(String itemAuthor) {
        this.itemAuthor = itemAuthor;
    }

    public Category getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }
    
    public SelectItem[] getItemCategories() {
        SelectItem[] items = new SelectItem[Category.values().length];
        int i = 0;
        for(ItemType it : ItemType.values()) {
            if(it.getTypeId() == viewSet) {
                items = new SelectItem[it.getCategoriesForType().length];
                for(Category c : it.getCategoriesForType())
                    items[i++] = new SelectItem(c, c.getTextRep());
            }    
        }
        return items;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemISBN() {
        return itemISBN;
    }

    public void setItemISBN(int itemISBN) {
        this.itemISBN = itemISBN;
    }

    public ItemType getItemItemType() {
        return itemItemType;
    }

    public void setItemItemType(ItemType itemItemType) {
        this.itemItemType = itemItemType;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public UploadedFile getItemImageLocation() {
        return itemImageLocation;
    }

    public void setItemImageLocation(UploadedFile itemImageLocation) {
        this.itemImageLocation = itemImageLocation;
    }

    public Map<Long, Boolean> getItemsToDelete() {
        return itemsToDelete;
    }

    public void setItemsToDelete(Map<Long, Boolean> itemsToDelete) {
        this.itemsToDelete = itemsToDelete;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getCopiesAmount() {
        return copiesAmount;
    }

    public void setCopiesAmount(int copiesAmount) {
        this.copiesAmount = copiesAmount;
    }

    public UploadedFile getAudioExcerptLocation() {
        return audioExcerptLocation;
    }

    public void setAudioExcerptLocation(UploadedFile audioExcerptLocation) {
        this.audioExcerptLocation = audioExcerptLocation;
    }
    
    public List<User> getListOfUsers() {
        List<User> retList = new ArrayList<User>();
        HashMap hm = um.getAllUsers();
        
        for(Object u : hm.values())
            retList.add((User)u);
        return retList;
    }
    
    public List<StaffAccount> getListOfStaff() {
        List<StaffAccount> retList = new ArrayList<StaffAccount>();
        HashMap hm = um.getAllStaff();
        
        for(Object u : hm.values())
            retList.add((StaffAccount)u);
        return retList;
    }
    
    public String viewDashboard() {
        return "/admin/index.xhtml?faces-redirect=true";
    }
    
    public String viewStaff() {
        return "/admin/staff.xhtml?faces-redirect=true";
    }
    
    public String viewReports() {
        return "/admin/reports.xhtml?faces-redirect=true";
    }
    
    public String viewMessages() {
        return "/admin/messages.xhtml?faces-redirect=true";
    }
    
    public String viewCSInquiries() {
        return "/admin/customerService.xhtml?faces-redirect=true";
    }
    
    public String vieweBooks() {
        return "/admin/eBooks.xhtml?faces-redirect=true";
    }
    
    public String viewAudiobooks() {
        return "/admin/audioBooks.xhtml?faces-redirect=true";
    }
    
    public String viewMembers() {
        return "/admin/members.xhtml?faces-redirect=true";
    }
    
    public String viewMusic() {
        return "/admin/music.xhtml?faces-redirect=true";
    }

    public Item getEditingItem() {
        return editingItem;
    }

    public void setEditingItem(Item editingItem) {
        this.editingItem = editingItem;
    }
}
