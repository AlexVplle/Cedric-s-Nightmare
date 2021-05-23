package pkg_player;

/**
 * This class is used to create the items
 * @author Alexis Vapaille
 * @version 2020.03
 */
public class Item 
{
    // ### Attributes ###
    
    /**
     * private String for the item's name
     */
    private String aName;
    
    /**
     * private String for the item's description
     */
    private String aDescription;
    
    /**
     * private int for the item's weight
     */
    private int aWeight;

    // ### Constructor ###
    /**
     * Constructor for item
     * @param pName        Item's name
     * @param pWeight      Item's weight
     * @param pDescription item's Description
     */
    public Item(final String pName, final int pWeight, final String pDescription)
    {
        this.aName        = pName;
        this.aWeight      = pWeight;
        this.aDescription = pDescription;
    } // Item(...)
    
    // ###Assessors ###
    /**
     * Assessor to get item's name
     * @return return the item's name
     */
    public String getName()
    {
        return this.aName;
    } // getNom()
    
    /**
     * Assessor to get item's weight
     * @return return the item's weight
     */
    public int getWeight()
    {
        return this.aWeight;
    } // getPrix()
    
    /**
     * Assessor to get item's description
     * @return return the item's description
     */
    public String getDescription()
    {
        return this.aName + " (" + this.aWeight + ")" + " : " + this.aDescription + "\n";
    } // getDescription()
    
    /**
     * Use to print a special description
     * @return return description's string
     */
    @Override public String toString()
    {
        return this.aName;
    } //toString()
} // Item
