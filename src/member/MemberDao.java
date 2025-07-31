package member;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class MemberDao extends DBConn implements MemberInterface {
	//Field
	
	
	//Constructor
	public MemberDao() {
		super();
	}
	
	//Method
	//CRUD 기능 구현 - 애플리케이션 기반의 DB연동은 기본적으로 Autocommit = true 임, 바로 적용됨!!
	/**
	 * 데이터 추가
	 * @param memberVo
	 */
	@Override
	public int insert(MemberVo member) {
		int rows = 0;
		String sql = """
				insert into member(name, email, created_at)
				values(?, ?, now())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			rows = pstmt.executeUpdate();			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	/**
	 * 전체 리스트
	 */
	@Override
	public List<MemberVo> listAll() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
				select member_id, name, email, left(created_at,10)
				from member
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
				
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 데이터 검색(id)
	 */
	@Override
	public MemberVo search(int memberId) {
		MemberVo memberVo = new MemberVo();
		String sql = """
				select member_id, name, email, created_at
				from member
				where member_id = ?;
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberVo.setMemberId(rs.getInt(1));
				memberVo.setName(rs.getString(2));
				memberVo.setEmail(rs.getString(3));
				memberVo.setCreatedAt(rs.getString(4));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberVo;
	}
	
	/**
	 * 데이터 검색(이름)
	 */
	@Override
	public List<MemberVo> search(String name) {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
				select member_id, name, email, created_at
				from member
				where name = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setMemberId(rs.getInt(1));
				memberVo.setName(rs.getString(2));
				memberVo.setEmail(rs.getString(3));
				memberVo.setCreatedAt(rs.getString(4));
				
				list.add(memberVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * 데이터 수정
	 */
	@Override
	public int update(MemberVo memberVo) {
		return 0;
	}
	
	/**
	 * 데이터 삭제
	 */
	@Override
	public int delete(int memberID) {
		return 0;
	}
	
	
}
