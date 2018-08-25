package SalesmanConnection;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import DBConnect.DBUtils;
import GoodsConnection.Goods;
import GoodsConnection.GoodsDao;

//�������ݲ�������
public class SalesmanDao {
	private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    GoodsDao goodsDao = new GoodsDao();
    //�ۻ�Ա�б�
    public List<Salesman> allSalesman() {
		List<Salesman> list = new ArrayList<Salesman>();
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from salesman");
			rs = ps.executeQuery();
			while (rs.next()) {
				Salesman salesman = new Salesman();
				salesman.setSID(rs.getInt(1));
				salesman.setSNAME(rs.getString(2));
				salesman.setSPASSWORD(rs.getString(3));
				list.add(salesman);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
    
    //��¼��֤(�������û��������ڵģ������׳��쳣��������ֹ)
    public String Login(String sname) {
    	String pw = null;
    	List<Salesman> list = allSalesman();
    	for (Salesman salesman : list) {
			if (salesman.getSNAME().equals(sname)) {
				pw = salesman.getSPASSWORD();
			}
		}
    	return pw;
    }
    
    //��ȡ���빺�ﳵ����Ʒ�ĵ���
    public int searchGoods(String name) {
    	int infodata = 0;
		List<Goods> list = goodsDao.allGoods();
		for (Goods goods : list) {
			if (goods.getGNAME().equals(name)) {
				infodata = (int)goods.getGPRICE();
			}
		}
		return infodata;
	}
}
