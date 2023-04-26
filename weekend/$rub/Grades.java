import java.util.Scanner;

/**
 * @ClassName Grades
 * @Description TODO
 * @Author 惠延旭
 * @Date 2023/4/20
 * @Version 1.0
 */
public class Grades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入该学生的成绩");
        double grade = input.nextDouble();
        if (grade >= 90) {
            System.out.println("  优");
        } else if (grade >= 60) {
            System.out.println("  良");
        } else {
            System.out.println("  差");
        }
    }
}
