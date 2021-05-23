package pkg_player;

import java.util.Stack;
import pkg_room.Room;
import pkg_skeleton.UserInterface;
import pkg_skeleton.ItemList;
import pkg_room.MovingPerson;

/**
 * This class creates a player with all his characteristics and methods
 * @author Alexis Vapaille
 * @version 2021.04.11
 */
public class Player{
    
    // ### Attributes ###
    /**
     * private player's name
     */
    private String aPlayerName;

    /**
     * private current room
     */
    private Room aCurrentRoom;
    
    /**
     * private Stack including Room
     */
    private Stack<Room> aBacks;
    
    /**
     * private User Interface
     */
    private UserInterface aGui;
    
    /**
     * private list of items
     */
    private ItemList aItemList;
    
    /**
     * private int max weight that the player can carry
     */
    private int aMaxWeight;
    
    /**
     * private int weight that the player carry
     */
    private int aWeight;
    
    /**
     * private int attack's player
     */
    private int aAttack;
    
    /**
     * private int health point's player
     */
    private int aMaxHealthPoint;
    
    /**
     * private int health point's player
     */
    private int aHealthPoint;
    
    // ### Constructor ###
    /**
    * Constructor for Player
    * @param pPlayerName  Player's name
    * @param pCurrentRoom Player's current room
    * @param pMaxWeight   Player's max weight
    * @param pMaxHealthPoint Player's max health
    */
    public Player(final String pPlayerName, final Room pCurrentRoom, final int pMaxWeight, final int pMaxHealthPoint)
    {
        this.aPlayerName     = pPlayerName;
        this.aCurrentRoom    = pCurrentRoom;
        this.aBacks          = new Stack<Room>();
        this.aItemList       = new ItemList();
        this.aMaxWeight      = pMaxWeight;
        this.aWeight         = 0;
        this.aAttack         = 1;
        this.aMaxHealthPoint = pMaxHealthPoint;
        this.aHealthPoint    = pMaxHealthPoint;
    }
    
    // ### Assessor ###
    /**
     * Assessor to get the player's current room
     * @return Return player's current room
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    } //getCurrentRoom()
    
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
     * Return the Stack containing the previous rooms
     * @return Stack containing the previous rooms
     */
    public Stack<Room> getBacks()
    {
        return this.aBacks;
    } //getBacks()
    
    /**
     * Assessor for health point's player
     * @return int health point's player
     */
    public int getHealthPoint()
    {
        return this.aHealthPoint;
    } //getHealthPoint()
    
    /**
     * Use to create GUI
     * @param pUserInterface User interface use to create GUI
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGui = pUserInterface;
    } //setGui(.)
    
    /**
     * Mutator for the weight
     * @param pItemWeight weight added to the attribut Weight
     */
    public void setWeight(final int pItemWeight)
    {
        this.aWeight += pItemWeight; 
    } //setWeight(.)
    
    /**
     * Mutator for the current room
     * @param pCurrentRoom new current room
     */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    } //setCurrentRoom(.)
    
    /**
     * Mutator for the health point's player
     * @param pHealthPoint integer to health the player
     */
    public void setHealthPoint(final int pHealthPoint)
    {
        if (this.aHealthPoint + pHealthPoint > this.aMaxHealthPoint){   
            this.aHealthPoint = this.aMaxHealthPoint;
        }
        else{
            this.aHealthPoint += pHealthPoint;
        }
    } //setHealthPoint(.)
    
    /**
     * Use to change the current room
     * @param pNewRoom Next room
     */
    public void changeRoom(final Room pNewRoom)
    {
        this.aBacks.push(this.aCurrentRoom);
        this.setCurrentRoom(pNewRoom);
    } //changeRoom(.)
    
    /**
     * Change the current room by the room on the top of the Stack
     */
    public void returnRoom()
    {
        this.setCurrentRoom(this.aBacks.pop());
    } //returnRoom()
    
    /**
     * Use to know if the Stack is empty
     * @return Return true if the Stack is empty
     */
    public boolean noBack()
    {
        return this.aBacks.empty();
    } //noBack()
    
    /**
     * Use to take an item from the room
     * @param pItemTaken String corresponding to the item taken
     */
    public void take(final String pItemTaken)
    {
        if (this.aCurrentRoom.itemPresent(pItemTaken)){
            if ((this.aWeight + this.aCurrentRoom.getItem(pItemTaken).getWeight()) <= this.aMaxWeight){
                this.setWeight(this.aCurrentRoom.getItem(pItemTaken).getWeight());
                this.aItemList.addItem(pItemTaken, this.aCurrentRoom.getItem(pItemTaken)) ;
                this.aCurrentRoom.removeItem(pItemTaken);
                this.aGui.println("Now, you carry a " + pItemTaken + "\n");
                if (pItemTaken.equals("sword")) this.aAttack = 3;
            }
            else{
                this.aGui.println("You are not enough strong to carry all that.\nYou can drop something to lighten your inventory.\n");
            }
        }
        else{
            this.aGui.println("This item isn't here.\n");
        }
    } //take(.)
    
    /**
     * Use to drop an item from the inventory
     * @param pItemDropped Item that will be dropped
     */
    public void drop(final String pItemDropped)
    {
        if (this.aItemList.itemPresent(pItemDropped)){
            this.setWeight(-this.aItemList.getItem(pItemDropped).getWeight());
            this.aGui.println("You dropped a " + pItemDropped + "\n");
            this.aCurrentRoom.addItem(pItemDropped, this.aItemList.getItem(pItemDropped));
            this.aItemList.removeItem(pItemDropped);
            if (pItemDropped.equals("sword")) this.aAttack = 1;
        }
        else{
            this.aGui.println("You don't have this object on you\n");
        }
    } //drop(.)
    
    /**
     * Used to fight
     * @param pCharacter String for the character
     */
    public void fight(final String pCharacter)
    {
        MovingPerson vCharacter = (MovingPerson) this.getCurrentRoom().getPerson(pCharacter);
        while (vCharacter.getHealthPoint() > 0){
            vCharacter.setHealthPoint(this.aAttack);
            this.setHealthPoint(-1);
            if (this.getHealthPoint() <= 0){
                this.aGui.println("you have no more life !\nYou have lost !\n");
                this.aGui.getEngine().endGame();
            }
        }
        this.aGui.getEngine().deletePerson(vCharacter);
        this.getCurrentRoom().deletePerson(pCharacter);
        this.aGui.println("You have defeated a wolf\n");
        this.aGui.println("You have " + this.aHealthPoint + " health point(s)\n");
    } //fight(.)
    
    /**
     * Use to create String to display the inventory's content
     * @return Return String of inventory's content 
     */
    public String items()
    {
        return "Inventory: " + this.aItemList.getItemsString() + "\nSlots used: " + this.aWeight + "/" + this.aMaxWeight + ".\n";
    } //items()
    
    /**
     * Use to know if an item is in the inventory
     * @param pItemSearched Item searched
     * @return boolean equals true if item searched is in the inventory
     */
    public boolean itemPresent(final String pItemSearched)
    {
        return this.aItemList.itemPresent(pItemSearched);
    } //itemPresent(.)
    
    /**
     * Use to eat
     * @param pItem String corresponding to edible thing
     */
    public void eat(final String pItem)
    {
        if (this.aItemList.itemPresent(pItem)){
            if(pItem.equals("magic_cookie")){
                this.setWeight(-this.aItemList.getItem("magic_cookie").getWeight());
                this.aMaxWeight *= 2;
                this.aGui.println("Your head is spinning...\nNow, you can carry twice as much\n");
                this.aItemList.removeItem("magic_cookie");
            }
            else if (pItem.equals("health_potion")){
                this.setHealthPoint(5);
                this.aItemList.removeItem("health_potion");
                this.aGui.println("You have been healed for 5 health points\n");
            }
            else if (pItem.equals("chicken_thigh")){
                this.aMaxHealthPoint *= 2;
                this.aItemList.removeItem("chicken_thigh");
                this.aGui.println("You have doubled your health points\n");
            }
            else{
                this.aGui.println("" + pItem + " is not edible.\n");
            }
        }
        else{
            this.aGui.println("You don't have "+ pItem + " on you.\n");
        }
    } //eat(.)
    
    /**
     * Use to talk
     * @param pCharacter Character to talk to
     */
    public void talk(final String pCharacter)
    {
        if (this.getCurrentRoom().characterPresent(pCharacter)){
            this.aGui.println(this.getCurrentRoom().getPerson(pCharacter).getText());
            if (pCharacter.equals("mum")){
                this.aGui.println("You have found your mom. You won.");
                this.aGui.getEngine().endGame();
            }
        }
        else{
            this.aGui.println("This character is not here.\n");
        }
    } //talk(.)
} //Player