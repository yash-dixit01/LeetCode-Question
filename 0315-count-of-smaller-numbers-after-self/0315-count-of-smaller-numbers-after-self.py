class Solution(object):
    def countSmaller(self, nums):
        n = len(nums)
        if n == 0:
            return []

        sorted_vals = sorted(set(nums))
        rank = {value: index + 1 for index, value in enumerate(sorted_vals)}

        bit = [0] * (len(sorted_vals) + 1)

        def add(index):
            while index <= len(sorted_vals):
                bit[index] += 1
                index += index & -index

        def prefix_sum(index):
            total = 0
            while index > 0:
                total += bit[index]
                index -= index & -index
            return total

        result = [0] * n
        for i in range(n - 1, -1, -1):
            r = rank[nums[i]]
            result[i] = prefix_sum(r - 1)
            add(r)

        return result