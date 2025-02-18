-- 코드를 입력하세요
WITH SEDAN AS(
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_TYPE = '세단'
)

SELECT DISTINCT C.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY C, SEDAN
WHERE 
    C.CAR_ID = SEDAN.CAR_ID
    AND MONTH(START_DATE) = 10
ORDER BY CAR_ID DESC