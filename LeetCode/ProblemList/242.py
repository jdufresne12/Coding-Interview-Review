# 242: Valid Anagram 
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False

        dictS = {}
        dictT = {}

        for char in s:
            if char in dictS:
                dictS[char] += 1
            else:
                dictS[char] = 1
        for char in t:
            if char in dictT:
                dictT[char] += 1
            else:
                dictT[char] = 1
        if dictS == dictT:
            return True
        
        return False


        
        # for i in range(len(s)):
        #     found = False
        #     for j in range(len(t)):
        #         if(s[i] == t[j]):
        #             found = True
        #             break
        #     if not found:
        #         return False
        # return True

sol = Solution()
print(sol.isAnagram("anagram", "nagaram"))  # Output: True
print(sol.isAnagram("rat", "car"))  # Output: False
