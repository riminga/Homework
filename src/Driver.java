public class Driver {
    private String firstName;
    private String lastName;
    private int experience;

    // ссылка на автобус
    private Bus bus;

    public Driver(String firstName, String lastName, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        // TODO: надо добавить проверку опыта
        this.experience = experience;
    }

    public void goToBus(Bus bus) {
        this.bus = bus;
        bus.setDriver(this);
    }

    public void drive() {
        this.bus.go();
    }


    public Bus getBus() {
        return bus;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExperience() {
        return experience;
    }
}

