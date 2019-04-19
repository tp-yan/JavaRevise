package ch15;

/* 寻找只出现一次的数
 * 问题：给定一个数组，数组中只有一个数仅出现过一次，其余数都出现过2次，请找出只出现1次的数
 * 思路： 使用异或操作，利用其特性：a^a = a, a^0 = 0,且异或操作满足交换律和结合律！！！  */
public class Code3_singleNum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 1, 2, 3, 3, 2};
        System.out.println(singleNum(nums));
    }

    public static int singleNum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 相当于将数组的所有数，与0进行异或操作，然后通过交换律与结合律将2次出现的数异或为0，
            // 最后只剩下0与出现1次的数异或，其结果就是该数本身
            res ^= nums[i];
        }
        return res;
    }
}

