N = int(input())

answer = 0
for i in range(1, N):
    arr = [int(str(i)[idx]) for idx in range(len(str(i)))]
    if sum(arr) + i == N:
        answer = i
        break

print(answer)