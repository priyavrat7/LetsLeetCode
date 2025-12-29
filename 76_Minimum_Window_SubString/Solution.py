class Solution(object):
    def tableExists(self, treq, temp):
        for ch in treq:
            if ch not in temp or treq[ch] > temp[ch]:
                return False
        return True

    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        left = 0
        right = 0

        treq = {}

        min_substr = ""
        min_len = float('inf')

        for ch in t:
            if ch in treq:
                treq[ch] += 1
            else:
                treq[ch] = 1

        # print(ts)
        # print(treq)
        temp = {}
        while (right < len(s)):

            if s[right] in temp:
                temp[s[right]] += 1
            else:
                temp[s[right]] = 1
            right += 1
            
            while(self.tableExists(treq, temp)):
                temp_str = s[left:right]
                if min_substr == "" or len(temp_str) < len(min_substr):
                    min_substr = temp_str[:]

                if temp[s[left]] == 1:
                    del temp[s[left]]
                else:
                    temp[s[left]] -= 1

                left += 1

        return min_substr
