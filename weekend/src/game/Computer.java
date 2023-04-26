package game;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author 
 * @Date 2023/4/25
 * @Version 1.0
 */

public class Computer {
    String playerName;
    int playerScore;

    public int showFist() {
        int index = (int)(Math.random()*3);
        String[] fingers = {"剪刀","石头",  "布"};
        System.out.println("电脑出拳：" + fingers[index]);
        return (index + 1);
    }
}
