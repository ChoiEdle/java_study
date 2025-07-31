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
	public int insert(MemberVo memberVo) {
		return 0;
	}
	
	/**
	 * 전체 리스트
	 */
	@Override
	public List<MemberVo> listAll() {
		return new ArrayList<MemberVo>();
	}
	
	/**
	 * 데이터 검색(id)
	 */
	@Override
	public MemberVo search(int memberId) {
		return new MemberVo();
	}
	
	/**
	 * 데이터 검색(이름)
	 */
	@Override
	public List<MemberVo> search(String name) {
		return new ArrayList<MemberVo>();
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
