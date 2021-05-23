package pkg_room;

import java.util.HashMap;

/**
 * This class is some kind of room that teleport the player when he left it
 */
public class TransporterRoom extends Room
{
    
    /**
     * private RoomRandomizer
     */
    private RoomRandomizer aRoomRandomizer;
    
    /**
     * Constructor for TransporterRoom
     * @param pDescription String containing the transporter room's description
     * @param pImage String used for the image
     */
    public TransporterRoom(final String pDescription, final String pImage)
    {
        super(pDescription, pImage);
        this.aRoomRandomizer = new RoomRandomizer();
    } //TransporterRoom(..)
    
    /**
     * Assesors to get the random room 
     * @param pDescription String useless
     * @param pTabRoom HashMap containing rooms
     * @param pSavedRoom Room saved for the command alea
     * @return Return the random room 
     */
    @Override public Room getExit(final String pDescription, final HashMap<String, Room> pTabRoom, final Room pSavedRoom)
    {
        return this.aRoomRandomizer.findRandomRoom(pTabRoom.values().toArray(new Room[pTabRoom.values().size()]), pSavedRoom);
    } //getExit(...)
} //TransporterRoom