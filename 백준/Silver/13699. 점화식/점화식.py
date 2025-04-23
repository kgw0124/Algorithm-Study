n = int(input())
dp = [1 for _ in range(n+1)]

for idx in range(1, n+1):
    tmp = 0
    for i in range(0, idx):
        tmp += dp[i]*dp[idx-1-i]
    dp[idx] = tmp

print(dp[n])