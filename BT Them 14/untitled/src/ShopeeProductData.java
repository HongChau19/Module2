import java.util.List;
import java.util.ArrayList;

public class ShopeeProductData {
    private List<String> csvProductLines;

    public ShopeeProductData() {
        this.csvProductLines = new ArrayList<>();
        csvProductLines.add("SHP001,AoPhongNam,120000,Ao phong nam thoi trang");
        csvProductLines.add("SHP002,QuanJeanNu,350000,Quan jean nu cap cao");
        csvProductLines.add("SHP003,GiayTheThao,500000,Giay the thao sieu nhe");
    }

    public List<String> getCsvProductLines() {
        return csvProductLines;
    }
}