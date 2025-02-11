N = int(input())

dp1 = [0 for i in range(N+1)] # 연산 횟수
dp2 = [1 for i in range(N+1)] # 연산 과정
for i in range(2, N+1):
    if i==2 or i==3:
        dp1[i] = 1
        continue

    temp = [dp1[i-1]] 
    temp2 = [i-1]
    if i%2 == 0:
        temp.append(dp1[i//2])
        temp2.append(i//2)
    if i%3 == 0:
        temp.append(dp1[i//3])
        temp2.append(i//3)

    dp1[i] = min(temp)+1
    dp2[i] = temp2[temp.index(min(temp))]

print(dp1[N])

if N == 1:
    print(1)
else:
    i = N
    arr = [str(N)]
    while dp2[i] > 1:
        i = dp2[i]
        arr.append(str(i))
    arr.append('1')
    print(' '.join(arr))