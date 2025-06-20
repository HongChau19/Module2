import java.util.List;

public class Main {
    public static void main(String[] args) {
        String urlToCrawl = "https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html";
        String outputFileName = "output.txt";

        // Bước 1: Crawl dữ liệu
        System.out.println("---------- Bắt đầu quá trình Crawl dữ liệu ----------");
        WebCrawler crawler = new WebCrawler();
        List<String> crawledTitles = crawler.crawlSongTitles(urlToCrawl);

        if (crawledTitles.isEmpty()) {
            System.out.println("Không có tiêu đề nào được crawl hoặc xảy ra lỗi.");
            return;
        }

        System.out.println("\n---------- Bắt đầu ghi dữ liệu vào File ----------");
        FileManager fileManager = new FileManager();
        fileManager.writeToFile(outputFileName, crawledTitles);

        System.out.println("\n---------- Đọc lại dữ liệu từ File và hiển thị ----------");
        List<String> titlesFromFile = fileManager.readFromFile(outputFileName);

        if (titlesFromFile.isEmpty()) {
            System.out.println("File output.txt rỗng hoặc không đọc được.");
        } else {
            System.out.println("\nCác tiêu đề đã được lưu trong " + outputFileName + ":");
            for (int i = 0; i < titlesFromFile.size(); i++) {
                System.out.println((i + 1) + ". " + titlesFromFile.get(i));
            }
        }

        System.out.println("\n---------- Chương trình đã hoàn tất ----------");
    }
}