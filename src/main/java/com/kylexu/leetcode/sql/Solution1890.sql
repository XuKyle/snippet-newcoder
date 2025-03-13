select user_id,max(a.time_stamp) as last_stamp from Logins   a where substring(time_stamp,1,4) = '2020'
group by user_id