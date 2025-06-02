package OOP;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees; //Danh Sách Nhân Viên
    private List<Project> projects; //Danh sách Dự Án

    public Company() {
        employees = new ArrayList<>();
        projects = new ArrayList<>();
    }

    // Thêm mới Nhân Viên
    public void addEmployee(Employee e) {
        for (Employee emp : employees) {
            if (emp.getId().equals(e.getId())) {
                System.out.println("Lỗi: Mã nhân viên " + e.getId() + " đã tồn tại.");
                return;
            }
        }
        employees.add(e);
        System.out.println("Đã thêm nhân viên: " + e.getFullName());
    }


    // Thêm mới dự án
    public void addProject(Project p) {
        for (Project proj : projects) { // Đổi 'p' thành 'projects'
            if (proj.getProjectId().equals(p.getProjectId())) {
                System.out.println("Lỗi: Mã dự án " + p.getProjectId() + " đã tồn tại.");
                return;
            }
        }
        projects.add(p);
        System.out.println("Đã thêm dự án: " + p.getProjectName());
    }

    //Gán Dự án cho Nhân Viên - Tìm ID Nhân Viên Và Project rồi Gán
    // Tìm Nhân Viên Theo ID
    public Employee getEmployeeById(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getId().equals(employeeId)) {
                return emp;
            }
        }
        return null;
    }
    // Tìm dự án theo ID
    public Project getProjectById(String projectId) {
        for (Project proj : projects) {
            if (proj.getProjectId().equals(projectId)) {
                return proj;
            }
        }
        return null;
    }

    // Giao nhân viên vào dự án nếu họ có thể đảm nhận
    public void assignEmployeeToProject(String employeeId, String projectId) {
        Employee employee = getEmployeeById(employeeId);
        Project project = getProjectById(projectId);

        if (employee == null) {
            System.out.println("Lỗi: Không tìm thấy nhân viên với mã " + employeeId);
            return;
        }
        if (project == null) {
            System.out.println("Lỗi: Không tìm thấy dự án với mã " + projectId);
            return;
        }

        // Gọi phương thức addMember của Project để thêm nhân viên
        project.addMembers(employee);
    }

    // Hiển thị danh sách tất cả nhân viên kèm loại, thông tin liên quan, và lương thực nhận. [cite: 12]
    public void displayAllSalaries() {
        System.out.println("\n===== Báo cáo tất cả Nhân viên và Lương thực nhận =====");
        if (employees.isEmpty()) {
            System.out.println("Chưa có nhân viên nào trong hệ thống.");
            return; // Thêm return để thoát khỏi phương thức
        }
        for (Employee emp : employees) {
            emp.displayEmployeeInfo();
            System.out.println("--------------------");
        }
    }

    // Hiển thị danh sách dự án và các thành viên đang tham gia
    public void displayAllProjectsAndMembers() {
        System.out.println("\n===== Báo cáo tất cả Dự án và Thành viên =====");
        if (projects.isEmpty()) {
            System.out.println("Chưa có dự án nào trong hệ thống.");
            return;
        }
        for (Project project : projects) {
            project.displayProjectMembers();
            System.out.println("====================");
        }
    }
}
