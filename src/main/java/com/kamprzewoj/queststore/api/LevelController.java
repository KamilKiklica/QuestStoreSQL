package com.kamprzewoj.queststore.api;

import com.kamprzewoj.queststore.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//@RequestMapping("/level")
@RepositoryRestController
public class LevelController {

	private final LevelService levelService;

	@Autowired
	public LevelController(@Qualifier("LevelService") LevelService levelService) {
		this.levelService = levelService;
	}

//	@GetMapping(path = "")
//	public
}
