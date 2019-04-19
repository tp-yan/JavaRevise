package ch15;

/* 位运算：加快计算效果，只能对整数进行位运算。因为所有数在内存中都是以二进制存放，故直接对数的二进制位进行操作非常快，
比如乘法、除2操作：通过左右移二进制位即可，无需将数转为十进制后再通过加法完成（乘法本质是由加法实现的）
* */
public class Code1_bitOption {
    /* 创建main函数快捷键： 输入psv即可出现提示 */
    public static void main(String[] args) {
        int a = 7, b = 2;
        System.out.println(a + " & " + b + " = " + (a & b));
        System.out.println(a + " | " + b + " = " + (a | b));
        System.out.println(a + " ^ " + b + " = " + (a ^ b));
        System.out.println("~" + a + " = " + (~a));
        System.out.println(a + " << " + b + " = " + (a << b));
        System.out.println(a + " >> " + b + " = " + (a >> b));      // 带符号右移，最左边高位与符号位保持一致
        System.out.println(a + " >>> " + b + " = " + (a >>> b));    // 无符号右移：最左边高位始终填0
    }
}
