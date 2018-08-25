package DBConnect;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

import GoodsConnection.Goods;

//�������ݿ�Ĵ���
public class DBUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/market?serverTimezone=GMT&useSSL=false";
	private static final String NAME = "root";
	private static final String PASSWORD = "songjie";
	private static Connection conn=null;
	//��̬����飨�������������������ݿ���뾲̬���У�
    static{
        try {
            //1.������������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.������ݿ������
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //�����ṩһ����������ȡ���ݿ�����
    public static Connection getConnection(){
        return conn;
    }
    
  //�رշ���
    public  static void close(ResultSet rs, Statement stat, Connection conn) throws SQLException{
        if(rs!=null){
        	rs.close();
        }
        if(stat!=null){
            stat.close();
        }
        if(conn!=null){
            conn.close();
        }
    }
}
