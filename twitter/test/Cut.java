
public class Cut {

	public int getLargestNumber(int[] list){
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<list.length ; i++){
			if(list[i] > max) max = list[i];
		}
		return max;
	}
	
}
