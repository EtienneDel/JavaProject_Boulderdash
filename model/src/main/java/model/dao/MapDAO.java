package model.dao;

import java.sql.*;

public class MapDAO extends AbstractDAO{

	
	private  String sql_map,sqlWidth,sqlHeigth;
	int map_Width,map_Heigth;

	BoulderDashBDDConnector boulderDashBDD = BoulderDashBDDConnector.getInstance(); //recupere l'instance du connecteur a  la bdd
	ResultSet rs = null;
	Statement st = null;
	Connection conn = null;
	
	private  void setmap(String title_map){
    sql_map   = "CALL recupere_map('"+title_map+"')";
    sqlWidth = "CALL recup_width('"+title_map+"')";
    sqlHeigth = "CALL recup_heigth('"+title_map+"')";
    }
	
    
    public MapDAO(){
    	super();
    }

    /**
     * Recupere la map
     * @param title
     * @return map
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
            rs.close();
        }
        else
            map = "fail"; //renvois "fail" si y'a pas de map

        return map;
    }
    
    public  void readSize(String title) throws SQLException{
        conn = boulderDashBDD.getConnection(); //recup la connexion a la bdd
        st = conn.createStatement(); //initialise le statement
        
        setmap(title);

        
        map_Width = 0;
        rs = st.executeQuery(sqlWidth); //execute la requete
        if(rs.next()) { //recupere le premier resultat
            map_Width = rs.getInt("width"); //recupere le contenu de la colonne width
            System.out.println("x = "+map_Width);
            rs.close();
        }
        else{
            map_Width = 0; //renvois 0 si erreur de lecture
        }	
        
        
        map_Heigth = 0 ;
        rs = st.executeQuery(sqlHeigth); //execute la requete
        if(rs.next()) { //recupere le premier resultat
            map_Heigth = rs.getInt("heigth"); //recupere le contenu de la colonne heigth
            System.out.println("y = "+map_Heigth);
            rs.close();
        }
        else{
        map_Heigth = 0; //renvois 0 si erreur de lecture
        }
        
    }

    
    		public char[][] putMapInTable(String map){
    			char tablemap[][] = new char[map_Width][map_Heigth]; 
    			for(int y=0;y <map_Heigth;y++){
    				for(int x= 0;x<map_Width;x++){
    					char c = map.charAt((y*map_Width)+x);
    					tablemap[x][y] = c;
    					
    				}
    				
    			}
				return tablemap;
    	
    }
    
    
    
    
}
