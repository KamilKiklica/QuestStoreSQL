package codecool.com.model.sql.queries;


import codecool.com.model.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorQuery {

    public void showMentor(Mentor mentor) {
        try (Connection c = new DataSource().getConnection()) {
            String query = "SELECT * from mentors";

            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.execute();


        } catch (SQLException e) {
            System.err.println("SQL exception when creating. ");
            e.printStackTrace();
        }
    }


        public void createMentor(Mentor mentor) {

        try (Connection c = new DataSource().getConnection()) {
            String query = " insert into mentors (first_name, last_name, phone_number, email, nick_name, city, favourite_number)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, mentor.getFirstName());
            preparedStmt.setString(2, mentor.getLastName());
            preparedStmt.setString(3, mentor.getPhoneNumber());
            preparedStmt.setString(4, mentor.getEmail());
            preparedStmt.setString(5, mentor.getNickName());
            preparedStmt.setString(6, mentor.getCity());
            preparedStmt.setInt(7, mentor.getFavouriteNumber());

            preparedStmt.execute();

        } catch (SQLException e) {
            System.err.println("SQL exception when creating. ");
            e.printStackTrace();
        }
    }

    public List<Mentor> readAllFirstNameAndLastNameOfMentors(){
//        Connection c = new DataSource().getConnection();
        List<Mentor> list = new ArrayList<>();
//        DataSource ds = new DataSource();
        try (ResultSet rs = new DataSource().executeQuery("SELECT first_name, last_name FROM mentors;")) {
            while(rs.next()){
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");

                Mentor mentor = new Mentor();
                mentor.setFirstName(firstname);
                mentor.setLastName(lastname);
                list.add(mentor);
            }

        } catch (SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return list;
    }

    public List<Mentor> readNicknamesOfMentorsFromMiskolc(){
//        Connection c = new DataSource().getConnection();
        ArrayList<Mentor> list = new ArrayList<>();
//        DataSource ds = new DataSource();
        try (ResultSet rs = new DataSource().executeQuery("SELECT nick_name FROM mentors where city='Miskolc';")) {
            while(rs.next()){
                String nickname = rs.getString("nick_name");

                Mentor mentor = new Mentor();
                mentor.setNickName(nickname);
                list.add(mentor);
            }

        } catch (SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return list;
    }

    public void deleteAllMentors() {
        try (Connection c = new DataSource().getConnection())
        {

            PreparedStatement st = c.prepareStatement("DELETE FROM mentors;");
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("SQL exception when deleting. ");
            System.out.println(e);
        }
    }

    public void createMentorsTable() {
        try (Connection c = new DataSource().getConnection())
        {

            PreparedStatement st = c.prepareStatement("DELETE FROM mentors;");
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("SQL exception when deleting. ");
            System.out.println(e);
        }
    }
/*

    CREATE TABLE IF NOT EXISTS mentors (
            task_id INT AUTO_INCREMENT PRIMARY KEY,
            title VARCHAR(255) NOT NULL,
    start_date DATE,
    due_date DATE,
    status TINYINT NOT NULL,
    priority TINYINT NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;*/
//    public void update(){}
//
//    public void update(Product product) {
//
//        ArrayList<Product> list = new ArrayList<Product>();
//        int available = product.isAvailable() ?  1 : 0;
//        int onStock = product.isOnStock() ? 1 : 0;
//        try (Connection c = new DataSource().getConnection())
//        {
//
//            String query = "UPDATE products SET name = ?, price = ?, amount= ? , isAvailable = ? , categoryId = ?, isOnStock = ? WHERE id = ?";
//            PreparedStatement preparedStmt = c.prepareStatement(query);
//
//            preparedStmt.setString(1, product.getName());
//            preparedStmt.setDouble(2, product.getPrice());
//            preparedStmt.setInt(3, product.getAmount());
//            preparedStmt.setInt(4, available);
//            preparedStmt.setInt(5, product.getCategory());
//            preparedStmt.setInt(6, onStock);
//            preparedStmt.setInt(7, product.getId());
//
//            preparedStmt.executeUpdate();
//
//        }
//        catch (SQLException e)
//        {
//            System.err.println("SQL exception when updating. ");
//            System.err.println(e.getMessage());
//        }
//
//    }
//
//    public void delete() {
//
//    }
//
//    public void delete(Product product) {
//        try (Connection c = new DataSource().getConnection())
//        {
//
//            PreparedStatement st = c.prepareStatement("DELETE FROM products WHERE id = " + product.getId() + ";");
//            st.executeUpdate();
//        }
//        catch(SQLException e)
//        {
//            System.err.println("SQL exception when deleting. ");
//            System.out.println(e);
//        }
//
//    }
//
}
