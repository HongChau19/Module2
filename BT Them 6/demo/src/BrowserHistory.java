import java.util.Stack;

public class BrowserHistory {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    public BrowserHistory(String homepage) {
        this.backStack = new Stack<>();
        this.forwardStack = new Stack<>();
        this.currentPage = null;
    }

    // Khi người dùng truy cập một trang mới
    void visit(String url) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = url;
        forwardStack.clear();
    }

    // Khi nhấn nút Back
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage); // Đẩy trang hiện tại vào forwardStack
            currentPage = backStack.pop();  // Lấy trang trước đó từ backStack
        } else {
            System.out.println("Không có trang nào để quay lại.");
        }
    }

    // Khi nhấn nút Forward
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        } else {
            System.out.println("Không có trang nào để tiến tới.");
        }
    }

    // Lấy trang hiện tại
    public String getCurrentPage() {
        return currentPage;
    }

}
