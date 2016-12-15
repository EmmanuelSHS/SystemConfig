-- start
.output traffic_site_date.csv
.header on
select host, dt_service, sum(count) as traffic from webbrowse group by host, dt_service;
--
.output traffic_site_sum.csv
.header on
select host, sum(count) as traffic from webbrowse group by host order by sum(count) desc;
--
.output traffic_user_sum.csv
.header on
select id, sum(count) as traffic from webbrowse group by id order by sum(count) desc;
--
.output traffic_user_date.csv
.header on
select id, dt_service, sum(count) as traffic from webbrowse group by id, dt_service;
--
.output traffic_date_sum.csv
.header on
select dt_service, sum(count) as traffic from webbrowse group by dt_service;
