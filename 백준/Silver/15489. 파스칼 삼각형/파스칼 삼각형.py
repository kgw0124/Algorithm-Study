R, C, W = map(int, input().split())
dp = [[1 for _ in range(30)] for _ in range(30)]

# dp 채우기
for y in range(3, 30):
    for x in range(2, y):
        dp[y][x] = dp[y-1][x-1] + dp[y-1][x]

# 정답 구하기
answer, dx = 0, 1
for y in range(R, R+W):
    for x in range(C, C+dx):
        answer += dp[y][x]
    dx += 1
print(answer)