package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	
	public static List<Docente> docentes = new ArrayList<Docente>();
	
	public static List<Docente> listarDocentes(){
		
		//Debería listar unicamente las carreras en estado true debido al borrado logico
		return docentes;
	}
	
	public static Docente buscarDocentePorLegajo (String legajo) {
		for (Docente d: docentes) {
			if (d.getLegajo().equals(legajo)){
				return d;
			}
		}
		return null;
	}
	
	public static void agregarDocente (Docente c) {
		c.setEstado(true);
		docentes.add(c);
	}
	
	public static void modificarDocente(Docente docenteModificado) {
		for (int i = 0 ; i < docentes.size() ; i++) {
			Docente docente = docentes.get(i);
			if (docente.getLegajo().equals(docenteModificado.getLegajo())) {
				docentes.set(i, docenteModificado);
				break;
			}
		}
	}
	
	public static void eliminarDocente (String codigo) {
		//borrado fisico
		//carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));    
		
		//borrado logico
		for (int i = 0 ; i < docentes.size() ; i++) {
			Docente docente = docentes.get(i);
			if (docente.getLegajo().equals(codigo)) {
				docente.setEstado(false);;
				break;
			}
		}
		
	}
}
