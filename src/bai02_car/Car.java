package bai02_car;

// Car.java
public class Car {
    // === THUỘC TÍNH (FIELDS) ===
    private final String make;
    private final String model;
    private final Engine engine; // Một đối tượng Car "có một" đối tượng Engine
    private int currentSpeed;

    // === CONSTRUCTOR ===
    public Car(String make, String model, Engine engine) {
        this.make = make;
        this.model = model;
        this.engine = engine;
    }

    // === PHƯƠNG THỨC (METHODS) ===

    /**
     * Khởi động xe.
     * <p>
     * Hành vi:
     * - In ra: "Attempting to start the car..."
     * - Sau đó gọi phương thức start() của đối tượng engine.
     * - Việc engine có khởi động thành công hay không phụ thuộc vào logic bên trong lớp Engine.
     */
    public void startCar() {
        System.out.println("Attempting to start the car...");
        engine.start();

    }

    /**
     * Tắt máy xe.
     * <p>
     * Hành vi:
     * - In ra: "Attempting to stop the car..."
     * - Gọi phương thức stop() của đối tượng engine.
     * - Nếu sau khi gọi stop(), engine không còn chạy (engine.isStarted() == false):
     * + Gán tốc độ currentSpeed = 0
     * + In ra: "Car has come to a complete stop."
     */
    public void stopCar() {
        System.out.println("Attempting to stop the car...");
        engine.stop();
        if (!engine.isStarted()) {
            currentSpeed = 0;
            System.out.println("Car has come to a complete stop.");
        }
    }

    /**
     * Tăng tốc xe.
     * <p>
     * Điều kiện:
     * - Động cơ phải đang chạy (engine.isStarted() == true)
     * - Lượng tăng tốc amount phải là số dương (amount > 0)
     * <p>
     * Hành vi:
     * - Nếu engine đang chạy và amount > 0:
     * + Tăng currentSpeed lên amount
     * + In ra: "Accelerating. Current speed: X km/h."
     * - Nếu engine đang chạy nhưng amount <= 0:
     * + In ra: "Error: Acceleration amount must be positive."
     * - Nếu engine đang tắt:
     * + In ra: "Error: Cannot accelerate, the engine is off."
     */
    public void accelerate(int amount) {
        if (engine.isStarted()) {
            if (amount > 0) {
                currentSpeed += amount;
                System.out.println("Accelerating. Current speed:" + currentSpeed + " km/h.");
            } else {
                System.out.println("Error: Acceleration amount must be positive.");
            }
        } else {
            System.out.println("Error: Cannot accelerate, the engine is off.");
        }

    }

    /**
     * Giảm tốc xe.
     * <p>
     * Điều kiện:
     * - Lượng giảm tốc amount phải là số dương (amount > 0)
     * <p>
     * Hành vi:
     * - Nếu amount > 0:
     * + Giảm currentSpeed đi amount
     * + Nếu currentSpeed < 0 thì gán lại currentSpeed = 0
     * + In ra: "Braking. Current speed: X km/h."
     * - Nếu amount <= 0:
     * + In ra: "Error: Brake amount must be positive."
     */
    public void brake(int amount) {
        if (amount > 0) {
            currentSpeed -= amount;
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
            System.out.println("Braking. Current speed:" + currentSpeed + " km/h.");

        } else {
            System.out.println("Error: Brake amount must be positive.");
        }
    }

    /**
     * Trả về một chuỗi chứa thông tin đầy đủ của xe.
     * Định dạng: "Car[Make=..., Model=..., Speed=... km/h, Engine_Info]"
     * Trong đó Engine_Info là kết quả từ phương thức toString() của đối tượng engine.
     */
    public String getCarInfo() {
        return "Car[Make=" + this.make + ", Model=" + this.model +
                ", Speed=" + this.currentSpeed + " km/h, " + this.engine.toString() + "]";
    }
}

