package hello.dbCalls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static int identification(Connection con, String login, int password) {
        PreparedStatement st = null;
        int id = 0;

        try {
            st = con.prepareStatement("select dbo.identification(?, ?)");

            st.setString(1, login);
            st.setInt(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int checkValidUser(Connection con, String phone, String login) {
        PreparedStatement st = null;
        int id = 0;

        try {
            st = con.prepareStatement("select dbo.checkValidUser(?, ?)");

            st.setString(1, phone);
            st.setString(2, login);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int checkValidLogin(Connection con, String login) {
        PreparedStatement st = null;
        int id = 0;

        try {
            st = con.prepareStatement("select dbo.checkValidLogin(?)");

            st.setString(1, login);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
