from typing import List


class Solution:

    def sortArray(self, nums: List[int]) -> List[int]:
        if not nums:
            return nums
        self.quick_sort(nums, 0, len(nums) - 1)
        return nums

    def quick_sort(self, nums: List[int], start: int, end: int) -> None:
        if start >= end:
            return
        mid = self.partition(nums, start, end)
        self.quick_sort(nums, start, mid - 1)
        self.quick_sort(nums, mid + 1, end)

    def partition(self, nums: List[int], start: int, end: int) -> int:
        # 选择基准数
        # 由于p中暂存了nums[start]的值，所以可以认为start 位置处已经挖出了一个坑
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
    s = [2, 1, 3, 5, 4]
    solution = Solution()
    result = solution.sortArray(s)
    print(result)
