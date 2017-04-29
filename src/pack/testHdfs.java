package pack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class testHdfs {
	public static void main(String[] args) {
		try {
			FileSystem fs = FileSystem.get(HDFSService.conf);
			
			String path = "/test/5566/big4M.ppt";
			
			String localPath = "/userfiles/86b90f7ce2414a72b32b5767b5bc1e6e/files/resourceaudit/microLearningResourceAudit/2017/03/UUID/82efed2a-b21e-4ff7-a609-6841e4b83730.pptx";
			System.out.println("localPath:"+localPath);
			
			//写入原文件到hadoop
			//本地文件D:\电子技术.ppt
//			FileInputStream is = new FileInputStream(localPath);
//			FSDataOutputStream os = fs.create(new Path(localPath));
//			IOUtils.copyBytes(is, os, HDFSService.conf);
			
//			//获取文件到本地
			FileOutputStream out = new FileOutputStream("D:\\test00.pptx");
			FSDataInputStream fis = fs.open(new Path(localPath));
			IOUtils.copyBytes(fis, out, 4096);
//			
//			is.close();
//			out.close();
//			
//			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
}
