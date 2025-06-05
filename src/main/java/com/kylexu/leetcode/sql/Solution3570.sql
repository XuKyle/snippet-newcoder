# Write your MySQL query statement below

with brow_info as (select book_id, count(*) as borrow_count
                   from borrowing_records
                   where return_date is null
                   group by book_id)

select a.book_id,
       a.title,
       a.author,
       a.genre,
       a.publication_year,
       b.borrow_count  current_borrowers
from library_books a
         join brow_info b on a.book_id = b.book_id and a.total_copies = b.borrow_count
order by a.total_copies desc, a.title
