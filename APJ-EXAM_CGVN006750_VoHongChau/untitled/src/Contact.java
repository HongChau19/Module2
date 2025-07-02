import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contact {
    private String phoneNumber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private LocalDate dateOfBirth;
    private String email;

    private static final DateTimeFormatter DISPLAY_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Contact(String phoneNumber, String group, String fullName, String gender, String address, LocalDate dateOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    // Getters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFormattedDateOfBirth() {
        if (dateOfBirth == null) {
            return "";
        }
        return dateOfBirth.format(DISPLAY_DATE_FORMATTER);
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setGroup(String group) {
        this.group = group;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Số ĐT: " + phoneNumber + ", Nhóm: " + group + ", Tên: " + fullName +
                ", GT: " + gender + ", ĐC: " + address + ", NS: " + getFormattedDateOfBirth() +
                ", Email: " + email;
    }
}