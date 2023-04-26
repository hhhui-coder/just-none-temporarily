package game;

import java.util.Scanner;

/**
 * @ClassName Person
 * @Description TODO
 * @Author 
 * @Date 2023/4/25
 * @Version 1.0
 */

public class Person {
    Scanner input = new Scanner(System.in);
    String playerName;
    int playerScore;
    String fistGiven;
    public int showFist() {
        int num = 1;
        System.out.println("请出拳:1.剪刀\t2.石头\t3.布\n(输入相应数字):");
        boolean givenFlag = true;
        while(givenFlag) {


         num = input.nextInt();
        switch(num) {

            case 1:
                fistGiven = "剪刀";
                givenFlag = false;
                break;
            case 2:
                fistGiven = "石头";
                givenFlag = false;
                break;
            case 3:
                fistGiven = "布";
                givenFlag = false;
                break;
            default:
                System.out.println("输入不正确，请重新输入");

        }
        }
        System.out.println("1.你出拳:" + fistGiven);
        return num;
    }
}
