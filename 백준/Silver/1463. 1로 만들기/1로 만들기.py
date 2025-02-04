N = int(input())
arr = [1 for i in range(N+1)]
arr[1] = 0 # 주의

for i in range(4, N+1): # arr[2]와 arr[3]은 1이므로 4부터 시작
    temp = [arr[i-1]+1]
    if i % 3 == 0:
        temp.append(arr[i//3]+1)
    if i % 2 == 0:
        temp.append(arr[i//2]+1)
    arr[i] = min(temp)

print(arr[N])