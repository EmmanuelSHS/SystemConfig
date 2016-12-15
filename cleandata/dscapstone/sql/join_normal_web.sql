.mode csv
.headers on
--.output 'traffic_id_url_bymonth.csv'
--
--SELECT a.month, a.id, a.host, sum(a.count) AS count
--FROM (
--    SELECT substr(w.dt_service, 6, 1) month, i.short AS id, u.short host, w.count AS count
--    FROM webbrowse w, id i, url u
--    WHERE w.id = i.id AND u.host = w.host
--) a
--GROUP BY a.month, a.id, a.host;
    
--.output 'merged_id_total_traffic.csv'
--
--SELECT n.*, b.count total_traffic
--FROM normal n, (
--    SELECT a.month, a.id, sum(a.count) count
--    FROM (
--        SELECT substr(w.dt_service, 6, 1) month, i.short id, w.count count
--        FROM webbrowse w, id i
--        WHERE w.id = i.id
--    ) a
--    GROUP BY a.month, a.id
--) b
--WHERE n.month = b.month AND n.id_short = b.id;

.output 'site_visit_stat.csv'

SELECT u.short, sum(w.count) AS count
FROM webbrowse w, url u
WHERE w.host = u.host
GROUP BY u.short
ORDER BY sum(w.count) DESC;

.quit
