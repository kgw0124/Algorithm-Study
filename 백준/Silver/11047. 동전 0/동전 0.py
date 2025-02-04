N,K = map(int, input().split(' '))
arr = [int(input()) for i in range(N)]

coins = 0
for i in range(N-1, -1, -1): # range(N-1, 0, -1)로 하면 첫번째 요소를 접근하지 않는다.
    if K >= arr[i]:
        coins += K//arr[i]
        K %= arr[i]
    
    if K == 0: # 해당 조건문 없으면 오류 발생 
        break

print(coins)
