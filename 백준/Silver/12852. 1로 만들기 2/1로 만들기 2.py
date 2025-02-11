N = int(input())

dp1 = [0 for i in range(N+1)] # 연산 횟수
dp2 = ['1' for i in range(N+1)] # 연산 과정
for i in range(2, N+1):
    if i==2 or i==3:
        dp1[i] = 1
        dp2[i] = str(i) + ' 1'
        continue

    dp1[i] = dp1[i-1] + 1
    dp2[i] = str(i) + ' ' + dp2[i-1]

    if i%2 == 0 and min(dp1[i], dp1[i//2] + 1) == dp1[i//2] + 1:
        dp1[i] = dp1[i//2] + 1
        dp2[i] = str(i) + ' ' + dp2[i//2]

    if i%3 == 0 and min(dp1[i], dp1[i//3] + 1) == dp1[i//3] + 1:
        dp1[i] = dp1[i//3] + 1
        dp2[i] = str(i) + ' ' + dp2[i//3]

print(dp1[N])
print(dp2[N])
