import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
answer = A+B

for a in sorted(answer):
    print(a, end=" ")