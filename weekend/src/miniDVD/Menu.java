package miniDVD;

import java.util.Scanner;

/**
 * @ClassName Menu
 * @Description TODO
 * @Author 惠延旭
 * @Date 2023/4/25
 * @Version 1.0
 */
public class Menu {
    Scanner input = new Scanner(System.in);
    String choiceReturn;
    DVDMgr dvdMgr = new DVDMgr();
    DVDset[] dvds = new DVDset[50];

    public void start() {
        for (int i = 0; i < dvds.length; i++) {
            DVDset student = new DVDset();
            dvds[i] = student;
        }
        dvdMgr.initial(dvds); // 初始化
        startMenu();
        // 每个功能最后都有一个是否选择返回
        boolean exitChoice = false;
        while (!exitChoice) {
            choiceReturn = input.next();
            if ("n".equals(choiceReturn)) {
                exitChoice = true;
            } else {
                startMenu();
            }
        }
    }

    public void startMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用miniDVD管理器"
                + "\n---------------------------------------"
                + "\n0.借出排行榜"
                + "\n1.新增DVD"
                + "\n2.查看DVD"
                + "\n3.删除DVD"
                + "\n4.借出DVD"
                + "\n5.归还DVD"
                + "\n6.退\t出"
                + "\n---------------------------------------"
                + "\n请选择：");
        int choiceNum = input.nextInt();
        boolean choiceFlag = true;
        while (choiceFlag) {
            switch (choiceNum) {
                case 0:
                    System.out.println("--->排行榜");
                    dvdMgr.rank(dvds);
                    choiceFlag = false;
                    break;
                case 1:
                    System.out.println("--->新增DVD");
                    dvdMgr.add(dvds);
                    choiceFlag = false;
                    break;
                case 2:
                    System.out.println("--->查看DVD");
                    dvdMgr.search(dvds);
                    choiceFlag = false;
                    break;
                case 3:
                    System.out.println("--->删除DVD");
                    dvdMgr.delete(dvds);
                    choiceFlag = false;
                    break;
                case 4:
                    System.out.println("--->借出DVD");
                    dvdMgr.borrow(dvds);
                    choiceFlag = false;
                    break;
                case 5:
                    System.out.println("--->归还DVD");
                    dvdMgr.returnBook(dvds);
                    choiceFlag = false;
                    break;
                case 6:
                    System.out.println("谢谢使用！");
                    System.exit(0);
                    choiceFlag = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    choiceNum = input.nextInt();
                    break;
            }
        }
    }
}
