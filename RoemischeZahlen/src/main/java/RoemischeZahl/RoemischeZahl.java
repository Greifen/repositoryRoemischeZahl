package RoemischeZahl;

public class RoemischeZahl {

	private char[] roemischeZahlen = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
	private int[] roemischeZahlenWerte = { 1, 5, 10, 50, 100, 500, 1000 };

	public static void main(String[] args) {
		RoemischeZahl roemischeZahl = new RoemischeZahl();
		System.out.println(roemischeZahl.roemischeZahlenAddieren("CMXC", "CMLXXVI")); //MCMLXVI
//		System.out.println(roemischeZahl.roemischeZahlenAddieren2("CMXC", "CMLXXVI"));

		System.out.println(roemischeZahl.roemischeZahlInDezimal("X"));
		System.out.println(roemischeZahl.dezimalzahlInRoemische(250 + 2984));
		System.out.println(roemischeZahl.dezimalzahlInRoemische(2984)); // MMCMLXXXIV

		int array[] = new int[3]; // create an array of 3 integers.
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;

		System.out.println(3 % 2 ==1);
	}

	/**
	 * wandelt eine roemische Zahl in eine Dezimalzahl um. TODO: i==j+1 ||i==j-1 bzw i=j+2 XC
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
		// bei einem Zeichen geht er nicht in die Schleife und gibt direkt danach den
		// roemischenZahlenWert an der stelleINArraysZeichen2 aus.
		int stelleInArraysZeichen2 = stelleInArrays(roemischeZahl.charAt(0));
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
	 * @param dezimalzahl Dezimalzahl unter 4000
	 * @return roemische Zahl oder Fehler: Nur Zahlen unter 4000.
	 */
	public String dezimalzahlInRoemische(int dezimalzahl) {
		if (dezimalzahl < 4000) {
			String roemischeZahl = "";
			int anzahlZehnerpotzen;
			for (int stelleInArrays = roemischeZahlenWerte.length - 1; stelleInArrays >= 0; stelleInArrays -= 2) {
				anzahlZehnerpotzen = dezimalzahl / roemischeZahlenWerte[stelleInArrays];

				// dezimalzahl: hier werden die höheren Stellen pro Durchlauf abgehängt
				dezimalzahl -= anzahlZehnerpotzen * roemischeZahlenWerte[stelleInArrays];

				if (anzahlZehnerpotzen != 0) {
					if (anzahlZehnerpotzen < 4) {
						for (int i = 0; i < anzahlZehnerpotzen; i++) {
							roemischeZahl += roemischeZahlen[stelleInArrays];
						}
					} else if (anzahlZehnerpotzen == 4) {
						roemischeZahl += roemischeZahlen[stelleInArrays];
						roemischeZahl += roemischeZahlen[stelleInArrays + 1];
					} else if (anzahlZehnerpotzen == 5) {
						roemischeZahl += roemischeZahlen[stelleInArrays + 1];
					} else if (anzahlZehnerpotzen < 9) {
						roemischeZahl += roemischeZahlen[stelleInArrays + 1];
						for (int i = 0; i < anzahlZehnerpotzen - 5; i++) {
							roemischeZahl += roemischeZahlen[stelleInArrays];
						}
					} else { // if(anzahlZehnerpotzen==9)
						roemischeZahl += roemischeZahlen[stelleInArrays];
						roemischeZahl += roemischeZahlen[stelleInArrays + 2];
					}
				}
			}
			return roemischeZahl;
		} else {
//			System.err.println("Fehler: Nur Zahlen unter 4000.");
			return "Fehler: Nur Zahlen unter 4000.";
		}
	}

	/**
	 * addiert zwei roemische Zahlen und gibt diese als roemische Zahl aus, wenn
	 * dessen Ergebnis unter 4000 ist. (wandelt dazu die beiden roemischen Zahlen in
	 * Dezimalzahlen um und dann die Summe dieser Dezimalzahlen wiederum zurück in
	 * eine roemische Zahl)
	 * 
	 * @param roemischeZahl1
	 * @param roemischeZahl2
	 * @return Summe der beiden roemischen Zahlen.
	 */
	public String roemischeZahlenAddieren(String roemischeZahl1, String roemischeZahl2) {
		return dezimalzahlInRoemische(roemischeZahlInDezimal(roemischeZahl1) + roemischeZahlInDezimal(roemischeZahl2));
	}

	/**
	 * addiert zwei roemische Zahlen und gibt diese als roemische Zahl aus, wenn
	 * dessen Ergebnis unter 4000 ist. (rechnet direkt mit den roemischen Zahlen.
	 * Nutzt dazu summeRoemischeStellenwerttafel, in welcher die Anzahl der
	 * roemischen Zeichen notiert wird und entbündelt und bündelt danach.)
	 * 
	 * @param roemischeZahl1
	 * @param roemischeZahl2
	 * @return Summe der beiden roemischen Zahlen.
	 */
	public String roemischeZahlenAddieren2(String roemischeZahl1, String roemischeZahl2) {
		int[] summeRoemischeStellenwerttafel = new int[7]; // { 0, 0, 0, 0, 0, 0, 0 };

		roemischeStellenwerttafel(roemischeZahl1, summeRoemischeStellenwerttafel);
		roemischeStellenwerttafel(roemischeZahl2, summeRoemischeStellenwerttafel);

		//entbündeln
		for (int i = 0; i < summeRoemischeStellenwerttafel.length; i+=2) {
			if (summeRoemischeStellenwerttafel[i]>0) {
				summeRoemischeStellenwerttafel[i+1]--;
				summeRoemischeStellenwerttafel[i]+=5;
			}
			else
			{
				summeRoemischeStellenwerttafel[i+2]--;
				summeRoemischeStellenwerttafel[i]+=10;
			}
		}
		
		//bündeln
		for (int i = 0; i < summeRoemischeStellenwerttafel.length; i+=2) {
			if(i % 2==0 && summeRoemischeStellenwerttafel[i]>3) {
				summeRoemischeStellenwerttafel[i]-=5;
				summeRoemischeStellenwerttafel[i+1]++;
			}
			else if(i % 2==1 && summeRoemischeStellenwerttafel[i]>1) {
				summeRoemischeStellenwerttafel[i]-=2;
				summeRoemischeStellenwerttafel[i+1]++;
			}
		}
		
		//Stellenwerttafel zu String
		String summeRoemischeZahl="";
		for (int i = summeRoemischeStellenwerttafel.length-1; i <= 0; i--) {
			if (i%2==0 && i>0) {
				if (summeRoemischeStellenwerttafel[i-1]==-1) {
					summeRoemischeZahl+=roemischeZahlenWerte[i-1];
					summeRoemischeZahl+=roemischeZahlenWerte[i];
				}
				else if (summeRoemischeStellenwerttafel[i-2]==-1) {
					summeRoemischeZahl+=roemischeZahlenWerte[i-2];
					summeRoemischeZahl+=roemischeZahlenWerte[i];				
				}
				else
				{
					for (int j=0; j < summeRoemischeStellenwerttafel[i]; j++) {
						summeRoemischeZahl+=roemischeZahlenWerte[i];
					}
				}
			}
			else {
				for (int j=0; j < summeRoemischeStellenwerttafel[i]; j++) {
					summeRoemischeZahl+=roemischeZahlenWerte[i];
				}
			}
		}
		
		
		return summeRoemischeZahl;
	}

	private void roemischeStellenwerttafel(String roemischeZahl, int[] summeRoemischeStellenwerttafel) {
		char zeichen1;
		char zeichen2;
		int stelleInArraysZeichen1;
		// bei einem Zeichen geht er nicht in die Schleife und gibt direkt danach den
		// roemischenZahlenWert an der stelleINArraysZeichen2 aus.
		int stelleInArraysZeichen2 = stelleInArrays(roemischeZahl.charAt(0));
		for (int stelleRoemischeZahl = 0; stelleRoemischeZahl < roemischeZahl.length() - 1; stelleRoemischeZahl++) {
			zeichen1 = roemischeZahl.charAt(stelleRoemischeZahl);
			zeichen2 = roemischeZahl.charAt(stelleRoemischeZahl + 1);

			stelleInArraysZeichen1 = stelleInArrays(zeichen1);
			stelleInArraysZeichen2 = stelleInArrays(zeichen2);

			if (stelleInArraysZeichen1 < stelleInArraysZeichen2) {
				summeRoemischeStellenwerttafel[stelleInArraysZeichen1]--;
				// dezimalzahl -= roemischeZahlenWerte[stelleInArraysZeichen1];
			} else {
				summeRoemischeStellenwerttafel[stelleInArraysZeichen1]++;
				// dezimalzahl += roemischeZahlenWerte[stelleInArraysZeichen1];
			}
//			TODO:logging
//			System.out.println(dezimalzahl);
		}
		summeRoemischeStellenwerttafel[stelleInArraysZeichen2]++;
		// dezimalzahl += roemischeZahlenWerte[stelleInArraysZeichen2];
	}
}
