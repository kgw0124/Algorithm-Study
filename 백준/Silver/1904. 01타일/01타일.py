N = int(input())

dp = [0 for i in range(N+1)]
for i in range(N+1):
    if i==1 or i==2:
        dp[i] = i
    else:
        dp[i] = (dp[i-1] + dp[i-2])%15746

print(dp[N])