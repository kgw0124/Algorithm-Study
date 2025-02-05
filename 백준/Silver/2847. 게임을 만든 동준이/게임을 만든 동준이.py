N = int(input())
arr = [int(input()) for i in range(N)]

answer = 0
for idx in range(N-1, 0, -1):
    if arr[idx-1] >= arr[idx]:
        while arr[idx-1] >= arr[idx]:
            arr[idx-1] -= 1
            answer += 1
print(answer)