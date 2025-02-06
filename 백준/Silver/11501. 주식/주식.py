T = int(input())

answer = []
for i in range(T):
    N = int(input())
    arr = list(map(int, input().split()))

    # 핵심 풀이
    maxVal = 0
    profit = 0
    for idx in range(N-1, -1, -1):
        if arr[idx] > maxVal:
            maxVal = arr[idx]
        else:
            profit += maxVal - arr[idx]
    # 끝

    answer.append(profit)

for a in answer:
    print(a)