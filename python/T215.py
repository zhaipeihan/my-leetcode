from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return self.find(nums, len(nums) - k, 0, len(nums) - 1)

    def find(self, nums: List[int], k: int, start: int, end: int):
        if start == end:
            return nums[start]
        base = self.partition(nums, start, end)
        if base == k:
            return nums[k]
        elif base < k:
            return self.find(nums, k, base + 1, end)
        elif base > k:
            return self.find(nums, k, start, base - 1)
        else:
            return None

    # 分区函数，返回基准位置p, 基准位置左边的数字都<= pv， 基准位置右边的数字都 >= pv
    def partition(self, nums: List[int], start: int, end: int) -> int:
        p = nums[start]
        while start < end:
            while nums[end] >= p and start < end:
                end = end - 1
            nums[start] = nums[end]
            while nums[start] <= p and start < end:
                start = start + 1
            nums[end] = nums[start]

        nums[start] = p
        return start


if __name__ == '__main__':
    s = Solution()
    nums = [2, 1]
    k = 2
    result = s.findKthLargest(nums, k)
    print(result)
