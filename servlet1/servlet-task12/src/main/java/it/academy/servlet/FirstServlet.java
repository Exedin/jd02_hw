package it.academy.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID=1l;

    @Override
    protected synchronized void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String realPath = getServletContext().getRealPath("/count.txt");
        final String s;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath))) {
            s = bufferedReader.readLine();
        }
        int count=Integer.parseInt(s)+1;
        String num=Integer.toString(count);
        resp.setContentType("image/jpeg");
        final BufferedImage image = new BufferedImage(650, 200, BufferedImage.TYPE_INT_BGR);
        final Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 78));
        graphics.setColor(Color.GREEN);
        graphics.drawString("visit number "+num, 100 , 100);
        final ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(realPath, false))) {
            bufferedWriter.write(num);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
