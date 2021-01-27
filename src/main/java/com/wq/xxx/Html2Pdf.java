package com.wq.xxx;

import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.OutputStream;

/*
 *Author：wuqiang
 *Time: 2021/1/27-15:34
 *Description: 根据URL，将网页转存为PDF文件
 */
public class Html2Pdf {
    private static final String LINUX_OS_OUT_PUT_PATH = "/home/data/pdf/"; //pdf文件的存放路径（Linux）
    
    private static final String WIN_OS_OUT_PUT_PATH = "D:/用户/wuqiang/task/01/html2Pdf/"; //pdf文件的存放路径（windows）
    
    private static final String WIN_OS_FONTS_PATH = "c:/Windows/Fonts/simsun.ttc";
    
    private static final String LINUX_OS_FONTS_PATH = "";
    
    public static void main(String[] args) {
        String outPath = WIN_OS_OUT_PUT_PATH;
        String fontsPath = WIN_OS_FONTS_PATH;
        if (isLinuxOs()) {
            outPath = LINUX_OS_OUT_PUT_PATH;
            fontsPath = LINUX_OS_FONTS_PATH;
        }
        
        urlToPdf("http://www.lrfun.com/toPdf.html", "20210105098888888.pdf", outPath, fontsPath);
    }
    
    /**
     * sdsfdgdsg
     *
     * @param url            链接地址
     * @param outputFileName 转存的PDF文件名
     */
    public static void urlToPdf(String url, String outputFileName, String outPutFilePath, String fontsPath) {
        try {
            String folder = outputFileName.substring(0, 6);
            String outputFile = outPutFilePath + folder + "/" + outputFileName;
            java.io.File targetFile = new java.io.File(outputFile);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            OutputStream os = new FileOutputStream(outputFile);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            ITextFontResolver fontResolver = renderer.getFontResolver();
            //fontResolver.addFont("/usr/share/fonts/chinese/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED); //Linux
            fontResolver.addFont(fontsPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); //windows
            renderer.layout();
            renderer.createPDF(os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static boolean isLinuxOs() {
        String osName = System.getProperties().getProperty("os.name");
        System.out.println(osName);
        return "Linux".equals(osName);
    }
}
