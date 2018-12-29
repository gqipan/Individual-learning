package array;


import java.util.HashMap;
import java.util.Map;

/**
 * @author gongqipan@qipeipu.com
 * @since 2018/12/28 15:50
 */
public class TowSum {


	public static void main(String[] args) {
		int[] result = twoSum_1(new int[]{2, 7, 11, 15}, 9);
		System.out.println(result);


	}

	private static int[] twoSum_2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])){
				return new int[]{i, map.get(target - nums[i])};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}

	private static int[] twoSum_1(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[0];
	}
}
