import java.util.Scanner;

/**
 * @ClassName LuckyDraw
 * @Description TODO
 * @Author 惠延旭
 * @Date 2023/4/21
 * @Version 1.0
 */

public class LuckyDraw {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choiceAgree;
        String admin = null;
        // 换行
        String password = null;
        int cardNum = 0000;
        boolean cardFlag = false, adminFlag = false;
        do {
            System.out.println("*******欢迎进入奖客富翁系统*******"
                    + "\n\t\t\t1.注册"
                    + "\n\t\t\t2.登录"
                    + "\n\t\t\t3.抽奖"
                    + "\n************************************");
            System.out.print("请选择菜单∶\t\t\t");
            int choiceNum = input.nextInt();

            switch (choiceNum) {
                case 1:
                    System.out.println("[奖客富翁系统 > 注册]"
                            + "\n请填写个人注册信息：\t");
                    System.out.print("用户名：\t");
                    admin = input.next();
                    System.out.print("密码：\t");
                    password = input.next();
                    cardNum = (int) ((Math.random() * 9 + 1) * 1000);
                    System.out.println("注册成功,请记好您的会员卡号"
                            + "\n\t\t\t用户名\t\t\t密码\t\t\t会员卡号"
                            + "\n\t\t\t"
                            + admin
                            + "\t\t\t\t"
                            + password
                            + "\t\t\t"
                            + cardNum);
                    cardFlag = true;
                    break;
                case 2:
                    System.out.println("[奖客富翁系统 > 登录]");
                    String admin1, password1;
                    if (!cardFlag) {
                        System.out.println("对不起，请先注册");
                        break;
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("请输入用户名：\t");
                        admin1 = input.next();
                        System.out.println("请输入密码：\t");
                        password1 = input.next();
                        if (admin.equals(admin1) && password.equals(password1)) {
                            System.out.println("欢迎您，\t" + admin);
                            adminFlag = true;
                            break;
                        }
                        System.out.println("输入错误！您还有" + (2 - i) + "次机会！");
                        if (i == 2) {
                            System.out.println("\n对不起，您3次均输入错误！系统退出，谢谢使用！");
                            System.exit(0);
                        }
                    }
                    break;
                case 3:
                    if (!adminFlag) {
                        System.out.println("对不起，请先登录");
                        break;
                    }
                    System.out.println("[奖客富翁系统 > 抽奖]"
                            + "\n 请输入您的卡号：\t");
                    int cardUnlucky = input.nextInt();
                    if (cardUnlucky != cardNum) {
                        System.out.println("这不是您的卡号");
                        break;
                    }
                    int[] lucks = new int[5];
                    for (int i = 0; i < lucks.length; i++) {
                        lucks[i] = (int) ((Math.random() * 9 + 1) * 1000);
                    }
                    System.out.println("本日的幸运数字为"
                            + "\t\t\t" + lucks[0]
                            + "\t\t\t" + lucks[1]
                            + "\t\t\t" + lucks[2]
                            + "\t\t\t" + lucks[3]
                            + "\t\t\t" + lucks[4]);
                    boolean luckFlag = false;
                    for (int i = 0; i < lucks.length; i++) {
                        if (cardUnlucky == lucks[i]) {
                            luckFlag = true;
                            break;
                        }
                    }
                    if (luckFlag) {
                        System.out.println("恭喜！\t您是本日的幸运会员！\t");
                    } else {
                        System.out.println("抱歉！ \t您不是本日的幸运会员！\t");
                    }

                    break;
                default:
                    System.out.println("请输入1、2或者3");
            }

            System.out.println("继续吗？ (y:n):  ");
            choiceAgree = input.next();
        } while ("y".equals(choiceAgree));
        System.out.println("系统退出，谢谢使用！");
        System.exit(0);

    }
}