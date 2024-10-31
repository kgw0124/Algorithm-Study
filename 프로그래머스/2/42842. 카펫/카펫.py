def solution(brown, yellow):
    for i in range(3, brown):
        if (brown + yellow) % i == 0:
            width = i
            height = (brown + yellow) // i
            
            if (width - 2) * (height - 2) == yellow:
                return(sorted([width, height], reverse=True))