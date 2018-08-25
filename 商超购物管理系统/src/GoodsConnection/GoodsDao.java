package GoodsConnection;

import java.sql.*;
import java.util.*;

import DBConnect.DBUtils;
import GoodsConnection.Goods;

//�������ݲ�������
public class GoodsDao {
	private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    //��ʾ��Ʒ�б�
    public List<Goods> allGoods() {
		List<Goods> list = new ArrayList<Goods>();
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from goods");
			rs = ps.executeQuery();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGID(rs.getInt(1));
				goods.setGNAME(rs.getString(2));
				goods.setGPRICE(rs.getDouble(3));
				goods.setGNUM(rs.getInt(4));
				list.add(goods);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
    
    //�����Ʒ
    public void addGoods(String name, double price, int num) throws SQLException {
		conn = DBUtils.getConnection();
		String sql = "INSERT INTO goods (gname, gpirce, gnum) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, price);
		preparedStatement.setInt(3, num);
		preparedStatement.execute();
	}
    
    //������Ʒ(�������޸�����)
    public void updateGoods(String name, double price, int num) throws SQLException {
		conn = DBUtils.getConnection();
		String sql = "UPDATE goods SET gname=?,gpirce=?,gnum=? WHERE gname=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, price);
		preparedStatement.setInt(3, num);
		preparedStatement.setString(4, name);
		preparedStatement.execute();
	}
    
    //ɾ����Ʒ
    public void delGoods(String name) throws SQLException {
		conn = DBUtils.getConnection();
		String sql = "DELETE FROM goods WHERE gname=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.execute();
	}
    
    //��ѯ��Ʒ
    public String[] searchGoods(String name) {
    	String[] infodata = new String[2];
		List<Goods> list = allGoods();
		for (Goods goods : list) {
			if (goods.getGNAME().equals(name)) {
				infodata[0] = String.valueOf(goods.getGPRICE());
				infodata[1] = String.valueOf(goods.getGNUM());
			}
		}
		return infodata;
	}
}
