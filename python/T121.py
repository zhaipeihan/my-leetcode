from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max = 0
        if not prices:
            return max
        min = prices[0]
        for i in prices:
            if i < min:
                min = i
            if i - min > max:
                max = i - min
        return max


if __name__ == '__main__':
    ll = [7, 1, 5, 3, 6, 4]
    a = Solution()
    print(a.maxProfit(ll))
