import sys
input=sys.stdin.readline

N = int(input())
arrN = list(map(int, input().split()))

M = int(input())
arrM = list(map(int, input().split()))

arr = set(arrN) & set(arrM)
for i in arrM:
    if i in arr:
        print(1)
    else:
        print(0)