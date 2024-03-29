package br.com.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.api.controller.ClientController;
import br.com.api.controller.upload.controller.SsdUploadController;
import br.com.api.controller.SacController;
import br.com.api.controller.RamController;
import br.com.api.repository.ClientRepository;
import br.com.api.service.ClientService;
import br.com.api.service.CpuFileService;
import br.com.api.service.SacService;
import br.com.api.service.RamService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@EnableJpaRepositories("web.repositories")
//@SpringBootTest
@WebMvcTest
public class ApiApplicationTests {
	// Teste de unidade

	@Autowired
	private ClientController contactController;

	@Autowired 
	private ClientRepository contactRepository;
	
	@MockBean
	private ClientService contactService;

	@Autowired
	private SsdUploadController ioc;

	@MockBean
	private CpuFileService ios;

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






