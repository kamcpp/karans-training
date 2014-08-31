package co.karans.phonebook;

import co.karans.phonebook.domain.dao.membership.RoleDAO;
import co.karans.phonebook.domain.entity.membership.Role;

public class PhoneBookApplication {
	public static void main(String[] args) {

		RoleDAO dao = new RoleDAO();
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		dao.save(role);

		System.out.println("Done.");
	}
}
