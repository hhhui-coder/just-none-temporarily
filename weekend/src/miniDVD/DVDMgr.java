package miniDVD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName DVDMgr
 * @Description TODO
 * @Author 
 * @Date 2023/4/25
 * @Version 1.0
 */
public class DVDMgr {
    Scanner input = new Scanner(System.in);

    public void initial(DVDset[] dvds) {
        dvds[0].name = "罗马假日";
        dvds[0].date = "2010-7-1";
        dvds[0].state = 0;
        dvds[0].count = 1;
        dvds[1].name = "风声鹤唳";
        dvds[1].state = 1;
        dvds[2].name = "浪漫满屋";
        dvds[2].state = 1;
    }

    public void search(DVDset[] dvds) {
        System.out.println("--->查看DVD"
                + "\n序号" + "\t\t状态" + "\t\t\t名称" + "\t\t\t\t\t\t\t借出日期");
        for (int i = 0; i < dvds.length; i++) {
            if (dvds[i].name == null) {
                break;
            }
            String state = null;
            if (dvds[i].state == 0) {
                state = "已借出";
            } else {
                state = "可借";
            }
            System.out.println(
                    "\n" + (i + 1) + "\t\t" + state + "\t\t\t《" + dvds[i].name + "》\t\t\t\t\t\t\t" + dvds[i].date);
        }
        System.out.println("输入o返回");
    }

    public void add(DVDset[] dvds) {
        System.out.println("请输入DVD名称：");
        for (int i = 0; i < dvds.length; i++) {
            if (dvds[i].name == null) {
                dvds[i].name = input.next();
                dvds[i].state = 1;
                System.out.println("新增《" + dvds[i].name + "》成功！");
                break;
            }
        }
        System.out.println("输入o返回");
    }

    public void delete(DVDset[] dvds) {
        System.out.println("请输入DVD名称：");
        String nameDelete = input.next();
        boolean deleteFlag = false;
        for (int i = 0; i < dvds.length; i++) {
            if (nameDelete.equals(dvds[i].name)) {
                if (dvds[i].state == 0) {
                    System.out.println("《" + nameDelete + "》的状态为借出，不能删除！");
                    break;
                } else {
                    for (int j = i; j < dvds.length; j++) {
                        dvds[j].name = dvds[j + 1].name;
                        dvds[j].state = dvds[j + 1].state;
                        dvds[j].date = dvds[j + 1].date;
                        if (dvds[j + 1].name == null) {
                            break;
                        }
                    }
                    System.out.println("删除成功！");
                    deleteFlag = true;
                }
                break;
            }
        }
        if (!deleteFlag) {
            System.out.println("不存在《" + nameDelete + "》这本书");
        }
        System.out.println("输入o返回");
    }

    public void borrow(DVDset[] dvds) {
        System.out.println("请输入DVD名称：");
        String nameBorrow = input.next();
        boolean deleteFlag = false;
        for (int i = 0; i < dvds.length; i++) {
            if (nameBorrow.equals(dvds[i].name)) {
                if (dvds[i].state == 0) {
                    System.out.println("《" + nameBorrow + "》的状态为借出，没了不能继续借出了");
                } else {
                    dvds[i].state = 0;
                    System.out.println("请输入借出日期（年-月-日）：");
                    dvds[i].date = input.next();
                    dvds[i].count += 1;
                    deleteFlag = true;
                }
                System.out.println("借出《" + nameBorrow + "》操作结束！");
                break;
            }
        }
        if (!deleteFlag) {
            System.out.println("不存在《" + nameBorrow + "》这本书");
        }
        System.out.println("输入o返回");
    }

    public void returnBook(DVDset[] dvds) {
        System.out.println("请输入DVD名称：");
        String nameReturn = input.next();
        System.out.println("请输入归还日期（年-月-日）：");
        String dateReturn = input.next();
        boolean deleteFlag = false;
        for (int i = 0; i < dvds.length; i++) {
            if (nameReturn.equals(dvds[i].name)) {
                if (dvds[i].state == 0) {
                    System.out.println("《" + nameReturn + "》归还成功！"
                            + "\n借出日期为：" + dvds[i].date
                            + "\n归还日期为：" + dateReturn);
                    Date d1 = new Date();
                    Date d2 = new Date();
                    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        d1 = sd.parse(dvds[i].date);
                        d2 = sd.parse(dateReturn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    long charge = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
                    double moneyPaid = charge;
                    System.out.println("\n应付租金：" + moneyPaid + "元");
                    // 最后执行变化操作
                    dvds[i].state = 1;
                    deleteFlag = true;
                    break;
                } else {
                    System.out.println("不要给我，这本书没有借出过");
                    break;
                }
            }
        }
        if (!deleteFlag) {
            System.out.println("不存在《" + nameReturn + "》这本书");
        }
        System.out.println("输入o返回");
    }

    public void rank(DVDset[] dvds) {
        int j = 0;
        for (int i = 0; i < dvds.length; i++) {
            if (dvds[i].name == null) {
                j = i;
                break;
            }
        }
        DVDset[] dvdsNew = new DVDset[j];
        for (int i = 0; i < dvdsNew.length; i++) {
            DVDset studentNew = new DVDset();
            dvdsNew[i] = studentNew;
        }
        for (int i = 0; i < dvdsNew.length; i++) {
            dvdsNew[i].count = dvds[i].count;
            dvdsNew[i].name = dvds[i].name;
        }
        System.out.println("\n次数" + " \t\t\t名称");
        for (int i = 0; i < dvdsNew.length - 1; i++) {
            for (int k = 0; k < dvdsNew.length - 1 - i; k++) {
                if (dvdsNew[k].count < dvdsNew[k + 1].count) {
                    DVDset switchNum = dvdsNew[j];
                    dvdsNew[k] = dvdsNew[k + 1];
                    dvdsNew[k + 1] = switchNum;
                }
            }
        }
        for (int i = 0; i < dvdsNew.length; i++) {
            System.out.println("\n" + dvdsNew[i].count + " \t\t\t《" + dvdsNew[i].name + "》");
        }
        System.out.println("输入o返回");
    }
}
