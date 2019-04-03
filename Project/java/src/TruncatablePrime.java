/**
 * Created by Student on 4/3/2019.
 */
public class TruncatablePrime {

    private static boolean isPrime(int x)
    {
        if(x == 1) return false;

        for(int i = 2; i * i <= x; ++ i)
        {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isLeftTruncatablePrime(int x)
    {
        int crtDiv = 10;
        int prevX = x;
        int crtX = 0;
        while(crtX != prevX)
        {
            prevX = crtX;
            crtX = x % crtDiv;
            if(! isPrime(crtX))
                return false;
            crtDiv *= 10;
        }

        //didn't reach the end(there was a 0)
        return x == crtX;
    }

    public static boolean isRightTruncatablePrime(int x)
    {
        int crtX = x;
        while(crtX != 0)
        {
            if(crtX % 10 == 0 || !isPrime(crtX)) {
                return false;
            }
            crtX /= 10;
        }

        return true;
    }

    public boolean isTruncatablePrime(int x)
    {
        return isLeftTruncatablePrime(x) && isLeftTruncatablePrime(x);
    }
}
