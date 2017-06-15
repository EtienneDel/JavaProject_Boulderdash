package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MapDAO extends AbstractDAO{

	
	private  String sql_map;
	ResultSet rs = null;
	Statement st = null;
	
	private  void setmap(String title_map){
    sql_map   = "{CALL recupere_map('"+title_map+"')}";
    
    }
	
    
    public MapDAO(){
    	super();
    }
    
    /** recupere la map . */
    public  String readMap(String title) throws SQLException{
    	String titre = title;
    	System.out.println(titre);
        setmap(title);
        System.out.println(sql_map);
        String map = "";
        
        rs = st.executeQuery(sql_map);
        
       
            map = rs.getString("level");
            System.out.println(map);

            
        
        
		return map;
        
    }

    public int readSize(){
        return 0;
    }
}
