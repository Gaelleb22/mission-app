package dev.mission.exec;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("listerParTJM")
public class ListerProchainesMissionParTJM implements Runnable{
	
	private MissionRepository missionRepository;

	/** Constructeur
	 * @param missionRepository
	 */
	public ListerProchainesMissionParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Saisissez un taux journalier");
		List<Mission> missions = missionRepository.findProchainesMissionParTJM(new BigDecimal(scanner.next()));
		
		for(Mission mission : missions) {
			System.out.println(mission.getLibelle()+" : "+mission.getDateDebut()+" - "+mission.getDateFin()+", taux journalier : "+mission.getTauxJournalier());
		}
		
	}
	
	

}
