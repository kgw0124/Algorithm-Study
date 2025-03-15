import sys
input = sys.stdin.readline

N, M = map(int, input().split())

mydict = {}
for _ in range(N):
    tmp = input().rstrip()

    if len(tmp) >= M:
        if tmp in mydict.keys():
            mydict[tmp] += 1
        else:
            mydict[tmp] = 1

newdict = dict(sorted(mydict.items(), key=lambda x:(-1*x[1], -1*len(x[0]), x[0])))
for k in newdict.keys():
    print(k)