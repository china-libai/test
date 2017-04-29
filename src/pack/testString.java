package pack;

public class testString {
	public static void main(String[] args) {
		String attachpath="/test/5566/test.ppt";
		String[] strs=attachpath.split("\\.");
		String suffix=strs[strs.length-1];
		System.out.println(suffix);
		System.out.println(strs);
		String i=testEnum.First.toString();
		for(testEnum e:testEnum.values()){
			System.out.println(e.toString());
			System.out.println(e.name());
		}
		testEnum e=testEnum.First;
		switch(e){
		case First: 
		}
	}
}
