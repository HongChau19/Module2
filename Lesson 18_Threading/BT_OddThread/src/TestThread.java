
public class TestThread {
    public static void main(String[] args) {
        System.out.println("--- Chạy luồng độc lập (không có join) ---");
        OddThread oddThread1 = new OddThread();
        EvenThread evenThread1 = new EvenThread();

        // Start các thread
        oddThread1.start();
        evenThread1.start();

        try {
            // Đợi cho cả hai luồng kết thúc trước khi chạy ví dụ join()
            oddThread1.join();
            evenThread1.join();
            System.out.println("\n--- Kết thúc chạy luồng độc lập ---\n");
        } catch (InterruptedException e) {
            System.err.println("Main thread bị gián đoạn.");
            Thread.currentThread().interrupt();
        }

        System.out.println("--- Chạy luồng có sử dụng join() để đảm bảo thứ tự ---");
        OddThread oddThread2 = new OddThread();
        EvenThread evenThread2 = new EvenThread();

        // Bắt đầu OddThread trước
        oddThread2.start();

        try {
            // Gọi join() trên oddThread2: luồng chính sẽ chờ oddThread2 kết thúc
            oddThread2.join();
            System.out.println("MainThread: OddThread đã hoàn thành, bây giờ khởi động EvenThread.");
        } catch (InterruptedException e) {
            System.err.println("Main thread bị gián đoạn khi chờ OddThread.");
            Thread.currentThread().interrupt();
        }

        // Sau khi oddThread2 kết thúc, mới start EvenThread
        evenThread2.start();

        try {
            // Đợi EvenThread kết thúc để đảm bảo tất cả các luồng con đã xong
            evenThread2.join();
            System.out.println("MainThread: EvenThread đã hoàn thành.");
        } catch (InterruptedException e) {
            System.err.println("Main thread bị gián đoạn khi chờ EvenThread.");
            Thread.currentThread().interrupt();
        }

        System.out.println("--- Chương trình chính kết thúc ---");
    }
}