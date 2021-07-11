package java0.homework;

/**
 * FiboUtil
 *
 * @author zengqi
 * @date 2021/7/11 9:01
 */
public class FiboUtil {

    public static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}
