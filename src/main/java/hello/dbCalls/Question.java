package hello.dbCalls;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;

public class Question {
    public static void saveFeedback(Connection con, int userId, int questionId, int feedback) {
        CallableStatement st = null;

        try {
            st = con.prepareCall("{call insertFeedback(?, ?, ?, ?)}");

            st.setInt("userID", userId);
            st.setInt("questionID", questionId);
            st.setInt("feedback", feedback);
            java.sql.Date answered = new java.sql.Date(Calendar.getInstance().getTime().getTime()); //Доработать, чтобы время было не нулевое всегда

            st.setDate("answered", answered);
            //st.registerOutParameter("userID", Types.INTEGER);

            st.execute();
            //return st.getInt("userID");
            //return st.getInt(9);

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

        //return -1;
    }

    public static void saveFavorites(Connection con, int userId, int questionId, int inFavorites) {
        CallableStatement st = null;

        try {
            st = con.prepareCall("{call insertFavorites(?, ?, ?, ?)}");

            st.setInt("userID", userId);
            st.setInt("questionID", questionId);
            st.setInt("inFavorites", inFavorites);
            java.sql.Date added = new java.sql.Date(Calendar.getInstance().getTime().getTime()); //Доработать, чтобы время было не нулевое всегда

            st.setDate("added", added);
            //st.registerOutParameter("userID", Types.INTEGER);

            st.execute();
            //return st.getInt("userID");
            //return st.getInt(9);

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

        //return -1;
    }

    public static void saveAnswer(Connection con, int userId, int questionId, int answer) {
        CallableStatement st = null;

        try {
            st = con.prepareCall("{call insertAnswer(?, ?, ?, ?)}");

            st.setInt("userID", userId);
            st.setInt("questionID", questionId);
            st.setInt("answer", answer);
            java.sql.Date answered= new java.sql.Date(Calendar.getInstance().getTime().getTime()); //Доработать, чтобы время было не нулевое всегда

            st.setDate("answered", answered);
            //st.registerOutParameter("userID", Types.INTEGER);

            st.execute();
            //return st.getInt("userID");
            //return st.getInt(9);

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

        //return -1;
    }
}
