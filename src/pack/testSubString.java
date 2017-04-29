package pack;

public class testSubString {

	public static void main(String[] args) {
		String docPath = "5555-66996-856dfd-85dfd.ppt";
		String fileSuffix = docPath.substring(docPath.lastIndexOf(".")+1,docPath.length());
		System.out.println(fileSuffix);
	}

}
