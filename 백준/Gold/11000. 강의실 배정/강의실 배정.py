import sys
import heapq
input = sys.stdin.readline

N = int(input())

# 수업의 시작 시간을 기준으로 정렬
timelines = []
for i in range(N):
    timelines.append(tuple(map(int, input().split())))
timelines.sort()

# 강의실 최소 갯수 구하기
heap = []
heapq.heappush(heap, timelines[0][1])

for i in range(1, N):
    start, end = timelines[i]

    if heap[0] <= start:
        heapq.heappop(heap)    
    heapq.heappush(heap, end)

print(len(heap))