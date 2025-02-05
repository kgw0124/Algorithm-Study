N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort(reverse=True)
B.sort()

answer = 0
for ab in zip(A,B):
    answer += ab[0] * ab[1]
print(answer)