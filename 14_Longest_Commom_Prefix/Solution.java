class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String common = strs[0];

        for(int i = 0; i < strs.length; ++i){
            while(strs[i].indexOf(common) != 0){
                common = common.substring(0, common.length() - 1);
                if(common == ""){
                    return "";
                }
            }
        }
        return common;
    }
}