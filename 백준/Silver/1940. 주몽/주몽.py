N, M = int(input()), int(input())
arr = list(map(int, input().split()))

# 정렬
arr.sort()

# 투포인터
answer, p1, p2 = 0, 0, N-1
while p1 < p2:
    if arr[p1] + arr[p2] == M:
        answer += 1
        p1 += 1
        p2 -= 1
    elif arr[p1] + arr[p2] > M:
        p2 -= 1
    elif arr[p1] + arr[p2] < M:
        p1 += 1
    
print(answer)