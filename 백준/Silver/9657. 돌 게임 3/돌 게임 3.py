N = int(input())

dp = [0 for i in range(1001)]

# init (1:SK, -1:CY)
dp[1],dp[3],dp[4] = 1,1,1
dp[2] = -1

# dp
for i in range(5,N+1):
    if dp[i-1] == -1 or dp[i-3] == -1 or dp[i-4] == -1:
        dp[i] = 1
    else:
        dp[i] = -1

# result
if dp[N] == 1:
    print("SK")
else:
    print("CY")