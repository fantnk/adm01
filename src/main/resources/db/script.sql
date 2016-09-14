SELECT * FROM traffic
WHERE date BETWEEN '2016-09-08' AND '2016-09-09' AND subscriber=9000000006;

SELECT subscriber, SUM(uplink) FROM traffic
WHERE date BETWEEN '2016-09-08' AND '2016-09-09' AND subscriber=9000000006
GROUP BY subscriber;

SELECT SUM(uplink) FROM traffic
WHERE date BETWEEN '2016-09-08 4:0:0' AND '2016-09-08 9:0:0' AND subscriber=9000000006
GROUP BY subscriber;

SELECT subscriber, '2016-09-08 4:0:0' as fromdate, '2016-09-08 4:0:0' as todate, SUM(uplink) as aa FROM traffic
WHERE date BETWEEN '2016-09-08 4:0:0' AND '2016-09-08 9:0:0' AND subscriber=9000000006
GROUP BY subscriber;