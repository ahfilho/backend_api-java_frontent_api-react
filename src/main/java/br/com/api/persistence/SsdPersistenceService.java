package br.com.api.persistence;

import br.com.api.auth.token.JWTTokenHelper;
import br.com.api.entity.Ssd;
import br.com.api.entity.ProductCategorySsd;
import br.com.api.service.SsdService;
import br.com.api.link.generator.BuildFileLinkSsd;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@AllArgsConstructor
@Controller
public class SsdPersistenceService {

    private final JWTTokenHelper jwtTokenHelper;
    private final SsdService ssdService;
    private final BuildFileLinkSsd buildFileLink;

    public SsdPersistenceService(JWTTokenHelper jwtTokenHelper, SsdService ssdService, BuildFileLinkSsd buildFileLink) {
        this.jwtTokenHelper = jwtTokenHelper;
        this.ssdService = ssdService;
        this.buildFileLink = buildFileLink;
    }

    public void SsdPersistence(MultipartFile file, Ssd ssd, ProductCategorySsd productCategorySsd)  throws IOException {
        ssdService.serviceSaveSsd(ssd, file, productCategorySsd);

    }

}
