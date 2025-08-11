# Write your MySQL query statement below


with stat_info as (select book_id,
                          count(*)                           as reading_count,
                          sum(if(session_rating >= 4, 1, 0)) as reading_4_count,
                          sum(if(session_rating <= 2, 1, 0)) as reading_2_count,
                          max(session_rating)                as max_session_rating,
                          min(session_rating)                as min_session_rating
                   from reading_sessions
                   group by book_id)
   , final_Info as (select book_id,
                           max_session_rating - min_session_rating                  reading_spread,
                           ((reading_4_count + reading_2_count) / reading_count) as extreme_rating
                    from stat_info
                    where reading_2_count >= 1
                      and reading_4_count >= 1
                      and reading_count >= 5
                      and ((reading_4_count + reading_2_count) / reading_count) >= 0.6)
select b.book_id,
       b.title,
       b.author,
       b.genre,
       b.pages,
       a.reading_spread as rating_spread,
       round(a.extreme_rating,2) as polarization_score
from final_Info a
         join books b on a.book_id = b.book_id
order by extreme_rating desc, b.title desc