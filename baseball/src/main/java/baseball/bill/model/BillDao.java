package baseball.bill.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class BillDao {

	@Resource
	DataSource ds;

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = null;

	public void init() {
		// TODO Auto-generated constructor stub

		try {

			//// ����� bean �� �ִ� datasource�� �����ͼ� Connection�� �޾ƿ´�
			con = ds.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//��� ������ ǥ�� �Ѽ��� ���� �й�� (��¥, ���� x)
	public BillVo firstAll() {
		init();
		System.out.println("�� dao�� allListNotDateSta() ����");
		BillVo res = new BillVo();

		try {
			sql = "select sum(deposit),sum(WITHDRAW),sum(HOME),sum(AWAY),sum(KBO),sum(we) from bill";

			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			if (rs.next()) {

				res.setDeposit(rs.getInt(1));
				res.setWithdraw(rs.getInt(2));
				res.setHome(rs.getInt(3));
				res.setAway(rs.getInt(4));
				res.setKbo(rs.getInt(5));
				res.setWe(rs.getInt(6));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return res;
	}

	
	
	//��� �ߴܺ� ����Ʈ : ��ü ���� ���� �հ�(��¥x)
	public ArrayList<BillVo> middleAll() {
		init();
		System.out.println("�� dao�� staList() ����");
		ArrayList<BillVo> res = new ArrayList<>();

		try {
			sql = "select stadium, sum(deposit),"
					+ "sum(WITHDRAW),sum(HOME),sum(AWAY),sum(KBO),sum(we)" + 
					"from bill group by stadium";

			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				BillVo vo = new BillVo();
				vo.setStadium(rs.getString(1));
				vo.setDeposit(rs.getInt(2));
				vo.setWithdraw(rs.getInt(3));
				vo.setHome(rs.getInt(4));
				vo.setAway(rs.getInt(5));
				vo.setKbo(rs.getInt(6));
				vo.setWe(rs.getInt(7));
				res.add(vo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return res;
	}
	
	
	//��� �ϴܺ� �˻�����  : ��ü ����, ��ü ��¥�� ���� �հ�
	//��ȯ �� 8��
	public ArrayList<BillVo> ssddAll() {
		init();
		System.out.println("�� dao�� staDateList() ����");
		ArrayList<BillVo> res = new ArrayList<>();
		
		try {
			sql = "select billdate,stadium,sum(deposit),sum(WITHDRAW),"
					+ "sum(HOME),sum(AWAY),sum(KBO),sum(we) "
					+ "from bill group by stadium, billdate"
					+ " order by billdate desc";
			
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				BillVo vo = new BillVo();
//				System.out.println("rs.getTimestamp(1) : "+rs.getTimestamp(1));
				vo.setBilldate(rs.getTimestamp(1));
//				System.out.println("dao.staDateList()�� ��¥ : "+vo.getBilldate());
				vo.setStadium(rs.getString(2));
				vo.setDeposit(rs.getInt(3));
				vo.setWithdraw(rs.getInt(4));
				vo.setHome(rs.getInt(5));
				vo.setAway(rs.getInt(6));
				vo.setKbo(rs.getInt(7));
				vo.setWe(rs.getInt(8));
				res.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return res;
	}
	
	
	
	//��� �ϴܺ� �˻�����  : ��ü ����, Ư�� ��¥�� ���� �հ�
	//��ȯ �� 8��
	public ArrayList<BillVo> ssdAll(String year1,String month1, String day1,
									String year2,String month2, String day2) {
		init();
		System.out.println("�� dao�� aStaTDateList() ����");
		ArrayList<BillVo> res = new ArrayList<>();
		
		try {
			sql = "select billdate, STADIUM, "
					+ "sum(deposit),sum(WITHDRAW),"
					+ "sum(HOME),sum(AWAY),sum(KBO),sum(we) from bill"
					+ " where billdate "
					+ "between ? and ? "
					+ "group by billdate, STADIUM "
					+ "order by billdate desc";

			String firstDate = year1+"/"+month1+"/"+day1;
			String lastDate = year2+"/"+month2+"/"+day2;
			
			System.out.println("�۽�Ʈ����Ʈ : "+firstDate);
			System.out.println("��Ʈ����Ʈ :"+lastDate);
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstDate);
			stmt.setString(2, lastDate);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				BillVo vo = new BillVo();
//				System.out.println("rs.getTimestamp(1) : "+rs.getTimestamp(1));
				vo.setBilldate(rs.getTimestamp(1));
//				System.out.println("dao.staDateList()�� ��¥ : "+vo.getBilldate());
				vo.setStadium(rs.getString(2));
				vo.setDeposit(rs.getInt(3));
				vo.setWithdraw(rs.getInt(4));
				vo.setHome(rs.getInt(5));
				vo.setAway(rs.getInt(6));
				vo.setKbo(rs.getInt(7));
				vo.setWe(rs.getInt(8));
				res.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return res;
	}
	
	//��� �ϴܺ� �˻�����  : ������ ������, Ư�� ��¥�� ���� �հ�
	//��ȯ �� 7��
	public ArrayList<BillVo> ddAll(String year1,String month1, String day1,
			String year2,String month2, String day2) {
		init();
		System.out.println("�� dao�� aStaTDateList() ����");
		ArrayList<BillVo> res = new ArrayList<>();
		
		try {
			sql = "select billdate, sum(deposit),sum(WITHDRAW),"
				+ "sum(HOME),sum(AWAY),sum(KBO),sum(we) from bill "
				+ "where billdate "
				+ "between ? and ? "
				+ "group by billdate "
				+ "order by billdate";
			
			String firstDate = year1+"/"+month1+"/"+day1;
			String lastDate = year2+"/"+month2+"/"+day2;
			
			System.out.println("�۽�Ʈ����Ʈ : "+firstDate);
			System.out.println("��Ʈ����Ʈ :"+lastDate);
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstDate);
			stmt.setString(2, lastDate);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				BillVo vo = new BillVo();
//				System.out.println("rs.getTimestamp(1) : "+rs.getTimestamp(1));
				vo.setBilldate(rs.getTimestamp(1));
//				System.out.println("dao.staDateList()�� ��¥ : "+vo.getBilldate());
				vo.setDeposit(rs.getInt(2));
				vo.setWithdraw(rs.getInt(3));
				vo.setHome(rs.getInt(4));
				vo.setAway(rs.getInt(5));
				vo.setKbo(rs.getInt(6));
				vo.setWe(rs.getInt(7));
				res.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return res;
	}
	
	
	//��� �ϴܺ� �˻�����  : Ư�� ���� , Ư�� ��¥�� ���� ��ȸ 
	//��ȯ �� 8��
	public ArrayList<BillVo> sdAll(String year1,String month1, String day1,
			String year2,String month2, String day2, String team) {
		init();
		System.out.println("�� dao�� aStaTDateList() ����");
		ArrayList<BillVo> res = new ArrayList<>();
		
		try {
			sql = "select BILLDATE, STADIUM, sum(deposit),sum(WITHDRAW),"
					+ "sum(HOME),sum(AWAY),sum(KBO),sum(we) "
					+ "from (select * from bill where stadium = ?) "
					+ "where BILLDATE between ? and ? "
					+ "group by BILLDATE, STADIUM "
					+ "order by billdate desc";
			
			String firstDate = year1+"/"+month1+"/"+day1;
			String lastDate = year2+"/"+month2+"/"+day2;
			
			System.out.println("�۽�Ʈ����Ʈ : "+firstDate);
			System.out.println("��Ʈ����Ʈ :"+lastDate);
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, team);
			stmt.setString(2, firstDate);
			stmt.setString(3, lastDate);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				BillVo vo = new BillVo();
//				System.out.println("rs.getTimestamp(1) : "+rs.getTimestamp(1));
				vo.setBilldate(rs.getTimestamp(1));
//				System.out.println("dao.staDateList()�� ��¥ : "+vo.getBilldate());
				vo.setStadium(rs.getString(2));
				vo.setDeposit(rs.getInt(3));
				vo.setWithdraw(rs.getInt(4));
				vo.setHome(rs.getInt(5));
				vo.setAway(rs.getInt(6));
				vo.setKbo(rs.getInt(7));
				vo.setWe(rs.getInt(8));
				res.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return res;
	}
	
	

	public void close() {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
		}
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
		}
	}
}
