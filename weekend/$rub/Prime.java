/**
 * @ClassName Prime
 * @Description TODO
 * @Author 惠延旭
 * @Date 2023/4/20
 * @Version 1.0
 */
public class Prime {
    public static void main(String[] args) {
        boolean flag = true;
        int sum = 0;
        for (int i = 101; i <= 200; i++) {
            for (int j = 2; j < i; j++) {
                flag = true;
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum += 1;
                System.out.println(i + "是质数");
            }
        }
        System.out.println("一共" + sum + "个质数");
    }
}
