"""
Time Complexity: O(n^2)
Space Complexity: O(1)
"""

def find(nums: list):

    res = []
    nums = sorted(nums)
    upper_prev = None

    for idx, num in enumerate(nums):
        if idx !=0 and num == upper_prev:
            continue
        upper_prev = num
        prev = None
        first = num
        right = len(nums) - 1
        left = idx + 1
        
        while left < right:

            if nums[left] > 0 or nums[right] < 0:
                break
            
            curr_sum = first + nums[left] + nums[right]
            
            if curr_sum > 0:
                right -= 1
            elif curr_sum < 0:
                left += 1
            else:
                if prev != nums[left]:
                    res.append([first, nums[left], nums[right]])
                    prev = nums[left]
                left += 1
                right -= 1
    return res



if __name__ == "__main__":
     nums = [-1,0,1,2,-1,-4]
     res = find(nums)
     
     for i in res:
         print(i)
