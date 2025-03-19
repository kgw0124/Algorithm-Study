from itertools import combinations_with_replacement

N, M = map(int, input().split())

arr = [str(i+1) for i in range(N)]
result = []
for p in list(combinations_with_replacement(arr,M)):
    result.append(p)

result.sort()
for r in result:
    print(' '.join(list(r)))