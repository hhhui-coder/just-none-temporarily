/**
 * @ClassName Autumn
 * @Description TODO
 * @Author 惠延旭
 * @Date 2023/4/20
 * @Version 1.0
 */
public class Autumn {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int hundred = i / 100,
                    ten = (i - 100 * hundred) / 10,
                    bit = i - 100 * hundred - 10 * ten;
            if (hundred * hundred * hundred
                    + ten * ten * ten
                    + bit * bit * bit == i) {
                System.out.println(i + "    ");
            }
        }
    }
}
