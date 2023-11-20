-- here i collect unbanned useres to use them in the subquery below

with ban as (
    select users_id
    from users
    where banned = 'No'
)
 
 
select request_at as Day ,
 round(sum(case when status like 'cancelled%' then 1.0 else 0 end) / count(*) , 2) as 'Cancellation Rate'
from Trips
where client_id in (select users_id from ban) and driver_id in (select users_id from ban)
and request_at between '2013-10-01' and '2013-10-03'

group by request_at