package RoemischeZahlen;

public class RoemischeZahlen {

		
	private char[] roemischeZahlen = {'I','V','X','L','C','D','M'};
	private int[] roemischeZahlenWert = {1,5,10,50,100,500,1000};
	
	public static void main(String[] args) {
		String roemischeZahl1= "CMXC";
		String roemischeZahl2= "CMLXXVI";
		RoemischeZahlen roemischeZahlen= new RoemischeZahlen();
		int dezimalzahl1 = roemischeZahlen.roemischeZahlInDezimal(roemischeZahl1);
		int dezimalzahl2 = roemischeZahlen.roemischeZahlInDezimal(roemischeZahl2);
		System.out.println(dezimalzahl1+dezimalzahl2);
	}

	private int roemischeZahlInDezimal(String beispielZahl1) {
		int dezimalzahl=0;
		char zeichen1;
		char zeichen2;
		int i;
		int j=0;
		for (int x = 0; x < beispielZahl1.length()-1; x++)
		{
			zeichen1 = beispielZahl1.charAt(x);
			zeichen2 = beispielZahl1.charAt(x+1);

			i=0;
			while(roemischeZahlen[i]!=zeichen1) {
				i++;
			}
			j=0;
			while(roemischeZahlen[j]!=zeichen2) {
				j++;
			}
			if(i<j) {
				dezimalzahl-=roemischeZahlenWert[i];
			}
			else
			{
				dezimalzahl+=roemischeZahlenWert[i];
			}

			System.out.println(dezimalzahl);
		}
		
		dezimalzahl+=roemischeZahlenWert[j];
		System.out.println(dezimalzahl);
		return dezimalzahl;
	}

}
