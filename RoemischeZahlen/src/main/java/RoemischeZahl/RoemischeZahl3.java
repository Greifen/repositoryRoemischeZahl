package RoemischeZahl;

public class RoemischeZahl3 {

	private String[] roemischeZahlen = new String[3999];

	public RoemischeZahl3() {
		super();

		for (int i = 0; i < 3999; i++) {
			roemischeZahlen[i] = intToRoman(i + 1);
		}
	}

	/**
	 * Chatgpt ist ja viel schlauer, wollte eigentlich nur dass er mir die explizite
	 * Menge aufschreibt und er programmiert das.
	 * 
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num) {
		String[] thousands = { "", "M", "MM", "MMM" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
	}

	public static void main(String[] args) {
		RoemischeZahl3 roemischeZahl = new RoemischeZahl3();
		System.out.println(roemischeZahl.roemischeZahlenAddieren("CMXC", "CMLXXVI")); // MCMLXVI
	}

	/**
	 * wandelt eine roemische Zahl in eine Dezimalzahl um. TODO: i==j+1 ||i==j-1 bzw
	 * i=j+2 XC Überprüfung der römischen Zahl selbst (eine kleinere vor und nur 3
	 * kleinere nach; allerdings 4 Zeichen speichern)
	 * 
	 * @param roemischeZahl
	 * @return dezimalZahl
	 */
	public int roemischeZahlInDezimal(String roemischeZahl) {
		for (int i = 0; i < roemischeZahlen.length; i++) {
			if (roemischeZahl.equals(roemischeZahlen[i])) {
				return i + 1;
			}

		}
		return -1;
	}

	/**
	 * gibt die Stelle in den Arrays roemischeZahlen bzw. roemischeZahlenWerte
	 * zurück.
	 * 
	 * @param dezimalzahl Dezimalzahl unter 4000
	 * @return roemische Zahl oder Fehler: Nur Zahlen unter 4000.
	 */
	public String dezimalzahlInRoemische(int dezimalzahl) {
		if (dezimalzahl > 0 && dezimalzahl < 4000) {
			return roemischeZahlen[dezimalzahl - 1];
		}
		return "Fehler: Nur Zahlen unter 4000.";
	}

	public String roemischeZahlenAddieren(String roemischeZahl1, String roemischeZahl2) {
		return dezimalzahlInRoemische(roemischeZahlInDezimal(roemischeZahl1) + roemischeZahlInDezimal(roemischeZahl2));
	}
}
