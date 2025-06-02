package OOP;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectId;
    private String projectName;
    private List<Employee> members; // Danh sách nhân viên tham gia dự án

    public Project(String projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.members = new ArrayList<>(); // Khởi tạo danh sách rỗng
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Employee> getMembers() {
        return members;
    }



    // Thêm nhân viên vào dự án
    public void addMembers(Employee e) {
        if (!members.contains(e)) { // Tránh thêm trùng lặp
            members.add(e);
            System.out.println(e.getFullName() + " đã được thêm vào dự án " + projectName);
        } else {
            System.out.println(e.getFullName() + " đã có trong dự án " + projectName);
        }
    }

    // Hiển thị danh sách nhân viên của dự án
    public void displayProjectMembers() {
        System.out.println("\n--- Danh sách nhân viên tham gia dự án: " + projectName + " (" + projectId + ") ---");
        if (members.isEmpty()) {
            System.out.println("Chưa có thành viên nào trong dự án này.");
            return;
        }
        for (Employee member : members) {
            System.out.println("- " + member.getFullName() + " (Mã: " + member.getId() + ")");
        }
    }
}
