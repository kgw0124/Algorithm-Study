N = int(input())
standard = list(input())
answer = 0

for _ in range(N-1):
    tmp = standard[:]
    compare = input()
    cnt = 0 # 기준값에 포함되지 않은 비교값의 문자 개수

    for c in compare:
        if c in tmp:
            tmp.remove(c)
        else:
            cnt += 1
    
    if cnt < 2 and len(tmp) < 2:
        answer += 1

print(answer)
