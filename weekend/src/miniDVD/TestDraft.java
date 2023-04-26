package miniDVD;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TestDraft
 * @Description TODO
 * @Author 鸡哥
 * @Date 2023/4/26
 * @Version 1.0
 */
public class TestDraft {
    public static void main(String[] args) {
        String dstr1 = "2018-06-01";
        String dstr2 = "2018-06-07";
        Date d1 = new Date();
        Date d2 = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d1 = sd.parse(dstr1);
            d2 = sd.parse(dstr2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long charge = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
        System.out.println(charge);
    }
}
