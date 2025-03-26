import heapq

A,B = map(int, input().split())

queue = [(A,1)]
while queue:
    tmp, cnt = heapq.heappop(queue)
    if tmp == B:
        print(cnt)
        break

    if tmp > B:
        print(-1)
        break

    heapq.heappush(queue, (tmp*2, cnt+1))
    heapq.heappush(queue, (int(str(tmp)+'1'), cnt+1))
