package RoemischeZahl;


public class RoemischeZahl {

	private char[] roemischeZahlen = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
	private int[] roemischeZahlenWerte = { 1, 5, 10, 50, 100, 500, 1000};

	public static void main(String[] args) {
		String roemischeZahl1 = "CMXC";
		String roemischeZahl2 = "CMLXXVI";
		RoemischeZahl roemischeZahle = new RoemischeZahl();
		int dezimalzahl1 = roemischeZahle.roemischeZahlInDezimal(roemischeZahl1);
		int dezimalzahl2 = roemischeZahle.roemischeZahlInDezimal(roemischeZahl2);
		System.out.println(dezimalzahl1);
		System.out.println(dezimalzahl2);
		System.out.println(dezimalzahl1 + dezimalzahl2);
		System.out.println(roemischeZahle.dezimalzahlInRoemische(dezimalzahl1 + dezimalzahl2));
		System.out.println(roemischeZahle.dezimalzahlInRoemische(3999));	
		System.out.println(roemischeZahle.dezimalzahlInRoemische(4000));
//		//wie konkatiniere ich String mit char?
//		String hallo="hallo";
//		char h='h';
//		char[] roemischeZahlen2 = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
//		hallo += roemischeZahlen2[0];
//		hallo += roemischeZahlen2[1];
//		System.out.println(hallo);
	}

	/**
	 * wandelt eine roemische Zahl in eine Dezimalzahl um. TODO: i==j+1 ||i==j-1
	 * Überprüfung der römischen Zahl selbst (eine kleinere vor und nur 3 kleinere
	 * nach; allerdings 4 Zeichen speichern)
	 * 
	 * @param roemischeZahl
	 * @return dezimalZahl
	 */
	public int roemischeZahlInDezimal(String roemischeZahl) {
		int dezimalzahl = 0;
		char zeichen1;
		char zeichen2;
		int stelleInArraysZeichen1;
		int stelleInArraysZeichen2 = 0;
		for (int stelleRoemischeZahl = 0; stelleRoemischeZahl < roemischeZahl.length() - 1; stelleRoemischeZahl++) {
			zeichen1 = roemischeZahl.charAt(stelleRoemischeZahl);
			zeichen2 = roemischeZahl.charAt(stelleRoemischeZahl + 1);

			stelleInArraysZeichen1 = stelleInArrays(zeichen1);
			stelleInArraysZeichen2 = stelleInArrays(zeichen2);

			if (stelleInArraysZeichen1 < stelleInArraysZeichen2) {
				dezimalzahl -= roemischeZahlenWerte[stelleInArraysZeichen1];
			} else {
				dezimalzahl += roemischeZahlenWerte[stelleInArraysZeichen1];
			}
//			TODO:logging
//			System.out.println(dezimalzahl);
		}

		dezimalzahl += roemischeZahlenWerte[stelleInArraysZeichen2];
		return dezimalzahl;
	} 

	/**
	 * wandelt eine Dezimalzahl in eine roemische Zahl um.
	 * 
	 * @param zeichen
	 * @return stelleInArray
	 */
	private int stelleInArrays(char zeichen) {
		int stelleInArrays;
		stelleInArrays = 0;
		while (roemischeZahlen[stelleInArrays] != zeichen) {
			stelleInArrays++;
		}
		return stelleInArrays;
	}

	/**
	 * gibt die Stelle in den Arrays roemischeZahlen bzw. roemischeZahlenWerte
	 * zurück.
	 * 
	 * @param dezimalzahl
	 * @return roemische Zahl
	 */
	public String dezimalzahlInRoemische(int dezimalzahl) {
		String roemischeZahl="";
		int anzahlZehnerpotzen;
		for (int stelleInArrays = roemischeZahlenWerte.length-1; stelleInArrays>=0 ; stelleInArrays-=2) {
			anzahlZehnerpotzen=dezimalzahl/roemischeZahlenWerte[stelleInArrays];
			dezimalzahl-=anzahlZehnerpotzen*roemischeZahlenWerte[stelleInArrays];
			if(anzahlZehnerpotzen!=0) {
				if (anzahlZehnerpotzen<4) {
					for (int i = 0; i < anzahlZehnerpotzen; i++) {
						roemischeZahl += roemischeZahlen[stelleInArrays];
					}
				}
				else if(anzahlZehnerpotzen==4) {
					roemischeZahl += roemischeZahlen[stelleInArrays];
					roemischeZahl += roemischeZahlen[stelleInArrays+1];
				}
				else if(anzahlZehnerpotzen==5) {
					roemischeZahl += roemischeZahlen[stelleInArrays+1];
				}
				else if(anzahlZehnerpotzen<9)
				{
					roemischeZahl += roemischeZahlen[stelleInArrays+1];
					for (int i = 0; i < anzahlZehnerpotzen-5; i++) {
						roemischeZahl += roemischeZahlen[stelleInArrays];
					}
				}
				else{ //if(x==9)
					roemischeZahl += roemischeZahlen[stelleInArrays];
					roemischeZahl += roemischeZahlen[stelleInArrays+2];
				}
			}
		}
		return roemischeZahl;
	}
}
