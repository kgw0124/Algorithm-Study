-- 코드를 입력하세요
WITH temp AS(
    SELECT CAR_ID, DATEDIFF(END_DATE, START_DATE)+1 AS DIFF
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
)

SELECT CAR_ID, ROUND(AVG(DIFF),1) AS AVERAGE_DURATION
FROM temp
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC