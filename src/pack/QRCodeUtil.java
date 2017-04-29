package pack;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeUtil {
	
	
    private static final String CHARSET = "utf-8";
    // 二维码图片格式
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static int QRCODE_SIZE = 166;
    // LOGO宽度
    private static int WIDTH = 30;
    // LOGO高度
    private static int HEIGHT = 30;
    
    public static void main(String[] args) throws Exception {
    	//只生成二维码（名片，微信扫描可直接保存到本机联系人）
    	String content = "BEGIN:VCARD\n" +
    		    "VERSION:3.0\n" +
    		    "N:刘彦交\n" +
    		    "TITLE:软件工程师\n" +
    		    "TEL:13145493977\n" +
    		    "EMAIL:975399405@qq.com\n" +
    		    "ADR;WORK:临沂市中印软件园\n" +
    		    "ORG:临沂市拓普网络股份有限公司\n" +
    		    "URL;WORK:http://www.iamtop.com\n" +
    		    "NOTE:微信号就是手机号\n" +
    		    "END:VCARD";
	  	QRCodeUtil.createQrImage(content, "D:/test.jpg", "D:/tou.png", 0, 0, 0, true);
	  	//读取二维码内容
	  	String str = QRCodeUtil.readQrImage("D:/m1.png");
	  	System.out.println(str);
	  }

    /**
     * 生成二维码图片
     * @param content   二维码内容
     * @param qrPath 	要生成的二维码图片路径
     * @param logoPath 	二维码中间的logo图本地路径 (设置null的话不会往二维码嵌入logo图片)
     * @param qr_size 	二维码图片尺寸（设置0的话会默认166）
     * @param logo_width 二维码中间的logo图宽度（设置0的话会默认20）
     * @param logo_hight 二维码中间的logo图高度（设置0的话会默认20）
     * @param needCompress 是否压缩logo图
     * @return 返回二维码图片路径
     * @throws Exception
     */
    public static String  createQrImage(String content,String qrPath, String logoPath,int qr_size,int logo_width,int logo_hight,boolean needCompress) throws Exception {

        File file = new File(qrPath);
        if (qr_size != 0) 	QRCODE_SIZE = qr_size;
        if (logo_width != 0) WIDTH = logo_width;
        if (logo_hight != 0) HEIGHT = logo_hight;
        try {
           BufferedImage image = QRCodeUtil.createImage(content, logoPath,needCompress);
           ImageIO.write(image, FORMAT_NAME, file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        // 将图像输出到Servlet输出流中。  
//        ServletOutputStream sos = response.getOutputStream();  
//        ImageIO.write(imageCode.getImage(request), "jpeg", sos);  
//        sos.close();  
        return file.getAbsolutePath();
    }
    
    /**
     * 创建二维码图片
     * @param content
     * @param imgPath
     * @param needCompress
     * @return
     * @throws Exception
     */
    private static BufferedImage createImage(String content, String imgPath,
            boolean needCompress) throws Exception {
        Hashtable hints = new Hashtable();
        // 设置QR二维码的纠错级别——这里选择最高H级别  容错率越高,二维码的有效像素点就越多.
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
        QRCodeUtil.insertImage(image, imgPath, needCompress);
        return image;
    }

   
    /**
     * 往二维码图片中添加logo图片
     * @param source 二维码图片
     * @param imgPath logo图片的本地路径
     * @param needCompress 是否压缩
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String imgPath,boolean needCompress) throws Exception {
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height,Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        //后边的两个参数是图片的圆弧度，越大logo图片就会越变成圆形
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 10, 10);
        //logo图片的外边框1就算比较窄的了，3就很宽了
        graph.setStroke(new BasicStroke(2f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 识别二维码内容
     * @param filePath 二维码图片路径
     * @return 返回二维码内容
     * @throws Exception
     */
    public static String readQrImage(String filePath) throws Exception {
    	File file = new File(filePath);
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable hints = new Hashtable();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }
   
    
}
