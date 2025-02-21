package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	
	@Autowired
	Carrera nuevaCarrera = new Carrera();
	@GetMapping ("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formCarrera");
		//Agrega el Objeto
		modelView.addObject("nuevaCarrera", nuevaCarrera);
		modelView.addObject("flag", false);
		return modelView;
	}
	
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraParaGuardar) {
		
		//guardar la carrera en la lista
		
		ListadoCarreras.agregarCarrera(carreraParaGuardar);
		//Mostrar Listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras" , ListadoCarreras.listarCarreras());
		return modelView;
	}
	
	@GetMapping("/eliminarCarrera/{codigo}")
	public ModelAndView borrarCarreraDelListado (@PathVariable (name="codigo") String codigo) {
		
		ListadoCarreras.eliminarCarrera(codigo);
		
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoDeCarreras", ListadoCarreras.listarCarreras());
		
		return modelView;
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView getFormModificarCarrera(@PathVariable(name="codigo") String codigo) {
		Carrera nuevaCarrera = ListadoCarreras.buscarCarreraPorCodigo(codigo);
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", nuevaCarrera);
		modelView.addObject("flag", true);
		return modelView;
	}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraModificada) {
		ListadoCarreras.modificarCarrera(carreraModificada);
		carreraModificada.setEstado(true);
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		return modelView;
	}
	
	
}
