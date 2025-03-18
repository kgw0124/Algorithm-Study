from itertools import product

def solution(word):
    mydict = []
    for i in range(1,6):
        for p in list(product(['A','E','I','O','U'], repeat=i)):
            mydict.append(p)
            
    mydict.sort()

    return mydict.index(tuple(word))+1