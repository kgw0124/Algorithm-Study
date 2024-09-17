def solution(myString):
    myList = myString.split("x")
    
    answer = []
    for i in myList:
            answer.append(len(i))
    return answer