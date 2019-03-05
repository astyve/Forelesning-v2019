import java.util.ArrayList;
import java.util.Iterator;

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
 * @author Arne Styve
 * @version v0.1
 */
public class PhoneBook
{
    private ArrayList<Person> personList;

    /**
     * Constructor for objects of class PhoneBook
     */
    public PhoneBook()
    {
        this.personList = new ArrayList<Person>();
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
            this.personList.add(person);
        }

        Person.getPi();
    }
    
    /**
     * Lists all persons in the phonebook by printing them to the
     * out-stream (console). This implementation uses the "traditional" for-loop
     * as we know it from Arduino-programming.
     */
    public void listAllPersons()
    {
        for (int i = 0; i < this.personList.size() ; i++)
        {
            Person p = this.personList.get(i);
            printPerson(p);
        }
    }

    /**
     * Lists all persons in the phonebook by printing them to the
     * out-stream (console). This implementation uses the for-each-loop.
     * 
     */   
    public void listAllPersons2()
    {
        // for-each
        for (Person p : this.personList)
        {
            printPerson(p);
        }
    }

    /**
     * Lists all persons in the phonebook by printing them to the
     * out-stream (console). This implementation uses the while-loop
     * with index.
     */   
    public void listAllPersons3()
    {
        int i = 0;
        while (i < this.personList.size())
        {
            Person p = this.personList.get(i);
            printPerson(p);

            // Remeber to increase the i!!
            i++;
        }
    }

    /**
     * Lists all persons in the phonebook by printing them to the
     * out-stream (console). This implementation uses the while-loop
     * with Iterator.
     */   
    public void listAllPersons4()
    {
        // Ask the collection (ArrayList) for its iterator
        Iterator<Person> it = this.personList.iterator();
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
     * Search the phonebook for person with the name given by the parameter.
     * Return the person if found. If not found <code>null</code> is returned.
     * 
     * This version uses the traditional for-loop with index. So this method will 
     * return the last person in the collection matching the name.
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
        for (int i = 0; i < this.personList.size(); i++)
        {
            Person p = personList.get(i);
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
     * This version uses the for-each-loop. So this method will return the last
     * person in the collection matching the name.
     * 
     * @param name the name to search for
     * @return The person matching the name searched for. 
     *         If no person is found, <code>null</code> is returned.
     */
    public Person findPersonByName2(String name)
    {
        Person person = null;

        // Whenever you use a for-loop, you are expected to always iterate through
        // the entire collection (ArrayList). It is NOT GOOD PRACTICE to break
        // a for-loop, and especially not returning from the middle of the for-loop!!
        for (Person p : this.personList)
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
     * In this verison we use index with the while-loop.
     * 
     * @param name the name to search for
     * @return The person matching the name searched for. 
     *         If no person is found, <code>null</code> is returned.
     */    
    public Person findPersonByName3(String name)
    {
        Person person = null;

        boolean found = false;

        int i = 0;
        while ((i < this.personList.size()) && !found)
        {
            Person p = personList.get(i);

            if (p.getName().equals(name))
            {
                // FOUND HIM/HER :-)
                person = p;
                found = true;
                //NB! We do NOT use break here either!! And ABSOLUTELY NOT return!!
            }
            i++;
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
    public Person findPersonByName4(String name)
    {
        Person person = null;

        boolean found = false;

        Iterator<Person> it = this.personList.iterator();
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
        this.addPerson(new Person("Trine", "98433987", "lkajsdlkfjh@lashjkdf.khj"));
        this.addPerson(new Person("Arne",  "98739847", "alksjdhf@aksjdf.lk"));
        this.addPerson(new Person("Jens",  "92739847", "alksjdhf@aksjdf.lk"));

    }



}
