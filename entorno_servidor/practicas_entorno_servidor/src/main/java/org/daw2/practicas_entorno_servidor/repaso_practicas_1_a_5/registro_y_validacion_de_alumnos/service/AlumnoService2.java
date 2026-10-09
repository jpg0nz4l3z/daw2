package org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.registro_y_validacion_de_alumnos.service;

import org.daw2.practicas_entorno_servidor.repaso_practicas_1_a_5.registro_y_validacion_de_alumnos.dto.AlumnoDTO2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AlumnoService2 {
    private List<AlumnoDTO2> alumnos;

    public AlumnoService2(){
        alumnos = new ArrayList<>(Arrays.asList(
                new AlumnoDTO2(1, "nombre-1", "email-1@gmail.com", 18, 4.5, "ANC1234"),
                new AlumnoDTO2(2, "nombre-2", "email-2@gmail.com", 17, 4.4, "ABN1234"),
                new AlumnoDTO2(3, "nombre-3", "email-3@gmail.com", 19, 5.0, "NBC1234")
        ));
    }

    public List<AlumnoDTO2> listAll(){
        return alumnos;
    }

    public String matricularAlumno(AlumnoDTO2 alumno){
        alumnos.add(alumno);
        return String.format("Alumno con id %d matriculado exitosamente", alumno.getId());
    }

    public List<AlumnoDTO2> obtenerAlumnosAprobados(){
        return alumnos.stream().filter(a -> a.getNotaMedia() >= 5.0).toList();
    }
}
