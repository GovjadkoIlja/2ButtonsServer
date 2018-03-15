package hello.dbCalls;

import java.sql.*;

public class UserPage {

    public static ResultSet getUserInfo(Connection con, int userID, int getUserID) {
        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("select * from dbo.getUserInfo(?, ?)", ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            st.setInt(1, userID);
            st.setInt(2, getUserID);

            rs = st.executeQuery();


            if (userID != getUserID) {
                if (rs.next()) {
                    if (rs.getInt("youFollowed") == 1) {
                        updateVisits(con, userID, getUserID);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void updateVisits(Connection con, int userID, int getUserID) {
        CallableStatement st = null;

        try {
            st = con.prepareCall("{call updateVisits(?, ?)}");

            st.setInt(1, userID);
            st.setInt(2, getUserID);

            st.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(st!=null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet getPosts(Connection con, int userID, int getUserID, int amount) {
        ResultSet rs = null;
        PreparedStatement st = null; //Нормально ли, что я его не закрываю?

        try {
            st = con.prepareStatement("select * from dbo.getPosts(?, ?, ?)");

            st.setInt(1, userID);
            st.setInt(2, getUserID);
            st.setInt(3, amount);

            rs = st.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
