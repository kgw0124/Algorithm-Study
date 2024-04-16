-- 코드를 작성해주세요
WITH ranking AS(
    SELECT ID, rank() over (order by SIZE_OF_COLONY DESC) AS ranking
    FROM ECOLI_DATA
), counting AS(
    SELECT COUNT(*) AS counting
    FROM ECOLI_DATA
)

SELECT ranking.ID,
    CASE WHEN (ranking.ranking/counting.counting <= 0.25) THEN "CRITICAL"
    WHEN (ranking.ranking/counting.counting <= 0.5) THEN "HIGH"
    WHEN (ranking.ranking/counting.counting <= 0.75) THEN "MEDIUM"
    WHEN (ranking.ranking/counting.counting <= 1) THEN "LOW"
    END AS COLONY_NAME
FROM ranking, counting
ORDER BY ID