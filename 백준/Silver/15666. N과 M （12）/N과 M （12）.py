from itertools import combinations_with_replacement

N, M = map(int,input().split())
arr = list(map(int, input().split()))

arr.sort()
answer = set()
for p in list(combinations_with_replacement(arr,M)):
    answer.add(p)

for a in sorted(answer):
    for t in a:
        print(t, end=" ")
    print()
