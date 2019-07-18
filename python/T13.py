class Solution:
    def romanToInt(self, s: str) -> int:
        value_set = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
        }
        i = 0
        sum = 0
        while i < len(s):
            if i == len(s) - 1:
                sum = sum + value_set[s[i]]
            else:
                # 高位数字 小于 低于数字，则是减法
                if value_set[s[i]] < value_set[s[i + 1]]:
                    sum = sum - value_set[s[i]]
                else:
                    sum = sum + value_set[s[i]]

            i = i + 1
        return sum


if __name__ == '__main__':
    a = Solution()
    print(a.romanToInt("III"))
