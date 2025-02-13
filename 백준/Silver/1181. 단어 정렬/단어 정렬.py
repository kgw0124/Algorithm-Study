N = int(input())

arr = set()
for i in range(N):
    arr.add(input())

arr = list(arr)
arr.sort(key=lambda x:(len(x), x))

for i in arr:
    print(i)