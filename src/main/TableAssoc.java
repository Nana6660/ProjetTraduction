package main;
import util.ACX;

public class TableAssoc {

	public class java {

	}

	public static String[] traducteur = ACX.lectureDico("lib/frenchEnglish.txt");// prendre le fichier
	// frenchEnglish.txt sous
	// forme d'un tableau de
	// string

public static String[] cles = new String[(traducteur.length) / 2];// permet de récuperer les mots en français

public static String[] valeurs = new String[(traducteur.length) / 2];// permet de récuperer les mots en anglais

public static String[] racines = ACX.lectureDico("lib/racines.txt");// prendre le fichier racines.txt sous
// forme d'un tableau de string

public static String[] clesRacine = new String[racines.length];// permet de récupérer les verbes conjugué

public static String[] valeursRacine = new String[racines.length];// permet de récupérer l'infinitif des verbes

}