n = int(input())

dp = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    tmp = list(map(int, input().split()))

    for idx, val in enumerate(tmp):
        if i == 0:
            dp[i][idx] = val
            continue

        arr = [dp[i-1][idx]]
        if idx-1 >= 0:
            arr.append(dp[i-1][idx-1])
        dp[i][idx] = val + max(arr)

print(max(dp[-1]))