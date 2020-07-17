package dev.mission.exec;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("lister")
public class ListerProchainesMissions implements Runnable{
	
	private MissionRepository missionRepository;
	
	/** Constructeur
	 * @param missionRepository
	 */
	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		List<Mission> missions = missionRepository.findProchainesMission();
		
		for(Mission mission : missions) {
			System.out.println(mission.getLibelle()+" : "+mission.getDateDebut()+" - "+mission.getDateFin()+", taux journalier : "+mission.getTauxJournalier());
		}
		
	}
	

}
