import sys
input=sys.stdin.readline

N = int(input())

my_dict = {}
for i in list(map(int, input().split())):
    if i in my_dict.keys():
        my_dict[i] += 1
    else:
        my_dict[i] = 1

M = int(input())

answer = []
for i in list(map(int, input().split())):
    if i in my_dict.keys():
        answer.append(str(my_dict[i]))
    else:
        answer.append('0')
print(' '.join(answer))