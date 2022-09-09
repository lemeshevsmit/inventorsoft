package lemeshev.test;

import lemeshev.PersonAutoGenerate;
import lemeshev.PersonLombok;
import lemeshev.PersonNotFullEquals;
import lemeshev.PersonWithoutEH;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


class PersonTest {
    private static List<Object> persons = new ArrayList<>();

    @BeforeAll
    public static void startInit() {
        PersonAutoGenerate firstPerson = new PersonAutoGenerate(1, "Taras", "Bulba", 33);
        PersonAutoGenerate secondPerson = new PersonAutoGenerate(1, "Taras", "Bulba", 33);
        PersonAutoGenerate thirdPerson = new PersonAutoGenerate(1, "Taras", "Bulba", 33);

        PersonLombok fourthPerson = new PersonLombok(2, "Ivan", "Mazepa", 67);
        PersonLombok fifthPerson = new PersonLombok(2, "Ivan", "Mazepa", 67);
        PersonLombok sixthPerson = new PersonLombok(2, "Ivan", "Mazepa", 67);

        PersonWithoutEH seventhPerson = new PersonWithoutEH(3, "Bogdan", "Khmelnitsky", 54);
        PersonWithoutEH eighthPerson = new PersonWithoutEH(3, "Bogdan", "Khmelnitsky", 54);
        PersonWithoutEH ninthPerson = new PersonWithoutEH(3, "Bogdan", "Khmelnitsky", 54);

        PersonNotFullEquals tenthPerson = new PersonNotFullEquals(4, "Demian", "Mnogogrishnui", 68);
        PersonNotFullEquals eleventhPerson = new PersonNotFullEquals(4, "Demian", "Mnogogrishnui", 68);
        PersonNotFullEquals twelfthPerson = new PersonNotFullEquals(4, "Demian", "Mnogogrishnui", 68);

        persons.add(firstPerson);
        persons.add(secondPerson);
        persons.add(thirdPerson);
        persons.add(fourthPerson);
        persons.add(fifthPerson);
        persons.add(sixthPerson);
        persons.add(seventhPerson);
        persons.add(eighthPerson);
        persons.add(ninthPerson);
        persons.add(tenthPerson);
        persons.add(eleventhPerson);
        persons.add(twelfthPerson);
    }

    @AfterAll
    private static void clear() {
        persons = null;
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "3, 4", "9,10"})
    public void defaultEqualsResult(int index1, int index2) {
        System.out.println("Testing method equals with default values for class:"
                + persons.get(index1).getClass().getName());
        boolean result = persons.get(index1).equals(persons.get(index2));
        assertEquals("Object not equals", true, result);
        System.out.println("Input pare is " + (result ? "equals" : "not equals") + " >>> " + result);
    }

    @ParameterizedTest
    @CsvSource({"6, 7"})
    public void defaultEqualsIncorrectResult(int index1, int index2) {
        System.out.println("Testing method equals with default values for class:"
                + persons.get(index1).getClass().getName());
        boolean result = persons.get(index1).equals(persons.get(index2));
        assertEquals("Object not equals", false, result);
        System.out.println("Input pare is " + (!result ? "equals" : "not equals") + " >>> " + result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 6, 9})
    public void reflexive(int index) {
        System.out.println("Testing reflexive for class: " + persons.get(index).getClass().getName());
        boolean result = persons.get(index).equals(persons.get(index));
        assertTrue("Object not equals", result);
        System.out.println("Reflexive is " + (result ? "passed" : "failed") + " >>> " + result);
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "3, 4", "6, 7", "9,10"})
    public void symmetric(int index1, int index2) {
        System.out.println("Testing symmetric for class: " + persons.get(index1).getClass().getName());
        boolean resultXY = persons.get(index1).equals(persons.get(index2));
        boolean resultYX = persons.get(index2).equals(persons.get(index1));
        assertEquals("Object not equals", true, resultXY == resultYX);
        System.out.println("Symmetric is " + (resultYX ? "passed" : "failed") +
                " >>> X^Y: " + resultXY + " Y^X: " + resultYX);
    }

    @ParameterizedTest
    @CsvSource({"0, 1, 2", "3, 4, 5", "9, 10, 11"})
    public void transitive(int index1, int index2, int index3) {
        System.out.println("Testing transitive for class: " + persons.get(index1).getClass().getName());
        boolean resultXY = persons.get(index1).equals(persons.get(index2));
        boolean resultYZ = persons.get(index2).equals(persons.get(index3));
        boolean resultZX = persons.get(index3).equals(persons.get(index1));
        boolean result = resultXY == resultYZ == resultZX;
        assertEquals("Object not equals", true, result);
        System.out.println("Transitive is " + (result ? "passed" : "failed") +
                " >>> X^Y: " + resultXY + " Y^Z: " + resultYZ + " Z^X: " + resultYZ);
    }
    @ParameterizedTest
    @CsvSource({"0, 1", "3, 4", "9,10"})
    public void consistent(int index1, int index2) {
        System.out.println("Testing consistent for class: " + persons.get(index1).getClass().getName());
        boolean first = persons.get(index1).equals(persons.get(index2));
        boolean second = persons.get(index1).equals(persons.get(index2));
        boolean third = persons.get(index1).equals(persons.get(index2));
        boolean result = first == second == third;
        assertEquals("Object not equals", true, result);
        System.out.println("Consistent is " + (result ? "passed" : "failed") +
                " >>> X^Y: " + first + " X^Y: " + second + " X^Y: " + second);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 6})
    public void equalsNull(int index) {
        System.out.println("Testing equals with null for class: " + persons.get(index).getClass().getName());
        boolean result = persons.get(index).equals(null);
        assertFalse("Object not equals", result);
        System.out.println("Equals with null is " + (!result ? "passed" : "failed") + " >>> " + result);
    }

    @Test
    public void nullPointException() {
        Exception exception = assertThrows(NullPointerException.class, () -> persons.get(9).equals(null));
        assertEquals("Cannot read field \"id\" because \"person\" is null", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "3, 4", "9,10"})
    public void equalsHashCode(int index1, int index2) {
        System.out.println("Testing hashCode for class: " + persons.get(index1).getClass().getName());
        boolean result = persons.get(index1).hashCode()==persons.get(index2).hashCode();
        assertEquals("Object not equals", true, result);
        System.out.println("HashCode in pare is " + (result ? "equals" : "not equals") + " >>> " + result);
    }

    @Test
    public void equalsHashCodeIncorrect() {
        System.out.println("Testing hashCode for class: " + persons.get(6).getClass().getName());
        boolean result = persons.get(6).hashCode()==persons.get(7).hashCode();
        assertEquals("Object not equals", false, result);
        System.out.println("HashCode in pare is " + (!result ? "equals" : "not equals") + " >>> " + result);
    }
}