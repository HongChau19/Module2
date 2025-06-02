package OOP;

public class Main {
    public static void main(String[] args) {
        Company company = new Company(); // Khởi tạo hệ thống quản lý

        // Thêm nhân viên
        System.out.println("----- Thêm Nhân viên -----");
        FullTimeEmployee ft1 = new FullTimeEmployee("NV001", "Nguyễn Văn A", "nva@example.com", 1000, 200); // Nhân viên chính thức [cite: 5]
        Intern intern1 = new Intern("NV002", "Trần Thị B", "ttb@example.com", 500, "Mentor X"); // Thực tập sinh [cite: 5]
        Contractor con1 = new Contractor("NV003", "Lê Văn C", "lvc@example.com", 0, 160, 15); // Nhân viên hợp đồng [cite: 5]
        FullTimeEmployee ft2 = new FullTimeEmployee("NV004", "Phạm Thu D", "ptd@example.com", 1200, 300);

        company.addEmployee(ft1); // Thêm mới nhân viên [cite: 9]
        company.addEmployee(intern1);
        company.addEmployee(con1);
        company.addEmployee(ft2);
        company.addEmployee(ft1); // Thử thêm trùng ID

        // Hiển thị thông tin tất cả nhân viên và lương thực nhận (đa hình) [cite: 9, 12]
        company.displayAllSalaries();

        // Thêm dự án
        System.out.println("\n----- Thêm Dự án -----");
        Project proj1 = new Project("DA001", "Phát triển Ứng dụng Mobile"); // Quản lý dự án [cite: 10]
        Project proj2 = new Project("DA002", "Thiết kế Website E-commerce");
        company.addProject(proj1);
        company.addProject(proj2);
        company.addProject(proj1); // Thử thêm trùng ID

        // Gán nhân viên vào dự án
        System.out.println("\n----- Gán Nhân viên vào Dự án -----");
        company.assignEmployeeToProject("NV001", "DA001"); // Giao nhân viên vào dự án [cite: 11]
        company.assignEmployeeToProject("NV002", "DA001");
        company.assignEmployeeToProject("NV003", "DA002");
        company.assignEmployeeToProject("NV004", "DA001");
        company.assignEmployeeToProject("NV001", "DA001"); // Thử gán trùng

        // Hiển thị danh sách dự án và các thành viên
        company.displayAllProjectsAndMembers();

        // Ví dụ cập nhật thông tin
        System.out.println("\n----- Cập nhật thông tin Nhân viên -----");
        ft1.setBonus(250);
        System.out.println("--- Sau khi cập nhật phụ cấp của Nguyễn Văn A ---");
        ft1.displayEmployeeInfo(); // Hiển thị thông tin nhân viên và lương thực nhận của họ [cite: 9]
    }
}