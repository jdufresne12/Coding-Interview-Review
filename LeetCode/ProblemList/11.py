# 11. Container With Most Water
# You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
# Find two lines that together with the x-axis form a container, such that the container contains the most water.
# Return the maximum amount of water a container can store.
# Notice that you may not slant the container.

from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        result = 0
        left = 0
        right = n - 1

        while left < right:
            area = min(height[left], height[right]) * (right - left)
            result = max(result, area)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return result

if __name__ == "__main__":
        sol = Solution()
        heights = [1,8,6,2,5,4,8,3,7]
        print(sol.maxArea(heights))
            
