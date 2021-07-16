package task1_sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {

    public static void getAverage() throws SQLException {
        ResultSet rs = StartConnection.statement.executeQuery("SELECT AVG(students.marks) as marksaverage from students where marks >= 40");
        while (rs.next()) {
            System.out.println(rs.getDouble(1));
        }
    }
}
