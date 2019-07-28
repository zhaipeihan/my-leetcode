from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if nums1 and not nums2:
            len_nums1 = len(nums1)
            if len_nums1 % 2 == 0:
                return (nums1[len_nums1 // 2 - 1] + nums1[len_nums1 // 2]) / 2
            else:
                return nums1[len_nums1 // 2]

        if not nums1 and nums2:
            len_nums2 = len(nums2)
            if len_nums2 % 2 == 0:
                return (nums2[len_nums2 // 2 - 1] + nums2[len_nums2 // 2]) / 2
            else:
                return nums2[len_nums2 // 2]

        size_length = len(nums1) + len(nums2)
        p = 0
        q = 0
        pr = 0
        qr = 0
        can_con = True
        result = []
        while len(result) < size_length // 2 + 1:
            if p == len(nums1) and q < len(nums2):
                result.append(nums2[q])
                q = q + 1
            elif q == len(nums2) and p < len(nums1):
                result.append(nums1[p])
                p = p + 1

            elif nums1[p] <= nums2[q]:
                result.append(nums1[p])
                p = p + 1
            else:
                result.append(nums2[q])
                q = q + 1

        return result[len(result) - 1] if size_length % 2 == 1 else (result[len(result) - 1] + result[
            len(result) - 2]) / 2


if __name__ == '__main__':
    solution = Solution()
    a = [2, 3, 4]
    b = [1]
    print(solution.findMedianSortedArrays(a, b))
