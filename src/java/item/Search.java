/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.util.*;

/**
 * @author
 * Piotr
 */
public class Search 
{
    
    private  List<Item> listOfItems; 
    
    public Search(List<Item> initListOfItems)
    {
        listOfItems = initListOfItems;
        
    }
    
    /*
     * Takes in an ArrayList of Strings for which search queries will be performed
     */
    public List<Item> performSimpleSearch(String initSearchQuery)
    {
        
        StringTokenizer queryString = new StringTokenizer(initSearchQuery);
        List<Item> itemsToBeReturned = new ArrayList<Item>();
        
        while(queryString.hasMoreTokens())
        {   
        String searchQuery = queryString.nextToken();
            
        itemsToBeReturned.addAll(getItemsByName(searchQuery));
        itemsToBeReturned.addAll(getItemsByAuthor(searchQuery));
        }
        
        itemsToBeReturned = organizeSearchResults(itemsToBeReturned);
        
        return itemsToBeReturned;   
    }
    
    public List<Item> performAdvancedSearch(String initTitle, String initName, String initKeyword, int initFormat, String initCategory)
    {
        List<Item> itemsToBeReturned = new ArrayList<Item>();
        
        itemsToBeReturned.addAll(getItemsByName(initTitle));
        itemsToBeReturned.addAll(getItemsByAuthor(initName));
        itemsToBeReturned.addAll(performSimpleSearch(initKeyword));
        getItemsByFormat(initFormat, itemsToBeReturned);
        getItemsByCategory(initCategory, itemsToBeReturned);
        
        itemsToBeReturned = organizeSearchResults(itemsToBeReturned);
        
        return itemsToBeReturned;
    }
    
    
    public List<Item> getItemsByName(String initItemName)
    {      
        
        List<Item> itemsToBeReturned = new ArrayList<Item>();
        
        if(initItemName.length() < 1)
            return itemsToBeReturned;
        
        String itemNameLowerCase = initItemName.toLowerCase();
        
        
        for(int i = 0; i < listOfItems.size(); i++)
        {
            String itemBeingLookedAtName = listOfItems.get(i).getItemName().toLowerCase();
            
            if(itemBeingLookedAtName.contains(itemNameLowerCase))
                    {
                        itemsToBeReturned.add(listOfItems.get(i));
                    }
        }
           
        return itemsToBeReturned;
            
    }
   
        public List<Item> getItemsByAuthor(String initAuthor)
    {
        List<Item> itemsToBeReturned = new ArrayList<Item>();
        
        if(initAuthor.length() < 1)
            return itemsToBeReturned;
        
        String authorLowerCase = initAuthor.toLowerCase();
        
        for(int i = 0; i < listOfItems.size(); i++)
        {
            String authorBeingLookedAtName = listOfItems.get(i).getAuthor().toLowerCase();
            
            if(authorBeingLookedAtName.contains(authorLowerCase))
                    {
                        itemsToBeReturned.add(listOfItems.get(i));
                    }
        }
           
        return itemsToBeReturned;
            
    }
    
       //removing all the items that do not fit format type selected by user
      public List<Item> getItemsByFormat(int initType, List<Item> initItems)
    {
        
        //case where user chose select all formats so we do not remove any items
        if(initType == 0)
            return initItems;
        
        for(int i = 0; i < initItems.size(); i++)
        {
            if(initItems.get(i).getItemType() != initType)
                    {
                        initItems.remove(initItems.get(i));
                        i--;
                    }
        }
           
            return initItems;
    }   
      
      public List<Item> getItemsByCategory(String initCategory, List<Item> initItems)
    {

        //case where user chose select all categories so we do not remove any items
        if(initCategory.equals("allcategories"))
            return initItems;
        
        for(int i = 0; i < initItems.size(); i++)
        {
            
            //if the item subject of the item does not equal the user entered subject that means the user does not want to see this item
            if(!(initItems.get(i).getItemSubject().equals(initCategory)))
                    {
                        initItems.remove(initItems.get(i));
                        i--;
                    }
        }
        
        
        
        return initItems;
            
    }  
       
      //used to organize the search results based on relevancy and remove duplicates, 
      //duplications of an item represent several matches for the item within the search 
      //(ie. item with most duplicates matches search query greatest)
      public List<Item> organizeSearchResults(List<Item> initItems)
      {
          List <SearchItem> listOfSearchItems = new ArrayList<SearchItem>();
          int FIRST_ELEMENT_OF_LIST = 0;
          
          while(!initItems.isEmpty())
        {
            Item currentItem = initItems.get(FIRST_ELEMENT_OF_LIST);
            int frequencyOfItem = Collections.frequency(initItems, currentItem);
            SearchItem currentItemAsSearchItem = new SearchItem(currentItem, frequencyOfItem);
            removeAllInstancesOfItemFromList(currentItem, initItems);
            listOfSearchItems.add(currentItemAsSearchItem);
            
        }
          //sorting the SearchItem List based on frequency
          Collections.sort(listOfSearchItems);
          List<Item> listToBeReturned = recreateListOfItemsFromSearchItems(listOfSearchItems);
          
          return listToBeReturned;
      }
      
      
      public void removeAllInstancesOfItemFromList(Item initItem, List<Item> initList)
      {
          for(int i = 0; i < initList.size(); i++)
          {
              if(initList.get(i).getItemId() == initItem.getItemId())
                      {
                          initList.remove(i);
                          i--;
                      }
                  
          }
      }
      
      public List<Item> recreateListOfItemsFromSearchItems(List<SearchItem> initSearchItems)
      {
          List<Item> itemListToBeReturned = new ArrayList<Item>();
          
          for(int i = 0; i < initSearchItems.size(); i++)
          {
              Item item = initSearchItems.get(i).getItem();
              itemListToBeReturned.add(item);
          }
          
          return itemListToBeReturned;
      }
    
}
