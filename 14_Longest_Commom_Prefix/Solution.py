class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        common = strs[0]

        for i in range(1, len(strs)):
            while strs[i].find(common) != 0:
                common = common[0 : len(common) - 1]
                if common == "":
                    return ""
        return common