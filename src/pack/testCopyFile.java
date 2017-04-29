package pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class testCopyFile {

	public static void main(String[] args) throws Exception {
		File f1=new File("D:\\lpg.jpg");
		File f2=new File("D:\\lpg2.jpg");
		copyFile(f1,f2);
	}
	
	public static void copyFile(File f1,File f2) throws Exception{
	  int length=2097152;
	  FileInputStream in=new FileInputStream(f1);
	  FileOutputStream out=new FileOutputStream(f2);
	  byte[] buffer=new byte[length];
	  while(true){
	   int ins=in.read(buffer);
	   if(ins==-1){
	    in.close();
	    out.flush();
	    out.close();
	    break;
	   }else
	    out.write(buffer,0,ins);
	  }
	 }

}
