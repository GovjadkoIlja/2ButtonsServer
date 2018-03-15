package hello.dbCalls;

import java.sql.*;

public class PeopleList {
    public static ResultSet getFollowers(Connection con, int id, int userID, int amount, String search) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getFollowers(?, ?, ?, ?)");

            st.setInt(1, id);
            st.setInt(2, userID);
            st.setInt(3, amount);
            st.setString(4, search);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getFollowTo(Connection con, int id, int userID, int amount, String search) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getFollowTo(?, ?, ?, ?)");

            st.setInt(1, id);
            st.setInt(2, userID);
            st.setInt(3, amount);
            st.setString(4, search);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getRecommendedFromContacts(Connection con, int userID, String search) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getRecommendedFromContacts(?, ?)");

            st.setInt(1, userID);
            st.setString(2, search);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getRecommendedFromFollows(Connection con, int userID, String search) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getRecommendedFromFollows(?, ?)");

            st.setInt(1, userID);
            st.setString(2, search);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet getRecommendedStrangers(Connection con, int userID, int amount, String search) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getRecommendedStrangers(?, ?, ?)");

            st.setInt(1, userID);
            st.setInt(2, amount);
            st.setString(3, search);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
