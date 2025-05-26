import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class TransactionExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
            conn.setAutoCommit(false); // Start transaction

            Statement stmt = conn.createStatement();

            // Debit account 1
            stmt.executeUpdate("UPDATE accounts SET balance = balance - 100 WHERE id = 1");

            // Credit account 2
            stmt.executeUpdate("UPDATE accounts SET balance = balance + 100 WHERE id = 2");

            // Commit transaction if both succeed
            conn.commit();
            System.out.println("Transfer successful");

        } catch (SQLException e) {
            System.out.println("Transaction failed. Rolling back...");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
                if (conn != null) conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
}

