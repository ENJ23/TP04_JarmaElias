package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	@GetMapping ("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		//Agrega el Objeto
		modelView.addObject("nuevaAlumno", nuevoAlumno);
		
		return modelView;
	}
	
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {
		
		//guardar la carrera en la lista
		
		ListadoAlumnos.agregarAlumno(alumnoParaGuardar);
		//Mostrar Listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos" , ListadoAlumnos.listarAlumnos());
		return modelView;
	}
	
	@GetMapping("/eliminarAlumno/{LU}")
	public ModelAndView borrarAlumnoDelListado (@PathVariable (name="LU") String LU) {
		
		ListadoAlumnos.eliminarAlumno(LU);
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoDeAlumnos", ListadoAlumnos.listarAlumnos());
		
		return modelView;
	}
}
