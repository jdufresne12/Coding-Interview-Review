# 868. Binary Gap
# Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.
# Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.

class Solution(object):
    def binaryGap(self, n):
        """
        :type n: int
        :rtype: int
        """
        binary = bin(n).replace("0b", "")
        gap = 0

        for i in range(len(binary)):
            if binary[i] == "1":
                for j in range(i+1, len(binary)):
                    if binary[j] == "1":
                        gap = max(gap, j - i)
                        break

        return gap

if __name__ == "__main__":
    s = Solution()
    print(s.binaryGap(22))
    print(s.binaryGap(8))
    print(s.binaryGap(5))