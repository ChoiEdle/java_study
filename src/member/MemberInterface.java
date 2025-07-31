package member;

import java.util.List;

public interface MemberInterface {
	public int insert(MemberVo memberVo);
	public List<MemberVo> listAll();
	public MemberVo search(int memberId);
	public List<MemberVo> search(String name);
	public int update(MemberVo memberVo);
	public int delete(int memberID);
	
}
