package model.dao;

import java.sql.*;

public class MapDAO extends AbstractDAO{

	
	private  String sql_map;

	BoulderDashBDDConnector boulderDashBDD = BoulderDashBDDConnector.getInstance(); //recupere l'instance du connecteur à la bdd
	ResultSet rs = null;
	Statement st = null;
	Connection conn = null;
	
	private  void setmap(String title_map){
    sql_map   = "CALL recupere_map('"+title_map+"')";
    
    }
	
    
    public MapDAO(){
    	super();
    }

    /**
     * Recupere la map
     * @param title
     * @return
     * @throws SQLException
     */
    public  String readMap(String title) throws SQLException{
        conn = boulderDashBDD.getConnection(); //recup la connexion a la bdd
        st = conn.createStatement(); //initialise le statement
        
        setmap(title);

        String map = "";
        
        rs = st.executeQuery(sql_map); //execute la requete
        if(rs.next()) { //recupere le premier resultat
            map = rs.getString("level"); //recupere le contenu de la colonne level
            System.out.println(map);
        }
        else
            map = "fail"; //fait un truc si y'a pas de map

        return map;
    }

    public int readSize(){
        return 0;
    }
}
