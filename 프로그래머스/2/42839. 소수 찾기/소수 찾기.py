from itertools import permutations

def isPrime(number):
    if number < 2: # 0 또는 1
        return False
    
    for i in range(2, round(number**0.5)+1):
        if number % i == 0:
            return False
    
    return True

def solution(numbers):
    # numbers 속 원소를 조합하여 생성할 수 있는 모든 숫자 찾기
    case = set() # 동일한 숫자가 생성될 수 있으므로 set()!
    numbers = list(numbers)
    for i in range(1, len(numbers)+1):
        tupleList = list(permutations(numbers, i)) # ** 순열 라이브러리 **
        for t in tupleList:
            case.add(int(''.join(t)))
    
    # 생성한 숫자가 소수인지 확인하기
    answer = 0
    for c in case:
        if isPrime(c):
            answer += 1
    return answer