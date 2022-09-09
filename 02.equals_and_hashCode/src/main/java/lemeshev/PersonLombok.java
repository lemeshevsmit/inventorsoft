package lemeshev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PersonLombok {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PersonLombok)) return false;
        final PersonLombok other = (PersonLombok) o;
        if (!other.canEqual(this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (!Objects.equals(this$firstName, other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (!Objects.equals(this$lastName, other$lastName)) return false;
        return this.getAge() == other.getAge();
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PersonLombok;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        result = result * PRIME + this.getAge();
        return result;
    }
}
