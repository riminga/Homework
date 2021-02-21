public class Passenger {
    private String firstName;
    private String lastName;

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void goToBus(Bus bus) {
        bus.addPassenger(this);
    }

    public String getFirstName() {
        return firstName;
    }
}

