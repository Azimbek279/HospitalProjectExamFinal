package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Patient;
import peaksoft.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientApi {

    private final PatientService patientService;

    @Autowired
    public PatientApi(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public String getAllPatient(@PathVariable Long id,Model model){
        model.addAttribute("patients",patientService.getAllPatient(id));
        model.addAttribute("hospitalId",id);
        return "/patient/patients";
    }

    @GetMapping("/{id}/newPatient")
    public String createPatient(@PathVariable("id") Long id, Model model){
        model.addAttribute("newPatient", new Patient());
        model.addAttribute("hospitalId",id);
        return "/patient/addPatient";
    }

    @PostMapping("/{id}/savePatient")
    public String savePatient(@ModelAttribute("newPatient") Patient patient,
                              @PathVariable("id") Long id){
        patientService.savePatient(patient,id);
        return "redirect:/patients" +id;
    }

    @GetMapping("/{patientId}/edit")
    public String updatePatient(@PathVariable("id") Long id,
                                @PathVariable("patientId") Long patientId,
                                Model model){
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient",patient);
//        model.addAttribute("hospitalId",patient.getHospital().getId());
        return "/patient/updatePatient";
    }

    @PostMapping("/{patientId}/update")
    public String saveUpdatePatient(@PathVariable("patientId")Long patientId,
                                    @PathVariable("id") Long id,
                                    @ModelAttribute("patient") Patient patient){
        patientService.updatePatient(patientId,patient);
        return "redirect:/{id}/patients";
    }

    @PostMapping("/{patientId}/delete")
    public String deletePatientById(@PathVariable("id") Long id,
                                    @PathVariable("patientId") Long patientId){
        patientService.deletePatientById(patientId);
        return "redirect:/{id}patients";
    }
}
