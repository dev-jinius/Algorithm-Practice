SELECT Count(*)    FISH_COUNT,
       Max(length) MAX_LENGTH,
       fish_type
FROM   fish_info
GROUP  BY fish_type
HAVING Avg(CASE
             WHEN length > 10 THEN length
             ELSE 10
           end) >= 33
ORDER  BY fish_type