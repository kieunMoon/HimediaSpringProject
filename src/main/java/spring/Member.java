package spring;

import java.time.LocalDateTime;

public class Member {
		
		private long id;
		private String email;
		private String password;
		private String name;
		private LocalDateTime registerDateTime;
		public Member(String email, String password, String name, LocalDateTime registerDateTime) {
			super();
			this.email = email;
			this.password = password;
			this.name = name;
			this.registerDateTime = registerDateTime;
		}
		long getId() {
			return id;
		}
		void setId(long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public String getPassword() {
			return password;
		}
		public String getName() {
			return name;
		}
		public LocalDateTime getRegisterDateTime() {
			return registerDateTime;
		}
		
		public void changePassword(String oldPassword, String newPassword) {
				if(this.password.equals(oldPassword) ) {
					throw new WrongIdPasswordException();
				}
				this.password = newPassword;
		
		}
		
}
