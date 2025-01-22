def solution(n,a,b):
    cnt = 0
    while True:
        cnt += 1
        # [예외] (2,3) → 짝수값이 홀수값보다 커야 한다.
        if (a-b==1 or b-a==1) and max(a,b)%2==0:
            return cnt
        a = next(a)
        b = next(b)
        
def next(n):
	if n%2 == 0:
		return n//2
	else:
		return (n+1)//2