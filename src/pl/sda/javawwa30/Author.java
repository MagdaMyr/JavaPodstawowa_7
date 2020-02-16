package pl.sda.javawwa30;

import java.time.LocalDate;

public class Author {

    final private String name;
    final private char gender;
    final private LocalDate birthDate;

    public Author(String name, char gender, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;

        if(validateGender(gender))
            this.gender = gender;
        else
            this.gender = 'k';
    }

    @Override
    public String toString() {
        return "Author[" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ']';
    }

    private boolean validateGender(char gender) {
        if(gender != 'm' && gender != 'k')
            return false;
        else
            return true;
    }

    public String getName() {
        return name;
    }
}
