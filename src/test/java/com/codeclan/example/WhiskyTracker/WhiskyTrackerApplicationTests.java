package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskiesByYear() {
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(2018);
		assertEquals("The Glendronach Revival", found.get(0).getName());
		assertEquals(2, found.size());

	}

	@Test
	public void findDistilleriesByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Highland");
		assertEquals("Glendronach", found.get(0).getName());
	}

	@Test
	public void findWhiskiesFromDistilleryByAge() {
		List<Whisky> found = whiskyRepository.findWhiskiesFromDistilleryByAge(1L, 15);
		assertEquals("The Glendronach Revival", found.get(0).getName());

	}

	@Test
	public void findWhiskiesFromRegion() {
		List<Whisky> found = whiskyRepository.findWhiskiesFromRegion("Highland");
		assertEquals(2, found.size());
	}


	@Test
	public void findDistilleriesWithWiskiesAged() {
		List<Distillery> found = distilleryRepository.findDistilleriesWithWiskiesAged(12);
		assertEquals(2, found.size()) ;
	}


}
