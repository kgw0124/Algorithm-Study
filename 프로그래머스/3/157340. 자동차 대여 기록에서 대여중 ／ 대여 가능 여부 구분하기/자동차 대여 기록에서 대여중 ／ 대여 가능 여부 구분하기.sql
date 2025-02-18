-- 코드를 입력하세요
# MAX('대여중', '대여 가능') 했을 때, 후자가 길이가 더 길어서 후자가 선택된다.
# 즉, CAR_ID로 GROUP BY 했을 때 하나라도 '대여 가능'이라면 '대여 가능'을 반환한다.
SELECT CAR_ID,
    MAX(CASE
        WHEN (DATEDIFF("2022-10-16", START_DATE) >= 0 AND DATEDIFF(END_DATE, "2022-10-16") >= 0) THEN '대여중'
        ELSE '대여 가능'
    END) AS AVAILABILITY 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
ORDER BY CAR_ID DESC
