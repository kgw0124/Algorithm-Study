n = int(input())

# n이 음수인 경우
isNegative = False
if n < 0 : 
    isNegative = True
    n *= -1

# fibonacci 수행
prev1,prev2 = 0,1  # fibo[0], fibo[1] = 0,1
for i in range(2, n+1):
    prev1, prev2 = prev2% 1000000000, (prev1+prev2)% 1000000000 # fibo[n] = fibo[n-1]+fibo[n-2]

# 정답 출력
if n == 0:
    print(0)
    print(0)
else:
    if isNegative and n%2==0:
        print(-1)
    else:
        print(1)
    print(prev2)

