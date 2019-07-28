package cc.peihan.java.all.leetcode;

public class T190 {


    public static void main(String[] args) {
        int a = -3;
        T190 t190 = new T190();
        t190.reverseBits(a);

//        int n = -3;
//        T190 t190 = new T190();
//        System.out.println(t190.reverseBits(n));
    }


    public int reverseBits(int n) {

        //核心思路把n不断>>，然后通过 & 1 来提取最右边的值
        //然后把res <<  通过 | 来赋值

        int res = 0;

        for (int i = 0; i < 32; i++, n >>= 1) {
            res = (res << 1) | (n & 1);
        }

        return res;
    }


    // you need treat n as an unsigned value
    public int reverseBits2(int n) {

        System.out.println("n value" + n);
        String ns = Integer.toBinaryString(n);
        char[] nsArray = ns.toCharArray();

        //32位整数
        char[] newIntBinary = new char[32];
        System.out.println("ns:" + ns);
        for (int i = nsArray.length - 1; i >= 0; i--) {
            newIntBinary[Math.abs(i - (nsArray.length - 1))] = nsArray[i];
        }

        for (int i = nsArray.length; i < 32; i++) {
            newIntBinary[i] = '0';
        }


        int result = 0;
        int j = 0;

        //newIntBinary是reverse后的二进制表示
        if (newIntBinary[0] == '0') {
            //正数 补码等于原码
            for (int i = 31; i >= 1; i--) {
                result += Math.pow(2, j) * Integer.valueOf(String.valueOf(newIntBinary[i]));
            }

        } else {
            //负数需要先将补码转换为原码，再进行计算
            char[] unsined = new char[32];
            unsined[0] = '0';
            for (int i = 1; i < 32; i++) {
                unsined[i] = newIntBinary[i];
            }
            int unsiedInt = Integer.parseInt(new String(unsined), 2);
            int unsiedIntM1 = unsiedInt - 1;
            String yuanma = Integer.toBinaryString(~unsiedInt);


        }


        return 1;


    }

}
