package ch15;

/*问题1：给定一个数，判断是否为2的N次幂
 * 解：关键技巧 a = a &(a-1)能消除a的最低有效位，即消除最右边的1，变为0。
 * 若一个数是2的N次幂，那么它的二进制表示有且只有一个1，如4:010；8:100
 * 故只需判断 a & (a-1)是否为0即可
 *
 * 问题2：整数转换。编写一个函数，确定一共需要改变多少个位，才能将整数A转换为整数B
 * 解：找出AB的不同位的个数即为需要改变的位数，通过异或操作能将不同位上变为1，然后再统计1个个数即可。
 * 如何统计一个数的二进制中1的个数？： 使用问题1中的技巧 a = a &(a-1)，循环消除a的最右边的1，直到a为0，循环次数即为1的个数
 * */
public class Code2_checkPowerOf2 {
    public static void main(String[] args) {
        // 控制台输出快捷键， sout + Tab/Enter
        System.out.println(checkPowerOfTwo(10));
        System.out.println(checkPowerOfTwo(16));

        System.out.println(minCountOfBitChange(1, 14));
        System.out.println(minCountOfBitChange(2, 3));
    }

    public static boolean checkPowerOfTwo(int a) {
        return (a & (a - 1)) == 0;
    }

    public static int minCountOfBitChange(int a, int b) {
        int temp = a ^ b;
        return bitNumOfOne(temp);
    }

    private static int bitNumOfOne(int x) {
        int res = 0;
        while (x != 0) {
            x &= (x - 1);
            res++;
        }
        return res;
    }


}
