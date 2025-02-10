import sys
input = sys.stdin.readline

N = int(input())

# 끝나는 수업을 기준으로 정렬
timelines = []
for i in range(N):
    timelines.append(tuple(map(int, input().split())))
timelines.sort(key=lambda x: (x[1], x[0]))

# "앞 index의 끝나는 시간 >= 다음 index의 시작 시간"인 경우 찾기
answer = 1
start, end = timelines[0]
for i in range(1, N):
    if timelines[i][0] >= end:
        answer += 1
        end = timelines[i][1]

print(answer)
