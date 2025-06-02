import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NextDayCalculatorTest {

    @Test
    @DisplayName("Test case: 1/1/2018 -> 2/1/2018")
    void testNextDay_case1() {
        String expected = "2/1/2018"; // Kết quả mong đợi [cite: 6]
        String result = NextDayCalculator.getNextDay(1, 1, 2018); // Gọi phương thức cần kiểm tra [cite: 6]
        assertEquals(expected, result); // So sánh kết quả thực tế với mong đợi [cite: 6]
    }

    @Test
    @DisplayName("Test case: 31/1/2018 -> 1/2/2018")
    void testNextDay_case2() {
        String expected = "1/2/2018"; // Kết quả mong đợi [cite: 6]
        String result = NextDayCalculator.getNextDay(31, 1, 2018); // Gọi phương thức cần kiểm tra [cite: 6]
        assertEquals(expected, result); // So sánh kết quả thực tế với mong đợi [cite: 6]
    }

    @Test
    @DisplayName("Test case: 30/4/2018 -> 1/5/2018")
    void testNextDay_case3() {
        String expected = "1/5/2018"; // Kết quả mong đợi [cite: 6]
        String result = NextDayCalculator.getNextDay(30, 4, 2018); // Gọi phương thức cần kiểm tra [cite: 6]
        assertEquals(expected, result); // So sánh kết quả thực tế với mong đợi [cite: 6]
    }

    @Test
    @DisplayName("Test case: 28/2/2018 -> 1/3/2018 (Không nhuận)")
    void testNextDay_case4() {
        String expected = "1/3/2018"; // Kết quả mong đợi [cite: 6]
        String result = NextDayCalculator.getNextDay(28, 2, 2018); // Gọi phương thức cần kiểm tra [cite: 6]
        assertEquals(expected, result); // So sánh kết quả thực tế với mong đợi [cite: 6]
    }

    @Test
    @DisplayName("Test case: 29/2/2020 -> 1/3/2020 (Năm nhuận)")
    void testNextDay_case5() {
        String expected = "1/3/2020"; // Kết quả mong đợi [cite: 6]
        String result = NextDayCalculator.getNextDay(29, 2, 2020); // Gọi phương thức cần kiểm tra [cite: 6]
        assertEquals(expected, result); // So sánh kết quả thực tế với mong đợi [cite: 6]
    }

    @Test
    @DisplayName("Test case: 31/12/2018 -> 1/1/2019")
    void testNextDay_case6() {
        String expected = "1/1/2019"; // Kết quả mong đợi [cite: 6]
        String result = NextDayCalculator.getNextDay(31, 12, 2018); // Gọi phương thức cần kiểm tra [cite: 6]
        assertEquals(expected, result); // So sánh kết quả thực tế với mong đợi [cite: 6]
    }

    // Thêm các test case cho trường hợp không hợp lệ
    @Test
    @DisplayName("Test invalid day (day > max days in month)")
    void testNextDay_invalidDay() {
        String expected = "Invalid Date";
        String result = NextDayCalculator.getNextDay(32, 1, 2018); // Ngày 32 là không hợp lệ
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test invalid month (month > 12)")
    void testNextDay_invalidMonth() {
        String expected = "Invalid Date";
        String result = NextDayCalculator.getNextDay(1, 13, 2018); // Tháng 13 là không hợp lệ
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test invalid day for specific month (e.g., 31st April)")
    void testNextDay_invalidDayForMonth() {
        String expected = "Invalid Date";
        String result = NextDayCalculator.getNextDay(31, 4, 2018); // Tháng 4 chỉ có 30 ngày
        assertEquals(expected, result);
    }
}