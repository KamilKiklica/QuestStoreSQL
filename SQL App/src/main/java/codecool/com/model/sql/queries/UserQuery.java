package codecool.com.model.sql.queries;

import codecool.com.model.User;

import java.sql.Connection;
import java.sql.ResultSet;

public class UserQuery {

    public User readUser(String nickname, String userPassword){
        Connection c = null;
        User newUser = new User();
        try {
            DataSource ds = new DataSource();
            ResultSet rs = ds.executeQuery("SELECT * FROM USERS WHERE nickname LIKE '"+nickname+"' AND password Like '"+userPassword+"';");
            if (rs.next() && rs.getString("nickname").equals(nickname)) {
                int id = rs.getInt("id");
                String name = rs.getString("nickname");
//                String password = rs.getString("password");
                int accessRights = rs.getInt("accessrights");

                newUser.setAccessRights(accessRights);
                newUser.setNickName(name);
//                newUser.set(password);
                newUser.setId(id);
            }
            rs.close();
            ds.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return newUser;
    }
}
