T = int(input())

inputs = []
for i in range(T):
    inputs.append(int(input()))

dp = [1 for i in range(101)] # dp[1],dp[2],dp[3] = 1,1,1
for i in range(4, max(inputs)+1):
    dp[i] = dp[i-2] + dp[i-3]

for i in inputs:
    print(dp[i])