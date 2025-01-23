def solution(elements):
    mySet = set()

    for i in range(len(elements)):
        temp = elements[i:] + elements[:i]
        
        sum = 0
        for j in temp:
            sum += j
            mySet.add(sum)
    
    return len(mySet)