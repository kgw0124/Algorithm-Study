import heapq
import sys
input=sys.stdin.readline

N = int(input())
arr = []
answer = []
for _ in range(N):
    tmp = int(input())

    if tmp == 0:
        if not arr:
            answer.append(0)
        else:
            answer.append(heapq.heappop(arr))
    else:
        heapq.heappush(arr, tmp)

for a in answer:
    print(a)