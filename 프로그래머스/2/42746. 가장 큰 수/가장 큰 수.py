def solution(numbers):
    # 높은 자릿 수부터 자릿 수 단위로 정렬하고 싶다? → 문자열로 정렬하기!
    numbers = list(map(str, numbers))
    numbers.sort(reverse=True)\
    
    # numbers의 최댓값이 4자리 수 → 각 수를 4번 반복해서 비교하자 : 34 30 3 → 34 3 30
    # "key=" : sort()의 정렬 기준을 의미
    numbers.sort(key=lambda x: str(x) * 4, reverse=True)
    
    answer = ''
    for n in numbers:
        answer += n
    return str(int(answer))