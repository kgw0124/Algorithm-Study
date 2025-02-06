N = input()

answer = 0
isFind = False
for idx, val in enumerate(N):
    if idx == 0:
        continue

    if N[idx] != N[idx-1]:
            if isFind:
                isFind = False
            else:
                answer += 1
                isFind = True

print(answer)