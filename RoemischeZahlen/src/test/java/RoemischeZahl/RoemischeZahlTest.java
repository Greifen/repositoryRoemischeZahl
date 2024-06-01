
package RoemischeZahl;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RoemischeZahlTest {

	private final RoemischeZahl roemischeZahl = new RoemischeZahl();

	@Test
	public void testRoemischeZahlInDezimal() {
		assertThat(roemischeZahl.roemischeZahlInDezimal("I")).isEqualTo(1);
		assertThat(roemischeZahl.roemischeZahlInDezimal("II")).isEqualTo(2);
		assertThat(roemischeZahl.roemischeZahlInDezimal("III")).isEqualTo(3);
		assertThat(roemischeZahl.roemischeZahlInDezimal("IV")).isEqualTo(4);
		assertThat(roemischeZahl.roemischeZahlInDezimal("V")).isEqualTo(5);
		assertThat(roemischeZahl.roemischeZahlInDezimal("VI")).isEqualTo(6);
		assertThat(roemischeZahl.roemischeZahlInDezimal("VII")).isEqualTo(7);
		assertThat(roemischeZahl.roemischeZahlInDezimal("VIII")).isEqualTo(8);
		assertThat(roemischeZahl.roemischeZahlInDezimal("IX")).isEqualTo(9);
		assertThat(roemischeZahl.roemischeZahlInDezimal("X")).isEqualTo(10);
		assertThat(roemischeZahl.roemischeZahlInDezimal("CMXC")).isEqualTo(990);
		assertThat(roemischeZahl.roemischeZahlInDezimal("CMLXXVI")).isEqualTo(976);
	}

	// JUnit Tests jede ziffer einmal 1,2,3,4,5,6,7,8,9,0 + Grenzfall +
	// unterschiedlich viele Stellen
	@Test
	public void testDezimalzahlInRoemische() {
		assertThat(roemischeZahl.dezimalzahlInRoemische(1)).isEqualTo("I");
		assertThat(roemischeZahl.dezimalzahlInRoemische(2)).isEqualTo("II");
		assertThat(roemischeZahl.dezimalzahlInRoemische(3)).isEqualTo("III");
		assertThat(roemischeZahl.dezimalzahlInRoemische(4)).isEqualTo("IV");
		assertThat(roemischeZahl.dezimalzahlInRoemische(5)).isEqualTo("V");
		assertThat(roemischeZahl.dezimalzahlInRoemische(6)).isEqualTo("VI");
		assertThat(roemischeZahl.dezimalzahlInRoemische(7)).isEqualTo("VII");
		assertThat(roemischeZahl.dezimalzahlInRoemische(8)).isEqualTo("VIII");
		assertThat(roemischeZahl.dezimalzahlInRoemische(9)).isEqualTo("IX");
		assertThat(roemischeZahl.dezimalzahlInRoemische(10)).isEqualTo("X");
		assertThat(roemischeZahl.dezimalzahlInRoemische(27)).isEqualTo("XXVII");
		assertThat(roemischeZahl.dezimalzahlInRoemische(870)).isEqualTo("DCCCLXX");
		assertThat(roemischeZahl.dezimalzahlInRoemische(2427)).isEqualTo("MMCDXXVII");
		assertThat(roemischeZahl.dezimalzahlInRoemische(2806)).isEqualTo("MMDCCCVI");
		assertThat(roemischeZahl.dezimalzahlInRoemische(2501)).isEqualTo("MMDI");
		assertThat(roemischeZahl.dezimalzahlInRoemische(3999)).isEqualTo("MMMCMXCIX");
		assertThat(roemischeZahl.dezimalzahlInRoemische(4000)).isEqualTo("Fehler: Nur Zahlen unter 4000.");
		assertThat(roemischeZahl.dezimalzahlInRoemische(4567)).isEqualTo("Fehler: Nur Zahlen unter 4000.");
		assertThat(roemischeZahl.dezimalzahlInRoemische(2984)).isEqualTo("MMMCMLXXXIV");
	}
}
