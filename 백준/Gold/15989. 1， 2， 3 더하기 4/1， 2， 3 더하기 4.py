T = int(input())
inputs = [int(input()) for _ in range(T)]

dp = [1 for _ in range(10001)] # 모두 1로 이루어진 경우 존재

for i in range(2,10001):
    dp[i] += dp[i-2] # 1+1 = 2

for i in range(3,10001):
    dp[i] += dp[i-3] # 1+1+1 = 3

for i in inputs:
    print(dp[i]) 