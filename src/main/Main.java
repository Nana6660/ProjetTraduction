package main;

//import static org.junit.Assert.assertEquals;

import util.ACX;

public class Main {

	// Fonction table d'association
	public static void table() {
		int j = 0;
		for (int i = 0; i < TableAssoc.traducteur.length; i = i + 2) {//je parcours l'ensemble des éléments du dictionnaire 
			TableAssoc.cles[j] = TableAssoc.traducteur[i];//On sait que dans le dictionnaire les mots en françis sont aux indices impaires et l'anglais aux paires. 
			TableAssoc.valeurs[j] = TableAssoc.traducteur[i + 1];// je rempli mes deux tableaux cles prend les mots d'indices paires et valeurs les mots d'incdes impaires
			j++;//permet de remplires mes tableaux paralléllement à des indices différents
		}
	}

	// Fonction table d'association pour les racines
	public static void tableRacine() {
		for (int i = 0; i < TableAssoc.racines.length; i++) {
			String[] mots = ACX.mots(TableAssoc.racines[i]);//me retourne un tbleau de mot 
			TableAssoc.clesRacine[i] = mots[1];//permet de récupérer les verbes conjugué
			TableAssoc.valeursRacine[i] = mots[2];//permet de récupérer l'infinitif des verbes
		}
	}

	// Niveau 1
	public static String[] traduire(String[] texte) {
		String[] traduction = new String[texte.length];
		boolean trouve = false;
		for (int i = 0; i < texte.length; i++) {
			trouve = false;
			for (int j = 0; j < TableAssoc.cles.length; j++) {
				if (texte[i].equalsIgnoreCase(TableAssoc.cles[j])) { // Autre methode possible avec la fonction
																		// recherche
					//j'utilise .equalsIgnoreCase pour ne pas prendre en conte les mots minuscule ou majuscule tout est traduit qu'il soit en minus ou en majus
					traduction[i] = TableAssoc.valeurs[j];//je remplis mon tbleau 
					trouve = true;
				}
			}
			if (!trouve)
				traduction[i] = texte[i];//si le mots n'est pas dans le dictionnaire il me retourne le mots 
		}
		return traduction;
	}

	// Niveau 2
	public static int recherche(String mot, String[] texte) {
		for (int i = 0; i < texte.length; i++) {
			if (mot.equalsIgnoreCase(texte[i]))//je compare les mots et ignorant les majuscules et minuscules
				return i;// l'indice du mot s'il existe
		}
		return -1;//si le mots n'existe pas 
	}

	public static String traduireUnMot(String s) {
		for (int j = 0; j < TableAssoc.cles.length; j++) {
			if (s.equalsIgnoreCase(TableAssoc.cles[j])) { // Autre methode avec la fonction recherche
				return TableAssoc.valeurs[j];
			}
		}
		return s;
	}

	public static String[] traduire2(String[] texte) {
		String[] traduction2 = new String[texte.length];
		for (int i = 0; i < texte.length; i++) {
			int indice = recherche((texte[i].toLowerCase()), TableAssoc.clesRacine);

			if (indice == -1) {
				traduction2[i] = texte[i];
			} else {
				traduction2[i] = traduireUnMot(TableAssoc.valeursRacine[indice]);
			}
		}
		return traduction2;
	}

	// Niveau 3
	public static String[] traduire3(String[] texte) {
		String[] traduction3 = new String[texte.length];
		for (int i = 0; i < texte.length; i++) {
			int indice = rechercheDicho((texte[i].toLowerCase()), TableAssoc.clesRacine);

			if (indice == -1) {
				traduction3[i] = texte[i];
			} else {
				traduction3[i] = traduireUnMot(TableAssoc.valeursRacine[indice]);
			}
		}
		return traduction3;
	}

	// Tri de la table
	public static void echange(String[] tab, int i, int j) {
		String c = tab[i];
		tab[i] = tab[j];
		tab[j] = c;
	}

	public static void triRapide(String[] tableau) {
		triRapide(tableau, 0, tableau.length - 1);//appel de fonction triRapide(tableauString,int,int)
	}

	public static int triRapideAux(String[] tableau, int debut, int fin) {//fonction dicothomique
		int compteur = debut;
		String pivot = tableau[(debut + fin) / 2];
		echange(tableau, compteur, (fin + debut) / 2);
		echange(TableAssoc.valeursRacine, compteur, (fin + debut) / 2);

		for (int i = debut + 1; i <= fin; i++) {
			if (tableau[i].compareTo(pivot) < 0) {
				compteur++;
				echange(tableau, compteur, i);
				echange(TableAssoc.valeursRacine, compteur, i);
			}
		}
		echange(tableau, debut, compteur);
		echange(TableAssoc.valeursRacine, debut, compteur);
		return compteur;
	}

	public static void triRapide(String[] tableau, int debut, int fin) {
		if (debut < fin) {
			int positionPivot = triRapideAux(tableau, debut, fin);
			triRapide(tableau, debut, positionPivot - 1);
			triRapide(tableau, positionPivot + 1, fin);
		}
	}

	// Fonction recherche dicho
	public static int rechercheDicho(String cherche, String[] t) {
		int debut = 0;
		int fin = t.length - 1;
		boolean trouve = false;
		int milieu = (debut + fin) / 2;

		while (!trouve && debut <= fin) {
			if (t[milieu].compareTo(cherche) == 0)
				trouve = true;
			else if (t[milieu].compareTo(cherche) > 0)
				fin = milieu - 1;
			else
				debut = milieu + 1;
			milieu = (debut + fin) / 2;
		}
		if (trouve)
			return milieu;
		else
			return -1;
	}

	// Niveau4
	public static String[] traduire4(String[] texte) {
		String[] traduction4 = new String[texte.length];
		for (int i = 0; i < texte.length; i++) {
			int indice = rechercheDicho((texte[i].toLowerCase()), TableAssoc.clesRacine);

			if (indice == -1) {
				traduction4[i] = texte[i];
			} else {
				traduction4[i] = traduireUnMot(TableAssoc.valeursRacine[indice]);
			}
		}
		return traduction4;
	}

	// Fonction auxiliaire
	public static void affiche(String[] t) {
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + " ");
		}
	}

	public static void main(String[] args) {
		table();
		tableRacine();
		String []t = {"mon","je","chercher"};
		affiche(traduire(t));
		//ACX.interfaceTraduction("traduire");
//		ACX.interfaceTraduction("traduire2");
//		triRapide(TableAssoc.clesRacine);
//		ACX.interfaceTraduction("traduire3");
//		ACX.interfaceTraduction("traduire4");
		// System.out.println(rechercheDicho("ADN", tableAssoc.cles));

	}
}
