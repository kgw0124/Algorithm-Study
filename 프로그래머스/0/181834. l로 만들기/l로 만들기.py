def solution(myString):
    myList = ["a","b","c","d","e","f","g","h","i","j","k"]
    for i in myList:
        if i in myString:
            myString = myString.replace(i, "l")
    return myString