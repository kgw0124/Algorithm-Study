-- 코드를 작성해주세요
WITH rare AS( -- RARE인 ITEM이 업그레이드될 수 있는 ITEM
    SELECT tree.ITEM_ID AS childId
    FROM ITEM_INFO info JOIN ITEM_TREE tree
    WHERE info.RARITY = "RARE" 
    AND info.ITEM_ID = tree.PARENT_ITEM_ID   
)

SELECT info.ITEM_ID, info.ITEM_NAME, info.RARITY
FROM ITEM_INFO info
WHERE info.ITEM_ID IN (SELECT childId FROM rare)
ORDER BY info.ITEM_ID DESC