package com.springbook.rice.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import com.springbook.rice.common.domain.Printer;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import net.sf.json.JSONObject;


/**
 * 
 * @author 
 *
 */
public class printerUtil {
	/**
	 * 获取签名
	 * 
	 * @param dayinji
	 * @return
	 */
	public static String getSign(Printer dayinji) {
		String sign = "appid" + dayinji.getAppid()
		            + "deviceid" + dayinji.getDeviceid()
		            + "devicesecret"+ dayinji.getDevicesecret()
		            + "printdata" + dayinji.getData() 
		            + "timestamp" + dayinji.getTimestamp()
			     	+ dayinji.getAppsecret();
		sign = MD5Utils.encodeToHex(sign);
		return sign;
	}
/**
 * 发送数据转码
 * @param s
 * @return
 */
	public static String percentEncode(String s) {
	    if (s == null) {
	        return "";
	    }
	    try {
	        return URLEncoder.encode(s, "UTF-8")
	                // OAuth encodes some characters differently:
	                .replace("*", "%2A")
	                .replace("%7E", "~");
	        // This could be done faster with more hand-crafted code.
	    } catch (UnsupportedEncodingException wow) {
	        throw new RuntimeException(wow.getMessage(), wow);
	    }
	}
/**
 * 	发送post
 * @param url 请求url
 * @param datas 请求数据
 * @return
 * @throws ClientProtocolException
 * @throws IOException
 */
public static boolean sendPost(String url,String datas) throws ClientProtocolException, IOException {
	boolean flag = false;
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPost post = new HttpPost(url);//构建post请求
	post.setHeader("Content-type","application/x-www-form-urlencoded");//设置请求头
    // 构建消息实体
    StringEntity entity = new StringEntity(datas, Charset.forName("UTF-8"));
    //entity.setContentType("application/x-www-form-urlencoded");//设置请求头
    entity.setContentEncoding("UTF-8");
    post.setEntity(entity);
	CloseableHttpResponse response = httpClient.execute(post);//发送
	if(response.getStatusLine().getStatusCode() == 200) {//请求成功
	if(entity !=null) {
		String str = EntityUtils.toString(response.getEntity());
      	JSONObject json = JSONObject.fromObject(str);//解析返回的数据
      	//String retMsg = json.getString("retMsg");//获取返回的retMsg
      	System.out.println("errMsg："+json.getString("errMsg"));
      	flag = true;
	}
	}else {
		System.out.println("请求失败");
	}
	return flag;
}
}
