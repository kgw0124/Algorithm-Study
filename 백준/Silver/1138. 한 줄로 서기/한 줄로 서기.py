N, arr = int(input()), list(map(int, input().split()))

line = [0 for _i in range(N)] # 0은 빈자리를 의미

for i in range(N): # 사람명
    cnt = 0
    for j in range(N): # 줄 idx
        if line[j] == 0:
            cnt += 1
        if cnt == arr[i]+1:
            line[j] = str(i+1)
            break

print(' '.join(line))