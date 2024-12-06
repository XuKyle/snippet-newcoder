# Write your MySQL query statement below


with user_rating as (select user_id, count(*) as rating_cnt
                     from MovieRating
                     group by user_id),
     rank_info as (select a.user_id,
                          b.name,
                          a.rating_cnt,
                          row_number() over (order by rating_cnt desc,b.name) as rk
                   from user_rating a
                            join Users b on a.user_id = b.user_id),
     movie_rating as (select movie_id, avg(rating) as rating
                      from MovieRating
                      where substring(created_at, 1, 7) = '2020-02'
                      group by movie_id),
     rating_info as (select a.movie_id, b.title, a.rating, row_number() over (order by a.rating desc,b.title) as rk
                     from movie_rating a
                              join Movies b on a.movie_id = b.movie_id)

select name as results
from rank_info
where rk = 1
union all
select title
from rating_info
where rk = 1
