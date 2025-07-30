package chapter20_JDBC;

import java.util.List;

public class TrgMemberTest {

	public static void main(String[] args) {
		TrgMemberDao dao = new TrgMemberDao();
		TrgMemberVo vo = new TrgMemberVo();
		String dmid = "M0005";
		
		vo.setMid("M0005");
		vo.setName("송길동");
		
		if(dao.insert(vo)) {
			List<TrgMemberVo> list = dao.getListAll();
			list.forEach((trg) -> {
				System.out.print(trg.getRno() + "\t");
				System.out.print(trg.getMid() + "\t");
				System.out.print(trg.getName() + "\t");
				System.out.print(trg.getMdate() + "\n");
			});
		}
		
		if(dao.delete(dmid)) {
			List<TrgMemberVo> list = dao.getListAll();
			list.forEach((trg) -> {
				System.out.print(trg.getRno() + "\t");
				System.out.print(trg.getMid() + "\t");
				System.out.print(trg.getName() + "\t");
				System.out.print(trg.getMdate() + "\n");
			});
		}
		
	}//main

}
