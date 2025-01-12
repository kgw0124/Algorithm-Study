def solution(n):
    # 재귀함수 → 시간 초과 → 배열 사용
    arr = []
    for i in range(n+1):
        if i == 0 or i == 1:
            arr.append(i)
        else:
            arr.append(arr[i-2]+arr[i-1])
    return arr[n]%1234567