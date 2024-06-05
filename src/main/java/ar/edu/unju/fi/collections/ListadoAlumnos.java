package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumnos {
	
	public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> listarAlumnos(){
		
		//Debería listar unicamente las carreras en estado true debido al borrado logico
		return alumnos;
	}
	
	public static Alumno buscarAlumnoPorLU (String LU) {
		for (Alumno a: alumnos) {
			if (a.getLU().equals(LU)){
				return a;
			}
		}
		return null;
	}
	
	public static void agregarAlumno (Alumno a) {
		a.setEstado(true);
		alumnos.add(a);
	}
	
	public static void modificarCarrera(Alumno alumnoModificado) {
		for (int i = 0 ; i < alumnos.size() ; i++) {
			Alumno carrera = alumnos.get(i);
			if (carrera.getLU().equals(alumnoModificado.getLU())) {
				alumnos.set(i, alumnoModificado);
				break;
			}
		}
	}
	
	public static void eliminarAlumno (String LU) {
		//borrado fisico
		//carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));    
		
		//borrado logico
		for (int i = 0 ; i < alumnos.size() ; i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getLU().equals(LU)) {
				alumno.setEstado(false);
				break;
			}
		}
		
	}
}
