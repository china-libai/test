package pack;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class testFile {

	public static void main(String[] args) throws IOException {
		File file=new File("");//设定为当前文件夹 
		System.out.println(file.getCanonicalPath());//获取标准的路径 D:\workspace\test
		System.out.println(file.getAbsolutePath());//获取绝对路径 D:\workspace\test
		
		String s="555@UUID666";
		System.out.println(s.split("@UUID")[0]);
		System.out.println(s.split("@UUID")[1]);
		
		String old="|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/03500d0ccd-6231-4edb-9cf4-c496bff35284.xlsx@UUID2016%E5%B9%B4%E5%B1%B1%E4%B8%9C%E9%AB%98%E8%80%83%E6%88%90%E7%BB%A9%E4%B8%80%E5%88%86%E4%B8%80%E6%AE%B5%E8%A1%A8.xlsx|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/0305ed1738-a2df-4901-b70f-92e61fee417c.pptx@UUID9%E3%80%81%E6%89%8B%E7%94%B5%E7%AD%92--%E7%94%B5%E6%B1%A0.pptx|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/037d655b87-ed19-4f4d-bfab-81ca7ecdfb2d.docx@UUID%E4%BC%81%E4%B8%9A%E7%BD%91%E7%AB%99%E5%88%B6%E4%BD%9C%E6%B5%81%E7%A8%8B.docx|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/03814a9c3b-fcfa-4af6-bed2-27f30e33d83c.doc@UUID%E6%9C%80%E6%96%B0Excel%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E5%A4%A7%E5%85%A8(%E8%B6%85%E5%85%A8).doc|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/032978b0ca-90d0-44d3-b1e6-04fbfa5494b4.pptx@UUID%E7%94%A8%E5%BF%83%E5%8F%91%E7%8E%B0%E7%B2%BE%E5%BF%83%E9%80%89%E6%9D%90.pptx|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/031b27ddce-bc95-4c07-9291-949fec7ffb1c.ppt@UUID%E7%94%B5%E5%AD%90%E6%8A%80%E6%9C%AF.ppt|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/035e711e2f-7f82-466e-bc6d-bb2612736b7c.ppt@UUID%E7%A5%9E%E5%A5%87%E7%9A%84%E8%B4%A7%E5%B8%81%E3%80%80PPT%E8%AF%BE%E4%BB%B6.ppt|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/03921993d2-4d6b-4efd-a3af-26be6ff9d881.ppt@UUID%E7%A5%9E%E5%A5%87%E7%9A%84%E8%B4%A7%E5%B8%81%E3%80%80%E3%80%8APPT%E8%AF%BE%E4%BB%B6%E3%80%8B%20-%20%E5%89%AF%E6%9C%AC.ppt|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/033a2aff91-e9c9-4c8f-a00f-cb2a66ce77d0.doc@UUID%E7%AC%AC%E5%9B%9B%E8%8A%82%E9%B8%9F%E7%9A%84%E7%94%9F%E6%AE%96%E5%92%8C%E5%8F%91%E8%82%B2.doc|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/033b3a2913-4a51-4582-89aa-220c9a1d7a01.xls@UUID%E8%8B%B1%E8%AF%AD%E5%AD%A6%E4%B9%A0%E7%AA%8D%E9%97%A8.xls";
		String[] paths = old.split("\\|");
		int i = 1;
		for(String path : paths){
			String[] parts = path.split("/");
			
				String windows = path;
				if(!path.endsWith("rar") && !path.endsWith("zip")){
					windows ="/pageoffice/view?readonly=false&attachpath="+URLEncoder.encode(path, "utf-8");
				}
				System.out.println("<a href="+ windows +" >");
				System.out.println(i+"、"+URLDecoder.decode(parts[parts.length-1], "utf-8")); 
				System.out.println("</a><br>");
				i++;
		}
		
		
		
		StringBuffer sb=new StringBuffer();
		sb.append("||/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/03/a1a0f37f-be29-4519-8953-f9ea47ab4ad5.ppt@UUID%E7%A5%9E%E5%A5%87%E7%9A%84%E8%B4%A7%E5%B8%81%E3%80%80PPT%E8%AF%BE%E4%BB%B6.ppt|/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/03/72f506e8-8697-4a65-b946-f4623c029e42.pptx@UUID%E7%94%A8%E5%BF%83%E5%8F%91%E7%8E%B0%E7%B2%BE%E5%BF%83%E9%80%89%E6%9D%90.pptx");
		System.out.println(sb.toString());
		String finalPath=sb.toString().replaceFirst("\\|\\|", "\\|");
		System.out.println(finalPath);
		
		
		
		//最后数据库要存放的路径字符串
//		String basePath="D:\\tomcat\\tomcat8.0.20\\webapps\\JYYMicroLearningResourceSYS";
//				StringBuffer sbuffer=new StringBuffer();
//				String lo="|/JYYMicroLearningResourceSYS/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/03/9%E3%80%81%E6%89%8B%E7%94%B5%E7%AD%92--%E7%94%B5%E6%B1%A0.pptx|/JYYMicroLearningResourceSYS/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/03/%E6%9C%80%E6%96%B0Excel%E4%BD%BF%E7%94%A8%E6%8A%80%E5%B7%A7%E5%A4%A7%E5%85%A8(%E8%B6%85%E5%85%A8).doc";
//				System.out.println("原始路径："+lo);
//				String[] paths = lo.split("\\|");
//				for(String path : paths){
//					
//					//有些路径拼上了项目名称（这里统一替换掉）
//					path=path.replaceAll("/micro-learning-resource", "");
//					path=path.replaceAll("/JYYMicroLearningResourceSYS", "");
//					
//					String savePath ="";
//					String[] parts = path.split("/");
//					try {
//						//文件名
//						String fileName=parts[parts.length-1];
//						//文件路径
//						int i=path.lastIndexOf("/");
//						System.out.println("i:"+i);
//						String filePath=path.substring(0, i);
//						//原始文件格式后缀
//						String[] strs=path.split("\\.");
//						String suffix="." + strs[strs.length-1];
//						//保存文件名
//						String saveFileName = UUID.randomUUID() + suffix;
//						//原始文件绝对路径
//						String originalFile=basePath + File.separator + filePath + File.separator + URLDecoder.decode(fileName,"utf-8") ;
//						//新文件存放路径（原始文件夹下的UUID文件夹里）
//						String saveFile =basePath + File.separator + filePath + File.separator + "UUID" + File.separator + saveFileName;
//						
//						System.out.println("fileName:"+fileName);
//						System.out.println("path:"+path);
//						System.out.println("filePath:"+filePath);
//						System.out.println("suffix:"+suffix);
//						System.out.println("saveFileName:"+saveFileName);
//						System.out.println("originalFile:"+originalFile);
//						System.out.println("saveFile:"+saveFile);
//						FileUtils.copyFile(new File(originalFile), new File(saveFile));
//						//最后要存入数据库的路径
//						savePath= filePath + saveFileName +"@UUID" + fileName;
//						
//					} catch (Exception e) {
//						e.printStackTrace();
//					} 
//					
//					sbuffer.append("|"+savePath);
//				}
//				//最后要存储的路径（有时候最开始是两个||，替换成一个|）
//				String finalPath22=sbuffer.toString().replaceFirst("\\|\\|", "\\|");
//				//最后数据库的路径存放
//				System.out.println(finalPath22);
	}

}
