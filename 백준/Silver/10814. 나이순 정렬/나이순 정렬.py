import sys
input=sys.stdin.readline

N = int(input())

names = []
members = []
for idx in range(N):
    age, name = input().split()
    names.append(name)
    members.append((int(age), idx))

members.sort(key=lambda x:(x[0], x[1]))

for i in members:
    print(i[0], names[i[1]])