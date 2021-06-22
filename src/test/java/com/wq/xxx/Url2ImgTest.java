package com.wq.xxx;

import org.fit.cssbox.demo.ImageRenderer;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.List;

/*
 * TODO
 * Created by wuqiang on 2021/1/28-16:30
 */

public class Url2ImgTest {
    
    // 打开网页并截图
    @Test
    public void name() throws AWTException, IOException, URISyntaxException {
    
        // 此方法仅适用于JdK1.6及以上版本
        Desktop.getDesktop().browse(
                new URL("http://www.baidu.com").toURI());
        Robot robot = new Robot();
        robot.delay(10000);
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
        // 最大化浏览器
        robot.keyRelease(KeyEvent.VK_F11);
        robot.delay(2000);
        Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
                height));
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        // 保存图片
        ImageIO.write(bi, "jpg", new File("D:\\用户\\wuqiang\\task\\01\\html2Pdf\\202101\\"+System.currentTimeMillis()+".jpg"));
    }
    
    @Test
    public void name23() throws IOException, SAXException {
        ImageRenderer render = new ImageRenderer();
        System.out.println("kaishi");
        String url = "https://www.cnblogs.com/zhangdashao/p/4606704.html";
        FileOutputStream out = new FileOutputStream(new File("D:\\用户\\wuqiang\\task\\01\\html2Pdf\\202101\\"+File.separator+"html.png"));
        render.renderURL(url, out, ImageRenderer.Type.PNG);
        System.out.println("OK");
    }
    
    @Test
    public void test_list() {
        List<Long> list1 = new ArrayList<>();
        list1.add(1L);
        list1.add(2L);
        list1.add(3L);
    
        List<Long> l2 = new ArrayList<>();
        l2.add(2L);
        l2.add(6L);
    
        list1.retainAll(l2);
        System.out.println(list1);
    }
}