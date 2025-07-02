import java.util.concurrent.TimeUnit;

// Lớp OddThread để in các số lẻ
class OddThread extends Thread {
    @Override
    public void run() {
        System.out.println("OddThread: Bắt đầu in số lẻ...");
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("OddThread: " + i);
            try {
                // Tạm dừng 10 milliseconds
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("OddThread: Bị gián đoạn!");
                Thread.currentThread().interrupt(); // Đặt lại trạng thái ngắt
            }
        }
        System.out.println("OddThread: Kết thúc.");
    }
}

// Lớp EvenThread để in các số chẵn
class EvenThread extends Thread {
    @Override
    public void run() {
        System.out.println("EvenThread: Bắt đầu in số chẵn...");
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("EvenThread: " + i);
            try {
                // Tạm dừng 15 milliseconds
                TimeUnit.MILLISECONDS.sleep(15);
            } catch (InterruptedException e) {
                System.out.println("EvenThread: Bị gián đoạn!");
                Thread.currentThread().interrupt(); // Đặt lại trạng thái ngắt
            }
        }
        System.out.println("EvenThread: Kết thúc.");
    }
}