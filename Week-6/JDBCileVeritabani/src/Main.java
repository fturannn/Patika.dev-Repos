import java.sql.*;
public class Main {
    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection connect = null;
        String sql = "SELECT * FROM employees";

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // DriverManager.getConnection() metodunu kullanarak veritabanına bir bağlantı oluştur.
            Statement st = connect.createStatement(); // Connection nesnesinin createStatement() metodunu kullanarak bir SQL ifadesi (statement) oluştur.
            ResultSet data = st.executeQuery(sql); // Statement nesnesinin executeQuery() metodunu kullanarak bir SQL sorgusu çalıştır ve sonuçları bir ResultSet nesnesinde sakla
            while (data.next()) {
                System.out.println("ID: " + data.getInt("id"));
                System.out.println("İsim: " + data.getString("name"));
                System.out.println("Pozisyon: " + data.getString("position"));
                System.out.println("Maaş: " + data.getInt("salary"));
                System.out.println("------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}