package spring;

public class MemberInfoPrinter {
	
	//회원 정보를 조회해서  => MemberDao
	//출력하는 기능을 구현  => MemberPrinter
	
	//의존 객체를 필드로 추가
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	//setter method 를 통해서 의존 객체를 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("일치하는 회원이 없다,,,,,,,");
			return;
		}
		
		printer.print(member);
	}
	
}
