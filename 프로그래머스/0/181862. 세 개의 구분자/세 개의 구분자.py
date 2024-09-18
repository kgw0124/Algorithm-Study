def solution(myStr):
    myList = myStr.replace("a"," ").replace("b"," ").replace("c", " ").split()
    if myList == []:
        return ["EMPTY"]
    return myList