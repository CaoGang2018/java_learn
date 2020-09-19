package com.cao.snake;

import javax.swing.*;

/**
 * @author Cao
 * @Date 2020/9/19 19:36
 */
public class StartGames {
    public static void main(String[] args) {
        // 1 绘制一个静态窗口
        JFrame jFrame = new JFrame("java-贪吃蛇小游戏");
        // 设置界面大小
        jFrame.setBounds(10, 10, 900, 720);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2 面板 panel
        jFrame.add(new GamePanel());
        jFrame.setVisible(true);
    }
}
