class Solution:
    # def lengthOfLongestSubstring(self, s: str) -> int:
    #     if not s:
    #         return 0
    #     if len(s) == 1:
    #         return 1
    #     str_size = [[1, 1, {s[0]: 1}]]
    #
    #     for i in range(1, len(s)):
    #         for e in str_size:
    #             if e[0]:
    #                 if s[i] in e[2]:
    #                     e[0] = 0
    #                 else:
    #                     e[1] = e[1] + 1
    #                     e[2][s[i]] = 1
    #         str_size.append([1, 1, {s[i]: 1}])
    #
    #     max = str_size[0][1]
    #     for e in str_size:
    #         if e[1] > max:
    #             max = e[1]
    #
    #     return max

    def lengthOfLongestSubstring(self, s: str) -> int:
        max = 1
        pool = {}
        if not s:
            return 0
        if len(s) == 1:
            return 1
        from_index = 0
        end_index = 0

        pool[s[0]] = 0
        for i in range(1, len(s)):
            if s[i] not in pool \
                    or pool[s[i]] < from_index:
                end_index = end_index + 1
                pool[s[i]] = i
                dis = end_index - from_index + 1
                if dis > max:
                    max = dis
            else:
                dis = end_index - from_index + 1
                from_index = pool[s[i]] + 1
                end_index = i
                pool[s[i]] = i
                if dis > max:
                    max = dis
        return max


if __name__ == '__main__':
    s = Solution()
    print(s.lengthOfLongestSubstring("tmmzuxt"))
