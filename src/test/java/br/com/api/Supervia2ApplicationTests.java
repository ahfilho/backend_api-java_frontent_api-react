package br.com.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.api.controller.ContactController;
import br.com.api.controller.ImageController;
import br.com.api.controller.SacController;
import br.com.api.controller.RamController;
import br.com.api.entity.Client;
import br.com.api.repository.ContactRepository;
import br.com.api.service.ContactService;
import br.com.api.service.OfferImageService;
import br.com.api.service.SacService;
import br.com.api.service.RamService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@EnableJpaRepositories("web.repositories")
//@SpringBootTest
@WebMvcTest
class Supervia2ApplicationTests {
	// Teste de unidade

	@Autowired
	private ContactController contactController;

	@Qualifier("contact")
	private Client contactModel;

	@Autowired 
	private ContactRepository contactRepository;
	
	@MockBean
	private ContactService contactService;

	@Autowired
	private ImageController ioc;

	@MockBean
	private OfferImageService ios;

	@Autowired
	private SacController sacController;

	@MockBean
	private SacService sacService;

	@Autowired
	private RamController whatsController;

	@MockBean
	private RamService whatsService;

	// private ContactRepository contactRepository;

	@BeforeEach
	public void setup() { //
		RestAssuredMockMvc.standaloneSetup(this.contactController);
	}

	@Test
	public void returnSucess_ContactSave( ) {

//		when(contactRepository.save(any(null)

	}

	// Testa o endpoint listar t
	/*@Test
	public void returnSucess_ContactList() {

		when(this.contactService.contactList());
		RestAssuredMockMvc.given().accept(ContentType.JSON).when().get("/cadcontato").then()
				.statusCode(HttpStatus.OK.value());

	}*/
}






