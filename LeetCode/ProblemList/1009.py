# 1009. Complement of Base 10 Integer
# The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
# For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
# Given an integer n, return its complement.

class Solution(object):
    def bitwiseComplement(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0: return 1
        binary = bin(n).replace("0b", "")

        for i in range(len(binary)):
            if binary[i] == "0":
                binary = binary[:i] + "1" + binary[i + 1:]
            else:
                binary = binary[:i] + "0" + binary[i + 1:]
        
        return int(binary, 2)


if __name__ == "__main__":
    s = Solution()
    print(s.bitwiseComplement(5))
    print(s.bitwiseComplement(7))
    print(s.bitwiseComplement(10))