import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebCrawler {

    public List<String> crawlSongTitles(String url) {
        List<String> songTitles = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements titles = doc.select("h3.title_song a");
            for (Element titleElement : titles) {
                String title = titleElement.attr("title");
                if (title != null && !title.isEmpty()) {
                    songTitles.add(title.trim());
                }
            }
            System.out.println("Đã crawl thành công " + songTitles.size() + " tiêu đề từ: " + url);

        } catch (IOException e) {
            System.err.println("Lỗi khi kết nối hoặc đọc dữ liệu từ URL: " + url);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi crawl dữ liệu: " + e.getMessage());
            e.printStackTrace();
        }
        return songTitles;
    }
}