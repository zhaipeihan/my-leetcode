public class T9 {


    public static void main(String[] args) {
        T9 t9 = new T9();
        boolean result = t9.isPalindrome(121);
        System.out.println(result);
    }

    public boolean isPalindrome2(int x) {
        String a = String.valueOf(x);
        String b = new StringBuilder(a).reverse().toString();
        return a.equals(b);
    }


    public boolean isPalindrome(int x) {
        String a = String.valueOf(x);
        char[] bc = a.toCharArray();
        char[] b1c = new char[bc.length];
        int j = 0;
        for (int i = bc.length - 1; i >= 0; i--) {
            b1c[j++] = bc[i];
        }
        String b = new String(b1c);
        return a.equals(b);
    }


}
