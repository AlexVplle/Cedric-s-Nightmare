package pkg_room;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import pkg_skeleton.ItemList;
import pkg_player.Player;
import pkg_player.Item;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author Alexis Vapaille
 * @version 2021.01.18
 */
public class Room
{   
    // ### Attributes ###
    
    /**
     * private String for room's description
     */
    private String aDescription;
    
    /**
     * private HashMap to contain room for the exits
     */
    private HashMap<String, Room> aExits;
    
    /**
     * private HashMap to contain the doors
     */
    private HashMap<String, Door> aDoors;
    
    /**
     * private HashMap to contain character in the room
     */
    private HashMap<String, Person> aPersons;
    
    /**
     * private String for the image's name
     */
    private String aImageName;
    
    /**
     * private HashMap to contain the items in the rooms
     */
    private ItemList aItemList;
    
    /**
     * private Stack to contain previous rooms
     */
    private Stack<Room> aBacks;
    
    // ### Constructor ###
    /**
    *Constructor for Room
    *@param pDescription Room's description
    *@param pImage Room's image
    */
    public Room(final String pDescription, final String pImage)
    {
        this.aDescription = pDescription;
        this.aImageName   = pImage;
        this.aExits       = new HashMap<String, Room>();
        this.aDoors       = new HashMap<String, Door>();
        this.aPersons     = new HashMap<String, Person>();
        this.aItemList    = new ItemList(); 
    } //Room(..)
    
    // ### Assessors ###
    /**
    * Assesors to get the room's description
    * @return Return the room's description
    */
    public String getDescription()
    {
        return this.aDescription;
    } //getDescription()
    
    /**
     * Assesors to get the possibly room's exits
     * @return Return String with the possibly exits
     */
    public String getExitString()
    {
        String vExits = "Exits:";
        Set<String> vKeys = this.aExits.keySet();
        for(String vExit: vKeys){
            vExits += " " + vExit;
        }
        return vExits;
    } //getExitString()
    
    /**
     * Assesors to get the room according to the direction
     * @param pDirection String giving the desired direction
     * @param pTabRoom HashMap useless
     * @param pRoomSaved Room useless
     * @return Return the room corresponding to the direction
     */
    public Room getExit(final String pDirection, final HashMap<String, Room> pTabRoom, final Room pRoomSaved)
    {
        return this.aExits.get(pDirection);
    } //getExit(.)
    
    /**
     * Assesors to get a long description
     * @return Return a long description of the room
     */
    public String getLongDescription()
    {   
        return "You are in the " + this.aDescription + ".\n" + this.getExitString() + this.getItemsString() + this.getPersonsString() + "\n"; 
    } //getLongDescription()

    /**
     * Assesors to get the room's HashMap
     * @return Return the room's HashMap
     */
    public HashMap getRoomHashMap()
    {
        return this.aExits;
    } //getRoomHashMap()
    
    /**
     * Return a string describing the room's image name
     * @return String describing the room's image name
     */
    public String getImageName()
    {
        return this.aImageName;
    } //getImageName()
    
    /**
     * Return the room's HashMap
     * @return Return the room's HashMap
     */
    public HashMap getItemHashMap()
    {
        return this.aItemList.getItemHashMap();
    } //getItemhashMap()
    
    /**
     * Assesors to get the item according to the String
     * @param pItemString String giving the desired item
     * @return Return the item corresponding to the String
     */
    public Item getItem(final String pItemString)
    {
        return this.aItemList.getItem(pItemString);
    } //getItem(.)
    
    /**
     * Use to create String to display the room's content
     * @return Return String of room's content 
     */
    public String getItemsString()
    {
        String vItems = "\nItem  --> " + this.aItemList.getItemsString();
        if (vItems.equals("\nItem  --> ")) return "\nThere is no items in this room.";
        return vItems;
    } //getItemsString()
    
    /**
     * Assesors to get the character's room
     * @return Return String with the character's room
     */
    public String getPersonsString()
    {
        String vPersonsString = "\nCharacter:";
        Set<String> vCharacter = this.aPersons.keySet();
        for(String vPerson: vCharacter){
            vPersonsString += " " + vPerson;
        }
        if (vPersonsString.equals("\nCharacter:")) vPersonsString = "\nThere is nobody !";
        return vPersonsString;
    } //getPersonsString()
    
    /**
     * Assessor for a specified person
     * @param pCharacter String to get a specified person
     * @return Person corresponding to string
     */
    public Person getPerson(final String pCharacter)
    {
        return this.aPersons.get(pCharacter);
    } //getCharacter(.)
    
    /**
     * Assesors to get the room's HashMap
     * @return Return the room's HashMap
     */
    public HashMap getPersonHashMap()
    {
        return this.aPersons;
    } //getPersonHashMap()
    
    // ### Mutator ###
    /**
    * Mutator to set the room according to the direction 
    * @param pDirection The desired direction
    * @param pNeighbor  Room in given direction
    */
    public void setExit(final String pDirection, final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    } //setExit(..)
    
    /**
    * Mutator to set the room according to the direction 
    * @param pNamePerson name's person
    * @param pPerson Person according to the string
    */
    public void setPerson(final String pNamePerson, final Person pPerson)
    {
        this.aPersons.put(pNamePerson, pPerson);
    } //setPerson(..)
    
    /**
     * Used to remove a room for a person
     * @param pNamePerson String to remove person from the room
     */
    public void deletePerson(final String pNamePerson)
    {
        this.aPersons.remove(pNamePerson);
    } //deletePerson(.)
    
    /**
    * Mutator to set the item according to the String 
    * @param pItemString The desired itemString
    * @param pItem  Item desired
    */
    public void addItem(final String pItemString, final Item pItem)
    {
        this.aItemList.addItem(pItemString, pItem);
    } //setItem(..)
    
    /**
     * Remove an item from the current room
     * @param pItemRemove Item removed
     */
    public void removeItem(final String pItemRemove)
    {
        this.aItemList.removeItem(pItemRemove);
    } //removeItem(.)
    
    /**
     * Use to know if an item is in the room
     * @param pItemSearched Item searched
     * @return boolean equals true if item searched is in the room
     */
    public boolean itemPresent(final String pItemSearched)
    {
        return this.aItemList.itemPresent(pItemSearched);
    } //itemPresent(.)
    
    /**
     * Use to get the door according to the string
     * @param pDirection String giving the desired door
     * @return Door corresponding to the direction
     */
    public Door getDoor(final String pDirection)
    {
        return this.aDoors.get(pDirection);
    } //getDoor(.)
    
    /**
     * Use to get the door's HashMap
     * @return door's HashMap
     */
    public HashMap getDoorHashMap()
    {
        return this.aDoors;
    } //getDoorHashMap()
    
    /**
     * Use to add doors
     * @param pDirection direction corresponding to the door
     * @param pDoor door corresponding to the direction
     */
    public void setDoor(final String pDirection, final Door pDoor)
    {
        this.aDoors.put(pDirection, pDoor);
    } //setDoor(..)
    
    /**
     * Used to know if a character is in the room
     * @param pCharacterString according to the character researched
     * @return boolean to know if a character is in the room
     */
    public boolean characterPresent(final String pCharacterString)
    {
        return this.aPersons.containsKey(pCharacterString);
    } //personCharacter(.)
    
    /**
     * Use to know if a room contains a specified exit
     * @param pExit exit researched
     * @return boolean true if a room contains a specified exit
     */
    public boolean isExit(final Room pExit)
    {
        return this.aExits.containsValue(pExit);
    } //isExit(.)
} //Room
