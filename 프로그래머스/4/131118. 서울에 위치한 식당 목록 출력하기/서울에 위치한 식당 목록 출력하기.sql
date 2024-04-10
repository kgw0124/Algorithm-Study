-- 코드를 입력하세요
WITH info AS(
    SELECT *
    FROM REST_INFO
    WHERE ADDRESS LIKE "서울%"
), review AS(
    SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
    FROM REST_REVIEW
    GROUP BY REST_ID
)

SELECT info.REST_ID, info.REST_NAME, info.FOOD_TYPE, info.FAVORITES, info.ADDRESS, review.SCORE
FROM info JOIN review
WHERE info.REST_ID = review.REST_ID
ORDER BY review.SCORE DESC, info.FAVORITES DESC