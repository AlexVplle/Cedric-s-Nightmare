package pkg_skeleton;

import java.util.HashMap;
import java.util.Set;
import pkg_player.Item;

/**
 * This class is used to create an HashMap and associated methods to manage Items in the inventory and in the rooms.
 * @author Alexis Vapaille
 * @version 2021.04.11
 */
public class ItemList{
    
    // ### Attributes ###
    /**
     * private HashMap including String as key and Item as value
     */
    private HashMap<String, Item> aItems;
    
    // ### Constructor ###
    /**
     * Constructor for ItemList
     */
    public ItemList(){
        this.aItems = new HashMap<String, Item>();
    } //ItemList()
    
    // ### Assesors ###
    /**
     * Assesors to get the item according to the String
     * @param pItemString String giving the desired item
     * @return Return the item corresponding to the String
     */
    public Item getItem(final String pItemString)
    {
        return this.aItems.get(pItemString);
    } //getItem(.)
    
    /**
     * Assesors to get the item's HashMap
     * @return Return the item's HashMap
     */
    public HashMap getItemHashMap()
    {
        return this.aItems;
    } //getItemHashMap()
    
    /**
     * Assesors to get the room's items
     * @return Return String with the items in the room
     */
    public String getItemsString()
    {   
        String vItems = "";
        Set<String> vKeys = this.aItems.keySet();
        for(String vItem: vKeys){
            vItems += " " + vItem;
        }
        return vItems;
    } //getItemsString()
    
    // ### Mutator ###
    /**
    * Mutator to set the item according to the String 
    * @param pItemString The desired itemString
    * @param pItem  Item desired
    */
    public void addItem(final String pItemString, final Item pItem)
    {
        this.aItems.put(pItemString, pItem);
    } //setItem(..)
    
    /**
     * Use to remove an item from HashMap
     * @param pItemRemove Item that will be removed
     */
    public void removeItem(final String pItemRemove)
    {
        this.aItems.remove(pItemRemove);
    } //removeItem(.)
    
    /**
     * Use to know if an item is in the HashMap
     * @param pItemSearched Item searched
     * @return boolean equals true if item searched is in the HashMap
     */
    public boolean itemPresent(final String pItemSearched)
    {
        return this.aItems.containsKey(pItemSearched);
    } //itemPresent(.)
} //ItemList