package dev.mission.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.mission.entite.Mission;

@DataJpaTest
public class MissionsRepositoryTests {
	
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	MissionRepository missionRepository;
	
	@BeforeEach
	void setUp () {
		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal("125.50"));
		mission.setDateDebut(LocalDate.of(2019, 10, 5));
		mission.setDateFin(LocalDate.of(2019, 10, 25));
		this.missionRepository.save(mission);
		
		Mission mission2 = new Mission();
		mission2.setLibelle("Mission 2");
		mission2.setTauxJournalier(new BigDecimal("115.50"));
		mission2.setDateDebut(LocalDate.of(2020, 10, 15));
		mission2.setDateFin(LocalDate.of(2020, 10, 25));
		this.missionRepository.save(mission2);
		
		Mission mission3 = new Mission();
		mission3.setLibelle("Mission 3");
		mission3.setTauxJournalier(new BigDecimal("100.50"));
		mission3.setDateDebut(LocalDate.of(2020, 11, 15));
		mission3.setDateFin(LocalDate.of(2020, 11, 30));
		this.missionRepository.save(mission3);
		
		Mission mission4 = new Mission();
		mission4.setLibelle("Mission 4");
		mission4.setTauxJournalier(new BigDecimal("115.50"));
		mission4.setDateDebut(LocalDate.of(2020, 10, 17));
		mission4.setDateFin(LocalDate.of(2020, 11, 2));
		this.missionRepository.save(mission4);
	}
	
	@Test
	void findByDateDebutGreaterThanEqual() {
		List<Mission> missions = missionRepository.findProchainesMission();
		assertThat(missions).size().isEqualTo(3);
	}
	
	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {
		List<Mission> missions = missionRepository.findProchainesMissionParTJM(new BigDecimal(110));
		assertThat(missions).size().isEqualTo(2);
	}

}
