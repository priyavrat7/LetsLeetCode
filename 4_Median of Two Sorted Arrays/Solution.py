class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        c1 = 0
        c2 = 0
        mid = (len(nums1) + len(nums2)) // 2
        final = []
        while c1 < len(nums1) and c2 < len(nums2):
            # print(final)
            if nums1[c1] < nums2[c2]:
                final.append(nums1[c1])
                c1 += 1
            else:
                final.append(nums2[c2])
                c2 += 1
        # Drain the remaining nums1, if nums1 is leanthy than nums2
        while c1 < len(nums1):
            final.append(nums1[c1])
            c1 += 1
        # Same for nums2
        while c2 < len(nums2):
            final.append(nums2[c2])
            c2 += 1

        print(final)

        if len(final) % 2 != 0:
            return final[mid]
        
        else:
            return (final[mid] + final[mid - 1]) / 2.0
        
        
        
        
        
            