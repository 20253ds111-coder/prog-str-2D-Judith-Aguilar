package com.example.demolistview.services;

import com.example.demolistview.repositores.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {
    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForList() throws IOException {
<<<<<<< HEAD
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines){
            if (line==null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);
            String name = parts[0].trim();
            String correo = parts[1].trim();
            String edad = parts[2].trim();
            result.add(name+"-"+correo+"-"+edad);
        }
        return result;
    }

    public void addPerson(String nombre, String email, String edad) throws IOException {
        validatePerson(nombre,email,edad);
        String nameSinComa = nombre.replace(",", "");
        String emailSinComa = email.replace(",", "");
        String edadSinComa = edad.replace(",","");

        repo.appendNewLine(nameSinComa+","+emailSinComa+","+edadSinComa);
    }
    private void validatePerson(String nombre, String email, String edad){
        if (nombre.isBlank() || nombre.isEmpty() || nombre.length()<3 ) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em = (email==null) ? "" : email.trim();
        if (em.isEmpty() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email no es valido");
        }
        try {
            int edadNumero = Integer.parseInt(edad);
            if (edadNumero < 18){
                throw new IllegalArgumentException("solo se aceptan mayores de edad");
            }

        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("la edad no es válida");
        }
    }
=======
        List<String> lines = repo.readAllLines(); //Recupera las lineas de archivo
        List<String> result = new ArrayList<>();//Listado de resultado con el formato deseado
        for (String line : lines){
            if (line==null || line.isBlank()) continue; //Ignora las lineas nulas

            String[] parts = line.split(",", -1);
            String name = parts[0].trim(); // Obtiee el nombre del arreglo
            String correo = parts[1].trim(); //Obtiene el correo del arreglo
            result.add(name+"-"+correo);//Se agrega a la lista de resultados con el formato
        }
        return result;
    }
>>>>>>> f904ef582e87db45768f78743f98609296d98ccb
}
