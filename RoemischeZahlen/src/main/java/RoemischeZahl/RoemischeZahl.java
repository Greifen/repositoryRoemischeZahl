package RoemischeZahl;

public class RoemischeZahl {

		
	private char[] roemischeZahlen = {'I','V','X','L','C','D','M'};
	private int[] roemischeZahlenWerte = {1,5,10,50,100,500,1000};
	
	public static void main(String[] args) {
		String roemischeZahl1= "CMXC";
		String roemischeZahl2= "CMLXXVI";
		RoemischeZahl roemischeZahlen= new RoemischeZahl();
		int dezimalzahl1 = roemischeZahlen.roemischeZahlInDezimal(roemischeZahl1);
		int dezimalzahl2 = roemischeZahlen.roemischeZahlInDezimal(roemischeZahl2);
		System.out.println(dezimalzahl1+dezimalzahl2);
	}

	/**wandelt roemische Zahl in eine Dezimalzahl um.
	 * TODO: i==j+1 ||i==j-1 Überprüfung der römischen Zahl selbst (eine kleinere vor und nur 3 kleinere nach; allerdings 4 Zeichen speichern)
	 * 
	 * @param roemischeZahl
	 * @return dezimalZahl
	 */
	private int roemischeZahlInDezimal(String roemischeZahl) {
		int dezimalzahl=0;
		char zeichen1;
		char zeichen2;
		int stelleInArrays1;
		int stelleInArrays2=0;
		for (int stelleRoemischeZahl = 0; stelleRoemischeZahl < roemischeZahl.length()-1; stelleRoemischeZahl++)
		{
			zeichen1 = roemischeZahl.charAt(stelleRoemischeZahl);
			zeichen2 = roemischeZahl.charAt(stelleRoemischeZahl+1);

			stelleInArrays1 = stelleInArrays(zeichen1);
			stelleInArrays2 = stelleInArrays(zeichen2);
			if(stelleInArrays1<stelleInArrays2) {
				dezimalzahl-=roemischeZahlenWerte[stelleInArrays1];
			}
			else
			{
				dezimalzahl+=roemischeZahlenWerte[stelleInArrays1];
			}

			System.out.println(dezimalzahl);
		}
		
		dezimalzahl+=roemischeZahlenWerte[stelleInArrays2];
		System.out.println(dezimalzahl);
		return dezimalzahl;
	}

	/**
	 * gibt die Stelle in den Arrays roemischeZahlen bzw. roemischeZahlenWerte zurück.
	 * @param zeichen
	 * @return stelleInArray
	 */
	private int stelleInArrays(char zeichen) {
		int stelleInArrays;
		stelleInArrays=0;
		while(roemischeZahlen[stelleInArrays]!=zeichen) {
			stelleInArrays++;
		}
		return stelleInArrays;
	}

}
