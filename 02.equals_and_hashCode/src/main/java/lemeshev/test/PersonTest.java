package lemeshev.test;

import lemeshev.PersonAutoGenerate;
import lemeshev.PersonLoombook;
import lemeshev.PersonWithoutEH;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class PersonTest {
    private static PersonAutoGenerate firstPerson, secondPerson;
    private static PersonLoombook thirdPerson, fourthPerson;
    private static PersonWithoutEH fifthPerson, sixthPerson;

    @BeforeAll
    public static void startInit() {
        firstPerson = new PersonAutoGenerate(1, "Taras", "Bulba", 33);
        System.out.println(firstPerson);
        secondPerson = new PersonAutoGenerate(1, "Taras", "Bulba", 33);
        System.out.println(secondPerson);

        thirdPerson = new PersonLoombook(2, "Ivan", "Mazepa", 67);
        System.out.println(thirdPerson);
        fourthPerson = new PersonLoombook(2, "Ivan", "Mazepa", 67);
        System.out.println(fourthPerson);

        fifthPerson = new PersonWithoutEH(3, "Bogdan", "Khmelnitsky", 54);
        System.out.println(fifthPerson);
        sixthPerson = new PersonWithoutEH(3, "Bogdan", "Khmelnitsky", 54);
        System.out.println(sixthPerson);

    }

    @AfterAll
    private static void clear() {
        firstPerson = null;
        secondPerson = null;
        thirdPerson = null;
        fourthPerson = null;
        fifthPerson = null;
        sixthPerson = null;
    }

    @Test
    public void DefaultEqualsResult(){
        System.out.println("TEST: Equals default values of object");
        assertTrue("Object not equals",firstPerson.equals(secondPerson));
        System.out.println("First pare is equals!");
        assertTrue("Object not equals",fourthPerson.equals(thirdPerson));
        System.out.println("Second pare is equals!");
        assertFalse("Object equals",fifthPerson.equals(sixthPerson));
        System.out.println("Third pare is NOT equals!");
    }
}