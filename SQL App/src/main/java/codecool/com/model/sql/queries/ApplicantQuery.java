package codecool.com.model.sql.queries;

import codecool.com.model.Applicant;
import codecool.com.model.FullNamePhoneNumber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicantQuery {

    public void createApplicant(Applicant applicant) {

        try (Connection c = new DataSource().getConnection()) {
            String query = " insert into applicants (first_name, last_name, email, application_code, phone_number)"
                    + " values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, applicant.getFirstName());
            preparedStmt.setString(2, applicant.getLastName());
            preparedStmt.setString(3, applicant.getEmail());
            preparedStmt.setInt(4, applicant.getApplicationCode());
            preparedStmt.setString(5, applicant.getPhoneNumber());

            preparedStmt.execute();

        } catch (SQLException e) {
            System.err.println("SQL exception when creating. ");
            e.printStackTrace();
        }
    }

    public List<FullNamePhoneNumber> searchForCarol(){
//        Connection c = new DataSource().getConnection();
//        DataSource ds = new DataSource();
        List<FullNamePhoneNumber> fullNamePhoneNumberList = new ArrayList<>();

        try (ResultSet rs = new DataSource().executeQuery("SELECT CONCAT(first_name,' ',last_name) AS FullName, phone_number FROM applicants\n" +
                "WHERE first_name='Carol';")) {
            while(rs.next()){
                String fullname = rs.getString("FullName");
                String phoneNumber = rs.getString("phone_number");

                FullNamePhoneNumber fullNamePhoneNumber = new FullNamePhoneNumber();
                fullNamePhoneNumber.setFullname(fullname);
                fullNamePhoneNumber.setPhoneNumber(phoneNumber);
                fullNamePhoneNumberList.add(fullNamePhoneNumber);
            }

        } catch (SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return fullNamePhoneNumberList;
    }

    public List<FullNamePhoneNumber> searchByEmailDomain(){
//        Connection c = new DataSource().getConnection();
//        DataSource ds = new DataSource();
        List<FullNamePhoneNumber> fullNamePhoneNumberList = new ArrayList<>();

        try (ResultSet rs = new DataSource().executeQuery("SELECT CONCAT(first_name,' ',last_name) AS FullName, phone_number FROM applicants\n" +
                "WHERE email like '%@adipiscingenimmi.edu%';")) {
            while(rs.next()){
                String fullname = rs.getString("FullName");
                String phoneNumber = rs.getString("phone_number");

                FullNamePhoneNumber fullNamePhoneNumber = new FullNamePhoneNumber();
                fullNamePhoneNumber.setFullname(fullname);
                fullNamePhoneNumber.setPhoneNumber(phoneNumber);
                fullNamePhoneNumberList.add(fullNamePhoneNumber);
            }

        } catch (SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return fullNamePhoneNumberList;
    }

    public List<Applicant> searchByApplicationCode(){
//        Connection c = new DataSource().getConnection();
//        DataSource ds = new DataSource();
        List<Applicant> applicants = new ArrayList<>();

        try (ResultSet rs = new DataSource().executeQuery("SELECT * FROM applicants WHERE application_code=54823;")) {
            while(rs.next()){
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                int applicationCode = rs.getInt("application_code");
                String phoneNumber =rs.getString("phone_number");

                Applicant applicant = new Applicant();
                applicant.setFirstName(firstName);
                applicant.setLastName(lastName);
                applicant.setEmail(email);
                applicant.setApplicationCode(applicationCode);
                applicant.setPhoneNumber(phoneNumber);
                applicants.add(applicant);
            }

        } catch (SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return applicants;
    }


    public void updateJemimaForemanPhoneNumber(String phonenumber) {
        try (Connection c = new DataSource().getConnection())
        {
            Applicant applicant = new Applicant();
            String query = "UPDATE applicants SET phone_number = ? WHERE first_name = ? and last_name = ?;";
            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, phonenumber);
            preparedStmt.setString(2, "Jemima");
            preparedStmt.setString(3, "Foreman");
            preparedStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("SQL exception when updating. ");
            System.err.println(e.getMessage());
        }

    }

    public List<Applicant> searchJemimaForeman(){
//        Connection c = new DataSource().getConnection();
//        DataSource ds = new DataSource();
        List<Applicant> applicants = new ArrayList<>();

        try (ResultSet rs = new DataSource().executeQuery("SELECT first_name, last_name, phone_number FROM applicants WHERE first_name like 'Jemima' and last_name like 'Foreman';")) {
            while(rs.next()){
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phoneNumber =rs.getString("phone_number");

                Applicant applicant = new Applicant();
                applicant.setFirstName(firstName);
                applicant.setLastName(lastName);
                applicant.setPhoneNumber(phoneNumber);
                applicants.add(applicant);
            }

        } catch (SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return applicants;
    }

    public void deleteApplicantsWithMausiseuEmailDomain() {
        try (Connection c = new DataSource().getConnection())
        {

            PreparedStatement st = c.prepareStatement("DELETE FROM applicants WHERE email like '%@mauriseu.net';");
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("SQL exception when deleting. ");
            System.out.println(e);
        }
    }


    public void deleteAllApplicants() {
        try (Connection c = new DataSource().getConnection())
        {

            PreparedStatement st = c.prepareStatement("DELETE FROM applicants;");
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("SQL exception when deleting. ");
            System.out.println(e);
        }
    }
}
