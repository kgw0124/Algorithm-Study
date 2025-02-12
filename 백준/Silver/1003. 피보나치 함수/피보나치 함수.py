T = int(input())

inputs = []
for i in range(T):
    inputs.append(int(input()))

# init
maxVal = max(inputs)
count0 = [0 for i in range(41)] # 런타임 에러 방지 차원
count1 = [0 for i in range(41)]
count0[0], count1[1] = 1, 1

for i in range(2, maxVal+1):
    count0[i] = count0[i-1] + count0[i-2]
    count1[i] = count1[i-1] + count1[i-2]

for i in inputs:
    print(str(count0[i]) + ' ' + str(count1[i]))