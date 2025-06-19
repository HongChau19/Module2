import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        char operator = ' ';
        double result = 0;

        try{
            System.out.print("Nhập số thứ nhất: ");
            num1 = scanner.nextInt();

            System.out.print("Nhập số thứ hai: ");
            num2 = scanner.nextInt();

            System.out.print("Nhập phép toán (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            switch(operator){
                case '+':
                    result = num1 + num2;
                    System.out.println(result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println(result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println(result);
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Lỗi không thể chia cho 0");
                    }
                    result = num1/num2;
                    System.out.println(result);
                    break;
                default:
                    System.out.println("Lỗi phép toán không hợp lệ");
            }
        } catch (InputMismatchException e){
            System.err.println("Lỗi nhập liệu: Vui lòng nhập đúng kiểu dữ liệu.");
            scanner.nextLine();
        }catch (ArithmeticException e){
            System.err.println(e.getMessage());
        }finally {
            System.out.println("Chương trình máy tính đã kết thúc.");
            scanner.close();
        }
    }
}
