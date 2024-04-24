-- 코드를 입력하세요
WITH filter AS(
    SELECT DISTINCT NAME
    FROM ANIMAL_INS
    WHERE NAME IS NOT NULL
)

SELECT COUNT(*) AS count
FROM filter