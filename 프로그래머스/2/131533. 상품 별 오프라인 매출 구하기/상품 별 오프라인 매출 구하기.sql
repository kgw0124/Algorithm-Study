-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, SUM(p.PRICE * os.SALES_AMOUNT) AS SALES
FROM PRODUCT p JOIN OFFLINE_SALE os
ON p.PRODUCT_ID = os.PRODUCT_ID
GROUP BY p.PRODUCT_ID
ORDER BY SALES DESC, PRODUCT_CODE