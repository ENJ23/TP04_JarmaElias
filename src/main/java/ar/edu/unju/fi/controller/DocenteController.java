package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;
@Controller
public class DocenteController {
	
	@Autowired
	Docente nuevoDocente = new Docente();
	@GetMapping ("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formDocente");
		//Agrega el Objeto
		modelView.addObject("nuevoDocente", nuevoDocente);
		
		return modelView;
	}
	
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente docenteParaGuardar) {
		
		//guardar la carrera en la lista
		
		ListadoDocentes.agregarDocente(docenteParaGuardar);
		//Mostrar Listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes" , ListadoDocentes.listarDocentes());
		return modelView;
	}
	
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView borrarDocenteDelListado (@PathVariable (name="legajo") String legajo) {
		
		ListadoDocentes.eliminarDocente(legajo);
		
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoDeDocentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
}
