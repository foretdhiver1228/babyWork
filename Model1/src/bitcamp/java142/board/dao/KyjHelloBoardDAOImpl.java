package bitcamp.java142.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bitcamp.java142.board.common.KyjChaeBunClass;
import bitcamp.java142.board.common.KyjConnProperty;
import bitcamp.java142.board.sql.KyjHelloBoardSqlQueryMap;
import bitcamp.java142.board.vo.KyjHelloBoardVO;

public class KyjHelloBoardDAOImpl implements KyjHelloBoardDAO {

	@Override
	public int insertKyjHelloBoard(KyjHelloBoardVO _kvo) {
		// TODO Auto-generated method stub
		System.out.println("[log] KyjHelloBoardDAOImpl.insertKyjHelloBoard() ���� >>> ");
		System.out.println("[log] _kvo �������� �ּҰ� >>> : " + _kvo);
		System.out.println("[log] �Է� �� ���� ��� >>> : " + _kvo.getKsubject()
													  + _kvo.getKname()
													  + _kvo.getKpw()
													  + _kvo.getKmemo());
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		try{
			con = KyjConnProperty.getConnection();
			System.out.println("[log] con.getAutuCommit >>> : " + con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("[log] con.getAutuCommit >>> : " + con.getAutoCommit());
			pstmt = con.prepareStatement(KyjHelloBoardSqlQueryMap.getInsertQuery());
			
			pstmt.setString(1, KyjChaeBunClass.bFormat());
			pstmt.setString(2, _kvo.getKsubject());
			pstmt.setString(3, _kvo.getKname());
			pstmt.setString(4, _kvo.getKpw());
			pstmt.setString(5, _kvo.getKmemo());
			pstmt.setString(6, _kvo.getKdeleteyn());
			nCnt = pstmt.executeUpdate();
			
			boolean b = !con.getAutoCommit();
			System.out.println("[log] boolean Ȯ�� >>> : " + b);
			if(!con.getAutoCommit())con.commit();
			System.out.println("[log] insert �� ���� ���� Ȯ�� >>> : " + nCnt);
		}catch(Exception e){
			System.out.println("[error] ������ >>> : " + e.getMessage());
		}finally{
			KyjConnProperty.conClose(con, pstmt);
		}
//		if(nCnt==0) return 0;
		System.out.println("[log] KyjHelloBoardDAOImpl.insertKyjHelloBoard() ���� <<<  ");
		return nCnt;
	}
	
	
	@Override
	public int updateKyjHelloBoard(KyjHelloBoardVO _kvo) {
		// TODO Auto-generated method stub
		System.out.println("[log] KyjHelloBoardDAOImpl.updateKyjHelloBoard() ���� >>> " );
		System.out.println("[log] _kvo �������� �ּҰ� : " + _kvo);
		System.out.println("[log] �Է��� ���� ��� >>> : " + _kvo.getKsubject() + " " + _kvo.getKmemo());
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		try{
			con = KyjConnProperty.getConnection();
			System.out.println("[log] con.getAutuCommit >>> : " + con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("[log] con.getAutuCommit >>> : " + con.getAutoCommit());
			pstmt = con.prepareStatement(KyjHelloBoardSqlQueryMap.getUpdateQuery());
			pstmt.setString(1, _kvo.getKsubject());
			pstmt.setString(2, _kvo.getKmemo());
			pstmt.setString(3, _kvo.getKno());
			nCnt = pstmt.executeUpdate();
			

			boolean b = !con.getAutoCommit();
			System.out.println("[log] boolean Ȯ�� >>> : " + b);
			if(!con.getAutoCommit())con.commit();
			System.out.println("[log] update �� ���� ���� Ȯ�� >>> : " + nCnt);
			KyjConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("[log] ������ >>> : " + e.getMessage());
		}finally{
			KyjConnProperty.conClose(con, pstmt);
		}
		System.out.println("[log] KyjHelloBoardDAOImpl.updateKyjHelloBoard() ���� <<<  " );

		return nCnt;
	}

	@Override
	public int deleteKyjHelloBoard(KyjHelloBoardVO _kvo) {
		// TODO Auto-generated method stub
		System.out.println("[log] KyjHelloBoardDAOImpl.deleteKyjHelloBoard() ���� >>> " );
		System.out.println("[log] _kvo �������� �ּҰ� : " + _kvo);		
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		try{
			con = KyjConnProperty.getConnection();
			System.out.println("[log] con.getAutuCommit >>> : " + con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("[log] con.getAutuCommit >>> : " + con.getAutoCommit());
			pstmt = con.prepareStatement(KyjHelloBoardSqlQueryMap.getDeleteQuery());
			pstmt.setString(1, _kvo.getKno());
			
			nCnt = pstmt.executeUpdate();
			

			boolean b = !con.getAutoCommit();
			System.out.println("[log] boolean Ȯ�� >>> : " + b);
			if(!con.getAutoCommit())con.commit();
			System.out.println("[log] update �� ���� ���� Ȯ�� >>> : " + nCnt);
			KyjConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("[log] ������ >>> : " + e.getMessage());
		}finally{
			KyjConnProperty.conClose(con, pstmt);
		}
		System.out.println("[log] KyjHelloBoardDAOImpl.deleteKyjHelloBoard() ���� <<< " );

		return nCnt;
	}

	@Override
	public ArrayList<KyjHelloBoardVO> selectKyjHelloBoard() {
		// TODO Auto-generated method stub
		System.out.println("[log] KyjHelloBoardDAOImpl.selectKyjHelloBoard() ���� >>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<KyjHelloBoardVO> aList = null;
		KyjHelloBoardVO kvo = null;

		try{
			con = KyjConnProperty.getConnection();
			System.out.println("[log] con >>> : " + con);
			pstmt = con.prepareStatement(KyjHelloBoardSqlQueryMap.getSelectQuery());
			rsRs = pstmt.executeQuery();
			System.out.println("[log] rsRs >>> : " + rsRs);
			
			if(rsRs!=null){
				aList = new ArrayList<KyjHelloBoardVO>();
				while(rsRs.next()){
					kvo = new KyjHelloBoardVO();
					kvo.setKno(rsRs.getString(1));
					kvo.setKsubject(rsRs.getString(2));
					kvo.setKname(rsRs.getString(3));
					kvo.setKpw(rsRs.getString(4));
					kvo.setKmemo(rsRs.getString(5));
					kvo.setKdeleteyn(rsRs.getString(6));
					kvo.setKinsertdate(rsRs.getString(7));
					kvo.setKupdatedate(rsRs.getString(8));
					aList.add(kvo);
					System.out.println("[log] aList >>> : " + aList);
				}
				System.out.println("[log] aList.size() >>> : " + aList.size());
			}
		}catch(Exception e){
			System.out.println("[log] ������ >>> : " + e.getMessage());
		}finally{
			KyjConnProperty.conClose(con, pstmt, rsRs);
		}
		System.out.println("[log] KyjHelloBoardDAOImpl.selectKyjHelloBoard() ���� <<< ");

		return aList;
	}


	@Override
	public ArrayList<KyjHelloBoardVO> selectKyjBoard(KyjHelloBoardVO _kvo) {
		// TODO Auto-generated method stub
		System.out.println("[log] KyjHelloBoardDAOImpl.selectKyjBoard() ���� >>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<KyjHelloBoardVO> aList = null;
		KyjHelloBoardVO kvo = null;
		
		try{
			con = KyjConnProperty.getConnection();
			System.out.println("(log) con >>> : " + con);
			pstmt = con.prepareStatement(KyjHelloBoardSqlQueryMap.getSearchQuery());
			System.out.println("\n[log] KyjHelloBoardSqlQueryMap.getSearchQuery() ������ Ȯ�� >>> ");
			System.out.println(KyjHelloBoardSqlQueryMap.getSearchQuery());
			pstmt.setString(1, _kvo.getKno());
			System.out.println("[log] _kvo >>> : " + _kvo.getKname());
			rsRs = pstmt.executeQuery();
			System.out.println("[log] rsRs >>> : " + rsRs);
			
			boolean bool = rsRs!=null;
			System.out.println("[log] KyjHelloBoardSqlQueryMap.getSearchQuery() ������ ���� Ȯ�� >>> " + bool);
			
			if(rsRs!=null){
				aList = new ArrayList<KyjHelloBoardVO>();
				while(rsRs.next()){
					kvo = new KyjHelloBoardVO();
					kvo.setKno(rsRs.getString(1));
					kvo.setKsubject(rsRs.getString(2));
					kvo.setKname(rsRs.getString(3));
					kvo.setKpw(rsRs.getString(4));
					kvo.setKmemo(rsRs.getString(5));
					kvo.setKdeleteyn(rsRs.getString(6));
					kvo.setKinsertdate(rsRs.getString(7));
					kvo.setKupdatedate(rsRs.getString(8));
					aList.add(kvo);
					System.out.println("[log] aList >>> : " + aList);
				}
				System.out.println("[log] aList.size() >>> : " + aList.size());
			}else{
				System.out.println("�˻� ����");
			}
		}catch(Exception e){
			System.out.println("[log] ������ >>> : " + e.getMessage());
		}finally{
			KyjConnProperty.conClose(con, pstmt, rsRs);
		}
		System.out.println("[log] KyjHelloBoardDAOImpl.selectKyjBoard() ���� <<< ");
		return aList;
	}

}