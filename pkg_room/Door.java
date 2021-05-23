package pkg_room;

/**
 * This class is used to create the doors
 * @author Alexis Vapaille
 * @version 2021.04.29
 */
public class Door
{
    
    /**
     * private String
     */
    private String aKey;
    
    /**
     * Constructor for Door
     * @param pKey String to open the door
     */
    public Door(final String pKey)
    {
        this.aKey = pKey;
    } //Door(.)
    
    /**
     * Assesors to get the door's key
     * @return String door's key
     */
    public String getKey()
    {
        return this.aKey;
    } //getKey()
} //Door