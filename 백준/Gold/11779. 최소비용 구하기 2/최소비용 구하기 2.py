import sys
import heapq

input = sys.stdin.readline

n, m = int(input()), int(input())

# graph 생성
graph = [[] for _ in range(n+1)]
for _ in range(m):
    start, end, dist = map(int, input().split())
    graph[start].append((end, dist))

# dijkstra
route = [[] for _ in range(n+1)]
dist = [1e9 for _ in range(n+1)]
def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0, start))
    route[start] = [start]
    dist[start] = 0

    while queue:
        tmp1, now = heapq.heappop(queue) # tmp1 : start ~ now

        if tmp1 > dist[now]:
            continue

        for next, tmp2 in graph[now]: # tmp2 : now ~ next
            if tmp1 + tmp2 < dist[next]:
                route[next] = route[now] + [next]
                dist[next] = tmp1 + tmp2
                heapq.heappush(queue, (tmp1 + tmp2, next))


sp, ep = map(int, input().split())
dijkstra(sp)
print(dist[ep]) # 최소 비용
print(len(route[ep])) # 최소 비용 경로 내 도시 개수
for r in route[ep]: # 최소 비용 경로
    print(r, end=" ")
