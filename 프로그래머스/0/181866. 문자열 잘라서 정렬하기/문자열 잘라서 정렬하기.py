def solution(myString):
    myList = myString.split("x")
    return sorted(filter(None,myList))