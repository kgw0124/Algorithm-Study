def solution(myString):
    myList = myString.replace("x", " ").split()
    return sorted(myList)