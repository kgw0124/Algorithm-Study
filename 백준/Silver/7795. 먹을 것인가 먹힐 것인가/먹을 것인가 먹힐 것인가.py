import sys
input = sys.stdin.readline

answer = []

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    A, B = list(map(int, input().split())), list(map(int, input().split()))

    # 정렬
    A.sort()
    B.sort() 

    # 투포인터
    tmp, pointB = 0, 0
    for i in range(N):
        while pointB < M and B[pointB] < A[i]:
            pointB += 1
        tmp += pointB
            
    answer.append(tmp)

for a in answer:
    print(a)