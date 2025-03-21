from itertools import permutations

N, M = map(int,input().split())
arr = list(map(int, input().split()))

answer = set()
for p in list(permutations(arr,M)):
    answer.add(p)

for a in sorted(answer):
    for t in a:
        print(t, end=" ")
    print()