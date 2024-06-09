package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {

	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping ("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formMateria");
		//Agrega el Objeto
		modelView.addObject("nuevaMateria", nuevaMateria);
		modelView.addObject("listadoDocente", ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarrera", ListadoCarreras.listarCarreras());	
		return modelView;
	}
	
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaParaGuardar) {
		
		//guardar la carrera en la lista
		materiaParaGuardar.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaParaGuardar.getDocente().getLegajo()));
		materiaParaGuardar.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaParaGuardar.getCarrera().getCodigo()));
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
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView getFormModificarCarrera(@PathVariable(name="codigo") String codigo) {
		
		Materia materiaAModificar = ListadoMaterias.buscarMateriaPorCodigo(codigo);
		
		ModelAndView modelView = new ModelAndView("formMateria");
		
		modelView.addObject("nuevaMateria", materiaAModificar);	
		modelView.addObject("listadoDocente", ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarrera", ListadoCarreras.listarCarreras());	
		modelView.addObject("flag", true);
		
		return modelView;
	}
	
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
		//modificar el docente
				materiaModificada.setDocente(ListadoDocentes.buscarDocentePorLegajo(materiaModificada.getDocente().getLegajo()));
				materiaModificada.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaModificada.getCarrera().getCodigo()));
				ListadoMaterias.modificarMateria(materiaModificada);
				
				//mostrar el listado
				ModelAndView modelView = new ModelAndView("listaDeMaterias");
				modelView.addObject("listadoMateria", ListadoMaterias.listarMaterias());	
				return modelView;	
	}
	
}
