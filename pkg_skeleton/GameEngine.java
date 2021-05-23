package pkg_skeleton;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import pkg_player.Player;
import pkg_room.Room;
import pkg_room.Door;
import pkg_room.Person;
import pkg_room.MovingPerson;
import pkg_room.TransporterRoom;
import pkg_player.Item;
import pkg_player.Beamer;
import pkg_command.Command;

/**
 *  This class is part of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.
 * 
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (Jan 2003) DB edited (2019)
 * @author Alexis Vapaille
 * @version 2021.04.07
 */
public class GameEngine
{   
    // ### Attributes ###
    /**
     * private Parser
     */
    private Parser aParser;
    
    /**
     * private User Interface
     */
    private UserInterface  aGui;
    
    /**
     * private Player 
     */
    private Player aPlayer;
    
    /**
     * private HashMap to contain the rooms where it is possible teleporting
     */
    private HashMap<String, Room> aTabRoom;
    
    /**
     * private boolean to know if the game is in the testing phase
     */
    private boolean aTest;
    
    /**
     * private Room saved for the command alea
     */
    private Room aSavedRoom;

    /**
     * private ArrayList containing the moving person
     */
    private ArrayList<MovingPerson> aMovingCharacter;
    
    // ### Constructor ###
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aTabRoom = new HashMap<String, Room>();
        this.aMovingCharacter = new ArrayList<MovingPerson>();
        this.createRooms();
        this.aTest = false;
    } //GameEngine()
    
    /**
     * Use to create GUI
     * @param pUserInterface User interface use to create GUI
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGui = pUserInterface;
        this.aPlayer.setGUI(this.aGui);
        this.printWelcome();
    } //setGUI(.)
    
    /**
     * Return the HashMap containing the rooms where it is possible teleporting
     * @return HashMap containing the rooms where it is possible teleporting
     */
    public HashMap getTabRoom()
    {
        return this.aTabRoom;
    } //getTabRoom()
    
    /**
     * Use to display the rooms available for the command alea
     * @return String containing the rooms available for the command alea
     */
    public String getRoomString()
    {
        String vRoomString = "Room available:";
        Set<String> vRooms = this.aTabRoom.keySet();
        for(String vRoom: vRooms){
            vRoomString += " " + vRoom;
        }
        return vRoomString;
    } //getRoomString()
    
    /**
     * Return User Interface
     * @return User Interface
     */
    public UserInterface getGui()
    {
        return this.aGui;
    } //getGui()
    
    /**
     * Return Player
     * @return Player
     */
    public Player getPlayer()
    {
        return this.aPlayer;
    } //getPlayer()
    
    /**
     * Return boolean to know if the game is in the testing phase
     * @return boolean to know if the game is in the testing phase
     */    
    public boolean getTest()
    {
        return this.aTest;
    } //getTest()
    
    /**
     * Return Room saved for the command alea
     * @return Room saved for the command alea
     */ 
    public Room getSavedRoom()
    {
        return this.aSavedRoom;
    } //getSavedRoom()
    
    /**
     * Mutator for test
     * @param pTest boolean 
     */ 
    public void setTest(final boolean pTest)
    {
        this.aTest = pTest;
    } //setTest(.)
    
    /**
     * Mutator for saved Room's alea
     * @param pSavedRoom new saved room
     */
    public void setSavedRoom(final Room pSavedRoom)
    {
        this.aSavedRoom = pSavedRoom;
    } //setSavedRoom(.)
    
    /**
     * Message giving information about the character's location
     */
    public void printLocationInfo()
    {   
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
    } //printLocationInfo()
    
    /**
     * Welcome message
     */
    public void printWelcome()
    {
        this.aGui.println("Here is:\nThe Cedric's Nightmare.\nThe Cedric's Nightmare is a new, incredibly adventure game.\nYou are in a nightmare where you have to find your mom to reassure you. On the way, you will surely come across enemies\nType 'help' if you need help.\n");
        this.printLocationInfo();
        if (this.aPlayer.getCurrentRoom().getImageName() != null) this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    } //printWelcome()

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room vCedricBedroom = new Room("Cedric's bedroom", "bedroom");
        Room vCorridor      = new Room("Corridor", "corridor");
        Room vBathroom      = new Room("Bathroom", "bathroom");
        Room vStairs        = new Room("Stairs", "staircase");
        Room vMainEntrance  = new Room("Main entrance", "mainEntrance");
        Room vGarden        = new Room("Garden", "garden");
        Room vCave          = new Room("Cave", "cave");
        Room vLunchroom     = new Room("Lunch room", "dinnerRoom");
        Room vKitchen       = new Room("Kitchen", "kitchen");
        Room vParentBedroom = new Room("Parent's bedroom", "bedroomParent");
        Door vGreenDoor     = new Door("green_key");
        TransporterRoom vWc = new TransporterRoom("WC", "wc");
        Door vRedDoor       = new Door("red_key");
        Door vTrapDoor      = new Door("trap_door");
        Item vMagicCookie  = new Item("Magic cookie", 1, "mmmmmmmhhhhhhh...it's weird\ntake and eat the cookie to know its effects");
        Item vPotion       = new Item("Health potion", 2, "heal 5 health points");
        Item vSword        = new Item("Sword", 3, "useful to attack");
        Item vChickenThigh = new Item("Chicken thigh", 2, "useful to increase the maximum health points");
        Item vGreenKey     = new Item("Green key", 1, "Useful to open the green door");
        Item vRedKey       = new Item("Red key", 1, "Useful to open the red door");
        Beamer vBeamer     = new Beamer(1, "useful to teleport towards a previous room");
        Person vMum        = new Person("I will console you");
        this.aTabRoom.put("wc", vWc);
        this.aTabRoom.put("stairs", vStairs);
        this.aTabRoom.put("corridor", vCorridor);
        this.aTabRoom.put("garden", vGarden);
        this.aTabRoom.put("main_entrance", vMainEntrance);
        this.aTabRoom.put("cave", vCave);
        this.aTabRoom.put("lunchroom", vLunchroom);
        MovingPerson vFirstWolf  = new MovingPerson("I am going to kill you !", "first_wolf",this.aTabRoom.values().toArray(new Room[this.aTabRoom.values().size()]));
        MovingPerson vSecondWolf = new MovingPerson("I am going to kill you !", "second_wolf",this.aTabRoom.values().toArray(new Room[this.aTabRoom.values().size()]));
        MovingPerson vThirdWolf  = new MovingPerson("I am going to kill you !", "third_wolf", this.aTabRoom.values().toArray(new Room[this.aTabRoom.values().size()]));
        this.aMovingCharacter.add(vFirstWolf);
        this.aMovingCharacter.add(vSecondWolf);
        this.aMovingCharacter.add(vThirdWolf);
        vFirstWolf.getCurrentRoom().setPerson("first_wolf", vFirstWolf);
        vSecondWolf.getCurrentRoom().setPerson("second_wolf", vSecondWolf);
        vThirdWolf.getCurrentRoom().setPerson("third_wolf", vThirdWolf);
        // We initialize the rooms and doors
        vCedricBedroom.setExit("south", vWc);
        vCedricBedroom.setExit("east", vCorridor);
        vWc.setExit("north", vCedricBedroom);
        vCorridor.setExit("west", vCedricBedroom);
        vCorridor.setExit("north", vBathroom);
        vCorridor.setExit("down", vStairs);
        vBathroom.setExit("south", vCorridor);
        vStairs.setExit("up", vCorridor);
        vStairs.setExit("down", vMainEntrance);
        vMainEntrance.setExit("up", vStairs);
        vMainEntrance.setExit("west", vGarden);
        vMainEntrance.setExit("east", vLunchroom);
        vMainEntrance.setExit("down", vCave);
        vGarden.setExit("down", vCave);
        vGarden.setExit("east", vMainEntrance);
        vCave.setExit("up", vMainEntrance);
        vLunchroom.setExit("west", vMainEntrance);
        vLunchroom.setExit("north", vKitchen);
        vLunchroom.setExit("east", vParentBedroom);
        vKitchen.setExit("south", vLunchroom);
        vParentBedroom.setExit("west", vLunchroom);
        vLunchroom.setDoor("north", vGreenDoor);
        vKitchen.setDoor("south", vGreenDoor);
        vLunchroom.setDoor("east", vRedDoor);
        vKitchen.setDoor("west", vRedDoor);
        // We initialize the rooms's exits
        vCave.addItem("magic_cookie", vMagicCookie);
        vCedricBedroom.addItem("sword", vSword);
        vBathroom.addItem("green_key", vGreenKey);
        vBathroom.addItem("heal's_potion", vPotion);
        vKitchen.addItem("red_key", vRedKey);
        vKitchen.addItem("chicken_thigh", vChickenThigh);
        vGarden.addItem("beamer", vBeamer);
        vParentBedroom.setPerson("mum", vMum);
        this.aPlayer = new Player("Cedric", vCedricBedroom, 5, 10);
    } // createRooms()
    
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * @param pDirection String containing the direction
     */
    public void goRoom(final String pDirection) 
    {
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit(pDirection, this.aTabRoom, this.aSavedRoom);
        if (vNextRoom == null){
            this.aGui.println("There is no door!\n");
        }
        else {
            if(this.aPlayer.getCurrentRoom().getDoor(pDirection) != null){
                if(this.aPlayer.itemPresent(this.aPlayer.getCurrentRoom().getDoor(pDirection).getKey())){
                    this.changeRoom(vNextRoom);
                }
                else{
                    this.aGui.println("You don't have " + this.aPlayer.getCurrentRoom().getDoor(pDirection).getKey() + " on you.\n");
                }
            }
            else{
                this.changeRoom(vNextRoom);
            }
        }
    } //goRoom(.)
    
    /**
     * Used to move randomly the moving person
     */
    public void movingPerson()
    {
        for(MovingPerson vMovingPerson: this.aMovingCharacter){
            vMovingPerson.getCurrentRoom().deletePerson(vMovingPerson.getName());
            vMovingPerson.setCurrentRoom(this.aTabRoom.values().toArray(new Room[this.aTabRoom.values().size()]));
            vMovingPerson.getCurrentRoom().setPerson(vMovingPerson.getName(), vMovingPerson);
        }
    } //movingPerson
    
    /**
     * Used to delete a person
     * @param pCharacter String character deleted
     */
    public void deletePerson(final MovingPerson pCharacter)
    {
        this.aMovingCharacter.remove(pCharacter);
    } //deletePerson(.)
    
    /**
     * Use to change the player's current room
     * @param pRoom Room that will replace the player's current room
     */
    public void changeRoom(final Room pRoom)
    {
        this.aPlayer.changeRoom(pRoom);
        this.movingPerson();
        if (!this.aPlayer.getCurrentRoom().isExit(this.aPlayer.getBacks().peek())) this.aPlayer.getBacks().clear();
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        if (this.aPlayer.getCurrentRoom().getImageName() != null) this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
        if (this.aPlayer.getCurrentRoom().characterPresent("first_wolf"))  this.aPlayer.fight("first_wolf");
        if (this.aPlayer.getCurrentRoom().characterPresent("second_wolf")) this.aPlayer.fight("second_wolf");
        if (this.aPlayer.getCurrentRoom().characterPresent("third_wolf"))  this.aPlayer.fight("third_wolf");
    } //changeRoom(.)
    
    /**
     * Use to back in the precedent room
     */
    public void back()
    {
        if (this.aPlayer.noBack()){
            this.aGui.println("It's impossible to back.\n");
        }
        else{
            this.aPlayer.returnRoom();
            this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
            if (this.aPlayer.getCurrentRoom().getImageName() != null)
                this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
        }
    } //back()
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * @param pCommandLine Command entered in the terminal
     */
    public void interpretCommand(final String pCommandLine) 
    {
        this.aGui.println("> " + pCommandLine);
        String vCommandLine = pCommandLine.toLowerCase();
        Command vCommand = this.aParser.getCommand(vCommandLine);
        if (vCommand == null){
            this.aGui.println("I don't know what you mean...");
        }
        else{
            vCommand.execute(this);
        }
    } //interpretCommand(.)

    // implementations of user commands:

    /**
     * Help message
     */
    public void printHelp()
    {
        this.aGui.println("You are lost. You are alone at home.\nYour command words are:\n" + this.aParser.getCommandString() + "\n");
    } //printHelp()

    /**
     * Use to test the game
     * @param pNomFichier File's name
     */
    public void test(final String pNomFichier)
    {
        try{
            Scanner vReadFile = new Scanner(new File("test\\" + pNomFichier + ".txt"));
            while(vReadFile.hasNextLine()){
                 this.interpretCommand(vReadFile.nextLine());
            }
        }
        catch(final IOException pIOException){
            this.aGui.println("This file doesn't exist.\n");
        }
    } //test(.)
    
    /**
     * Message giving information about the room
     * @param pSecondWord String to know what have to look
     */
    public void look(final String pSecondWord)
    {
        if (pSecondWord != null){
            if (this.aPlayer.itemPresent(pSecondWord)){
                this.aGui.println(this.aPlayer.getItem(pSecondWord).getDescription());
            }
            else{
                this.aGui.println("This item isn't in your inventory.\n");
            }
        }
        else this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
    } //look(.)  
    
    /**
     * Use to charge the beamer
     */
    public void charge()
    {
        if(this.aPlayer.itemPresent("beamer")){
            Beamer vBeamer = (Beamer) this.aPlayer.getItem("beamer");
            vBeamer.setRoomCharged(this.aPlayer.getCurrentRoom());
            this.aGui.println("You saved " + this.aPlayer.getCurrentRoom().getDescription() + " in your beamer.\n");
        }
        else{
            this.aGui.println("You don't have the Beamer on you.\n");
        }
    } //charge()
    
    /**
     * Use to fire the beamer
     */
    public void fire()
    {
        if(this.aPlayer.itemPresent("beamer")){
            Beamer vBeamer = (Beamer) this.aPlayer.getItem("beamer");
            if(vBeamer.getRoomCharged() == null){
                this.aGui.println("You didn't save a previous room.\nType \"fire\" to save a room.\n");
            }
            else{
                this.changeRoom(vBeamer.getRoomCharged());
            }
        }
        else{
            this.aGui.println("You don't have the Beamer on you.\n");
        }
    } //fire()
    
    /**
     * Use when the time is over
     */
    public void timeIsUp()
    {
        this.aGui.println("time's up !\n");
        this.endGame();
    } //timeIsUp()
    
    /**
     * Use to save a room for the transporter room
     * @param pRoom Room that will be saved for the transportation
     */
    public void alea(final String pRoom)
    {
        if (this.aTabRoom.containsKey(pRoom)){
            this.aSavedRoom = this.aTabRoom.get(pRoom);
            this.aGui.println( pRoom + " is now saved.\n");
        }
        else{
            this.aGui.println("this room doesn't exist.\n");
        }
    } //alea(.)
    
    /**
     * End message
     */
    public void endGame()
    {
        this.aGui.println("Thank you for playing.  Good bye.");
        this.aGui.enable(false);
    } //endGame()
} //GameEngine
