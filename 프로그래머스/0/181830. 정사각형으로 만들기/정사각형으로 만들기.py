def solution(arr):
    height = len(arr)
    width = len(arr[0])
    
    if height > width:
        for i in arr:
            for j in range(height - width):
                i.append(0)
    else:
        for i in range(width - height):
            arr.append([0 for j in range(width)])
                
    return arr