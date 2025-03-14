N, X = map(int, input().split())
arr = list(map(int, input().split()))

answer = [sum(arr[0:X])]
start = 0
for end in range(X, N):
    answer.append(answer[-1] + arr[end] - arr[start])
    start += 1

maxVal = max(answer)
if maxVal == 0:
    print("SAD")
else:
    print(maxVal)
    print(answer.count(maxVal))