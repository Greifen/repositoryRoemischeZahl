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
		for (int stelleRömischeZahl = 0; stelleRömischeZahl < roemischeZahl.length()-1; stelleRömischeZahl++)
		{
			zeichen1 = roemischeZahl.charAt(stelleRömischeZahl);
			zeichen2 = roemischeZahl.charAt(stelleRömischeZahl+1);

			stelleInArrays1=0;
			while(roemischeZahlen[stelleInArrays1]!=zeichen1) {
				stelleInArrays1++;
			}
			stelleInArrays2=0;
			while(roemischeZahlen[stelleInArrays2]!=zeichen2) {
				stelleInArrays2++;
			}
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

}
