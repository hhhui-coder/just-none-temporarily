import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName CommonMaxMin
 * @Description TODO
 * @Author 惠延旭
 * @Date 2023/4/20
 * @Version 1.0
 */
public class CommonMaxMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数字");
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        for (int i = nums[0] - 1; i > 0; i--) {
            if (nums[0] % i == 0 && nums[1] % i == 0) {
                System.out.println("这两个数的最大公约数为： " + i);
            }
        }
        for (int i = nums[1] + 1;; i++) {
            if (i % nums[0] == 0 && i % nums[1] == 0) {
                System.out.println("这两个数的最小公倍数为： " + i);
                break;
            }
        }
    }
}
