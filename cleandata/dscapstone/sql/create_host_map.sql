CREATE TABLE IF NOT EXISTS url(short text, host text);
.mode csv
.separator ','
.import url_mapping.csv url
