package baseball.player.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import baseball.player.model.PlayerVo;

@Component
public class PlayerDao {
	// 페이지 리로딩시 셀렉팅 목록을 유지하기 위한 전역변수
	private static String year = "";
	private static String month = "";
	private static String date = "";
	private static String team = "구단선택";
	private static String position = "";
	private static String playerNameNo = "";
	private static String playerId = "";
	@Resource
	DataSource ds;

	String url = "localhost:1521:xe";
	String id = "java";
	String pw = "java";

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = null;

	public PlayerDao() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@" + url, id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() {
		// TODO Auto-generated constructor stub

		try {

			//// 등록한 bean 에 있는 datasource를 가져와서 Connection을 받아온다
			con = ds.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<PlayerVo> getteam(HttpServletRequest request) {// HttpServletRequest request

		ArrayList list = new ArrayList();
		  String teamStr = "doosan,samsung,nexen,kia,lg,lotte,hanhwa,sk,kt";
		  String[] arr = teamStr.split(",");
		  for(int i = 0; i < arr.length; i++){
		   list.add(arr[i]);
		  }
		  return list;
		 }
		

	public ArrayList getposition(HttpServletRequest request) {
		ArrayList list = new ArrayList();
		  String positionStr = "";
		  String teamKey = request.getParameter("teamId");
		  if(teamKey != null){
		  // if(teamKey.equals("3")){
		    positionStr = "pitcher,infielder,outfielder";
		   }else{
		    return list;
		   }
		   String[] arr = positionStr.split(",");
		   for(int i = 0; i < arr.length; i++){
		    list.add(arr[i]);
		  }
		  return list;
		 }
		
	public ArrayList getplayerNameNo(HttpServletRequest request) {
		PlayerVo res = null;
		ArrayList qq = new ArrayList();
		try {
			sql = "select * from player where teamId = ? and position LIKE ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, request.getParameter("teamId"));
			stmt.setString(2, "%"+request.getParameter("position")+"%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				res = new PlayerVo();

				res.setPlayerName(rs.getString("playerName"));
				res.setPlayerId(rs.getInt("playerId"));
				qq.add(res.getPlayerName()+" ["+res.getPlayerId()+"] ");/**/
				//qq.add(res.getPlayerId());

			} /*else {
				return qq;
			}
*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { close(); }
			 */

		return qq;
	}

	
	
	/*public String getYeardropdown(HttpServletRequest request) {
		if (request.getParameter("yeardropdown") != null) {
			year = request.getParameter("yeardropdown");
		} else {
			year = "구단선택";
		}
		return year;
	}
	public String getMonthdropdown(HttpServletRequest request) {
		if (request.getParameter("monthdropdown") != null) {
			month = request.getParameter("monthdropdown");
		} else {
			month = "구단선택";
		}
		return month;
	}
	public String getDaydropdown(HttpServletRequest request) {
		if (request.getParameter("daydropdown") != null) {
			date = request.getParameter("daydropdown");
		} else {
			date = "구단선택";
		}
		return date;
	}*/
	public String getteamState(HttpServletRequest request) {
		if (request.getParameter("teamId") != null) {
			team = request.getParameter("teamId");
		} else {
			team = "구단선택";
		}
		return team;
	}

	public String getpositionState(HttpServletRequest request) {
		if (request.getParameter("position") != null) {
			position = request.getParameter("position");
		} else {
			position = "";
		}
		return position;
	}

	public String getplayerNameNoState(HttpServletRequest request) {
		if (request.getParameter("playerNameNo") != null) {
			//한글만 추출
			playerNameNo = request.getParameter("playerNameNo").replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]", "");
			//영문만 추출
			//playerNameNo = request.getParameter("playerNameNo");/*.replaceAll("[^a-zA-Z]", "")*/
		} else {
			playerNameNo = "";
		}
		return playerNameNo;
	}
	
	public String getplayerNameNoState1(HttpServletRequest request) {
		if (request.getParameter("playerNameNo") != null) {
			playerId = request.getParameter("playerNameNo").replaceAll("[^0-9]", "");
		} else {
			playerId = "";
		}
		return playerId;
	}
	public String getplayerNameNoState2(HttpServletRequest request) {
		if (request.getParameter("playerNameNo") != null) {
			//한글만 추출
			playerNameNo = request.getParameter("playerNameNo").replaceAll("[^\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F]", "");
			//영문만 추출
			//playerNameNo = request.getParameter("playerNameNo").replaceAll("[^a-zA-Z]", "");
		} else {
			playerNameNo = "";
		}
		return playerNameNo;
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