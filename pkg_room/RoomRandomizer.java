package pkg_room;

import java.util.Random;

/**
 * This class is used to randomize a room
 * @author Alexis Vapaille
 * @version 2021.04.29
 */
public class RoomRandomizer
{
    /**
     * private Random
     */
    private Random aRandom;
    
    /**
     * Constructor for RoomRandomizer
     */
    public RoomRandomizer()
    {
        this.aRandom = new Random();
    } //RoomRandomizer()
    
    /**
     * Used to randomize a room
     * @param pTabRoom Room[] containing the rooms where it is possible 
     * @param pSavedRoom Room saved for the command alea 
     * @return Room random room
     */
    public Room findRandomRoom(final Room[] pTabRoom, final Room pSavedRoom)
    {
        if(pSavedRoom == null){
            return pTabRoom[this.aRandom.nextInt(pTabRoom.length)];
        }
        else{
            return pSavedRoom;
        }
    } //findRandomRoom(..)
} //RoomRandomizer