N = int(input())
arr = [int(input()) for i in range(N)]

arr.sort()

temp = []
for idx, val in enumerate(arr):
    temp.append(val * (N-idx))
print(max(temp))