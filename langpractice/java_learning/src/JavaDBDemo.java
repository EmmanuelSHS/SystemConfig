import java.sql.*;

public class JavaDBDemo {
	public static void main(String[] args) {
		try {
			/** loading driver */
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			System.out.println("Loading embedded driver");
			Connection conn = null;
			/** define and connect to DB */
			conn = DriverManager.getConnection("jdbc:derby:helloDB;create=true");
			System.out.println("create and connect to DB");
			conn.setAutoCommit(false);
			
			/** create and insert two records */
			Statement s = conn.createStatement();
			s.execute("create table hellotable(name varchar(40), score int)");
			System.out.println("Created table hellotable");
			s.execute("insert into hellotable values('Ruth Cao', 86)");
			s.execute("insert into hellotable values('Flora Shi', 92)");
			/** list two records */
			ResultSet rs = s.executeQuery(
					"SELECT name, score FROM hellotable ORDERED BY score");
			System.out.println("name\t\t score");
			while(rs.next()) {
				StringBuilder builder = new StringBuilder(rs.getString(1));
				builder.append("\t");
				builder.append(rs.getInt(2));
				System.out.println(builder.toString());
			}
			// delete table
			s.execute("drop table hellotable");
			System.out.println("Dropped table hellotable");
			
			rs.close();
			s.close();
			System.out.println("Closed result set and statement");
			conn.commit();
			conn.close();
			System.out.println("Committed result set and statement");
			
			try {
			/** execute closure of the database */
				DriverManager.getConnection("jdbc:derby:helloDB;shutdown=true");
			} catch (Throwable e) {
				/** Exception handling */
			}
			System.out.println("Demo finished");
		} catch (Exception e) {}
	}
}
