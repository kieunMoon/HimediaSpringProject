package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRequestSevice;

@Configuration  //스프링 설정 클래스를 의미
public class AppCtx {
	
	@Bean		//해당 메서드가 생성한 객체를 스프링 빈으로 설정
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	@Bean
	public MemberRequestSevice memberRegSvc() {
		return new MemberRequestSevice(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
		
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberPrinter(memberPrinter());
		infoPrinter.setMemberDao(memberDao());
		return infoPrinter;
	}
	
	
	
}
