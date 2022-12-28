package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRequestSevice;

public class Assembler {
	private MemberDao memberDao;
	private MemberRequestSevice regSvc;
	private ChangePasswordService pwdSvc;;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRequestSevice(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}
	
	public MemberDao getMemberDao() {
		return this.memberDao;
	}
	public MemberRequestSevice getRegSvc() {
		return this.regSvc;
	}
	public ChangePasswordService getChangepasswordService() {
		return this.pwdSvc;
	}
	
}