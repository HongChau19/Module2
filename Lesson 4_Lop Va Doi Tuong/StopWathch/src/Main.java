import java.util.Random;

public class Main {
        public static void main(String[] args) {
            int n = 100000;
            int[] arr = new int[n];

            // Tạo mảng ngẫu nhiên
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt(1000000);
            }

            // Đo thời gian thực thi của thuật toán sắp xếp chọn
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            selectionSort(arr);
            stopWatch.stop();

            System.out.println("Elapsed time: " + stopWatch.getElapsedTime() + " milliseconds");
        }

        public static void selectionSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }
    }