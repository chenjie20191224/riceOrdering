package com.springbook.rice;



import java.io.IOException;
import java.util.Date;

import com.springbook.rice.common.domain.Printer;
import com.springbook.rice.common.utils.printerUtil;
import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.Test;



class printerUtilTest {
	@Test
	void test() throws ClientProtocolException, IOException {
        String url = "http://api.zhongwuyun.com";
		Printer printer = new Printer();
		int time =Math.round(new Date().getTime()/1000);//时间戳
		String data = "<MS>3</MS><S2><C>#3 饿了么星选 </C></S2>................................<S2><C>----在线支付----</C></S2><S1><C>test_89176_63080</C></S1>下单时间:09月06日11时19分<RN>订单编号:15362039995244<RN>**************商品**************<C>---1号口袋---</C><H2><TR><TD>api测试商品_9</TD><TD>×1</TD><TD>9.90</TD></TR><TR><TD>api测试商品_7</TD><TD>×1</TD><TD>9.90</TD></TR><TR><TD>蒸鸡蛋</TD><TD>×1</TD><TD>21.00</TD></TR></H2>********************************<H2>配送费:6.00<RN></H2><H2>餐盒费:0.00<RN></H2>********************************<H2>订单总价:￥46.80<RN></H2><S2>腾讯北京总部大楼 海淀区西二旗大街</S2><RN><S2>李(先生)<RN>177-5510-5793</S2><RN><H2><S2>备注：[未选择餐具数量]；</S2></H2>";//打印内容
		printer.setAppid(8000393);//appid
		printer.setAppsecret("cc853a7740a30ede3d4db1d1b147870f");//appsecret
		printer.setDeviceid("");//设备id
		printer.setDevicesecret("");//设备秘钥
		printer.setTimestamp(time);//时间戳
		printer.setData(data);
		String sign = printerUtil.getSign(printer);
		System.out.println("time："+time);
		System.out.println("url："+printerUtil.percentEncode(data));
		System.out.println("sign："+sign);
		//请求数据
		String datas = "appid="+printer.getAppid()+"&sign="+sign+"&timestamp="+time+"&deviceid="+
		printer.getDeviceid()+"&devicesecret="+printer.getDevicesecret()+"&printdata="+printerUtil.percentEncode(data);
        System.out.println(datas);
		printerUtil.sendPost(url, datas);
	}

}
