package LC;

public class _11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] wallHeights) {
        int left = 0;
        int right = wallHeights.length - 1;
        int maxArea = -1;

        while (left < right) {
            int length = (right - left);
            int height = Math.min(wallHeights[left], wallHeights[right]);
            int area = (height * length);

            if (maxArea < area) maxArea = area;

            if (wallHeights[left] < wallHeights[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return maxArea;
    }
}
