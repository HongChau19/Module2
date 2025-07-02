import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawSongExample {


    public static void main(String[] args) {
        try {
            URL url = new URL("https://vnexpress.net/");
            // open the stream and put it into BufferedReader
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            // close scanner
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n+", "");
            // regex
            Pattern p = Pattern.compile(" alt=\"(.*?)\" class=\"lazy\"");
            //<a href="https://vnexpress.net/bo-tai-chinh-du-kien-sua-luat-thue-thu-nhap-ca-nhan-vao-thang-10-4909242.html#vn_source=Home&amp;vn_campaign=ThuongVien&amp;vn_medium=Item-1&amp;vn_term=Desktop&amp;vn_thumb=1&amp;vn_aid=1000000" title="Bộ Tài chính: Dự kiến sửa Luật Thuế thu nhập cá nhân vào tháng 10" data-medium="Item-1" data-thumb="1" data-itm-source="#vn_source=Home&amp;vn_campaign=ThuongVien&amp;vn_medium=Item-1&amp;vn_term=Desktop&amp;vn_thumb=1" data-itm-added="1">Bộ Tài chính: Dự kiến sửa Luật Thuế thu nhập cá nhân vào tháng 10</a>
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}