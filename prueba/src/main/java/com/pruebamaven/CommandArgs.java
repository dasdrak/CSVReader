package com.pruebamaven;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandArgs{
	/**
	 * 
	 * @param args the command line arguments
	 */
    public static void main(String[] args) {
        System.out.println("Por favor introduzca la URL: ");

        Scanner url = new Scanner(System.in);

        if (url.hasNext(Pattern.compile(".*.csv.*")))
            System.out.println("La URL introducida es correcta");
        else
            System.out.println("La URL introducida no es correcta, asegurate de que la extensión sea .csv");

        if (url != null)
            url.close();

    }

}