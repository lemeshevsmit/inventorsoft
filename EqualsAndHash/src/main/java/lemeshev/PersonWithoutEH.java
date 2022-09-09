package lemeshev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PersonWithoutEH {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
