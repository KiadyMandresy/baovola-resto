package connex;
import java.sql.*;

public class Connex
{
    Connection con;
    public Connex()
    {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/sakafo";
            String user= "postgres";
            String mdp = "kalisi61";
            Connection conn = DriverManager.getConnection(url, user, mdp);
            setCon(conn);
        }
		catch (Exception e1) {
			e1.printStackTrace();
		}
    }
    public void deco()
    {
        try{
        getCon().close();

        }
		catch (Exception e1) {
			e1.printStackTrace();
		}
    }
    public void setCon(Connection c)
    {
        con=c;
    }
    public Connection getCon()
    {
        return con;
    }
}

