import math

def solution(arr):
    # 최대공약수 함수 : math.gcd()
    # 최소공배수 = (최소공배수를 구하고자 하는 수들을 곱한 값) / 최대공약수
    lcd = arr[0] 
    gcd = arr[0]
    
    for i in range(len(arr)-1):
        gcd = math.gcd(lcd, arr[i+1])
        lcd = (lcd*arr[i+1])//gcd      

    return lcd

		