
/**
 * Write a description of class PhoneBookApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneBookApp
{
    public static void main(String[] args)
    {
        PhoneBook phoneBoo1 = new PhoneBook();
        phoneBoo1.fillPhoneBookWithDummies();
        phoneBoo1.listAllPersons();     
        
        Person p = new Person("Arne", "74635243", "lkjlkhj@lkhj.ljkh");
        
        phoneBoo1.addPerson(p);
        phoneBoo1.listAllPersons();     
       
        
    }
}
