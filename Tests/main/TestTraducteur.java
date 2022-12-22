package main;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTraducteur {

	@BeforeClass
	public static void init() {
// Si des initialisations sont nécessaires avant de réaliser les tests
// les lancer ici
		Main.table();
		Main.tableRacine();
		Main.triRapide(TableAssoc.clesRacine);
	}

	// test pour la fonction traduire
	@Test
	public void test1() {
		String[] t1 = { "je", "chercher", "azer" };
		String[] t1Attendu = { "I", "look for", "azer" };

		String[] t1Traduit = Main.traduire(t1);
		assertArrayEquals(t1Attendu, t1Traduit);
	}

	@Test
	public void test2() {
		String[] t2 = {};
		String[] t2Attendu = {};

		String[] t2Traduit = Main.traduire(t2);
		assertArrayEquals(t2Attendu, t2Traduit);
	}

	@Test
	public void test3() {
		String[] t3 = { "cheval" };
		String[] t3Attendu = { "horse" };

		String[] t3Traduit = Main.traduire(t3);
		assertArrayEquals(t3Attendu, t3Traduit);
	}

	@Test
	public void test4() {
		String[] t4 = { "ADN", "Abkhasie", "Abkhasien", "Abyssin" };
		String[] t4Attendu = { "DNA", "Abkhazia", "Abkhazian", "Abyssinian" };

		String[] t4Traduit = Main.traduire(t4);
		assertArrayEquals(t4Attendu, t4Traduit);
	}
	// test pour la fonction traduire2

	@Test
	public void test5() {
		String[] t5 = { "cheval" };
		String[] t5Attendu = { "horse" };

		String[] t5Traduit = Main.traduire2(t5);
		assertArrayEquals(t5Attendu, t5Traduit);
	}

//	@Test
//	public void test6() {
//		String[] t6 = { "mon", "belle", "chaussures" };
//		String[] t6Attendu = { "my", "beautiful", "shoes" };
//
//		String[] t6Traduit = Main.traduire2(t6);
//		assertArrayEquals(t6Attendu, t6Traduit);
//	}

	@Test
	public void test7() {
		String[] t7 = {};
		String[] t7Attendu = {};

		String[] t7Traduit = Main.traduire2(t7);
		assertArrayEquals(t7Attendu, t7Traduit);
	}

	// test pour la fonction triRapide
	@Test
	public void test8() {
		String[] t8 = { "aa", "zz", "ee", "rr", "tt", "yy" };
		String[] t8Attendu = { "aa", "ee", "rr", "tt", "yy", "zz" };

		Main.triRapide(t8);
		assertArrayEquals(t8Attendu, t8);
	}

	// test pour la fonction traduire3
//	@Test
//	public void test9() {
//		String[] t9 = { "mes", "belles", "chaussures" };
//		String[] t9Attendu = { "my", "beautiful", "shoe" };
//
//		String[] t9Traduit = Main.traduire3(t9);
//		assertArrayEquals(t9Attendu, t9Traduit);
//	}

	@Test
	public void test10() {
		String[] t10 = { "je", "cherche" };
		String[] t10Attendu = { "I", "look for" };

		String[] t10Traduit = Main.traduire3(t10);
		assertArrayEquals(t10Attendu, t10Traduit);
	}

	// test pour la fonction traduireUnMot
	@Test
	public void test11() {
		String s = "bonjour";
		String sAttendu = "good morning";

		String sTraduit = Main.traduireUnMot(s);
		assertEquals(sAttendu, sTraduit);
	}

	// test pour la fonction rechercheDicho
	@Test
	public void test12() {
		String[] t12 = { "aa", "ee", "rr", "tt", "yy", "zz" };
		int indice = Main.rechercheDicho("ee", t12);

		assertEquals(1, indice);
	}

	// test sur la fonction traduire4
	@Test
	public void test13() {
		String[] t1 = { "je", "chercher", "azer" };
		String[] t1Attendu = { "I", "look for", "azer" };

		String[] t1Traduit = Main.traduire4(t1);
		assertArrayEquals(t1Attendu, t1Traduit);
	}

	@Test
	public void test14() {
		String[] t2 = {};
		String[] t2Attendu = {};

		String[] t2Traduit = Main.traduire4(t2);
		assertArrayEquals(t2Attendu, t2Traduit);
	}

	@Test
	public void test15() {
		String[] t3 = { "cheval" };
		String[] t3Attendu = { "horse" };

		String[] t3Traduit = Main.traduire4(t3);
		assertArrayEquals(t3Attendu, t3Traduit);
	}

	
}
