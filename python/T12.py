class Solution:
    POOL = {
        1: {
            0: "",
            1: "I",
            2: "II",
            3: "III",
            4: "IV",
            5: "V",
            6: "VI",
            7: "VII",
            8: "VIII",
            9: "IX",
        },
        10: {
            0: "",
            1: "X",
            2: "XX",
            3: "XXX",
            4: "XL",
            5: "L",
            6: "LX",
            7: "LXX",
            8: "LXXX",
            9: "XC"
        },
        100: {
            0: "",
            1: "C",
            2: "CC",
            3: "CCC",
            4: "CD",
            5: "D",
            6: "DC",
            7: "DCC",
            8: "DCCC",
            9: "CM",
        },
        1000: {
            0: "",
            1: "M",
            2: "MM",
            3: "MMM"
        }
    }

    def intToRoman(self, num: int) -> str:
        s = str(num)
        weight = 1
        result = []
        for i in range(len(s) - 1, -1, -1):
            dig = int(s[i])
            r = Solution.POOL[weight][dig]
            for j in range(len(r) - 1, -1, -1):
                result.append(r[j])
            weight = weight * 10

        return "".join(result[::-1])


if __name__ == '__main__':
    s = Solution()
    result = s.intToRoman(100)
    print(result)
    print(type(result))
