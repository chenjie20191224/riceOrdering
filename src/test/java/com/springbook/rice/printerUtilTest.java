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
		String data = "<MS>2</MS><B1><S2><C>#1美团外卖</C></S2></B1><S1><C>*鲜汤馄饨王（吉首店）*</C></S1>--------------------------------<S2><C>[预订单]</C></S2><S2><C>--在线支付--</C></S2><H2><S1>送达时间：10-17 07:40</S1><RN></H2><H2><S1>备注：[用餐人数1人]; 多放辣 多放辣 多放辣</S1><RN></H2>下单时间:10-17 06:51<RN>订单编号:10187153373368819<RN>********************************<B1><C>-----------1号口袋-----------</C></B1><H2><TR><TD>豆腐花(豆腐花(加酸菜))</TD><TD>×1</TD><TD>3</TD></TR><TR><TD>鲜肉小笼包(小笼包(加辣))</TD><TD>×1</TD><TD>7</TD></TR></H2><B1>--------------其他--------------</B1>餐盒费: ￥1<RN>配送费: ￥4<RN>折扣: ￥1<RN>满10.0元减1.0元<RN>******************************** 原价:15<RN><B1> 总价:<S2>14</S2><RN></B1><B1><S2>故宫 (芒果网咖114号机)</S2><RN></B1><B1><S2>18333333333</S2><RN></B1><B1><S2>谢(女士)(门店新客户)</S2><RN></B1>";//打印内容
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
