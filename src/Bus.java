public class Bus {
    private static final int MAX_PLACES_COUNT = 3;
    // поля, описывающие состояния
    private int number;
    private String model;
    private boolean isRun;

    // объектная переменная
    private Driver driver; // null
    // массив пассажиров
    // массив ссылок на объекты
    private Passenger[] passengers;
    // фактическое количество пассажиров
    private int passengersCount;
    // описали приватный конструктор, который
    // выделяет память под массив объектов
    private Bus() {
        // создаем массив в котором может быть
        // максимум 5 ссылок на объекты
        // изначально в этом массиве
        // 5 переменных и у них у всех - null
        this.passengers = new Passenger[MAX_PLACES_COUNT];
    }

    // конструктор с параметрами
    public Bus(int number, String model) {
        // вызвали пустой конструктор
        this();
        this.number = number;
        this.model = model;
    }

    // перегруженный с водителем
    public Bus(int number, String model, Driver driver) {
        this();
        this.number = number;
        this.model = model;
        this.driver = driver;
    }

    // гет-метод, который позволяет получить информацию о водителе
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        if (!isRun) {
            this.driver = driver;
        } else {
            System.err.println("Нельзя менять водителя!");
        }
    }

    public void addPassenger(Passenger passenger) {
        if (isRun) {
            System.err.println("Машина уже едет");
            return;
        }
        // [null null null null null]
        // passengersCount = 0
        // addPassenger(marsel)
        // passengers[0] = marsel
        // [marsel null null null null]
        // passengersCount = 1
        // addPassenger(ivan)
        // passengers[1] = ivan
        // [marsel ivan null null null]
        // passengersCount = 2
        if (this.passengersCount < passengers.length) {
            passengers[passengersCount] = passenger;
            passengersCount++;
        } else {
            System.err.println("Мест больше нет!");
        }
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public void go() {
        this.isRun = true;
        System.out.println("Автобус " + number
                + " модели " + model
                + " поехал под управлением " + driver.getFirstName());
        for (int i = 0; i < passengersCount; i++) {
            System.out.println("Едет с нами: " + passengers[i].getFirstName());
        }
    }

    public void stop() {
        this.isRun = false;
    }
}

