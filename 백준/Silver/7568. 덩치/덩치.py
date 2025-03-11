N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

answer = [0 for _ in range(N)]
for idx1, val1 in enumerate(arr):
    rank = 1
    for idx2, val2 in enumerate(arr):
        if idx1 == idx2:
            continue
        else:
            if val1[0] < val2[0] and val1[1] < val2[1]:
                rank += 1

    answer[idx1] = str(rank)

print(' '.join(answer))

