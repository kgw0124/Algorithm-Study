import sys
input = sys.stdin.readline

N = int(input())

lines = []
for i in range(N):
    lines.append(tuple(map(int, input().split())))
lines.sort()

answer = 0
start, end = lines[0]
for i in range(1, N):
        newStart, newEnd = lines[i]
        if newStart <= end:
            end = max(end, newEnd)
        else:
            answer += end - start
            start = newStart
            end = newEnd

answer += end - start

print(answer)
