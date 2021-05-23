package pkg_room;

import java.util.Random;

/**
 * This class is used to create moving characters
 */
public class MovingPerson extends Person
{
    /**
     * private String name's moving character
     */
    private String aName;
    
    /**
     * private int health point's player
     */
    private int aHealthPoint;
    
    /**
     * private Room current room's moving character
     */
    private Room aCurrentRoom; 
    
    /**
     * private Random
     */
    private Random aRandom;
    
    /**
     * Constructor for MovingPerson
     * @param pText String for the text displayed when the player talk him
     * @param pName String for name's moving character
     * @param pTabRoom Array containing rooms
     */
    public MovingPerson(final String pText,final String pName,  final Room[] pTabRoom)
    {
        super(pText);
        this.aName = pName;
        this.aRandom = new Random();
        this.aCurrentRoom = pTabRoom[this.aRandom.nextInt(pTabRoom.length)];
        this.aHealthPoint = 5;
    } //MovingPerson(...)
    
    /**
     * Assessor for name's moving character
     * @return String name's moving character
     */
    public String getName()
    {
        return this.aName;
    } //getName()
    
    /**
     * Assessor for current room's moving character
     * @return Room current room's moving character
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    } //getCurrentRoom()
    
    /**
     * Assessor for health point's moving person
     * @return health point's moving person
     */
    public int getHealthPoint()
    {
        return this.aHealthPoint;
    } //getHealthPoint()
    
    /**
     * Mutator for current room's moving character
     * @param pTabRoom Array containing rooms
     */
    public void setCurrentRoom(final Room[] pTabRoom)
    {
        this.aCurrentRoom = pTabRoom[this.aRandom.nextInt(pTabRoom.length)];
    } //setCurrentRoom(.)
    
    /**
     * Mutator for health point's moving person
     * @param pHealthPoint Health point removed
     */
    public void setHealthPoint(final int pHealthPoint)
    {
        this.aHealthPoint -= pHealthPoint;
    } //setHealthPoint(.)
} //MovingPerson
