package cc.peihan.java.all.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class T13 {

    /**
     * static变量在类加载的时候就会触发初始化，如果计算时间是从执行方法开始计算，static可以保证提前初始化，减少耗时
     */
    private static final Map<Character, Integer> ROMAN_NUMBER = new HashMap<>(16);

    static {
        ROMAN_NUMBER.put('I', 1);
        ROMAN_NUMBER.put('V', 5);
        ROMAN_NUMBER.put('X', 10);
        ROMAN_NUMBER.put('L', 50);
        ROMAN_NUMBER.put('C', 100);
        ROMAN_NUMBER.put('D', 500);
        ROMAN_NUMBER.put('M', 1000);
    }

    public int romanToInt(String s) {
        List<Integer> list = new ArrayList<>(s.length() - 1);


        // 下面这行可以看一下，写起来代码比较少，看起来简洁一点，主要就是 reduce方法的使用
        return ((s == null || s.length() == 0)) ? 0 : IntStream.range(0, s.length() - 1).reduce(0,
                (sum, one) -> ROMAN_NUMBER.get(s.charAt(one)) < ROMAN_NUMBER.get(s.charAt(one + 1)) ?
                        sum - ROMAN_NUMBER.get(s.charAt(one)) :
                        sum + ROMAN_NUMBER.get(s.charAt(one))) + ROMAN_NUMBER.get(s.charAt(s.length() - 1));
    }


    public static void main(String[] args) {

        T13 t13 = new T13();
        int result = t13.romanToInt("LVIII");
        System.out.println(result);

//        int sumR = IntStream.range(0, 10).reduce(0, (sum, one) -> {
//            System.out.println("sum" + sum);
//            System.out.println("one" + one);
//            return sum + one;
//        });
//        System.out.println(sumR);


    }


}
