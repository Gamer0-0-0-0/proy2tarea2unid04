package com.ejemplos.debugger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DebuggingExample {
	public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        
        JMGC: Se añade una colección y se intercambia todo lo relacionado de names 
        a coleccionString.
        Collection<String> coleccionString = names;
        
        coleccionString.add("Alice");
        coleccionString.add("Bob");
        coleccionString.add("Charlie");
        coleccionString.add("Diana");
        coleccionString.add("Juan");

        DebuggingExample example = new DebuggingExample();
        example.printNames(coleccionString);
        
        int totalLetters = example.calculateTotalLetters(coleccionString);
        System.out.println("Total de letras: " + totalLetters);

        double averageLetters = example.calculateAverageLetters(coleccionString, totalLetters);
        System.out.println("Promedio de letras por nombre: " + averageLetters);

        example.addName(coleccionString, "Edward");
        example.removeName(coleccionString, "Alice");
        example.printNames(coleccionString);
    }

	/**
     * Imprime todos los nombres
     *
     * @param "Collection_<_String_>_coleccionString" es la colección que contiene los nombres
     * @param for para poder pasar por todas las lienas de la colección
     * @return imprime con system.out.print todos los nombres de dentro de la colección
     */
    public void printNames(Collection<String> coleccionString) {    	
    	for (String name :  coleccionString) {
            System.out.println(name); // Use Step Over here
        }
    }

    public void addName(Collection<String> coleccionString, String nameToAdd) {
    	coleccionString.add(nameToAdd); // Use Step Into here
        System.out.println("Added name: " + nameToAdd);
    }

    public boolean removeName(Collection<String> coleccionString, String nameToRemove) {
        boolean result = coleccionString.remove(nameToRemove); // Set a breakpoint and use Step Return here
        System.out.println("Removed name: " + nameToRemove);
        return result;
    }
    public int calculateTotalLetters(Collection<String> coleccionString) {
        int total = 0;
        for (String name : coleccionString) {
            total += name.length(); // Use Step Into here and check the 'total' variable
        }
        return total;
    }

    public double calculateAverageLetters(Collection<String> coleccionString, int totalLetters) {
        return coleccionString.isEmpty() ? 0 : (double) totalLetters / coleccionString.size(); // Set a breakpoint and use 'Evaluate Expression' here
    }

}