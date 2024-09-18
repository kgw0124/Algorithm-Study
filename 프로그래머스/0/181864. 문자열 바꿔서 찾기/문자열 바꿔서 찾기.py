def solution(myString, pat):
    myList = list(myString)
    for i in range(len(myList)):
        if myList[i] == "A":
            myList[i] = "B"
        else:
            myList[i] = "A"
            
    return int(pat in "".join(myList))