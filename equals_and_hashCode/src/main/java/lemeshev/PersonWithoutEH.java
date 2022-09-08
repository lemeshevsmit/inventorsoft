package lemeshev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonWithoutEH {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
