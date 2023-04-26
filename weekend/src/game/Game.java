package game;

import java.util.Scanner;

/**
 * @ClassName Game
 * @Description TODO
 * @Author 
 * @Date 2023/4/25
 * @Version 1.0
 */

public class Game {
    Computer computer = new Computer();
    Scanner input = new Scanner(System.in);

    Person person = new Person();
    public void initial() {

        Scanner input = new Scanner(System.in);
        System.out.println("-------------欢\t迎\t进\t入\t游\t戏\t世\t界-------------"
                + "\n\n"
                + "\n\t\t\t\t\t*********************"
                + "\n\t\t\t猜拳，开始"
                + "\n\t\t\t\t\t*********************"
                + "\n\n"
                + "\n出拳规则:1.剪刀2.石头3.布"
                + "\n请选择对方角色(1:刘备2:孙权3:曹操) :");


        boolean choosenFlag = true;
        while(choosenFlag) {


            int choiceNameNum = input.nextInt();
            switch(choiceNameNum) {

                case 1:
                    computer.playerName = "刘备";
                    choosenFlag = false;
                    break;
                case 2:
                    computer.playerName = "孙权";
                    choosenFlag = false;
                    break;
                case 3:
                    computer.playerName = "曹操";
                    choosenFlag = false;
                    break;
                default:
                    System.out.println("输入不正确，请重新输入");

            }
        }
        System.out.println("请输入你的姓名：");
        person.playerName = input.next();
        System.out.println("\n"+person.playerName+"\tVS\t"+ computer.playerName +"\t对战");


    }

    public void startGame() {

        int sum = 0;
        initial();
        System.out.println("要开始吗？（y/n）");
        String choiceAgree = input.next();
        if ("y".equals(choiceAgree)) {

            while ("y".equals(choiceAgree)) {

                int choice2 =  person.showFist();
                int choice1 =  computer.showFist();
                int result = 0;

                switch(choice1) {
                    case 1:
                        switch(choice2) {
                            case 1:
                                result = 3;
                                break;
                            case 2:
                                result = 2;
                                break;
                            case 3:
                                result = 1;
                                break;
                        }
                        break;
                    case 2:
                        switch(choice2) {
                            case 1:
                                result = 1;
                                break;
                            case 2:
                                result = 3;
                                break;
                            case 3:
                                result = 2;
                                break;
                        }
                        break;
                    case 3:
                        switch(choice2) {
                            case 1:
                                result = 2;
                                break;
                            case 2:
                                result = 1;
                                break;
                            case 3:
                                result = 3;
                                break;
                        }
                        break;
                }





switch(result) {
    case 1:
        System.out.println("结果：^_^，你输了，真笨！");
        computer.playerScore += 1;
        break;
    case 2:
        System.out.println("结果：恭喜，你赢了！");
        person.playerScore += 1;
        break;
    case 3:
        System.out.println("结果：和局，真衰！嘿嘿，等着瞧吧！");
        break;

}




                System.out.println("是否要开始下一轮：（y/n）");
                choiceAgree = input.next();
                sum += 1;
            }
        } else {
            System.exit(0);
        }
        System.out.println("-----------------------------"
                + computer.playerName + "\tVS\t匿名"
                + "\n对战次数：" + sum);
        System.out.println("姓名\t\t\t得分"
        +"\n"+person.playerName+"\t\t\t"+person.playerScore
        +"\n"+computer.playerName+"\t\t\t" + computer.playerScore);
if(computer.playerScore > person.playerScore) {
    System.out.println("结果：呵呵，笨笨，下次加油啊！");
}else if(computer.playerScore == person.playerScore) {
    System.out.println("结果：打成平手，下次再和你一分高下");
}else {
    System.out.println("结果：恭喜，你赢了！");
}
        System.out.println( "-----------------------------");
    }
}
