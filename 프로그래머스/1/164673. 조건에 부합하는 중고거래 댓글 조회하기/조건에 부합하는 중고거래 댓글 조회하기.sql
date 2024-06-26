-- 코드를 입력하세요
WITH b AS(
    SELECT *
    FROM USED_GOODS_BOARD
    WHERE YEAR(CREATED_DATE) = 2022
    AND MONTH(CREATED_DATE) = 10
)


SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, "%Y-%m-%d")
FROM b JOIN USED_GOODS_REPLY r
WHERE b.BOARD_ID = r.BOARD_ID
ORDER BY r.CREATED_DATE, b.TITLE