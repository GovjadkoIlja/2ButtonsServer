package hello.dbCalls;

import java.sql.*;

public class Results {
    /*static ResultSet getResults(Connection con, int userID, int questionID) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getResults(?, ?)");

            st.setInt(1, userID);
            st.setInt(2, questionID);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }*/

    public static ResultSet getResults(Connection con, int userID, int questionID, int minAge, int maxAge, int sex) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getResults(?, ?, ?, ?, ?)");

            st.setInt(1, userID);
            st.setInt(2, questionID);
            st.setInt(3, minAge);
            st.setInt(4, maxAge);
            st.setInt(5, sex);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getPhotos(Connection con, int userID, int questionID, int amount, int minAge, int maxAge, int sex) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getPhotos(?, ?, ?, ?, ?, ?)");

            st.setInt(1, userID);
            st.setInt(2, questionID);
            st.setInt(3, amount);
            st.setInt(4, minAge);
            st.setInt(5, maxAge);
            st.setInt(6, sex);

            rs = st.executeQuery();

            //rs = (ResultSet)st.getResultSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getAnsweredList(Connection con, int userID, int questionID, int amount, int answer, int minAge, int maxAge, int sex, String search) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getAnsweredList(?, ?, ?, ?, ?, ?, ?, ?)");

            st.setInt(1, userID);
            st.setInt(2, questionID);
            st.setInt(3, amount);
            st.setInt(4, answer);
            st.setInt(5, minAge);
            st.setInt(6, maxAge);
            st.setInt(7, sex);
            st.setString(8, search);

            rs = st.executeQuery();

            //rs = (ResultSet)st.getResultSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
