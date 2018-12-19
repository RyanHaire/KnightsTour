package kt;
import java.util.Random;

class Utilities {

	static int randomNum(int max) {
		Random rn = new Random();
		return rn.nextInt(max);
	}
	
	static int[] addArrays(int[] arr1, int[] arr2) {
		int length = arr1.length;
		int[] result = new int[length];
		
		for(int i = 0; i < length; i++) {
			result[i] = arr1[i] + arr2[i];
		}
		
		return result;
	}
}
