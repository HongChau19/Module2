public class UserSession {
    private static int onlineCount = 0;

    public UserSession() {
            onlineCount++;
        }
    public void logout(){
        onlineCount--;
       }
    public static int getOnlineCount() {
        return onlineCount;
    }
    public static void mophong (){
        UserSession user1 = new UserSession();
        UserSession user2 = new UserSession();
        UserSession user3 = new UserSession();

        // In ra số lượng người dùng online
        System.out.println("Số lượng người dùng online: " + UserSession.getOnlineCount());
        // Một người dùng đăng xuất (user1)
        user1.logout();
        // In ra số lượng người dùng online sau khi một người dùng đăng xuất
        System.out.println("Số lượng người dùng online sau khi một người dùng đăng xuất: " + UserSession.getOnlineCount());
    }
    public static void main(String[] args) {
        // Gọi phương thức mophong để thực hiện mô phỏng
        mophong();
    }
}