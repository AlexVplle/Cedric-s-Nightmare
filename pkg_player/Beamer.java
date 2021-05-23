package pkg_player;

import pkg_room.Room;

/**
 * This class is some kind of item allowing teleporting
 * @author Alexis Vapaille
 * @version 2021.04.29
 */
public class Beamer extends Item
{
    
    /**
     * private Room charged for the beamer
     */
    private Room aRoomCharged;
    
    /**
     * Constructor for Beamer
     * @param pWeight beamer's weight
     * @param pDescription beamer's description
     */
    public Beamer(final int pWeight, final String pDescription)
    {
        super("Beamer" , pWeight, pDescription);
    }
    
    /**
     * Assessors to get the room charged
     * @return Room charged in the beamer
     */
    public Room getRoomCharged()
    {
        return this.aRoomCharged;
    } //getRoomCharged()
    
    /**
     * Mutator to set the room charged
     * @param pRoomCharged new room charged in the beamer
     */
    public void setRoomCharged(final Room pRoomCharged)
    {
        this.aRoomCharged = pRoomCharged;
    } //setRoomCharged(.)
} //Beamer