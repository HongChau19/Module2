import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;
    // Định nghĩa formatter cho việc đọc/ghi ngày tháng theo định dạng yyyy-MM-dd
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
        System.out.println("Đã thêm danh bạ thành công.");
    }

    public boolean updateContact(String phoneNumber, Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                contacts.set(i, updatedContact);
                System.out.println("Đã cập nhật danh bạ thành công.");
                return true;
            }
        }
        return false;
    }

    public boolean deleteContact(String phoneNumber) {
        return contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
    }

    public List<Contact> searchContacts(String keyword) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().contains(keyword) ||
                    contact.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(contact);
            }
        }
        return results;
    }

    public Contact getContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    // --- Chức năng đọc danh bạ từ file CSV ---
    public void readContactsFromFile(String filePath) {
        this.contacts.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length >= 7) {
                    String phoneNumber = data[0].trim();
                    String group = data[1].trim();
                    String fullName = data[2].trim();
                    String gender = data[3].trim();
                    String address = data[4].trim();
                    String dobString = data[5].trim();
                    String email = data[6].trim();

                    LocalDate dateOfBirth = null;
                    if (!dobString.isEmpty()) {
                        try {
                            dateOfBirth = LocalDate.parse(dobString, DATE_FORMATTER); // Phân tích theo yyyy-MM-dd
                        } catch (DateTimeParseException e) {
                            System.err.println("Lỗi định dạng ngày sinh cho liên hệ: " + fullName + ". Ngày sinh bị bỏ qua.");
                        }
                    }

                    Contact newContact = new Contact(phoneNumber, group, fullName, gender, address, dateOfBirth, email);
                    this.contacts.add(newContact);
                } else {
                    System.err.println("Dòng dữ liệu không hợp lệ (thiếu cột): " + line);
                }
            }
            System.out.println("Đã đọc " + this.contacts.size() + " danh bạ từ file " + filePath + " thành công.");

        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file danh bạ: " + e.getMessage());
            System.out.println("Hãy đảm bảo file 'data/contacts.csv' tồn tại và có quyền truy cập.");
        }
    }

    public void writeContactsToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("phoneNumber,group,fullName,gender,address,dateOfBirth,email");
            bw.newLine();


            for (Contact contact : contacts) {
                String dobFormatted = (contact.getDateOfBirth() != null) ?
                        contact.getDateOfBirth().format(DATE_FORMATTER) : "";

                String line = String.join(",",
                        contact.getPhoneNumber(),
                        contact.getGroup(),
                        contact.getFullName(),
                        contact.getGender(),
                        contact.getAddress(),
                        dobFormatted,
                        contact.getEmail()
                );
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Đã ghi " + this.contacts.size() + " danh bạ vào file " + filePath + " thành công.");

        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file danh bạ: " + e.getMessage());
            System.out.println("Hãy đảm bảo thư mục 'data/' tồn tại và có quyền ghi.");
        }
    }
}