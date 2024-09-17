def solution(myString):
    myList = myString.split("x")
    
    answer = []
    for i in myList:
        if i == "":
            answer.append(0)
        else:
            answer.append(len(i))
    return answer