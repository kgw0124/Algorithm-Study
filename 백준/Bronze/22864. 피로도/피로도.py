A,B,C,M = map(int, input().split())

tired, work = 0, 0
for _ in range(24):
    if tired >= M or tired + A > M:
        tired = max(0, tired - C)
    else:
        work += B
        tired += A

print(work)