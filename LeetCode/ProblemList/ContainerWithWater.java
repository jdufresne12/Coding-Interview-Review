public class ContainerWithWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int amount = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(amount, max);

            if (height[left] > height[right])
                right--;
            else
                left++;
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithWater solution = new ContainerWithWater();
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(solution.maxArea(heights));
    }
}
