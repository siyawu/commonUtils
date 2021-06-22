package com.wq.xxx;
/*
 * TODO
 * Created by wuqiang on 2021/2/1-10:23
 */

public class HtmlString {
    public static String htmlStr =
//            "<title>报价单</title>" +
//            "<style>body,input{color:#000;font-size:12px;font-family:SimSun;" +
//            "margin:0px;" +
//            "padding:0px;background-color:#FFF;}p,ul,li,dt,dd,h1,h2,h3,h4,h5,h6,a{margin:0px;padding:0px;" +
//            "list-style-type:none;text-decoration:none;font-weight:normal;color:#000;font-size:14px;}img{border:0px;" +
//            "vertical-align:middle;}ul{list-style-type:none;}input,select{vertical-align:middle;margin:0;}" +
//            ".clear{clear:both;text-align:center;}.clearfix:after{content:\".\";display:block;clear:both;font-size:0;" +
//            "zoom:1;height:0;line-height:0;}.fl{float:left;}.fr{float:right;}table{border-collapse:collapse;" +
//            "}td{border:1px solid #000;font-size:12px;}.qm_print{width:674px;margin:0 auto;text-align:right;}.
//            quote_main{width:674px;margin:0 auto;}.qm_Af .fr{padding-top:26px}.qm_Bf{padding-top:30px;line-height:30px;}.qm_Bf h1,.qm_Bf p{text-align:center;}
//            .qm_Bf h1{font-size:18px;}.qm_Cf{width:600px;margin:0 auto;line-height:30px;}.qm_Cf td{border:0;}.qm_Df table{border:1px solid #000;}.qm_Df td{padding:5px 10px;}
//            .qm_Df_tr1 td{text-align:center;padding:10px 3px;}.qm_Ef{width:600px;margin:0 auto;line-height:18px;padding-top:10px;position:relative;}.qm_Ef div{line-height:26px;}
//            .qm_Ef img{position:absolute;right:32px;top:140px;width:132px;}.qm_title{font-size:26px;text-align:center;margin:30px 0;}.qm_Ff{width:600px;margin:0 auto 10px;line-height:20px;}
//            .qm_Ff input{display:block;line-height:20px;border:0;width:100%;padding:0;}
//            .qm_Gf{margin-top:50px;position:relative}.qm_Gf img{position:absolute;right:30px;top:-42px;width:132px;height:132px;}
//            .expressSingle{margin:68px 0 0 62px;font-weight:600;line-height:17px;}.lh35{line-height:35px;}" +
//            "</style>" +
//            "<div>" +
//            "<div><img src=\"http://www.lrfun.com/statics/fun2/images/logo.png\" width=\"120\"/>" +
//            "<div><img src=\"http://xgs.test.xiyukeji.net/fileService/file/single-preview/781651fc-d117-469b-89e9-20abc4f5b926/5.jpg\" " +
//            "<div><img src=\"http://xgs.test.xiyukeji.net/fileService/file/single-preview/781651fc-d117-469b-89e9-20abc4f5b926/5.jpg\" " +
            "<div><img src=\"file:///D:\\用户\\wuqiang\\task\\01\\html2Pdf\\5.jpg\" width=\"120\"/>" +
            "<div><img src=\"file:///D:\\用户\\wuqiang\\task\\01\\html2Pdf\\5.jpg\" width=\"120\"/>" +
            "<div>编号：201905098888888</div></div>" +
            "<div>" +
                "<p style=\"text-align:center;\">XXX科技有限公司</p>" +
                "<p id=\"address\">地址：广东省东莞市</p>" +
                "<p id=\"phone\">电话：0769-88888888</p>" +
                "<p>www.lrfun.com</p>" +
                "<p>E-mail：xxx@lrfun.com</p>" +
            "</div>" +
            "<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"> " +
                "<tr><td>甲方：ZZZ科技有限公司</td>" +
                    "<td>联系人：张三</td>" +
                "</tr>" +
                "<tr><td>乙方：<span>东莞市XXX科技有限公司</span></td>" +
                     "<td>联系人：刘小姐</td>" +
                "</tr>" +
                "<tr><td colspan=\"2\">经甲乙方友好协商，签定以下合同条款，并按合同条款执行。</td>" +
                "</tr>" +
                "<tr><td colspan=\"2\">一、甲方委托乙方的制作项目表：</td>" +
                "</tr>" +
            "</table>" +
            
            "<div>" +
            "<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">" +
                "<tr>" +
                    "<td width=\"38\">编号</td>" +
                    "<td width=\"100\">项目</td>" +
                    "<td>零件名称</td>" +
                    "<td width=38>数量</td>" +
                    "<td width=68>价格(元)</td>" +
                    "<td width=68>时间(天)</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>1</td>" +
                    "<td>打印</td>" +
                    "<td>xiaohezi_asm_asm0506.stp</td>" +
                    "<td>2</td>" +
                    "<td rowspan=\"1\">￥460.25</td>" +
                    "<td>120小时</td>" +
                "</tr>" +
                "<tr>" +
                    "<td>2</td>" +
                    "<td>税额</td>" +
                    "<td>--</td>" +
                    "<td>1</td>" +
                    "<td>￥14.11</td>" +
                    "<td> </td>	" +
                "</tr>" +
                "<tr>" +
                    "<td> 3</td>" +
                    "<td>快递费</td>" +
                    "<td>--</td>" +
                    "<td>1</td>	" +
                    "<td>￥15.00</td>" +
                    "<td> </td>" +
                "</tr>" +
                "<tr>" +
                    "<td> 4</td>" +
                    "<td>运费险</td>" +
                    "<td>--</td>" +
                    "<td>1</td>" +
                    "<td>￥1.00</td>" +
                    "<td> </td>	" +
                "</tr>" +
                "<tr>" +
                    "<td colspan=6>工艺处理：打磨。</td>" +
                "</tr>" +
                "<tr>" +
                    "<td colspan=6><span>总合计(RMB)</span>" +
                                    "<span>￥490.36</span>" +
                    "</td>" +
                "</tr>" +
                "<tr>" +
                "<td colspan=6>" +
                    "<span>已付款，含税，含运费</span>" +
                    "<span>总金额(大写) 人民币：肆佰玖拾元叁角陆分</span>" +
                "</td>" +
                "</tr>" +
            "</table>" +
            "</div>" +
            "<div>二、甲、乙双方本着互利的合作精神，信守合同，如有违约，按《中华人民共和国合同法》承担违约责任。<br/><br/>" +
            "三、本合同自双方签字后即时生效，合同文本一式二份，甲、乙双方各执一份，均具同等法律效力。<br/><br/>" +
            "<b>银行转账账户：</b><br/>" +
            "名　称：<span>东莞市XXX科技有限公司</span><br/>" +
            "账　户：<span>8888888888888888888</span><br/>" +
            "开户行：<span>东莞XXXX银行</span><br/><br/>" +
            "<div>甲方代表（签章）：<br/>签订日期：</div>" +
            "<div>乙方代表（签章）：<span>东莞市XXX科技有限公司</span><br/>" +
            "签订日期：2019-05-06</div></div></div>";
}
