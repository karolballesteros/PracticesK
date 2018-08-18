package net.phptravels.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.phptravels.bc.BC;
import net.phptravels.utils.Constants;
import org.openqa.selenium.WebDriver;

public class Steps {
	private WebDriver driver;
	private BC bc = new BC(Constants.urlAmbiente);

	@Given("^Dubai como destino para comprar un tour$")
	public void dubai_como_destino_para_comprar_un_tour() throws Throwable {
		System.out.println("Dubai como destino para comprar un tour$");
		bc.searchDubaiTours();
	}

	@Given("^escoger uno de los tours presentados$")
	public void escoger_uno_de_los_tours_presentados() throws Throwable {
//		bc.searchDubaiTours2();
	}

	@Then("^comprar como invitado$")
	public void comprar_como_invitado() throws Throwable {
//		bc.searchDubaiTours3();
	}

}
