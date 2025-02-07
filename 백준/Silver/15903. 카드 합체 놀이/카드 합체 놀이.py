import heapq

n, m = map(int, input().split())
arr = list(map(int, input().split()))

heap = []
for i in arr:
    heapq.heappush(heap, i)

for i in range(m):
    min1 = heapq.heappop(heap)
    min2 = heapq.heappop(heap)

    heapq.heappush(heap, min1 + min2)
    heapq.heappush(heap, min1 + min2)

print(sum(heap))