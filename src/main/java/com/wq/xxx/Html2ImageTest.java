package com.wq.xxx;
/*
 * TODO
 * Created by wuqiang on 2021/1/29-17:30
 */

import com.sun.javafx.scene.shape.PathUtils;
import com.wq.xxx.utils.io.PathUtil;
import gui.ava.html.Html2Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

public class Html2ImageTest {
    
    static String htmlTemplateStr =
            "<div style=\"width: 674px;margin:0 auto\">" +
                    "<p style=\"text-align: center;margin: 0;font-size: 18px;font-weight: bold;\">客户服务单</p>" +
                    "<p style=\"text-align: right;margin: 0;font-size: 12px;margin-bottom: 10px;border-bottom: 1px solid;height: 16px;line-height: 10px;\"> 工单号：666666</p>" +
                    "<table style=\"border-collapse: collapse;\" border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">" +
                    "    <tbody>" +
                    "      <tr>" +
                    "        <td colspan=\"7\" style=\"text-align: center;background-color: #9e9e9e;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\"><strong>客户信息</strong></p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">设备名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            序列号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">" +
                    "            保修情况：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            服务类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">" +
                    "            客户名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            联系人：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "          </p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">" +
                    "            设备地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            邮编：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "          </p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">情况描述：</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 13px;\">注意：此签名表示授权海恒智能技术有限公司对以上情况服务</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;text-align: right;\">" +
                    "            <span style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">用户签字：</span>" +
                    "            <img style=\"position: relative;top: 40px;\" width=100 height=63" +
                    "              src=\"http://xgs.test.xiyukeji.net/fileService/file/single-preview/781651fc-d117-469b-89e9-20abc4f5b926/5.jpg\"/>" +
                    "            &nbsp;&nbsp;&nbsp;" +
                    "            <span style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">日期：</span>" +
                    "            <u style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">" +
                    "              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            </u>" +
                    "          </p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\" style=\"text-align: center;background-color: #9e9e9e;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\"><strong>售后服务填写部分</strong></p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">收费服务判断：保外：<input style=\"position: relative;top:2px\"" +
                    "              type=\"checkbox\" /> 上门：<input type=\"checkbox\" style=\"position: relative;top:2px\" /> 非合同用户：<input" +
                    "              type=\"checkbox\" style=\"position: relative;top:2px\" /> 更换备件：<input type=\"checkbox\"" +
                    "              style=\"position: relative;top:2px\" /> 其他：<input type=\"checkbox\" style=\"position: relative;top:2px\" />" +
                    "          </p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\" style=\"text-align: center;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">收费用务价格明细（详见附表）</p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td style=\"width: 115px;text-align: center;\" colspan=\"2\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">人工费</p>" +
                    "        </td>" +
                    "        <td style=\"width: 114px;text-align: center;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">备件费</p>" +
                    "        </td>" +
                    "        <td style=\"width: 114px;text-align: center;\" colspan=\"2\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">交通费</p>" +
                    "        </td>" +
                    "        <td style=\"width: 114px;text-align: center;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">其他：<u>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></p>" +
                    "        </td>" +
                    "        <td style=\"width: 114px;text-align: center;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">总计费用</p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td style=\"width: 115px;\" colspan=\"2\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "        </td>" +
                    "        <td style=\"width: 114px;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "        </td>" +
                    "        <td style=\"width: 114px;\" colspan=\"2\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "        </td>" +
                    "        <td style=\"width: 114px;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "        </td>" +
                    "        <td style=\"width: 114px;\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td style=\"width: 286px;padding: 10px;\" colspan=\"4\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">使用备件清单：</p>" +
                    "          <table style=\"border-collapse: collapse;\" border=\"1\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">" +
                    "            <tbody>" +
                    "              <tr>" +
                    "                <td width=\"82\" style=\"text-align: center;\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">备件名称</p>" +
                    "                </td>" +
                    "                <td width=\"106\" style=\"text-align: center;\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">序列号</p>" +
                    "                </td>" +
                    "                <td width=\"50\" style=\"text-align: center;\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">价格</p>" +
                    "                </td>" +
                    "              </tr>" +
                    "              <tr>" +
                    "                <td width=\"82\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "                <td width=\"106\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "                <td width=\"50\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "              </tr>" +
                    "              <tr>" +
                    "                <td width=\"82\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "                <td width=\"106\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "                <td width=\"50\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "              </tr>" +
                    "              <tr>" +
                    "                <td width=\"82\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "                <td width=\"106\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "                <td width=\"50\">" +
                    "                  <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "                </td>" +
                    "              </tr>" +
                    "            </tbody>" +
                    "          </table>" +
                    "        </td>" +
                    "        <td style=\"width: 285px;\" colspan=\"3\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;padding-left: 20px;\">注意：此签名表示同意以上费用</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;text-align: right;padding-right: 50px;\">（单位用户请盖公章）</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;\"><span" +
                    "              style=\"display: inline-block;margin-left: 20px;\">确认签字：</span><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>&nbsp;&nbsp;&nbsp;日期：<u>&nbsp;" +
                    "              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>" +
                    "          </p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">检查过程及分析：</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">" +
                    "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "          <p style=\"margin: 3px;font-size: 14px;text-align: right;padding-right: 20px;\">" +
                    "            工程师签字：<u>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>&nbsp;&nbsp;&nbsp;日期：<u>&nbsp;" +
                    "              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></p>" +
                    "          </p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">服务时间统计：服务开始：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            </u>时<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            </u>分，结束时间：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </u>时<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            </u>分&nbsp; 共计：<u>&nbsp;&nbsp;" +
                    "              &nbsp;&nbsp;&nbsp;&nbsp;</u>小时<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </u>分钟</p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td colspan=\"7\">" +
                    "          <p style=\"margin: 3px;font-size: 14px;\">您对本次服务：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "            </u>，建议应该改进：<u>&nbsp;&nbsp;" +
                    "              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "          </p>" +
                    "        </td>" +
                    "      </tr>" +
                    "      <tr>" +
                    "        <td style=\"width: 10px;\">" +
                    "          <p style=\"margin: 15px;font-size: 14px;\">注意事项</p>" +
                    "        </td>" +
                    "        <td style=\"width: 543px;\" colspan=\"6\">" +
                    "          <p style=\"margin: 3px;font-size: 12px;\">1.&nbsp;&nbsp; 适用范围：本服务单适用于所有在海恒智能技术有限公司购买设备的用户；</p>" +
                    "          <p style=\"margin: 3px;font-size: 12px;\">2.&nbsp;&nbsp; 合同用户服务事项详见服务协议书；</p>" +
                    "          <p style=\"margin: 3px;font-size: 12px;\">3.&nbsp;&nbsp; 本服务经用户签署后，表示客户授权海恒智能技术有限公司为其提供技术服务。</p>" +
                    "        </td>" +
                    "      </tr>" +
                    "    </tbody>" +
                    "  </table>" +
                    "  <p style=\"margin: 3px;font-size: 14px;text-align: right;margin-top: 20px;\">" +
                    "<span style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">客户签字：</span>" +
                    "       <img style=\"position: relative;top: 40px;\" width=100 height=63" +
                    "      src=\"http://xgs.test.xiyukeji.net/fileService/file/single-preview/781651fc-d117-469b-89e9-20abc4f5b926/5.jpg\" />&nbsp;&nbsp;&nbsp;<span" +
                    "      style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">日期：</span><u" +
                    "      style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">&nbsp;" +
                    "      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></p>" +
                    "</div>";
    
    
    public static Date parse(String format, String strDate) {
        Date date = null;
        try {
            if (null != strDate && format.length() > 0) {
                SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
                date = simpleFormat.parse(strDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public static void main(String[] args) throws IOException {
        int n = 100;
        long l = System.currentTimeMillis();
    
        for (int i = 0; i < n; i++) {
            testSwing();
        }
        System.out.println("cost swing : " + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        
        for (int i = 0; i < n; i++) {
            testHtml2Image();
        }
        System.out.println("cost Image: " + (System.currentTimeMillis() - l));
    }
    
    public static void testHtmlTemplate() throws IOException {
        
        long start0 = System.currentTimeMillis();
        Html2Image imageGenerator = new Html2Image();
        
        //加载html模版
        com.wq.xxx.CustomerServiceOrderModel.Builder builder = com.wq.xxx.CustomerServiceOrderModel.Builder.builder();
        builder.withEquipmentName("一体化打印机打印机出现间歇性故sds董事会");
        builder.withWorkOrderNum("XJ20210114000009");
        builder.withSerialNumber("111111111111111111111111");
        builder.withWarrantySituation("保修期内");
        builder.withServiceType("免费维修");
        builder.withCustomerName("西南交大");
        builder.withContactPhone("108888888888");
        builder.withContactPersonName("张三");
        builder.withDeviceAddress("四川省成都市武侯区南津路东一段888号科学城3单元附6号");
        builder.withSituationDesc("情况描述信息，打印机出现间歇性故障，需要维修");
//        builder.withUserSign("http://xgs.test.xiyukeji.net/fileService/file/single-preview/781651fc-d117-469b-89e9-20abc4f5b926/5.jpg");
        builder.withUserSignDate("20210121");
        builder.withInspectionProcessAndAnalysis(
                "搜嘎所过过翁个无过过过过过过过过过过过过过过过搜嘎所过过翁个无过过过过过过过过过过过过过过过" +
                        "搜嘎所过过翁个无过过过过过过过过过过过过过过过搜嘎所过过翁个无过过过过过过过过过过过过过过过" +
                        "搜嘎所过过翁个无过过过过过过过过过过过过过过过搜嘎所过过翁个无过过过过过过过过过过过过过过过" +
                        "搜嘎所过过翁个无过过过过过过过过过过过过过过过搜嘎所过过翁个无过过过过过过过过过过过过过过过");
        LocalTime startLoc = LocalTime.now();
        builder.withStartTime(startLoc);
        builder.withEndTime(startLoc);
//        builder.withServiceFeedBack("满意");
//        builder.withSuggests("建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的建议所得到的");
//        builder.withSuggests("建议所得到的建得到的建议所得到的sdgfdsagadsgasdgdsagadsgsadgsd\nagsdg的时候闪电估分");
//        builder.withCustomerSign("http://xgs.test.xiyukeji.net/fileService/file/single-preview/b975fa1c-dcab-43e3-a08d-575c82bf99b6/_img202114155240.png_20210204155241.png");
        builder.withCustomerSignDate("20201231");
        com.wq.xxx.CustomerServiceOrderModel serviceOrderModel = builder.build();
        htmlTemplateStr = new CustomerServiceTemplateFunction().apply(serviceOrderModel);
        imageGenerator.getParser().loadHtml(htmlTemplateStr);
        
        //把html写入到图片
        String tempFIle = PathUtil.combine(System.getProperty("java.io.tmpdir"), "higgs.tmp", "1.png");
        if (!new File(tempFIle).getParentFile().exists()) {
            new File(tempFIle).getParentFile().mkdirs();
        }
        
        imageGenerator.getImageRenderer().setWidth(686).saveImage(tempFIle);
        System.out.println(tempFIle);
//        imageGenerator.saveAsImage("/home/tangzj_tx9900/wq/1.png");
        System.out.println("total : " + (System.currentTimeMillis() - start0));
    }
    
    private static void testHtml2Image() {
        Html2Image imageGenerator = new Html2Image();
    
        String htmlStr = "<div style=\"width: 674px;margin:0 auto\">" +
//                "<span style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">客户签字：</span>" +
                "       <img style=\"position: relative;top: 40px;\" width=100 height=63" +
                "      src=\"http://xgs.test.xiyukeji.net/fileService/file/single-preview/781651fc-d117-469b-89e9-20abc4f5b926/5.jpg\" />" +
                "       <img style=\"position: relative;top: 40px;\" width=100 height=63" +
                "      src=\"http://xgs.test.xiyukeji.net/fileService/file/single-preview/7c6185cc-fded-4d04-8a39-0cea02e5b1e4/_img202102917527.png_20210129170527.png\" />" +
                "</div>";
            
                imageGenerator.getParser().loadHtml(htmlStr);
        String tempFIle = PathUtil.combine(System.getProperty("java.io.tmpdir"), "higgs.tmp", UUID.randomUUID() + ".png");
        if (!new File(tempFIle).getParentFile().exists()) {
            new File(tempFIle).getParentFile().mkdirs();
        }
//        System.out.println(tempFIle);
        imageGenerator.getImageRenderer().setWidth(600).setHeight(880).saveImage(tempFIle);
    }
    
    private static void testSwing() throws IOException {
        BufferedImage bufImage = new BufferedImage(600,880 , BufferedImage.TYPE_INT_ARGB);
        BufferedImage sign = ImageIO.read(new URL("http://xgs.test.xiyukeji.net/fileService/file/single-preview/7c6185cc-fded-4d04-8a39-0cea02e5b1e4/_img202102917527.png_20210129170527.png"));
        BufferedImage sign1 = ImageIO.read(new URL("http://xgs.test.xiyukeji.net/fileService/file/single-preview/781651fc-d117-469b-89e9-20abc4f5b926/5.jpg"));
        
        Graphics2D graphics = bufImage.createGraphics();
        graphics.drawImage(sign.getScaledInstance(200, 100, Image.SCALE_DEFAULT), 60, 0, null);
        graphics.drawImage(sign1.getScaledInstance(200, 100, Image.SCALE_DEFAULT), 60, 100, null);
        graphics.dispose();
        String tempFIle = PathUtil.combine(System.getProperty("java.io.tmpdir"), "higgs.tmp", UUID.randomUUID() + ".png");
        if (!new File(tempFIle).getParentFile().exists()) {
            new File(tempFIle).getParentFile().mkdirs();
        }
        ImageIO.write(bufImage, "png", new File(tempFIle));
    }
}
