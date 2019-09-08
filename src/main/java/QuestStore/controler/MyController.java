package QuestStore.controler;

import QuestStore.model.User;
import QuestStore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyController {

	@Autowired
	private IUserService userService;

	@GetMapping("/showUsers")
	public String findUsers(Model model) {
		List<User> users = (List<User>) userService.findAll();
		model.addAttribute("users", users);
		System.out.println(users);
		System.out.println("----------------------------------------------------------------");
		return "showUsers";
	}
}
