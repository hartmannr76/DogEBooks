/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.managers;

import enums.Category;
import enums.ItemType;
import item.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.apache.commons.lang.ArrayUtils;
import sessions.AudiobookFacade;
import sessions.EbookFacade;
import sessions.ItemFacade;
import sessions.MusicFacade;


/**
 *
 * @author Ricky
 */
@ManagedBean
@ApplicationScoped
@Stateless
public class ItemManager {

    List<Item> listOfItems;
    @EJB
    EbookFacade ebookFacade;
    
    @EJB
    MusicFacade musicFacade;
    
    @EJB
    AudiobookFacade audioBookFacade;
    
    @EJB
    ItemFacade itF;
    
    /**
     * Creates a new instance of ItemManager
     */
    public ItemManager() 
    {
    }
    
    @PostConstruct
    public void init() 
    {
        listOfItems = new ArrayList<Item>();
        initializeAllEbooks();
        initializeAllAudioBooks();
	initializeAllMusic();
        
    }
     
    public void initializeAllEbooks()
    {
        List <EBook> listOfEbooks = ebookFacade.getAllEbooks();
        listOfItems.addAll(listOfEbooks);
    }
	
    public void initializeAllAudioBooks()
    {
            List <AudioBook> listOfAudioBooks = audioBookFacade.getAllAudiobooks();
            listOfItems.addAll(listOfAudioBooks);


    }

    public void initializeAllMusic()
    {
            List <Music> listOfMusic = musicFacade.getAllMusic();
            listOfItems.addAll(listOfMusic);

    }
    
    public Item getItemById(int id) {
        for(Item i : listOfItems) {
            if(i.getBookId() == id)
                return i;
        }
        return null;
    }
    
    public void addItemToLibrary(Item i) {
       
        itF.createItem(i);
        
        Item item = itF.getItemByName(i.getItemName());
        
        //updating listOfItems
        i.setItemId(item.getItemId());
        
        if(i.getItemType() == ItemType.EBOOK.getTypeId())
        {
            ebookFacade.createBook((EBook)i);
        }
        
        listOfItems.add(i);
    }
    
    public void updateItemInLibrary(Item i) {
        itF.updateItemInDatabase(i);
        int index = listOfItems.indexOf(i);
        listOfItems.set(index, i);
    }
    
    public void removeItemFromLibrary(int id) {
        for(Item i : listOfItems) {
            if(i.getBookId() == id) {
                listOfItems.remove(i);
                itF.removeItem(i);
                break;
            }
        }
    }
    
    public List<Item> getItemsByCategory(Category c) {
        List<Item> listToReturn = new ArrayList<Item>();

        for(Item i : listOfItems) {
            if(i.getItemCategory() == c.getCategoryId())
                listToReturn.add(i);
        }
        
        return listToReturn;
    }
    
    public List<List<Item>> getTypeLists(ItemType it) {
        List<List<Item>> returnSet = new ArrayList<List<Item>>();
        
        List<Item> newestItemList = new ArrayList<Item>();
        List<Item> featuredItemList = new ArrayList<Item>();
        List<Item> highestRatedList = new ArrayList<Item>();
        // First list will be for newest items of type
        
        List<Item> sortSet = new ArrayList<Item>();
        for(Item i : listOfItems) {
            if(i.getItemType() == it.getTypeId())
                sortSet.add(i);
        }

        if(sortSet.size() > 0) {
            Collections.sort(sortSet, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2) {
                return i2.getDateAdded().compareTo(i1.getDateAdded());
            }
            });
            
            // Only get the first 4 items
            for(int i = 0; i < 4; i++)
                newestItemList.add(sortSet.get(i));
            
            // Only get the first 4 items
            for(int i = 3; i < 7; i++)
                featuredItemList.add(sortSet.get(i));
            }

           // Last list will be for highest rated items of type
            Collections.sort(sortSet, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2) {
                Integer i2Num = i2.getNumberOfLikes();
                return i2Num.compareTo(i1.getNumberOfLikes());
                }
            });
           
            // Only get the first 4 items
            for(int i = 0; i < 4; i++)
                highestRatedList.add(sortSet.get(i));
   
            returnSet.add(newestItemList);
            returnSet.add(featuredItemList);
            returnSet.add(highestRatedList);
        
        return returnSet;
    }
    
    public List<List<Item>> getIndexLists() {
        List<List<Item>> returnSet = new ArrayList<List<Item>>();
        
        List<Item> newestEbookList = new ArrayList<Item>();
        List<Item> newestAudiobookList = new ArrayList<Item>();
        List<Item> newestMusicList = new ArrayList<Item>();
        int amount;
        
        List<Item> sortSet = new ArrayList<Item>();
        for(Item i : listOfItems) {
            if(i.getItemType() == 1)
                sortSet.add(i);
        }

        if(sortSet.size() > 0) {
            Collections.sort(sortSet, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2) {
                return i2.getDateAdded().compareTo(i1.getDateAdded());
            }
            });
            
            amount = 5;
            if(sortSet.size() < 5)
                amount = sortSet.size();
            // Only get the first 4 items
            for(int i = 0; i < amount; i++)
                newestEbookList.add(sortSet.get(i));
        }
        
        sortSet = new ArrayList<Item>();
        for(Item i : listOfItems) {
            if(i.getItemType() == 2)
                sortSet.add(i);
        }

        if(sortSet.size() > 0) {
            Collections.sort(sortSet, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2) {
                return i2.getDateAdded().compareTo(i1.getDateAdded());
            }
            });
            
            amount = 5;
            if(sortSet.size() < 5)
                amount = sortSet.size();
            // Only get the first 4 items
            for(int i = 0; i < amount; i++)
                newestAudiobookList.add(sortSet.get(i));
        }
        
        sortSet = new ArrayList<Item>();
        for(Item i : listOfItems) {
            if(i.getItemType() == 3)
                sortSet.add(i);
        }

        if(sortSet.size() > 0) {
            Collections.sort(sortSet, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2) {
                return i2.getDateAdded().compareTo(i1.getDateAdded());
            }
            
            });
          if(sortSet.size() > 0) {  
            amount = 5;
            if(sortSet.size() < 5)
                amount = sortSet.size();
            // Only get the first 4 items
            for(int i = 0; i < amount; i++)
                newestMusicList.add(sortSet.get(i));
          }
        }
        
        returnSet.add(newestEbookList);
        returnSet.add(newestAudiobookList);
        returnSet.add(newestMusicList);
        
        return returnSet;
    }
    
    public List<Item> simpleSearch(String s) {
        Search searchItem = new Search(listOfItems);
        List<Item> returnItems = searchItem.performSimpleSearch(s);
        return returnItems;
    }
    
    public List<Item> advancedSearch(String initTitle, String initName, String initKeyword, int initFormat, String initSubject) {
        Search searchItem = new Search(listOfItems);
        
        List<Item> returnItems = searchItem.performAdvancedSearch(initTitle, initName, initKeyword, initFormat, initSubject);
        return returnItems;
    }
    
    public List<Item> getList() {
        return listOfItems;
    }
    
    public List<Item> getAdminItemList(int i) {
        List<Item> returnList = new ArrayList<Item>();
        for(Item item : listOfItems) {
            if(item.getItemType() == i)
                returnList.add(item);
        }
        return returnList;
    }
    
    public int getItemDisplaySize() {
        return listOfItems.size();
    }
    
    public void submitItemRating(int itemId, int rating, int userId) {
        
    }
}
