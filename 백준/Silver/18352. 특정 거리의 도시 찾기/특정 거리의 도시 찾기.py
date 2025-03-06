import math
import heapq
import sys

# Dijkstra
def di(graph, dist, start, K):
    queue = []
    dist[start] = 0
    heapq.heappush(queue, (dist[start], start))

    while queue:
        tmp, now = heapq.heappop(queue)

        if tmp == K:
            break

        for next_node, next_cost in graph[now]:
            cost = tmp + next_cost
            
            if cost < dist[next_node]:
                dist[next_node] = cost
                heapq.heappush(queue, (cost, next_node))


# MAIN
N, M, K, X = map(int, sys.stdin.readline().split())

# graph, dist 생성
graph = [[] for _ in range(N+1)]
for _ in range(M):
    k, v = map(int, sys.stdin.readline().split())
    graph[k].append((v,1))

dist = [math.inf for _ in range(N+1)]
    
# 다익스트라 수행
di(graph, dist, X, K)

# 답
if K not in dist:
    print(-1)

for idx, val in enumerate(dist):
    if val == K:
        print(idx)