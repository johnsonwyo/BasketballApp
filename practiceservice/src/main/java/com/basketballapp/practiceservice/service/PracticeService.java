package com.basketballapp.practiceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.basketballapp.practiceservice.config.ServiceConfig;
import com.basketballapp.practiceservice.model.Practice;
import com.basketballapp.practiceservice.repository.PracticeRepository;

@Service
public class PracticeService {

	@Autowired
	MessageSource messages;

	@Autowired
	private PracticeRepository practiceRepository;

	@Autowired
	ServiceConfig config;

	public Practice getPractice(String date, int grade) {
		Practice practice = practiceRepository.findByDateAndGrade(date, grade);
		if (null == practice) {
			throw new IllegalArgumentException(
					String.format(messages.getMessage("practice.search.error.message", null, null), date, grade));
		}
		return practice;
	}

	public Practice createPractice(Practice practice) {
		practiceRepository.save(practice);

		return practice;
	}

	public Practice updatePractice(Practice practice) {
		this.deletePractice(practice.getDate(), practice.getGrade());
		practiceRepository.save(practice);

		return practice;
	}

	public String deletePractice(String date, int grade) {
		Practice practice = practiceRepository.findByDateAndGrade(date, grade);
		practiceRepository.delete(practice);
		return "practice: " + date + " " + grade + " was deleted.";

	}
}
