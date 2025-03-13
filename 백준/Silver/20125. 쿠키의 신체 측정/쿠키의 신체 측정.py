def findHeart(N):
    for i in range(N):
        tmp = input()
        if "*" in tmp:
            for j in range(N):
                if tmp[j] == "*":
                    return (i+2,j+1)
    
def findArm(y):
    left, right = 0, 0
    tmp = input()
    for i in range(N):
        if tmp[i] == "*":
            if i < y-1:
                left += 1
            elif y-1 < i:
                right += 1

    return (left, right)

def findWaistAndLeg(N,x,y):
    waist, left, right = 0, 0, 0
    for i in range(x, N):
        tmp = input()
        if tmp[y-1] == "*":
            waist += 1
        if tmp[y-2] == "*":
            left += 1
        if tmp[y] == "*":
            right += 1

    return (waist, left, right)

# Main
N = int(input())

x, y = findHeart(N)
leftArm, rightArm = findArm(y)
waist, leftLeg, rightLeg = findWaistAndLeg(N, x, y)

print(x,y)
print(leftArm, rightArm, waist, leftLeg, rightLeg)