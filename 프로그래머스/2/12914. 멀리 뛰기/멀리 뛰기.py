def solution(n):    
    # factorial -(integer 범위 초과)→ DP
    dp = [0 for i in range(n+1)]
    # 0이 맞는데 dp 규칙 적용을 위해 1로 선언
    # dp[0] = 0, dp[2] = 2하면 n=1일 때 오류 발생
    dp[0] = 1 
    dp[1] = 1
    
    for i in range(2, n+1):
        dp[i] = dp[i-1] + dp[i-2]
        
    return dp[n]%1234567