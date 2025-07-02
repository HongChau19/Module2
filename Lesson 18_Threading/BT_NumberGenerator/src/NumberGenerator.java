import java.util.concurrent.TimeUnit; // Import for TimeUnit

public class NumberGenerator implements Runnable {

    private String threadName; // Để dễ dàng nhận biết luồng nào đang chạy

    public NumberGenerator(String name) {
        this.threadName = name;
        System.out.println("Tạo luồng: " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Luồng " + threadName + " bắt đầu chạy.");
        System.out.println("hashCode của " + threadName + ": " + this.hashCode());

        for (int i = 1; i <= 10; i++) {
            System.out.println("Luồng " + threadName + ": " + i);
            try {
                // Tạm dừng 500 milliseconds
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Luồng " + threadName + " bị gián đoạn.");
                Thread.currentThread().interrupt(); // Đặt lại trạng thái ngắt
            }
        }
        System.out.println("Luồng " + threadName + " kết thúc.");
    }

    public static void main(String[] args) {
        // Tạo 2 đối tượng NumberGenerator
        NumberGenerator generator1 = new NumberGenerator("Generator-1");
        NumberGenerator generator2 = new NumberGenerator("Generator-2");

        // Tạo 2 đối tượng Thread với tham số khởi tạo là 2 đối tượng NumberGenerator
        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);

        System.out.println("\n--- Chạy với Priority Mặc Định ---");
        // Gọi phương thức start() cho cả 2 thread
        thread1.start();
        thread2.start();

        try {
            // Chờ cho cả hai luồng kết thúc trước khi thử thay đổi priority
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Luồng chính bị gián đoạn khi chờ các luồng con.");
            Thread.currentThread().interrupt();
        }

        System.out.println("\n--- Chạy với Priority Thay Đổi ---");
        // Tạo lại các luồng để chạy lại với priority mới (vì luồng không thể khởi động lại)
        NumberGenerator generator3 = new NumberGenerator("Generator-3 (MAX_PRIORITY)");
        NumberGenerator generator4 = new NumberGenerator("Generator-4 (MIN_PRIORITY)");

        Thread thread3 = new Thread(generator3);
        Thread thread4 = new Thread(generator4);

        // Thay đổi priority của 2 thread
        thread3.setPriority(Thread.MAX_PRIORITY); // Priority cao nhất
        thread4.setPriority(Thread.MIN_PRIORITY); // Priority thấp nhất

        System.out.println("Priority của Generator-3: " + thread3.getPriority());
        System.out.println("Priority của Generator-4: " + thread4.getPriority());

        // Chạy lại chương trình với priority đã thay đổi
        thread3.start();
        thread4.start();
    }
}