import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Main {
    private static ContactManager contactManager = new ContactManager();
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Chọn chức năng: ");
            String inputChoice = scanner.nextLine();
            try {
                choice = Integer.parseInt(inputChoice);
            } catch (NumberFormatException e) {
                choice = -1; // Invalid choice
            }

            switch (choice) {
                case 1:
                    viewContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    readFromFile();
                    break;
                case 7:
                    writeToFile();
                    break;
                case 8:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("------------------------------------");
    }

    // 1. Xem danh sách
    private static void viewContacts() {
        List<Contact> contacts = contactManager.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ rỗng. Vui lòng thêm liên hệ mới.");
            return;
        }

        int count = 0;
        for (Contact contact : contacts) {
            System.out.println(contact);
            count++;
            if (count % 5 == 0 && count < contacts.size()) {
                System.out.println("Nhấn Enter để xem 5 mục tiếp theo...");
                scanner.nextLine();
            }
        }
        System.out.println("Đã hiển thị tất cả danh bạ.");
    }

    // 2. Thêm mới
    private static void addNewContact() {
        System.out.println("\n--- THÊM MỚI DANH BẠ ---");
        String phoneNumber, group, fullName, gender, address, email;
        LocalDate dateOfBirth = null;

        boolean validPhoneNumberInput = false;
        do {
            System.out.print("Số điện thoại: ");
            phoneNumber = scanner.nextLine();
            if (!isValidPhoneNumber(phoneNumber)) {
                System.out.println("Lỗi: Số điện thoại không hợp lệ hoặc để trống. Vui lòng nhập lại.");
            } else {
                if (contactManager.getContactByPhoneNumber(phoneNumber) != null) {
                    System.out.println("Lỗi: Số điện thoại này đã tồn tại trong danh bạ. Vui lòng nhập số khác.");
                } else {
                    validPhoneNumberInput = true;
                }
            }
        } while (!validPhoneNumberInput);

        do {
            System.out.print("Nhóm : ");
            group = scanner.nextLine();
            if (group.trim().isEmpty()) {
                System.out.println("Lỗi: Nhóm không được để trống. Vui lòng nhập lại.");
            }
        } while (group.trim().isEmpty());

        do {
            System.out.print("Họ tên : ");
            fullName = scanner.nextLine();
            if (fullName.trim().isEmpty()) {
                System.out.println("Lỗi: Họ tên không được để trống. Vui lòng nhập lại.");
            }
        } while (fullName.trim().isEmpty());

        do {
            System.out.print("Giới tính : ");
            gender = scanner.nextLine();
            if (gender.trim().isEmpty()) {
                System.out.println("Lỗi: Giới tính không được để trống. Vui lòng nhập lại.");
            }
        } while (gender.trim().isEmpty());

        do {
            System.out.print("Địa chỉ : ");
            address = scanner.nextLine();
            if (address.trim().isEmpty()) {
                System.out.println("Lỗi: Địa chỉ không được để trống. Vui lòng nhập lại.");
            }
        } while (address.trim().isEmpty());

        dateOfBirth = promptForDate("Ngày sinh (yyyy-MM-dd) : ", null, true);

        boolean validEmail = false;
        do {
            System.out.print("Email : ");
            email = scanner.nextLine();
            if (email.trim().isEmpty()) {
                System.out.println("Lỗi: Email không được để trống. Vui lòng nhập lại.");
            } else if (isValidEmail(email)) {
                validEmail = true;
            } else {
                System.out.println("Lỗi: Định dạng Email không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!validEmail);

        Contact newContact = new Contact(phoneNumber, group, fullName, gender, address, dateOfBirth, email);
        contactManager.addContact(newContact);
    }

    // 3. Cập nhật
    private static void updateContact() {
        System.out.println("\n--- CẬP NHẬT DANH BẠ ---");
        String phoneNumberToUpdate;
        Contact existingContact;

        while (true) {
            System.out.print("Nhập số điện thoại của danh bạ cần sửa (hoặc Enter để thoát): ");
            phoneNumberToUpdate = scanner.nextLine();

            if (phoneNumberToUpdate.isEmpty()) {
                System.out.println("Thoát chức năng cập nhật.");
                return;
            }

            existingContact = contactManager.getContactByPhoneNumber(phoneNumberToUpdate);
            if (existingContact == null) {
                System.out.println("Không tìm được danh bạ với số điện thoại trên. Vui lòng thử lại.");
            } else {
                break;
            }
        }

        System.out.println("Tìm thấy danh bạ: " + existingContact);
        System.out.println("Nhập thông tin mới (để trống nếu không muốn thay đổi):");


        System.out.print("Nhóm mới (" + existingContact.getGroup() + "): ");
        String group = scanner.nextLine();
        if (!group.trim().isEmpty()) {
            existingContact.setGroup(group.trim());
        }


        System.out.print("Họ tên mới (" + existingContact.getFullName() + "): ");
        String fullName = scanner.nextLine();
        if (!fullName.trim().isEmpty()) {
            existingContact.setFullName(fullName.trim());
        }

        System.out.print("Giới tính mới (" + existingContact.getGender() + "): ");
        String gender = scanner.nextLine();
        if (!gender.trim().isEmpty()) {
            existingContact.setGender(gender.trim());
        }


        System.out.print("Địa chỉ mới (" + existingContact.getAddress() + "): ");
        String address = scanner.nextLine();
        if (!address.trim().isEmpty()) {
            existingContact.setAddress(address.trim());
        }

        LocalDate updatedDateOfBirth = promptForDate(
                "Ngày sinh mới (yyyy-MM-dd) (" + existingContact.getFormattedDateOfBirth() + ", để trống để giữ nguyên): ",
                existingContact.getDateOfBirth(),
                false
        );
        existingContact.setDateOfBirth(updatedDateOfBirth);

        String email;
        do {
            System.out.print("Email mới (" + existingContact.getEmail() + ", để trống để giữ nguyên): ");
            email = scanner.nextLine();

            if (email.isEmpty()) {
                break;
            } else if (isValidEmail(email)) {
                existingContact.setEmail(email);
                break;
            } else {
                System.out.println("Lỗi: Định dạng Email mới không hợp lệ. Vui lòng nhập lại hoặc để trống để giữ nguyên.");
            }
        } while (true);

        contactManager.updateContact(phoneNumberToUpdate, existingContact);
    }

    private static LocalDate promptForDate(String prompt, LocalDate defaultValue, boolean isMandatory) {
        LocalDate date = defaultValue; // Initialize with default value
        String dobString;
        boolean validInput = false;

        do {
            System.out.print(prompt);
            dobString = scanner.nextLine();

            if (dobString.trim().isEmpty()) {
                if (isMandatory) {
                    System.out.println("Lỗi: Trường này không được để trống. Vui lòng nhập.");
                } else {
                    validInput = true;
                    date = defaultValue;
                }
            } else {
                try {
                    date = LocalDate.parse(dobString, DATE_FORMATTER);
                    validInput = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Lỗi: Định dạng ngày sinh không hợp lệ. Vui lòng nhập " + "yyyy-MM-dd" + ".");
                }
            }
        } while (!validInput);
        return date;
    }

    // 4. Xóa
    private static void deleteContact() {
        System.out.println("\n--- XÓA DANH BẠ ---");
        String phoneNumberToDelete;
        Contact contactToDelete;

        while (true) {
            System.out.print("Nhập số điện thoại của danh bạ muốn xóa (hoặc Enter để thoát): ");
            phoneNumberToDelete = scanner.nextLine();

            if (phoneNumberToDelete.isEmpty()) {
                System.out.println("Thoát chức năng xóa.");
                return;
            }

            contactToDelete = contactManager.getContactByPhoneNumber(phoneNumberToDelete);
            if (contactToDelete == null) {
                System.out.println("Không tìm được danh bạ với số điện thoại trên. Vui lòng thử lại.");
            } else {
                break;
            }
        }

        System.out.println("Bạn có chắc chắn muốn xóa danh bạ này? " + contactToDelete.getFullName() + " (" + contactToDelete.getPhoneNumber() + ")");
        System.out.print("Nhập 'Y' để xác nhận xóa, bất kỳ ký tự nào khác để hủy: ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            contactManager.deleteContact(phoneNumberToDelete); // contactManager's delete method prints success/failure
        } else {
            System.out.println("Hủy bỏ thao tác xóa. Quay về Menu.");
        }
    }

    // 5. Tìm kiếm
    private static void searchContact() {
        System.out.println("\n--- TÌM KIẾM DANH BẠ ---");
        System.out.print("Nhập từ khóa (Số điện thoại hoặc Họ tên): ");
        String keyword = scanner.nextLine();

        List<Contact> searchResults = contactManager.searchContacts(keyword);

        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy danh bạ nào phù hợp với từ khóa '" + keyword + "'.");
        } else {
            System.out.println("Kết quả tìm kiếm cho '" + keyword + "':");
            for (Contact contact : searchResults) {
                System.out.println(contact);
            }
        }
    }

    // 6. Đọc file
    private static void readFromFile() {
        System.out.println("\n--- ĐỌC DANH BẠ TỪ FILE CSV ---");
        System.out.println("Cảnh báo: Thao tác này sẽ xóa toàn bộ danh bạ hiện có trong bộ nhớ.");
        System.out.print("Bạn có muốn tiếp tục? (Y/N): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Đã hủy đọc file. Danh bạ trong bộ nhớ không thay đổi.");
            return;
        }

        String defaultFilePath = "data/contacts.csv";
        contactManager.readContactsFromFile(defaultFilePath);
        viewContacts();
    }

    // 7. Ghi vào file
    private static void writeToFile() {
        System.out.println("\n--- GHI DANH BẠ VÀO FILE CSV ---");
        System.out.println("Cảnh báo: Thao tác này sẽ ghi đè nội dung file 'data/contacts.csv'.");
        System.out.print("Bạn có muốn tiếp tục? (Y/N): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Đã hủy ghi file. Dữ liệu không được lưu.");
            return;
        }
        String defaultFilePath = "data/contacts.csv";
        contactManager.writeContactsToFile(defaultFilePath);
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.trim().isEmpty() && phoneNumber.matches("^0\\d{9,10}$");
    }

    private static boolean isValidEmail(String email) {
        return email != null && !email.trim().isEmpty() && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
}