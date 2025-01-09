def solution(s):
    strArr = s.split(' ')
    intArr = [int(i) for i in strArr]
    return str(min(intArr)) + ' ' + str(max(intArr))