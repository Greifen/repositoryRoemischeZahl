
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
		assertThat(roemischeZahl.dezimalzahlInRoemische(2984)).isEqualTo("MMCMLXXXIV");
	}

	@Test
	public void testRoemischeZahlenAddieren() {
		//anhängen
		assertThat(roemischeZahl.roemischeZahlenAddieren("XI", "XI")).isEqualTo("XXII");
		assertThat(roemischeZahl.roemischeZahlenAddieren("XI", "IX")).isEqualTo("XX");
		
		//abhängen
		assertThat(roemischeZahl.roemischeZahlenAddieren("III", "IV")).isEqualTo("VII");
		assertThat(roemischeZahl.roemischeZahlenAddieren("CM", "MCIX")).isEqualTo("MMIX");
		
		
		//bündeln
		assertThat(roemischeZahl.roemischeZahlenAddieren("VIII", "VIII")).isEqualTo("XVI");
		assertThat(roemischeZahl.roemischeZahlenAddieren("XX", "XX")).isEqualTo("XL");
		
		//entbündeln
		assertThat(roemischeZahl.roemischeZahlenAddieren("IV", "IX")).isEqualTo("XIII");
		assertThat(roemischeZahl.roemischeZahlenAddieren("IX", "IX")).isEqualTo("XVIII");
		assertThat(roemischeZahl.roemischeZahlenAddieren("XCIX", "XCIX")).isEqualTo("CXCVIII");
		
		assertThat(roemischeZahl.roemischeZahlenAddieren("CDL", "DCLXX")).isEqualTo("MCXX");
		assertThat(roemischeZahl.roemischeZahlenAddieren("CMXC", "CMLXXVI")).isEqualTo("MCMLXVI");
	}
	
	
	@Test
	public void testRoemischeZahlenAddieren2() {
		//anhängen
		assertThat(roemischeZahl.roemischeZahlenAddieren2("XI", "XI")).isEqualTo("XXII");
		assertThat(roemischeZahl.roemischeZahlenAddieren2("XI", "IX")).isEqualTo("XX");
		
		//abhängen
		assertThat(roemischeZahl.roemischeZahlenAddieren2("III", "IV")).isEqualTo("VII");
		assertThat(roemischeZahl.roemischeZahlenAddieren2("CM", "MCIX")).isEqualTo("MMIX");
		
		
		//bündeln
		assertThat(roemischeZahl.roemischeZahlenAddieren2("VIII", "VIII")).isEqualTo("XVI");
		assertThat(roemischeZahl.roemischeZahlenAddieren2("XX", "XX")).isEqualTo("XL");
		
		//entbündeln
		assertThat(roemischeZahl.roemischeZahlenAddieren2("IV", "IX")).isEqualTo("XIII");
		assertThat(roemischeZahl.roemischeZahlenAddieren2("IX", "IX")).isEqualTo("XVIII");
		assertThat(roemischeZahl.roemischeZahlenAddieren2("XCIX", "XCIX")).isEqualTo("CXCVIII");
		
		assertThat(roemischeZahl.roemischeZahlenAddieren2("CDL", "DCLXX")).isEqualTo("MCXX");
		assertThat(roemischeZahl.roemischeZahlenAddieren2("CMXC", "CMLXXVI")).isEqualTo("MCMLXVI");
	}
}
