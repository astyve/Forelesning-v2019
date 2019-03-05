import java.util.Iterator;
import java.util.HashMap;

/**
 * Represents a phone book, holding a collection of
 * persons with their name, numbers and e-mails.
 * 
 * And for the time beeing, is also the User Interface...
 * 
 * From this register you can:
 * <ul>
 *  <li>Add a person</li>
 *  <li>Remove a person</li>
 *  <li>Find person by name</li>
 *  <li>Find person by phone number</li>
 *  <li>List all persons (?!?!?)</li>
 *  </ul>
 *
 * This version uses a HashMap for internal storage of persons. The key
 * used is the phone-number, since usually there is only one person related
 * to a single phone number.
 * 
 * @author Arne Styve
 * @version v0.1
 */
public class PhoneBookHashMap
{
    
    private HashMap<String, Person> personMap;

    /**
     * Constructor for objects of class PhoneBook
     */
    public PhoneBookHashMap()
    {
        this.personMap = new HashMap<String, Person>();
    }

    /**
     * Adds a person to the ponebook.
     * @param person The person to be added to the phone book. 
     *               If <code>null</code>, nothing is being added.
     */
    public void addPerson(Person person)
    {
        if (person != null)
        {
            // Adds the person to the HashMap, using the phone-number
            // of the person as a key
            this.personMap.put(person.getPhoneNumber(), person);
        }
    }

    
    


    /**
     * Lists all persons in the phonebook by printing them to the
     * out-stream (console). This implementation uses the for-each-loop.
     * 
     */   
    public void listAllPersons()
    {
        // for-each
        for (Person p : this.personMap.values())
        {
            printPerson(p);
        }
    }

  

    /**
     * Lists all persons in the phonebook by printing them to the
     * out-stream (console). This implementation uses the while-loop
     * with Iterator.
     * 
     * Note that since we use a HashMap, we really have two collesctions
     * in one; the keys, and the values. Hence, we must choose which of
     * these to collections within the HashMap we want to iterate
     * over. To get to all the persons, we have to iterate over the
     * values-collection (since the values are of type Person).
     */   
    public void listAllPersons2()
    {
        // Ask the collection (HashMap) for its iterator of the values part
        // of the collection
        Iterator<Person> it = this.personMap.values().iterator();
        // Use the iterator-object to move from one object to the next
        //in the collection (ArrayList)
        while (it.hasNext())    //Ask the iterator: Is there an object at current location?
        {
            Person p = it.next(); //Ask the iterator to return the object at current location
            printPerson(p);
        }
    }    

    /**
     * Prints the information of the person provided. This is a private
     * helper method used by the other methods in the class.
     * 
     * @param person The person to print the details of.
     */
    private void printPerson(Person person)
    {
        System.out.println("Name: " + person.getName() + ", " 
            + " Phonenumber: " + person.getPhoneNumber()
            + " E-mail: " + person.getEmail());
    }

    /**
     * Searches the phonebook for the person with the phone number provided
     * by the parameter.
     * 
     * @param phoneNumber The phone-number to search for
     * @return The person matching the phone number searched for.
     *         If no person found, or if the parameter is invalid, <code>null</code>
     *         is returned.
     */
    public Person findPersonByPhoneNumber(String phoneNumber)
    {
        // The only time you are "allowed" to return other places in
        // the code than at the end of the method, is when you perform
        // validity-cheks on parameters. This is often reffered to as 
        // "Guard statements".
        if (null == phoneNumber)
        {
            return null;
        }
        
        // Since we are using a HashMap, we can directly look up the correct
        // person bu using the get()-method and the phone-number as a key.
        // No need to loop/iterate over the HashMap.
        // If no keys are found matching the phone number provided,
        // the get()-method returns <code>null</code>.
        return this.personMap.get(phoneNumber);
    }
       
 
    /**
     * Search the phonebook for person with the name given by the parameter.
     * Return the person if found. If not found <code>null</code> is returned.
     * 
     * This version uses the for-each-loop. So this method will return the last
     * person in the collection matching the name.
     * 
     * @param name the name to search for
     * @return The person matching the name searched for. 
     *         If no person is found, <code>null</code> is returned.
     */
    public Person findPersonByName(String name)
    {
        Person person = null;

        // Whenever you use a for-loop, you are expected to always iterate through
        // the entire collection (ArrayList). It is NOT GOOD PRACTICE to break
        // a for-loop, and especially not returning from the middle of the for-loop!!
        for (Person p : this.personMap.values())
        {
            if (p.getName().equals(name))
            {
                // FOUND HIM/HER :-)
                person = p;
                //break; //NEI NEI NEI NEI!!!
                //return p; //STRYK!!!
            }
        }

        return person;
    }    

    /**
     * Search the phonebook for person with the name given by the parameter.
     * Return the person if found. If not found <code>null</code> is returned.
     * 
     * This version uses the while-loop. Using the while-loop enables us to break the
     * loop before iterating the entire collection. I.e. when you find the person
     * matching the name, you can stop searching and terminate the loop.
     * 
     * In this verison we use the Iterator-object.
     * 
     * @param name the name to search for
     * @return The person matching the name searched for. 
     *         If no person is found, <code>null</code> is returned.
     */    
    public Person findPersonByName2(String name)
    {
        Person person = null;

        boolean found = false;

        Iterator<Person> it = this.personMap.values().iterator();
        //This while loop will run as long as there are objects left to visit
        //in the collection (ArrayList) AND we have still not found the person
        //we are looking for.
        while (it.hasNext() && !found)
        {
            Person p = it.next();

            if (p.getName().equals(name))
            {
                // FOUND HIM/HER :-)
                person = p;
                found = true;
                //NB! We do NOT use break here either!! And ABSOLUTELY NOT return!!
            }
        }

        return person;
    }      

    
    /**
     * Fills the PhoneBook with some "dummy" persons to have some
     * people to work on to test the functionality of the phonebook.
     * 
     * Note how we use "anonomous objects" when adding objects
     * of the type Person to the Phonebook.
     * 
     * Also note that I use the addPerson()-method instead of the
     * personList.add()-method.
     */
    public void fillPhoneBookWithDummies()
    {
        //Alternative way to add multiple persons using a local variable.
        //But since the local variable p is only used to hold the new object
        //until it is added to the PhoneBook, we might as well do without
        //using a local variable, and use "anonomous objects" instead.
        /**
        Person p = new Person("Arne", "982739847", "alksjdhf@aksjdf.lk");
        this.addPerson(p);
        p = new Person("Jens", "982739847", "alksjdhf@aksjdf.lk");
        this.addPerson(p);
        Person p3 = new Person("Line", "982739847", "alksjdhf@aksjdf.lk");
        this.addPerson(p3);
         */

        //NOTE: I use the addPerson()-method instead of this.personlist.add(). Why?
        //      because the addPerson()-method verifies that the object added to the 
        //      phonebook is a valid object. Hence it is safer to always use this method
        //      than adding directly into the ArrayList.
        this.addPerson(new Person("Trine", "34498987", "lkajsdlkfjh@lashjkdf.khj"));
        this.addPerson(new Person("Arne",  "98279847", "alksjdhf@aksjdf.lk"));
        this.addPerson(new Person("Jens",  "98739847", "alksjdhf@aksjdf.lk"));

    }
}
