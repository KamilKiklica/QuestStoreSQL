package QuestStore.service;

import java.util.List;

import QuestStore.model.User;
import QuestStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}
}
