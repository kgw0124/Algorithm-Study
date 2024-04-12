-- 코드를 작성해주세요
WITH childParent AS(
    SELECT child.ID AS childId, child.GENOTYPE AS childGeno, parent.ID AS parentId, parent.GENOTYPE AS parentGeno
    FROM ECOLI_DATA child JOIN ECOLI_DATA parent
    WHERE child.PARENT_ID = parent.ID
)

SELECT childId AS ID, childGeno AS GENOTYPE, parentGeno AS PARENT_GENOTYPE
FROM childParent
WHERE childGeno & parentGeno = parentGeno
ORDER BY ID