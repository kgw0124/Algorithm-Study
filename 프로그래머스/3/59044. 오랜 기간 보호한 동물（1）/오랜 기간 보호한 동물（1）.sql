-- 코드를 입력하세요
SELECT i.NAME AS NAME, i.DATETIME AS DATETIME
FROM ANIMAL_INS i 
LEFT JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID 
WHERE o.ANIMAL_ID IS NULL # ← 조심
ORDER BY DATETIME
LIMIT 3