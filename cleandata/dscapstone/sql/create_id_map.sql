CREATE TABLE IF NOT EXISTS id(id text, short text);
.separator ' '
.mode csv
.import id_mapping.csv id
DELETE FROM id WHERE short = 'id_short';
