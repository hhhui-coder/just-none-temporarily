import java.util.Scanner;

/**
 * @ClassName Rabbit
 * @Description TODO
 * @Author 惠延旭
 * @Date 2023/4/20
 * @Version 1.0
 */
public class Rabbit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入过去了多少月");
        int month = input.nextInt();
        System.out.println(month + "个月后兔子的数量为" + sum(month));
    }

    public static int sum(int n) {
        if (n < 3) {
            return 2;
        } else {
            return sum(n - 2) + sum(n - 1);
        }
    }
}
