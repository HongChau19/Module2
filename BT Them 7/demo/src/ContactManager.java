import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactManager {
    private Map<String, Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        contacts = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addContact(){
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();

        if (contacts.containsKey(phoneNumber)) {
            System.out.print("Liên lạc đã tồn tại. Bạn có muốn ghi đè không? (y/n): ");
            String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            return;
            }
        }
        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        contacts.put(phoneNumber, new Contact(name, email));
        System.out.println("Liên lạc đã được thêm thành công!");
        }

        public void editContact() {
        System.out.print("Nhập số điện thoại cần sửa: ");
        String phoneNumber = scanner.nextLine();

        if (!contacts.containsKey(phoneNumber)) {
            System.out.println("Số điện thoại không tồn tại!");
            return;
        }

        System.out.print("Nhập họ tên mới (để trống nếu không thay đổi): ");
        String name = scanner.nextLine();
        System.out.print("Nhập email mới (để trống nếu không thay đổi): ");
        String email = scanner.nextLine();

        Contact contact = contacts.get(phoneNumber);
        if (!name.isEmpty()) {
            contact.setName(name);
        }
        if (!email.isEmpty()) {
            contact.setEmail(email);
        }

        System.out.println("Liên lạc đã được sửa thành công!");
    }

    public void deleteContact() {
        System.out.print("Nhập số điện thoại cần xóa: ");
        String phoneNumber = scanner.nextLine();

        if (contacts.remove(phoneNumber) != null) {
            System.out.println("Liên lạc đã được xóa thành công!");
        } else {
            System.out.println("Số điện thoại không tồn tại!");
        }
    }

    public void searchContact() {
        System.out.print("Nhập từ khoá tìm kiếm: ");
        String keyword = scanner.nextLine();
        boolean found = false;

        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (entry.getValue().getName().contains(keyword) || entry.getValue().getEmail().contains(keyword)) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy liên lạc nào khớp với từ khoá!");
        }
    }

        public void showMenu() {
            while (true) {
                System.out.println("Menu chính:");
                System.out.println("1. Thêm liên lạc");
                System.out.println("2. Sửa liên lạc");
                System.out.println("3. Xoá liên lạc");
                System.out.println("4. Tìm kiếm liên lạc");
                System.out.println("5. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        editContact();
                        break;
                    case 3:
                        deleteContact();
                        break;
                    case 4:
                        searchContact();
                        break;
                    case 5:
                        System.out.println("Thoát chương trình...");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }
}
