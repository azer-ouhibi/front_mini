package tn.esprit.springproject.Controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;


import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.services.IUniversiteService;
import tn.esprit.springproject.services.UniversitePDFExporter;

@RestController
public class UniversiteController {
	@Autowired
	IUniversiteService iu; // pour assurer le couplage faible

	// http://localhost:8088/SpringMVC/servlet/retrieveAllUniversite
	@CrossOrigin("*")
	@GetMapping("/retrieveAllUniversite")
	@ResponseBody
	public List<Universite> getDetailFactures() {
		List<Universite> listIU = iu.retrieveAllUniversite();
		return listIU;
	}

	// http://localhost:8088/SpringMVC/servlet/addUniversite
	@CrossOrigin("*")
	@PostMapping("/addUniversite")
	@ResponseBody
	public Universite addUniversite(@RequestBody Universite df) {
		Universite addIU = iu.addUniversite(df);
		return addIU;

	}

	// http://localhost:8088/SpringMVC/servlet/deleteUniversite/{id}
	@CrossOrigin("*")
	@DeleteMapping("/deleteUniversite/{id}")
	@ResponseBody
	public void deleteUniversite(@PathVariable("id") Integer id) {
		iu.deleteUniversite(id);
	}

	// http://localhost:8088/SpringMVC/servlet/updateUniversite
	@CrossOrigin("*")
	@PutMapping("/updateUniversite")
	@ResponseBody
	public Universite updateUniversite(@RequestBody Universite un) {
		return iu.updateUniversite(un);

	}

	// http://localhost:8088/SpringMVC/servlet/retrieveUniversite/{id}
	@CrossOrigin("*")
	@GetMapping("/retrieveUniversite/{id}")
	@ResponseBody
	public Universite retrieveUniversite(@PathVariable("id") Integer id) {
		Universite un = iu.retrieveUniversite(id);
		return un;
	}
	
	// http://localhost:8088/SpringMVC/servlet/assignUniversiteToDepartement/{idUni}/{idDep}
		@CrossOrigin("*")
		@PostMapping("/assignUniversiteToDepartement/{idUni}/{idDep}")
		@ResponseBody
		public void assignUniversiteToDepartement(@PathVariable("idUni") Integer idUni,@PathVariable("idDep") Integer idDep) {
			 iu.assignUniversiteToDepartement(idUni,idDep);

		}
		
		// http://localhost:8088/SpringMVC/servlet/getUniversiteByDepartementNumber/{id}
		@CrossOrigin("*")
		@GetMapping("/getUniversiteByDepartementNumber/{id}")
		@ResponseBody
		public Integer getUniversiteByDepartementNumber(@PathVariable("id") Integer id) {
			iu.retrieveUniversite(id);
			return iu.getUniversiteByDepartementNumber(id);
		}
		
		// http://localhost:8088/SpringMVC/servlet/pdf

				@GetMapping("/pdf")
			    public void exportToPDF(HttpServletResponse response ) throws DocumentException, IOException {
					response.setContentType("application/pdf/{id}");
			        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			        String currentDateTime = dateFormatter.format(new Date());
			         
			        String headerKey = "Content-Disposition";
			        String headerValue = "attachment; filename=facture_" + currentDateTime + ".pdf";
			        response.setHeader(headerKey, headerValue);
			         
			        List<Universite> listFactures = iu.retrieveAllUniversite();
			         
			        UniversitePDFExporter exporter = new UniversitePDFExporter(listFactures);
			        exporter.export(response);
			         
			    }


}
