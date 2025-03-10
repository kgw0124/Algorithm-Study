N, K = map(int, input().split())

# 딕셔너리 생성
mydict = {}
for i in range(N):
    mydict[i+1] = list(map(int, input().split()))

# 정렬
mydict = dict(sorted(mydict.items(), key=lambda x:(x[1][0], x[1][1], x[1][2]), reverse=True))

# 순위 매기기
answer = 1
prev = list(mydict.values())[0]
for k in mydict.keys():
    if mydict[k] != prev:
        answer += 1

    if k == K:
        print(answer)
        break

