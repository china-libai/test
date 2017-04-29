package pack;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class testConvertFileToSwf {

	/**
	 * 通过main方法测试
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String path="/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/04/UUID/5d854fb6-7697-47ac-8ffd-8b72beabae5b.doc";
		String fileName="八年级语文下册第二单元第7课《雷电颂》导学案.doc";
		convertFileToSwf(path,URLEncoder.encode(fileName,"utf-8"));
	}
	
	/** 
     *  发送 get请求 “文档中心”系统转换成swf 
	 * @param fileName 
     */  
    public static Map<String,String> convertFileToSwf(String path, String fileName) {  
    	Map<String,String> map=new HashMap<String,String>();
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        try {
        	String DocCenterConverUrl="http://doc.linyi.cc/TopDocumentMIS/docConvert/convert?docPath";
        	String requestSysName = "jiaoyuyun";
        	String getUrl=DocCenterConverUrl + "=" + path + "&fileName="+fileName+"&requestSysName="+requestSysName;
            // 创建httpget.
            HttpGet httpget = new HttpGet(getUrl);  
            System.out.println("请求路径：" + httpget.getURI());
            // 执行get请求.    
            CloseableHttpResponse response = httpclient.execute(httpget);  
            String resultJsonString ="";
            try {
                // 获取响应实体    
                HttpEntity entity = response.getEntity();  
                // 打印响应状态    
                //System.out.println(response.getStatusLine());  
                if (entity != null) {  
                    resultJsonString = EntityUtils.toString(entity);
                    
                    // 打印响应内容
                    System.out.println("请求响应：" + resultJsonString);
                }
                JSONObject job = JSONObject.parseObject(resultJsonString);
                String resultStatus=job.get("status").toString();
                String resultMessage=job.get("message").toString();
                map.put("status", resultStatus);
                map.put("message", resultMessage);
                return map;
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
		return map;
    }

}
