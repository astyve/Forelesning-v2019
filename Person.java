
/**
 * Represents a person by name, phone number and e-mail.
 *
 * @author Arne Styve
 * @version v0.1 2019-01-28
 */
public class Person
{
    private String name;
    private String phoneNumber; // 90543334
    private String eMail;
    
    // Klassevariabel
    private static int numberOfObjectsCreated = 0;
    
    // Objekt Konstant
    private final int MAX_AGE;
    
    // Klasse konstant
    private static final double PI = 3.14;
    
    /**
     * Creates an instance of the Person class.
     * @param name The name of the person on the form "Firstname Lastname"
     * @param phoneNumber The phone number of the person without the country code, 
     *                    and no spaces in the number
     * @param eMail The e-mail address of the person.
     */
    public Person(String name, String phoneNumber, String eMail)
    {
        MAX_AGE = 54 + numberOfObjectsCreated*2;
        this.name = name;
        //Call the mutator-method to make sure necessary validation is being
        //done before accepting the phone number.
        //It is always good practice to use the mutator-methods in the constructor
        //instead of setting the fields directly.
        this.setPhoneNumber(phoneNumber);
        this.eMail = eMail;
        
        numberOfObjectsCreated++;
    }

    public static double getPi()
    {
        return PI;
    }
    
    /**
     * Sets the phone number to the person. The phone number must be 8 digits,
     * and the string provided must contain only numbers.
     * If an invalid phonnumber is provided, the phonenumber will be set to an empty string.
     * 
     * @param phoneNumber The phonenumber to set for the person
     */
    public void setPhoneNumber(String phoneNumber)
    {
        if ((phoneNumber.length() == 8) && isNumericString(phoneNumber))
        {
            this.phoneNumber = phoneNumber;
        }
        else
        {
            //Set the phonenumber to an ampty string
            this.phoneNumber = "";
        }
    }

    /**
     * Analyse a string to check if the string only contains
     * numbers and no letters.
     * A private helper-method used in the setPhoneNumber-method.
     * 
     * @param str The string to be analysed
     * @return <code>true</code> if the string only contains numbers between 0 and 9,
     *         <code>false</code> otherwise.
     */
    private boolean isNumericString(String str) 
    {
        boolean isNumeric = true;

        if (str == null)
        {
            isNumeric = false;
        }
        else
        {
            for (char c : str.toCharArray())
            {
                if (c < '0' || c > '9')
                {
                    isNumeric = false;
                }
            }
        }
        return isNumeric;
    }

    /**
     * Returns the name of the person
     * @return the name of the person on the form "surname, lastname"
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns the phone number of the person.
     * @return the phone number of the person without the country code
     */
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    /**
     * Returns the e-mail address of the person.
     * @return the e-mail address of the person.
     */
    public String getEmail()
    {
        return this.eMail;
    }

    //NEVER TO BE USED!!! 
    //NEVER add methods to a class representing an entity 
    //(like Person, Newspaper etc) that tryes to put together a string presenting
    //the entire object. This is User Interface issues, and has no place in "low level"
    //objects like Person.
    private String getDetailsAsString()
    {
        return "Name: "
            + this.name
            + ", Phone: "
            + this.phoneNumber
            + ", E-mail: "
            + this.eMail;
    }
}
