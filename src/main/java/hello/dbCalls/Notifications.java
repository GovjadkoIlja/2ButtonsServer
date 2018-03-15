package hello.dbCalls;

import java.sql.*;
import java.util.Calendar;

public class Notifications {
    public static ResultSet getNewFollowers(Connection con, int userID) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getNewFollowers(?)");

            st.setInt(1, userID);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    static ResultSet getNewRecommendedQuestions(Connection con, int userID) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getNewRecommendedQuestions(?)");

            st.setInt(1, userID);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    static void updateNotsDate(Connection con, int userID) { //Call each time we see Notifications. Perhaps add to the constructor;
        ResultSet rs = null;
        CallableStatement st = null;

        try {
            st = con.prepareCall("{call updateNotsDate(?, ?)}");

            st.setInt("userID", userID);

            java.sql.Date lastNots = new java.sql.Date(Calendar.getInstance().getTime().getTime()); //Доработать, чтобы время было не нулевое всегда
            st.setDate("newLastNots", lastNots);

            st.execute();;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
