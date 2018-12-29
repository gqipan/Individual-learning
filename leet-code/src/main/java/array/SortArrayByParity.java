package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongqipan@qipeipu.com
 * @since 2018/12/28 21:02
 */
public class SortArrayByParity {

	public static void main(String[] args) {

	}

	private static int[] sortArrayByParity(int[] A) {
		List<Integer> even = new ArrayList<>(A.length);
		List<Integer> odd = new ArrayList<>(A.length);
		for (int i : A) {
			if (i%2 == 0){
				even.add(i);
			}else {
				odd.add(i);
			}
		}
		int [] result = new int[A.length];

		for (int i = 0; i < even.size(); i++) {
			result[i] = even.get(i);
		}
		for (int i = 0; i < odd.size(); i++) {
			result[even.size() + i] = odd.get(i);
		}
		return result;
	}


}
