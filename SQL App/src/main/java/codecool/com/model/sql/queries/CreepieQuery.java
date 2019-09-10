package codecool.com.model.sql.queries;

import codecool.com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreepieQuery {

    public void createMentor(User user) {

        try (Connection c = new DataSource().getConnection()) {
            String query = " insert into users (firstname, lastname, email, nickname, password, accessrights)"
                    + " values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, user.getFirstName());
            preparedStmt.setString(2, user.getLastName());
            preparedStmt.setString(3, user.getEmail());
            preparedStmt.setString(4, user.getNickName());
            preparedStmt.setString(5, user.getPassword());
            preparedStmt.setInt(6, user.getAccessRights());
            preparedStmt.execute();
            preparedStmt.close();

        } catch (SQLException e) {
            System.err.println("SQL exception when creating. ");
            e.printStackTrace();
        }
    }

    public void updateMentor(User user) {

        try (Connection c = new DataSource().getConnection()) {
            String query = "UPDATE users SET firstname = ?, lastname = ?, email= ? , nickname = ? , password = ?, accessrights = ?, photo = ? WHERE id = ?";
            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, user.getFirstName());
            preparedStmt.setString(2, user.getLastName());
            preparedStmt.setString(3, user.getEmail());
            preparedStmt.setString(4, user.getNickName());
            preparedStmt.setString(5, user.getPassword());
            preparedStmt.setInt(6, user.getAccessRights());
            preparedStmt.setString(7, user.getPhotoUrl());
            preparedStmt.setInt(8, user.getId());
            preparedStmt.execute();
            preparedStmt.close();

        } catch (SQLException e) {
            System.err.println("SQL exception when creating. ");
            e.printStackTrace();
        }
    }

    public ArrayList<User> readAllMentors(){
//        Connection c = new DataSource().getConnection();
        ArrayList<User> list = new ArrayList<>();
//        DataSource ds = new DataSource();
        try (ResultSet rs = new DataSource().executeQuery("SELECT * FROM USERS WHERE accessrights=2;")) {
            while(rs.next()){
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String nickname = rs.getString("nickname");
                String password = rs.getString("password");
                String photoUrl = rs.getString("photo");
                int accessrights = rs.getInt("accessrights");

                User user = new User();
                user.setId(id);
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setEmail(email);
                user.setNickName(nickname);
                user.setPassword(password);
                user.setNickName(nickname);
                user.setPhotoUrl(photoUrl);
                user.setAccessRights(accessrights);
                list.add(user);
            }
        } catch (SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return list;
    }
}
