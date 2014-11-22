/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.requests;

import controller.managers.ItemManager;
import controller.managers.UserManager;
import enums.Category;
import enums.ItemType;
import item.EBook;
import item.Item;
import item.Search;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import sessions.UserSession;
import user.User;
import user.WishlistItem;

/**
 * This is our main visual controlling bean. It controls most user view requests, and based on
 * the page and information asked to be displayed, it will populate the proper data structures
 * and fill them in with the required information
 * 
 * @author Ricky
 */

@ManagedBean (name = "viewReq")
@ViewScoped
public class ViewRequestController implements Serializable {

    int typeToView;
    int categoryToView;
    int itemToView;
    @EJB 
    UserSession us;
    @EJB 
    UserManager um;
    @EJB
    ItemManager im;
    List<Item> userCart;
    List<Item> listOfeItems;
    List<WishlistItem> listOfWishlistItems;
    //      Using set numbers to represent locations on different pages (i.e. Index: ebooks, audiobooks, music; Type: newest, featured,
    //      highest rated)
    List<Item> set1; 
    List<Item> set2;
    List<Item> set3;
    Item viewableItem;
    String currentList;
    ItemType typeViewed;
    Category categoryViewed;
    String search;
    
    User userView;
    
    // Items for advanced search
    String searchTitle;
    String searchAuthor;
    String searchKeyword;
    int searchFormat;
    String searchSubject;
    
    Item index1;
    Item index2;
    Item index3;

    /**
     * In order to populate information to view a wishlist that the user has requested,
     * we need to grab the hidden element from the prev page request
     */
    
    public ViewRequestController() {  
        this.currentList = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("list");
        System.out.print(currentList);
    }
    
    
    /**
     * This is one of the more important function in this structure, it finds the page request in the url and 
     * will populate data structures for the requested page to use
     */
    @PostConstruct
    public void init() {
        userCart = us.getObjCart();
        if(getPageSet().equals("type")) {
            if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("typeId") != null) 
                typeToView = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("typeId"));
            else typeToView = 1;
            System.out.print("Preparing type page..." + typeToView);
            prepareTypePage();
        } 
        else if(getPageSet().equals("category")) {
            if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("catId") != null)
                categoryToView = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("catId"));
            else categoryToView = 1;
            System.out.print("Preparing category page..." + categoryToView);
            prepareCategoryPage();
        }
        else if(getPageSet().equals("item")) {
            if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("bookId") != null)
                itemToView = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("bookId"));
            else itemToView = 1;
            System.out.print("Preparing item page..." + itemToView);
            prepareItemPage();
        }
        else if(getPageSet().equals("account")) {
            if(us.getUser() == null && !getPage().equals("cart.xhtml") && !getPage().equals("register.xhtml") && !getPage().equals("login.xhtml"))
                redirectUserHome(FacesContext.getCurrentInstance());
            System.out.print("Preparing account page...");
            if(us.getUser() != null) {
                userView = us.getUser();
                listOfWishlistItems = us.getUser().getWishlists();
            }
        }
        else if(getPageSet().equals("search")) {
            System.out.print("Preparing search page...");
            if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("searchType") != null) {
                String title = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("title");
                if (title==null)
                    title="";
                String author = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("name");
                if (author==null)
                    author="";
                String keyword = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("keyword");
                if (keyword==null)
                    keyword="";
                int format = 0;
                if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("format") != null)
                   format = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("format"));
                String subject = resolveSubject(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("subject"));
                runAdvancedSearch(title, author, keyword, format, subject);
            }
            else if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("search") != null) {
                search = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("search");
                runSearch();
            }
        }
        else {
            System.out.print("Preparing index page...");
            System.out.print(getPageSet());
            prepareIndexPage();
        }
    }
    
    public void redirectUserHome(FacesContext context) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ViewRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void attrListener(ActionEvent event){
	currentList = (String)event.getComponent().getAttributes().get("list");
        System.out.print(currentList);
    }
    
    /**
     * Generic function to figure out what the page request is
     * @return the location of the request
     */
    
    public String getPageSet(){
        String orig = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        String[] postSplit = orig.split("/");
        return postSplit[1];
    }
    
    public String getPage(){
        String orig = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        String[] postSplit = orig.split("/");
        return postSplit[2];
    }
    
    /*
     * Prepare pages
     */
    
    public void prepareTypePage() {
        for(ItemType it : ItemType.values()) {
            if(it.getTypeId() == typeToView)
                typeViewed = it;
        }
                
        List<List<Item>> setList = im.getTypeLists(typeViewed);
        set1 = setList.get(0);
        
        set2 = setList.get(1);
        
        set3 = setList.get(2);
        
    }
    
    /**
     * Function prepares a data structure for the "Category" page to use populated with
     * the corresponding items
     */
    
    public void prepareCategoryPage() {
        for(Category c : Category.values()) {
            if(c.getCategoryId() == categoryToView) {
                categoryViewed = c;
                listOfeItems = im.getItemsByCategory(c);
            }
        }   
        
        for(ItemType it : ItemType.values()) {
            for(Category c : it.getCategoriesForType())
                if(c == categoryViewed) {
                    typeViewed = it;
                }
        }
    }
    
    /**
     * Function prepares a data structure for the "Item" page to use populated with
     * the corresponding items
     */
    
    public void prepareItemPage() { 
        viewableItem = im.getItemById(itemToView);
        categoryToView = viewableItem.getItemCategory();
        typeToView = viewableItem.getItemType();
        
        for(Category c : Category.values()) {
            if(c.getCategoryId() == categoryToView) {
                categoryViewed = c;
            }
        } 
        
        for(ItemType it : ItemType.values()) {
            if(it.getTypeId() == typeToView)
                typeViewed = it;
        }
    }
    
    /**
     * Function prepares a data structure for the "Index" page to use populated with
     * the corresponding items
     */
    
    public void prepareIndexPage() {
        List<List<Item>> setList = im.getIndexLists();
        set1 = setList.get(0);
        
        set2 = setList.get(1);
        
        set3 = setList.get(2);
 
        index1 = set1.get(4);
        index2 = set1.get(0);
        index3 = set2.get(2);
    }
    
    public List<Item> getUserCart() {
        return userCart;
    }
    
    public List<Item> getListOfeItems() {
        return listOfeItems;
    }
    
    public List<Item> getSet1() {
        return set1;
    }
    
    public List<Item> getSet2() {
        return set2;
    }
    
    public List<Item> getSet3() {
        return set3;
    }
    
    public Item getViewableItem() {
        return viewableItem;
    }
    
    public String getCategoryToView() {
        for(ItemType it : ItemType.values()) {
            if(it.getTypeId() == typeToView)
                typeViewed = it;
        }
        return typeViewed.getTextRep();
    }

    public void setCategoryToView(int categoryToView) {
        this.categoryToView = categoryToView;
    }

    public String getSTypeToView() {
        int id = getITypeToView();
        if(id == 1)
            return "eBooks";
        else if(id == 2)
            return "Audiobooks";
        else if(id == 3)
            return "Music";
        else
            return "eBooks";
    }
    
    public void runSearch() {
       listOfeItems = im.simpleSearch(search); 
    }
    
    public void runAdvancedSearch(String initTitle, String initName, String initKeyword, int initFormat, String initSubject) {
       listOfeItems = im.advancedSearch(initTitle, initName, initKeyword, initFormat, initSubject); 
    }
    
    public int getITypeToView() {
        return typeToView;
    }

    public void setTypeToView(int typeToView) {
        this.typeToView = typeToView;
    }
    
    public String getCurrentList() {
        return currentList;
    }

    public void setCurrentList(String currentList) {
        this.currentList = currentList;
    }
    
    public String updateUser() {
        us.setUser(userView);
        
        return "/account/view.xhtml?faces-redirect=true";
    }
    
    public String viewBook() {
        int id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("bookId"));
        return "/item/view.xhtml?faces-redirect=true&bookId=" + id;
    }
    
    public String viewCategory() {
        int id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("catId"));
        return "/category/view.xhtml?faces-redirect=true&catId=" + id;
    }
    
    public String viewSearch() {
        String id = search;
        return "/search/view.xhtml?faces-redirect=true&search=" + id;
    }
    
    public String viewAdvancedSearch() {
        return "/search/advanced.xhtml?faces-redirect=true";
    }
    
    public String handleAdvancedSearchSubmit() {
        return "/search/view.xhtml?faces-redirect=true&searchType=advanced&title="+searchTitle+"&name="+searchAuthor+"&keyword="+searchKeyword+
                "&format="+searchFormat+"&subject="+searchSubject;//
    }

    public String viewType() {
        int id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("typeId"));
        return "/type/view.xhtml?faces-redirect=true&typeId=" + id;
    }
    
    public String viewIndex() {
        return "../index.xhtml?faces-redirect=true";
    }
    
    public String viewWishlist() {
        return "/account/viewList.xhtml";
    }

    public Category getCategoryViewed() {
        return categoryViewed;
    }

    public void setCategoryViewed(Category categoryViewed) {
        this.categoryViewed = categoryViewed;
    }

    public ItemType getTypeViewed() {
        return typeViewed;
    }

    public void setTypeViewed(ItemType typeViewed) {
        this.typeViewed = typeViewed;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearchAuthor() {
        return searchAuthor;
    }

    public void setSearchAuthor(String searchAuthor) {
        this.searchAuthor = searchAuthor;
    }

    public int getSearchFormat() {
        return searchFormat;
    }

    public void setSearchFormat(int searchFormat) {
        this.searchFormat = searchFormat;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchSubject() {
        return searchSubject;
    }

    public void setSearchSubject(String searchSubject) {
        this.searchSubject = searchSubject;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public Item getIndex1() {
        return index1;
    }

    public void setIndex1(Item index1) {
        this.index1 = index1;
    }

    public Item getIndex2() {
        return index2;
    }

    public void setIndex2(Item index2) {
        this.index2 = index2;
    }

    public Item getIndex3() {
        return index3;
    }

    public void setIndex3(Item index3) {
        this.index3 = index3;
    }

    public User getUserView() {
        return userView;
    }

    public void setUserView(User userView) {
        this.userView = userView;
    }
    
    public List<String> getCategoriesForSearch() {
        List<String> returnList = new ArrayList<String>();
        for(Category c : ItemType.AUDIOBOOK.getCategoriesForType())
            returnList.add(c.getTextRep());
        for(Category c : ItemType.MUSIC.getCategoriesForType())
            returnList.add(c.getTextRep());
        return returnList;
    }
    
    public String sendToPub() {
        return "index.xhtml";
    }

    private String resolveSubject(String get) {
        for(Category c : ItemType.AUDIOBOOK.getCategoriesForType()) {
            if(c.getTextRep().contains(get))
                return c.getTextRep();
        }
        for(Category c : ItemType.MUSIC.getCategoriesForType()) {
            if(c.getTextRep().contains(get))
                return c.getTextRep();
        }
        return "allcategories";
    }
}
