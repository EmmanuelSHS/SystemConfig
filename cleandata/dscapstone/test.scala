val text = sc.textFile("/home/mengqi/dscapstone/merged.csv");
lazy val data = text.map(line => line.split(",").map(elem => elem.trim));
data.count;
