package tn.esprit.springproject.Scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.ContratRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;
import tn.esprit.springproject.services.IContratService;

import java.util.List;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class SchedulerS {
//    ContratRepository cr ;
//    EtudiantRepository er;
//    IContratService cs;
//
//    @Scheduled(cron = "* 1 * * * *")
//    public void selectAll(){
//        List<Etudiant> list= (List<Etudiant>) er.findAll();
//        for (Etudiant etudiant: list){
//            log.info(etudiant.toString());
//        }
//    }
   // @Scheduled(cron = "0 0 13 * * *")
   // public void select(){
   //     log.info(cs.retrieveAndUpdateStatusContrat());
    //}

}
