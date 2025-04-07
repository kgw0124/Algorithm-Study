N, K = map(int, input().split())
arr = list(input())

move = []
for t in range(1,K+1):
    move.append(t)
    move.append(t*-1)
move.sort()

cnt = 0
for idx, val in enumerate(arr[:]):
    if val == 'H':
        continue

    for m in move:
        dx = idx + m
        if 0 <= dx < N and arr[dx] == 'H':
            arr[dx] = 'X'
            cnt += 1
            break

print(cnt)