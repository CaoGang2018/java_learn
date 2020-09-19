package com.cao.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author Cao
 * @Date 2020/9/19 19:44
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int length; // 蛇长度
    int[] snaX = new int[600]; // 蛇坐标X
    int[] snaY = new int[500]; // 蛇坐标Y
    String fx;  // R L U D

    boolean isStart = false; // 游戏是否开始

    Timer timer = new Timer(300, this);

    // 定义一个食物
    int foodX;
    int foodY;
    Random random = new Random();

    // 死亡判断
    boolean isFailed = false;

    // 积分系统
    int score;

    // 初始化
    public void init(){
        length = 3;
        fx = "R";

        // 头部坐标
        snaX[0] = 100;snaY[0] = 100;
        // 身体坐标
        snaX[1] = 75;snaY[1] = 100;
        snaX[2] = 50;snaY[2] = 100;

        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);

        score = 0;
    }
    public GamePanel(){
        init();
        // 获取键盘监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    // 画板， 界面 蛇
    // Graphics 画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 清屏
        this.setBackground(Color.BLACK); // 设置背景的颜色

        // 绘制头部广告栏
        Data.header.paintIcon(this, g, 25, 11);

        // 绘制游戏区域
        g.fillRect(25, 75, 850, 600);

        // 画一条静态的小蛇
        switch (fx) {
            case "R" -> Data.right.paintIcon(this, g, snaX[0], snaY[0]);
            case "L" -> Data.left.paintIcon(this, g, snaX[0], snaY[0]);
            case "U" -> Data.up.paintIcon(this, g, snaX[0], snaY[0]);
            case "D" -> Data.down.paintIcon(this, g, snaX[0], snaY[0]);
        }

        for (int i = 1; i < length; i++){
            Data.body.paintIcon(this, g, snaX[i], snaY[i]); // 蛇的身体长度
        }
        // 花积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18)); // 字体
        g.drawString("长度：" + (length-3), 750, 35);
        g.drawString("分数：" + score, 750, 55);

        // 画食物
        Data.food.paintIcon(this, g, foodX, foodY);

        // 游戏提示是否开始
        if(!isStart){
            // 画一个文字
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40)); // 字体
            g.drawString("按下空格开始游戏", 300, 300);
        }

        // 失败提醒
        if(isFailed){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40)); // 字体
            g.drawString("游戏失败，按下空格重新开始游戏", 200, 300);
        }
    }
    // 监听键盘事件
    @Override
    public void keyPressed(KeyEvent e) {
        // 键盘按下 未释放
        // 获取按下的键盘
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_SPACE){
            if(isFailed){
                isFailed = false;
                init(); // 重新初始化游戏
            }else {
                isStart = !isStart;
            }
            repaint();
        }

        // 键盘控制走向
        if(keyCode == KeyEvent.VK_LEFT){
            fx = "L";
        }else if(keyCode == KeyEvent.VK_RIGHT){
            fx = "R";
        }else if(keyCode == KeyEvent.VK_DOWN){
            fx = "D";
        }else if(keyCode == KeyEvent.VK_UP){
            fx = "U";
        }
    }

    // 定时器， 监听时间流动 执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        // 如果游戏处于开始 并且游戏没有是吧
        if(isStart && !isFailed){
            for(int i = length-1; i > 0; i--){
                // 除了脑袋， 身体前移
                snaX[i] = snaX[i-1];
                snaY[i] = snaY[i-1];
            }

            // 通过控制方向让头部移动
            switch (fx) {
                case "R" -> {
                    snaX[0] += 25;
                    if (snaX[0] > 850) {
                        snaX[0] = 25;
                    }
                }
                case "L" -> {
                    snaX[0] -= 25;
                    if (snaX[0] < 25) {
                        snaX[0] = 850;
                    }
                }
                case "U" -> {
                    snaY[0] -= 25;
                    if (snaY[0] < 75) {
                        snaY[0] = 650;
                    }
                }
                case "D" -> {
                    snaY[0] += 25;
                    if (snaY[0] > 650) {
                        snaY[0] = 75;
                    }
                }
            }
            // 吃食物
            if(snaX[0] == foodX && snaY[0] == foodY){
                length++;
                score += 10;
                // 重新生成食物
                foodX = 25 + 25 * random.nextInt(34);
                foodY = 75 + 25 * random.nextInt(24);
            }

            // 结束判断
            for (int i = 1; i < length; i++) {
                if (snaX[0] == snaX[i] && snaY[0] == snaY[i]) {
                    isFailed = true;
                    break;
                }
            }

            // 刷新界面
            repaint();
        }
        timer.start();
    }



    @Override
    public void keyTyped(KeyEvent e) {
        // 键盘按下弹起  敲击
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // 键盘按下 释放
    }
}
