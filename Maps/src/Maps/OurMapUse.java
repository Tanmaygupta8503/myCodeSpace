package Maps;

public class OurMapUse {
	
	public static void main(String[] args) {
		Map<String,Integer> map =new Map<>();
		for(int i=0;i < 30 ;i++)
		{
			map.insert("abc"+i, i+1);
			System.out.println("i = "+i+"lf "+map.loadFactor());
		}
		map.removeKey("abc1");
		map.removeKey("abc7");
		map.removeKey("abc10");
		for(int i = 0 ; i < 30 ;i ++)
		{
			System.out.println("abc"+i+":"+map.getValue("abc"+i));
		}
	}
}
