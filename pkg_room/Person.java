package pkg_room;

/**
 * This class is used to create person
 */
public class Person
{
    /**
     * private String for the text displayed when the player talk him
     */
    private String aText;
    
    /**
     * Constructor for Person
     * @param pText String 
     */
    public Person(final String pText)
    {
        this.aText = pText;
    } //Person(.)
    
    /**
     * Assessor for the text displayed when the player talk him
     * @return String for the text displayed when the player talk him
     */
    public String getText()
    {
        return this.aText;
    } //getText()
} //Person