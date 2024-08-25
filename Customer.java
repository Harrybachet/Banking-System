
// This is a Customer class //
public class Customer {


    // This is me making their firstName and lastName private //
    private String firstName;
    private String lastName;

    // This is a global variable called FName and LName //
    public static String FName;
    public static String LName;


    // This is a Customer constructor where we take in the first and last name of the user //
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // This is just returning the first and last names //
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    // This is just unused global variables, I couldn't find any use of them, but it was in the requirements, so I included it //
    public String setLastName() {
        return LName;
    }

    // This is just unused global variables, I couldn't find any use of them, but it was in the requirements, so I included it //
    public String setFirstName() {
        return FName;
    }


}
