public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0; // Khởi tạo số dư bằng 0
    }

    //Getter
    public String getOwnerName() {
        return this.ownerName;
    }

    public double getBalance() {
        return this.balance;
    }
    // Setter
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //Xử lý ngoại lệ
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nạp tiền thành công.");
        } else {
            System.out.println("Số tiền nạp vào phải là số dương.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Không đủ số dư để rút.");
            }
        } else {
            System.out.println("Số tiền rút ra phải là số dương.");
        }
    }

    public static void main(String[] args) {
        // Tạo hai tài khoản
        BankAccount acc1 = new BankAccount("Nguyễn Văn A");
        BankAccount acc2 = new BankAccount("Trần Thị B");

        // Nạp tiền vào tài khoản 1
        acc1.deposit(1000);
        System.out.println("Số dư tài khoản 1: " + acc1.getBalance());

        // Thử rút số tiền vượt quá số dư
        acc1.withdraw(1200); // Không đủ số dư
        System.out.println("Số dư tài khoản 1 sau khi rút: " + acc1.getBalance());

        // Rút một số tiền hợp lệ
        acc1.withdraw(500);
        System.out.println("Số dư tài khoản 1 sau khi rút: " + acc1.getBalance());

        // Thử nạp số âm
        acc1.deposit(-200); // Sẽ thông báo lỗi
    }
}
