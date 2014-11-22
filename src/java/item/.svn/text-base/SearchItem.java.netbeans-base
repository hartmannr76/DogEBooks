/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 *
 * @author
 * Piotr
 */
public class SearchItem implements Comparable 
{
    private Item item;
    private int frequencyOfItem;
    
    public SearchItem(Item initItem, int initFrequency)
    {
        item = initItem;
        frequencyOfItem = initFrequency;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the frequencyOfItem
     */
    public int getFrequencyOfItem() {
               return frequencyOfItem;      
    }

    /**
     * @param frequencyOfItem the frequencyOfItem to set
     */
    public void setFrequencyOfItem(int frequencyOfItem) {
        this.frequencyOfItem = frequencyOfItem;
    }


    
    // returns 0 if equal, 1 greater, less than 0 if smaller
    @Override
    public int compareTo(Object o) 
    {
        SearchItem i = (SearchItem) o;
        
        if(i.getFrequencyOfItem() > frequencyOfItem)
            return 1;
                
        if(i.getFrequencyOfItem() < frequencyOfItem)
            return -1;
        
        //case where both items are equal
        return 0;
    }
    
    
}
