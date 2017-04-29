package pack;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class decode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str=URLEncoder.encode("电子技术.ppt","utf-8");
		String str3=URLEncoder.encode("《电子技术.ppt","utf-8");
		System.out.println(str);
		System.out.println(str3);
		//%E6%95%99%E5%AD%A6%E8%AE%BE%E8%AE%A1
//		String str2="%E6%95%99%E5%AD%A6%E8%AE%BE%E8%AE%A1";
//		String decodeStr=URLDecoder.decode(str2,"utf-8");
//		System.out.println(decodeStr);
		String str4="%E5%9B%9B%E5%A4%A7%E2%80%9C%E5%8A%9F%E2%80%9D%E8%87%A3%EF%BC%88%E5%BE%AE%E8%AF%BE%E5%88%B6%E4%BD%9C%EF%BC%89.ppt";
		System.out.println(URLDecoder.decode(str4,"utf-8"));
		//#############################文件名：???ó&ldquo;??&rdquo;???¨??????×÷??.ppt
		
		String filePathAndName="/b8ca1348-f921-46a6-bb3b-3d8090743e18.ppt@UUID四大&ldquo;功&rdquo;臣（微课制作）.ppt";
		
         //这个filePath就是服务器真实保存文件的路径加文件名
         String filePath="";
         String fileName="";
         if(filePathAndName.indexOf("@UUID") > -1){
         	fileName= URLDecoder.decode(filePathAndName.split("@UUID")[1],"UTF-8");
         	filePath= filePathAndName.split("@UUID")[0];
         }else{
         	String[] strs= filePathAndName.split("/");
         	fileName= URLDecoder.decode(strs[strs.length-1],"UTF-8");
         	filePath= filePathAndName;
         }
         System.out.println("fileName:"+fileName);
         System.out.println("filePath:"+filePath);
         String str6="ÿ";
         System.out.println(new String(str6.getBytes("gb2312"),"ISO8859-1"));
         
         Map<String,String> map=new HashMap();
     	map.put("&nbsp;", " ");
     	map.put("&iexcl;", "?");
     	map.put("&cent;", "￠");
     	map.put("&pound;", "￡");
     	map.put("&curren;", "¤");
     	map.put("&yen;", "￥");
     	map.put("&brvbar;", "|");
     	map.put("&sect;", "§");
     	map.put("&uml;", "¨");
     	map.put("&copy;", "?");
     	map.put("&ordf;", "a");
     	map.put("&laquo;", "?");
     	map.put("&not;", "?");
     	map.put("&shy;", "");
     	map.put("&reg;", "?");
     	map.put("&macr;", "ˉ");
     	map.put("&deg;", "°");
     	map.put("&plusmn;", "±");
     	map.put("&sup2;", "2");
     	map.put("&sup3;", "3");
     	map.put("&acute;", "′");
     	map.put("&micro;", "μ");
     	map.put("&para;", "?");
     	map.put("&middot;", "·");
     	map.put("&cedil;", "?");
     	map.put("&sup1;", "1");
     	map.put("&ordm;", "o");
     	map.put("&raquo;", "?");
     	map.put("&frac14;", "?");
     	map.put("&frac12;", "?");
     	map.put("&frac34;", "?");
     	map.put("&iquest;", "?");
     	map.put("&Agrave;", "à");
     	map.put("&Aacute;", "á");
     	map.put("&Acirc;", "?");
     	map.put("&Atilde;", "?");
     	map.put("&Auml;", "?");
     	map.put("&Aring;", "?");
     	map.put("&AElig;", "?");
     	map.put("&Ccedil;", "?");
     	map.put("&Egrave;", "è");
     	map.put("&Eacute;", "é");
     	map.put("&Ecirc;", "ê");
     	map.put("&Euml;", "?");
     	map.put("&Igrave;", "ì");
     	map.put("&Iacute;", "í");
     	map.put("&Icirc;", "?");
     	map.put("&Iuml;", "?");
     	map.put("&ETH;", "D");
     	map.put("&Ntilde;", "?");
     	map.put("&Ograve;", "ò");
     	map.put("&Oacute;", "ó");
     	map.put("&Ocirc;", "?");
     	map.put("&Otilde;", "?");
     	map.put("&Ouml;", "?");
     	map.put("&times;", "×");
     	map.put("&Oslash;", "?");
     	map.put("&Ugrave;", "ù");
     	map.put("&Uacute;", "ú");
     	map.put("&Ucirc;", "?");
     	map.put("&Uuml;", "ü");
     	map.put("&Yacute;", "Y");
     	map.put("&THORN;", "T");
     	map.put("&szlig;", "?");
     	map.put("&agrave;", "à");
     	map.put("&aacute;", "á");
     	map.put("&acirc;", "a");
     	map.put("&atilde;", "?");
     	map.put("&auml;", "?");
     	map.put("&aring;", "?");
     	map.put("&aelig;", "?");
     	map.put("&ccedil;", "?");
     	map.put("&egrave;", "è");
     	map.put("&eacute;", "é");
     	map.put("&ecirc;", "ê");
     	map.put("&euml;", "?");
     	map.put("&igrave;", "ì");
     	map.put("&iacute;", "í");
     	map.put("&icirc;", "?");
     	map.put("&iuml;", "?");
     	map.put("&eth;", "e");
     	map.put("&ntilde;", "?");
     	map.put("&ograve;", "ò");
     	map.put("&oacute;", "ó");
     	map.put("&ocirc;", "?");
     	map.put("&otilde;", "?");
     	map.put("&ouml;", "?");
     	map.put("&divide;", "÷");
     	map.put("&oslash;", "?");
     	map.put("&ugrave;", "ù");
     	map.put("&uacute;", "ú");
     	map.put("&ucirc;", "?");
     	map.put("&uuml;", "ü");
     	map.put("&yacute;", "y");
     	map.put("&thorn;", "t");
     	map.put("&yuml;", "?");
     	Iterator it=map.entrySet().iterator();
     	while(it.hasNext()){
     		Map.Entry<String,String> ent=(Entry<String, String>) it.next();
     		System.out.println("ent.getKey():"+ent.getKey()+"  ent.getValue():"+ent.getValue());
     	}
	}
}
