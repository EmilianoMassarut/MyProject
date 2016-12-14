

public class PreDAO {
     private static PreDAO dao = null;
     private static Connection conn = null;
     
     private PreDAO(){
         InitialContext initContext =null;
         
         try{
         initContext = new InitialContext();
         
         Context envContext = (Context)initContext.lookup("java:/comp/env");

         DataSource ds = (DataSource)envContext.lookup("jdbc/miodb");

         conn=ds.getConnection();
         }
         catch (NamingException ex) {
             ex.printStackTrace();
         }
         catch(SQLException e){
             e.printStackTrace();
         } 
     }
     
     public static PreDAO getPreDAO(){
         if(dao==null){
             dao=new PreDAO();
         }
         return dao;
     }
     public static Connection getConnection(){
         if(conn==null){
             dao=new PreDAO();
         }
         return conn;
     }
}
