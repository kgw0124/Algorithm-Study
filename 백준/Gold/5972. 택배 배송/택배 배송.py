import heapq

N, M = map(int, input().split())

# graph 생성
graph = [[] for _ in range(N+1)]
for _ in range(M):
    A, B, C = map(int, input().split())
    graph[A].append((B,C))
    graph[B].append((A,C))

# dijkstra
dist = [1e9 for _ in range(N+1)]
def dijkstra(start):
    queue = []
    heapq.heappush(queue,(0, start))

    while queue:
        dist1, now = heapq.heappop(queue) # dist1 = ~ now 거리 총합

        for next, dist2 in graph[now]: # dist2 = now ~ next 거리
            if dist1 + dist2 < dist[next]:
                dist[next] = dist1 + dist2
                heapq.heappush(queue, (dist1 + dist2, next))

dijkstra(1)
print(dist[N])