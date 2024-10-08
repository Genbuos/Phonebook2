import org.junit.jupiter.api.Test;
import phonebook.PhoneBook;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;
public class RemoveTest {
    @Test
    public void test1() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String name = "John";
        String phoneNumber = "302-555-4545";
        phoneBook.add(name, phoneNumber);
        assertTrue(phoneBook.hasEntry(name));

        // when
        phoneBook.remove(name);

        // then
       assertFalse(phoneBook.hasEntry(name));
    }

    @Test
    public void test2() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String phoneNumber = "302-554-4545";
        phoneBook.add(name, phoneNumber);
        assertTrue(phoneBook.hasEntry(name));

        // when
        phoneBook.remove(name);

        // then
        assertFalse(phoneBook.hasEntry(name));
    }


    @Test
    public void test3() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Smith";
        String phoneNumber = "302-554-4535";
        phoneBook.add(name, phoneNumber);
        assertTrue(phoneBook.hasEntry(name));

        // when
        phoneBook.remove(name);

        // then
        assertFalse(phoneBook.hasEntry(name));
    }
}
