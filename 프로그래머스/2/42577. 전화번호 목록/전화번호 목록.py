def solution(phone_book):      
    dictionary = {}
    for i in range(len(phone_book)):
        dictionary[phone_book[i]] = i
        
    for i in dictionary.keys():
        for j in range(len(i)):
            if i[:j] in dictionary.keys():
                return False
    return True