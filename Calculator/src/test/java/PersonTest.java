import org.blitmatthew.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {

    @Test
    public void Person_Compare_Equals() {
        Person person = new Person("Nazi", 34);
        Person person1 = new Person("Nazi", 34);

        assertEquals(person, person1);
    }

    @Test
    public void Person_Compare_NotEquals() {
        Person person = new Person("Nahsung", 28);
        Person person1 = new Person("Syed", 24);

        assertNotEquals(person1,person);
    }
}
