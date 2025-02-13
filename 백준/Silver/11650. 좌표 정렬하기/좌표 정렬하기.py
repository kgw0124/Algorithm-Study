import sys
input=sys.stdin.readline

N = int(input())

graph = [tuple(map(int, input().split())) for _ in range(N)]
graph.sort(key=lambda x:(x[0], x[1]))

for i in graph:
    print(i[0], i[1])
