def solution(nums):
    mySet = set(nums)
    
    if len(nums)/2 <= len(mySet):
        return len(nums)/2
    else:
        return len(mySet)