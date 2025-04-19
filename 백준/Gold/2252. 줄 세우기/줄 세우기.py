from collections import deque

N, M = map(int, input().split())

# graph, inDegree 생성
graph = [[] for _ in range(N+1)]
inDegree = [0 for _ in range(N+1)]
for i in range(M):
    s1, s2 = map(int, input().split())
    graph[s1].append(s2)
    inDegree[s2] += 1

# 진입차수가 0인 학생 queue에 넣기
queue = deque([])
for i in range(1, N+1):
    if inDegree[i] == 0:
        queue.append(i)

# 진입차수가 0인 학생을 연결한 간선 제거
answer = []
while queue:
    tmp = queue.popleft()
    answer.append(tmp)

    for i in graph[tmp]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            queue.append(i)

for a in answer:
    print(a, end=" ")
