package com.wq.xxx;
/*
 * 客户服务单模板
 * Created by wuqiang on 2021/2/2-15:59
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.function.Function;

public class CustomerServiceTemplateFunction implements Function<com.wq.xxx.CustomerServiceOrderModel, String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceTemplateFunction.class);
    
    @Override
    public String apply(com.wq.xxx.CustomerServiceOrderModel orderModel) {
        long serveDuration = 0;
        if (orderModel.getStartTime() != null && orderModel.getEndTime() != null) {
            serveDuration = Duration.between(orderModel.getStartTime(), orderModel.getEndTime()).getSeconds();
        }
    
        String startHour = "　";
        String startMinute = "　";
        if (orderModel.getStartTime() != null) {
            startHour = String.valueOf(orderModel.getStartTime().getHour());
            startMinute = String.valueOf(orderModel.getStartTime().getMinute());
        }
        String endHour = "　";
        String endMinute = "　";
        if (orderModel.getEndTime() != null) {
            endHour = String.valueOf(orderModel.getEndTime().getHour());
            endMinute = String.valueOf(orderModel.getEndTime().getMinute());
        }
    
        String processAnalysis = "";
        String equipmentName = orderModel.getEquipmentName();
        try {
            processAnalysis = getStringByEnter(orderModel.getInspectionProcessAndAnalysis(), 30);
            equipmentName = getStringByEnter(equipmentName, 26);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Deal inspectionProcessAndAnalysis error, {}", e.getMessage());
        }
    
        return
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html lang=\"zh-CN\" xmlns=\"http://www.w3.org/1999/xhtml\">" +
              "<div style=\"width: 674px;margin:0 auto\">" +
                "<p style=\"text-align: center;margin: 0;font-size: 18px;font-weight: bold;\">客户服务单</p>" +
                "<p style=\"text-align: right;margin: 0;font-size: 12px;margin-bottom: 10px;border-bottom: 1px solid;height: 16px;line-height: 10px;\"> 工单号：" +
                    orderModel.getWorkOrderNum() +
                "</p>" +
                "<table style=\"width: 673px;border-collapse: collapse;\" border=1 cellspacing=0 cellpadding=0>" +
                    "<tbody>" +
                        "<tr>" +
                            "<td colspan=7 style=\"text-align: center;background-color: #9e9e9e;\">" +
                                "<p style=\"margin: 3px;font-size: 14px;\"><strong>客户信息</strong></p>" +
                            "</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td colspan=7>" +
                                "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">" +
                                  "<span style=\"vertical-align:top!important\">设备名称：</span>" +
                                  "<span style=\"display: inline-block;width: 220px;\">" + equipmentName + "</span>" +
                                  "<span style=\"display: inline-block;width: 100px;vertical-align:top!important\">型号：</span>" +
                                  "<span style=\"display: inline-block;width: 100px;vertical-align:top!important\">序列号：" + orderModel.getSerialNumber() + "</span></p>" +
                        "</td>" +
                       "</tr>" +
                     "<tr>" +
                        "<td colspan=7>" +
                          "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">" +
                            "保修情况：<span style=\"display: inline-block;width: 220px;\">" +  orderModel.getWarrantySituation() + "</span>" +
                            "服务类型：" + orderModel.getServiceType() +
                          "</p>" +
                        "</td>" +
                     "</tr>" +
                     "<tr>" +
                        "<td colspan=7>" +
                            "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">" +
                             "客户名称：<span style=\"display: inline-block;width: 220px;\">" + orderModel.getCustomerName() + "</span>" +
                             "联系电话：<span style=\"display: inline-block;width: 120px;\">" + orderModel.getContactPhone() + "</span>" +
                             "联系人：" + orderModel.getContactPersonName() +
                            "</p>" +
                        "</td>" +
                     "</tr>" +
                     "<tr>" +
                        "<td colspan=7>" +
                            "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">" +
                              "设备地址：<span style=\"display: inline-block;width: 400px;\">" + orderModel.getDeviceAddress() + "</span>" +
                              "邮编：" +
                            "</p>" +
                        "</td>" +
                      "</tr>" +
                      "<tr>" +
                        "<td colspan=7>" +
                            "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">情况描述：</p>" +
                              "<span style=\"display: inline-block;width: 400px;text-indent: 14px\">" +  orderModel.getSituationDesc() + "</span>" +
//                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                        "</td>" +
                      "</tr>" +
                      "<tr>" +
                        "<td colspan=7>" +
                            "<p style=\"margin: 3px 3px 3px 7px;font-size: 13px;\">注意：此签名表示授权海恒智能技术有限公司对以上情况服务</p>" +
                            "<p style=\"margin: 3px;font-size: 14px;\">" +
                            "<div style=\"position: relative;\">" +
                                "<p style=\"position: absolute;right: 130px;top: -40px;\">" +
                                    "<img width=\"120\" height=\"63\" style=\"position: relative;top: 9px;\"" +
                                        "src=" + orderModel.getUserSign() + "/>" +
                                "</p>" +
                                "<p style=\"margin: 3px;font-size: 14px;text-align: right;margin-top: 20px;\">" +
                                    "<span style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">用户签字：" +
                                        "<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></span>&nbsp;" +
                                    "<span style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">日期：</span>" +
                                        "<u style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">&nbsp;" + orderModel.getUserSignDate() + "&nbsp;</u>" +
                                "</p>" +
                            "</div>" +
                        "</td>" +
                       "</tr>" +
                       "<tr>" +
                        "<td colspan=7 style=\"text-align: center;background-color: #9e9e9e;\">" +
                            "<p style=\"margin: 3px;font-size: 14px;\"><strong>售后服务填写部分</strong></p>" +
                        "</td>" +
                       "</tr>" +
                       "<tr>" +
                        "<td colspan=7>" +
                            "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">收费服务判断：" +
                                "保外：<input style=\"position: relative;top:2px\" type=\"checkbox\" /> " +
                                "上门：<input type=\"checkbox\" style=\"position: relative; top:2px\" /> " +  // checked="checked"
                                "非合同用户：<input type=\"checkbox\" style=\"position: relative;top:2px\" /> " +
                                "更换备件：<input type=\"checkbox\" style=\"position: relative;top:2px\" /> " +
                                "其他：<input type=\"checkbox\" style=\"position: relative;top:2px\" />" +
                            "</p>" +
                        "</td>" +
                       "</tr>" +
                       "<tr>" +
                        "<td colspan=7 style=\"text-align: center;\">" +
                            "<p style=\"margin: 3px;font-size: 14px;\">收费用务价格明细（详见附表）</p>" +
                        "</td>" +
                       "</tr>" +
                       "<tr>" +
                        "<td style=\"width: 130px;text-align: center;\" colspan=\"2\">" +
                            "<p style=\"margin: 3px;font-size: 14px; width:130px\">人工费</p>" +
                        "</td>" +
                        "<td style=\"width: 130px;text-align: center;\">" +
                            "<p style=\"margin: 3px;font-size: 14px;width: 130px\">备件费</p>" +
                        "</td>" +
                        "<td style=\"width: 130px;text-align: center;\" colspan=\"2\">" +
                            "<p style=\"margin: 3px;font-size: 14px;width: 130px\">交通费</p>" +
                        "</td>" +
                        "<td style=\"width: 130px;text-align: center;\">" +
                            "<p style=\"margin: 3px;font-size: 14px;width: 130px\">其他：<u>&nbsp;&nbsp;</u></p>" +
                        "</td>" +
                        "<td style=\"text-align: center;\">" +
                            "<p style=\"margin: 3px;font-size: 14px;\">总计费用</p>" +
                        "</td>" +
                       "</tr>" +
                       "<tr>" +
                        "<td style=\"width: 115px;\" colspan=\"2\">" +
                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                        "</td>" +
                        "<td style=\"width: 114px;\">" +
                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                        "</td>" +
                        "<td style=\"width: 114px;\" colspan=\"2\">" +
                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                        "</td>" +
                        "<td style=\"width: 114px;\">" +
                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                        "</td>" +
                        "<td style=\"width: 114px;\">" +
                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                        "</td>" +
                       "</tr>" +
                       "<tr>" +
                        "<td style=\"width: 286px;padding: 10px;\" colspan=4>" +
                            "<p style=\"margin: 3px;font-size: 14px;\">使用备件清单：</p>" +
                            "<table style=\"border-collapse: collapse;\" border=1 width=100% cellspacing=0 cellpadding=0>" +
                                "<tbody>" +
                                    "<tr>" +
                                        "<td width=82 style=\"text-align: center;\">" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">备件名称</p>" +
                                        "</td>" +
                                        "<td width=106 style=\"text-align: center;\">" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">序列号</p>" +
                                        "</td>" +
                                        "<td width=50 style=\"text-align: center;\">" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">价格</p>" +
                                        "</td>" +
                                    "</tr>" +
                                    "<tr>" +
                                        "<td width=82>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                        "<td width=106>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                        "<td width=50>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                    "</tr>" +
                                    "<tr>" +
                                        "<td width=82>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                        "<td width=106>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                        "<td width=50>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                    "</tr>" +
                                    "<tr>" +
                                        "<td width=82>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                        "<td width=106>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                        "<td width=50>" +
                                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                                        "</td>" +
                                    "</tr>" +
                                "</tbody>" +
                            "</table>" +
                        "</td>" +
                        "<td style=\"width: 285px;\" colspan=3>" +
                            "<p style=\"margin: 3px;font-size: 14px;padding-left: 20px;\">注意：此签名表示同意以上费用</p>" +
                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                            "<p style=\"margin: 3px;font-size: 14px;text-align: right;padding-right: 50px;\">（单位用户请盖公章）</p>" +
                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                            "<p style=\"margin: 3px;font-size: 14px;\">" +
                                "<span style=\"display: inline-block;margin-left: 20px;\">确认签字：</span><u>&nbsp;&nbsp;&nbsp;&nbsp;</u>&nbsp;" +
                                    "日期：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>" +
                            "</p>" +
                        "</td>" +
                      "</tr>" +
                      "<tr>" +
                         "<td colspan=7>" +
                            "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">检查过程及分析：</p>" +
                            "<p style=\"margin: 3px 3px 3px 14px;font-size: 14px;text-indent: 14px\">" + processAnalysis + "</p>" +
                            "<p style=\"margin: 3px;font-size: 14px;\">&nbsp;</p>" +
                            "<p style=\"margin: 3px;font-size: 14px;text-align: right;padding-right: 20px;\">" +
                            "工程师签字：<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>&nbsp;日期：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></p>" +
                        "</td>" +
                      "</tr>" +
                      "<tr>" +
                        "<td colspan=7>" +
                            "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">服务时间统计：服务开始：<u>&nbsp;" + startHour +
                            "&nbsp;</u>时<u>&nbsp;" + startMinute +
                            "&nbsp;</u>分，结束时间：<u>&nbsp;" + endHour + "&nbsp;</u>时<u>&nbsp;" + endMinute + "&nbsp;</u>分" +
                            "&nbsp;共计：<u>&nbsp;" + (serveDuration >= 0 ? (serveDuration / 3600) : "　") + "&nbsp;" +
                      "</u>小时<u>&nbsp;" +
                                                (serveDuration >= 0 ? ((serveDuration % 3600) / 60) : "　") + "&nbsp;" +
                      "</u>分钟</p>" +
                        "</td>" +
                      "</tr>" +
                      "<tr>" +
                        "<td colspan=7>" +
                            "<p style=\"margin: 3px 3px 3px 7px;font-size: 14px;\">您对本次服务：" +
                                "<span style=\"border-bottom: 1px solid;display: inline-block;\">" + orderModel.getServiceFeedBack() + "</span>，建议应该改进：" +
                                "<span style=\"border-bottom: 1px solid;display: inline-block;width: 360px;\">" + orderModel.getSuggests() + "&nbsp;</span>" +
//                                "</span>" +
                            "</p>" +
                        "</td>" +
                      "</tr>" +
                      "<tr>" +
                        "<td style=\"width: 10px;\">" +
                            "<p style=\"margin: 15px;font-size: 14px;\">注意事项</p>" +
                        "</td>" +
                        "<td style=\"width: 543px;\" colspan=6>" +
                            "<p style=\"margin: 3px;font-size: 12px;\">1.&nbsp;适用范围：本服务单适用于所有在海恒智能技术有限公司购买设备的用户；</p>" +
                            "<p style=\"margin: 3px;font-size: 12px;\">2.&nbsp;合同用户服务事项详见服务协议书；</p>" +
                            "<p style=\"margin: 3px;font-size: 12px;\">3.&nbsp;本服务经用户签署后，表示客户授权海恒智能技术有限公司为其提供技术服务。</p>" +
                        "</td>" +
                      "</tr>" +
                    "</tbody>" +
                "</table>" +
                "<div style=\"position: relative;\">" +
                        "<p style=\"position: absolute;right: 130px;top: -40px;\">" +
                        "<img width=\"120\" height=\"63\" style=\"position: relative;top: 9px;\"" +
                        "src=" + orderModel.getCustomerSign() + "/>" +
                        "</p>" +
                        "<p style=\"margin: 3px;font-size: 14px;text-align: right;margin-top: 20px;\">" +
                        "<span style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">客户签字：<u>" +
                                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        "</u></span>&nbsp;" +
                        "<span style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">日期：</span>" +
                        "<u style=\"display: inline-block;height: 50px;padding-top: 25px;vertical-align: top;\">&nbsp;" + orderModel.getCustomerSignDate() +
                        "&nbsp;</u>" +
                        "</p>" +
                "</div>" +
        "</div>";
    }
    
//    private static String adapterOpenJdk(String newValue, String defaultVal) {
//        if (FontUtilities.isOpenJDK) {
//            return newValue;
//        }
//        return defaultVal;
//    }
    
    // 对固定长度字符串添加换行符
    private static String getStringByEnter(String inContext, int count) throws UnsupportedEncodingException {
        for (int i = 1; i <= inContext.length(); i++) {
            if (inContext.substring(0, i).getBytes("GBK").length > count) {
                return inContext.substring(0, i - 1) + "\n" + getStringByEnter(inContext.substring(i - 1), count);
            }
        }
        return inContext;
    }
}