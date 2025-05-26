import java.sql.*;

class StudentDAO {
    Connection conn;

    StudentDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:students.db");
    }

    void insertStudent(int id, String name) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (id, name) VALUES (?, ?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        }
    }

    void updateStudent(int id, String name) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
