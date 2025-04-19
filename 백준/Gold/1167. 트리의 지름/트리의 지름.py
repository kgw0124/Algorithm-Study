V = int(input())

# graph 생성
graph = [[] for _ in range(V+1)]
for _ in range(V):
    tmp = list(map(int, input().split()))
    
    start = tmp[0]
    for i in range(1, len(tmp)-2, 2):
        graph[start].append((tmp[i], tmp[i+1]))

# 트리의 지름 : max(1~가장 먼 node(A)의 거리, A~가장 먼 node의 거리)
def dfs(start):
    global answer, nodeA
    answer, nodeA = 0,0

    checker = [0 for _ in range(V+1)]
    stack = [(start,0)]
    checker[start] = 1

    while stack:
        start, dist = stack.pop()
        for next, tmp in graph[start]:
            if checker[next] == 0:
                if answer < dist+tmp:
                    answer = dist+tmp
                    nodeA = next

                stack.append((next, dist+tmp))
                checker[next] = 1

dfs(1)
dfs(nodeA)
print(answer)