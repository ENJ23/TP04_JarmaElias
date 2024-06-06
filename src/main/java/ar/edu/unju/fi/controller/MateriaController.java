package ar.edu.unju.fi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;

public class MateriaController {

	
	Materia nuevaMateria = new Materia();
	@GetMapping ("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formMateria");
		//Agrega el Objeto
		modelView.addObject("nuevaMateria", nuevaMateria);
		
		return modelView;
	}
	
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
		
		//guardar la carrera en la lista
		
		ListadoMaterias.agregarMateria(materiaParaGuardar);
		//Mostrar Listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias" , ListadoMaterias.listarMaterias());
		return modelView;
	}
	
	@GetMapping("/eliminarMateria/{codigo}")
	public ModelAndView borrarMateriaDelListado (@PathVariable (name="codigo") String codigo) {
		
		ListadoMaterias.eliminarMateria(codigo);
		
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoDeMaterias", ListadoMaterias.listarMaterias());
		
		return modelView;
	}
	
}
