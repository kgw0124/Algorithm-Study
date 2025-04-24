import math
import sys

input = sys.stdin.readline

N = int(input())
    
dp = [x for x in range(N+1)]


for i in range(1, N+1):
    for j in range(1, int(math.sqrt(i) + 1)):
        if dp[i] > (dp[i - j * j] + 1):
            dp[i] = dp[i - j * j] + 1
        
print(dp[N])