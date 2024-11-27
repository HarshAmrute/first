#https://leetcode.com/problems/two-sum/description/
"""
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

"""
#Solved this in 20 minutes. Solution:
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #return ([0,1])
        list =[]
        l = len(nums)
        sum=0
        for i in range(0,l):
            x = nums[i]
            sum = x

            for j in range(i+1,l):
                y = nums[j]
                sum = sum + y

                if (sum == target) :
                    list.append((i))
                    list.append((j))
                    return (list)

