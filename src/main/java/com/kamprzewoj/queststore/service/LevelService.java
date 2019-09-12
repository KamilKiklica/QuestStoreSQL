package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.Level;
import com.kamprzewoj.queststore.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("LevelService")
public class LevelService {
	private final LevelRepository levelRepository;

	@Autowired
	public LevelService(@Qualifier("LevelRepository") LevelRepository levelRepository) {
		this.levelRepository = levelRepository;
	}

	public Optional<Level> getLevelByName(String name) {
		return levelRepository.findByName(name);
	}
}
