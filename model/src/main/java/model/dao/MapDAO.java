package model.dao;
/**
 * <h1>the MapDAO class</h1>
 *
 * @author Yanis Mercier
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MapDAO extends AbstractDAO {

    /**
     * attributes
     */
    private static MapDAO instance = null;
    int map_Width, map_Heigth;
    BoulderDashBDDConnector boulderDashBDD = BoulderDashBDDConnector.getInstance(); //get the instance of the connector to the database
    ResultSet rs = null;
    Statement st = null;
    Connection conn = null;
    private String sql_map, sqlWidth, sqlHeigth,sqldiamonds;
    private int amntdiamonds;
    private char tablemap[][];
    private int map_width, map_height;
    private char tab_map[][];

    /**
     * constructors with parameter name of the map to search
     * @param nomMap
     * @throws SQLException
     */
    private MapDAO(String nomMap) throws SQLException {
        super();

        String str_map;


        str_map = readMap(nomMap);
        map_width = readSize(nomMap, "width");
        map_height = readSize(nomMap, "heigth");
        tab_map = putMapInTable(str_map);
        amntdiamonds = getDiamondssss(nomMap);
    }

    /**
     * get the singleton
     *
     * @return
     */
    public static MapDAO getMapDAO() {
        if (instance == null) {

            return null;
        }
        return instance;
    }

    /**
     * Set the singleton
     *
     * @param nomMap
     * @return
     */
    public static MapDAO setMapDAO(String nomMap) {
        if (instance == null) {

            try {
                instance = new MapDAO(nomMap);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * set the map
     *
     * @param title_map
     */
    private void setmap(String title_map) {
        sql_map = "CALL recupere_map('" + title_map + "')";
        sqlWidth = "CALL recup_width('" + title_map + "')";
        sqlHeigth = "CALL recup_heigth('" + title_map + "')";
        sqldiamonds =  "CALL recup_diamonds('" + title_map + "')";
    }

    /**
     * read the string map in the database
     *
     * @param title
     * @return map
     * @throws SQLException
     */
    public String readMap(String title) throws SQLException {
        conn = boulderDashBDD.getConnection(); //get the connection to the database
        st = conn.createStatement(); //initialisation of the statement

        setmap(title);

        String map = "";

        rs = st.executeQuery(sql_map); //execute the request
        if (rs.next()) { //get the first result
            map = rs.getString("level"); //get the content of column level
            rs.close();
        } else
            map = "fail"; //send fail if there is no map

        return map;
    }

    /**
     * read the size in the database
     *
     * @param title
     * @param dim
     * @return
     * @throws SQLException
     */
    public int readSize(String title, String dim) throws SQLException {
        conn = boulderDashBDD.getConnection(); //get the instance of the connector to the database
        st = conn.createStatement(); //initialisation of the statement

        setmap(title);


        map_Width = 0;
        rs = st.executeQuery(sqlWidth); //execute the request
        if (rs.next()) { //get the first result
            map_Width = rs.getInt("width"); //get the content of column width
           if (dim.equals("width")) {
                return map_Width;
            }

            rs.close();
        } else {
            map_Width = 0; //send back 0 if there is an error of reading
        }


        map_Heigth = 0;
        rs = st.executeQuery(sqlHeigth); //execute the request
        if (rs.next()) { //get the first result
            map_Heigth = rs.getInt("heigth"); //get the content of column heigth
            if (dim.equals("heigth")) {
                return map_Heigth;
            }

            rs.close();
        } else {
            map_Heigth = 0; //send back 0 if there is an error of reading
        }
        return 0;


    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * get the amount of diamonds in DB
     * 
     * 
     * @param title
     * @return amntdiamonds 
     * @throws SQLException
     */
    public int getDiamondssss(String title) throws SQLException{
    	conn = boulderDashBDD.getConnection(); //get the connection to the database
        st = conn.createStatement(); //Initialization of the statement
        amntdiamonds = 0;
        setmap(title);

        rs = st.executeQuery(sqldiamonds); //execute the request
        if (rs.next()) { //get the first result
            amntdiamonds = rs.getInt("nb_diamonds"); //get the content of column level
            rs.close();
        }
       return amntdiamonds;
    }
    

    
    
    
    
    
    
    
    
    
    
    /**
     * transform the string map into a table
     *
     * @param map
     * @return
     */
    public char[][] putMapInTable(String map) {
        tablemap = new char[map_Width][map_Heigth];
        for (int y = 0; y < map_Heigth; y++) {
            for (int x = 0; x < map_Width; x++) {
                char c = map.charAt((y * map_Width) + x);
                tablemap[x][y] = c;
            }
        }
        return tablemap;
    }

    /**
     * getter and seter of the differents attributes
     */
    public char[][] getTablemap() {
        return tablemap;
    }

    public void setTablemap(char[][] tablemap) {
        this.tablemap = tablemap;
    }

    public int getMap_Heigth() {
        return map_Heigth;
    }

    public void setMap_Heigth(int map_Heigth) {
        this.map_Heigth = map_Heigth;
    }

    public int getMap_Width() {
        return map_Width;
    }

    public void setMap_Width(int map_Width) {
        this.map_Width = map_Width;
    }

	
	public int getdiamonds(){
		// TODO Auto-generated method stub
		int chare = amntdiamonds;
		return chare ;
	}
}

