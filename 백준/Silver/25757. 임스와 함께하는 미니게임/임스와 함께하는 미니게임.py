N, type = input().split()

myset = set()
for _ in range(int(N)):
    myset.add(input())

if type == "Y":
    print(len(myset))
elif type == "F":
    print(len(myset) // 2)
else:
    print(len(myset) // 3)
