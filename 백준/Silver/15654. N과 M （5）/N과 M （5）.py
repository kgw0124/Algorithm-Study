from itertools import permutations

N, M = map(int, input().split())
arr = list(map(int,input().split()))

arr.sort()
for p in list(permutations(arr, M)):
        tmp = list(map(str, list(p)))
        print(' '.join(tmp))

