def solution(video_len, pos, op_start, op_end, commands):
    # min → second
    video_arr = video_len.split(":")
    pos_arr = pos.split(":")
    op_start_arr = op_start.split(":")
    op_end_arr = op_end.split(":")
    
    video_min = 60*int(video_arr[0]) + int(video_arr[1])
    pos_min = 60*int(pos_arr[0]) + int(pos_arr[1])
    op_start_min = 60*int(op_start_arr[0]) + int(op_start_arr[1])
    op_end_min = 60*int(op_end_arr[0]) + int(op_end_arr[1])\
    
    # commands 수행
    for c in commands:
        if op_start_min <= pos_min and pos_min <= op_end_min:
            pos_min = op_end_min
        
        if c == "prev":
            if pos_min < 10:
                pos_min = 0
            else:
                pos_min -= 10
        elif c == "next":
            if video_min - pos_min < 10:
                pos_min = video_min
            else:
                pos_min += 10        

    if op_start_min <= pos_min and pos_min <= op_end_min:
        pos_min = op_end_min
    
    # second → min
    answer = str(pos_min//60).zfill(2) + ":" + str(pos_min%60).zfill(2)
    return answer