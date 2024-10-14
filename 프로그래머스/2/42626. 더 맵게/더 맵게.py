import heapq

def solution(scoville, K):
    heap = []
    for i in scoville:
        heapq.heappush(heap, i)
        
    answer = 0
    while heap[0] < K:
        if len(heap) == 1 and heap[0] < K: # 예외 처리
            return -1
        answer += 1
        val1 = heapq.heappop(heap)
        val2 = heapq.heappop(heap)
        heapq.heappush(heap, val1 + val2*2)
        
    return answer