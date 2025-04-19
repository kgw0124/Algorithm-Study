import heapq

N, D = map(int, input().split())

# graph 생성
graph = [[] for _ in range(D+1)]
for i in range(D):
    graph[i].append((i+1,1))

# 지름길 업데이트
for _ in range(N):
    start, end, dist = map(int, input().split())
    if end > D:
        continue
    graph[start].append((end, dist))

# dijkstra
dist = [int(1e9) for _ in range(D+1)]
def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0,start))
    dist[start] = 0

    while queue:
        tmp1, now = heapq.heappop(queue)

        if tmp1 > dist[now]:
            continue

        for next, tmp2 in graph[now]:
            if tmp1 + tmp2 < dist[next]:
                dist[next] = tmp1 + tmp2
                heapq.heappush(queue, (tmp1+tmp2, next))

dijkstra(0)
print(dist[D])