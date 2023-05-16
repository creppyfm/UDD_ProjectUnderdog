package LC;

import java.util.Arrays;
import java.util.Collections;

public class _875_KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int k = minEatingSpeed(piles, 5);
        System.out.println(k);
    }

    /**
     * Runtime n log m, where m represents array.max, and n represents array.length;
     * */
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = returnsH(piles, mid);
            if (comparison <= h) {
                if (mid == 1) return mid;
                if (returnsH(piles, mid - 1) > h) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        throw new Error("Not reached");
    }

    public static int returnsH(int[] piles, int k) {
        int h = 0;
        for (int p : piles) {
            int pileTime = (p + k - 1) / k;
            h += pileTime;
        }
        return h;
    }
}

