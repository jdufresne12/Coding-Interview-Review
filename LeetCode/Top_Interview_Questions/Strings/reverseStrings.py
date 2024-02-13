#John Dufresne
# Write a function that reverses a string. The input string is given as an array of characters s.
#You must do this by modifying the input array in-place with O(1) extra memory.
from typing import List

class Solution:
    def reverseString(self, s: List[str]):
        left, right = 0, len(s) - 1
        while left < right:
            # Swap the characters
            s[left], s[right] = s[right], s[left]
            # Move the pointers
            left, right = left + 1, right - 1

sol = Solution()
s = ["h", "e", "l", "l", "o"]
sol.reverseString(s)
print(s)