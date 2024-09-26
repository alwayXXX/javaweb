package top.soft.class03response.pratice;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@WebServlet("/verifyCode")
public class VerifyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height = 45;

        // 创建验证码图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 美化图片 创建画笔对象
        Graphics2D g = image.createGraphics();

        // 设置背景颜色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 定义可能的字符集
        String str = "1234567890qwrtypsdfghjklzxcvbnmQWRTYPSDFGHJKLZXCVBNM";
        Random random = new Random();

        // 设置字体
        String[] fonts = {"Arial", "Times New Roman", "Courier New"};
        Font font = new Font(fonts[random.nextInt(fonts.length)], Font.BOLD, 20 + random.nextInt(10));
        g.setFont(font);

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            code.append(ch);

            // 设置字体颜色
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);

            // 随机旋转角度
            AffineTransform oldTransform = g.getTransform();
            g.rotate(random.nextDouble() * Math.PI / 10, width / 5 * i + 10, height / 2);
            g.drawString(String.valueOf(ch), width / 5 * i + 10, height / 2 + 10);
            g.setTransform(oldTransform);
        }

        // 绘制边框
        g.setColor(new Color(200, 200, 200));
        g.drawRect(0, 0, width - 1, height - 1);

        // 生成干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g.drawLine(x1, y1, x2, y2);
        }

        // 添加随机噪点
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g.drawLine(x, y, x, y);
        }

        // 将验证码图片展现到页面上
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }
}
