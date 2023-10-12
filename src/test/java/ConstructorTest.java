
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import phonebook.PhoneBook;

import java.util.*;

public class ConstructorTest {
    @Test
    public void testNullaryConstructor() {
        // given
        // when
        PhoneBook phoneBook = new PhoneBook();

        // then
      assertTrue(phoneBook.getMap() instanceof Map<String, List<String>>);
    }

    @Test
    public void testNonNullaryConstructor() {
        // given
        Map<String, List<String>> dependency = new LinkedHashMap<>();

        // when
        PhoneBook phoneBook = new PhoneBook(dependency);

        // then
        assertEquals(dependency, phoneBook.getMap());
    }

}
