from itertools import combinations

N, M = map(int, input().split())

arr = [str(i+1) for i in range(N)]
result = []
for p in list(combinations(arr,M)):
    result.append(p)

result.sort()
for r in result:
    print(' '.join(list(r)))