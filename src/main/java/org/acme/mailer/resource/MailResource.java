package org.acme.mailer.resource;

import org.acme.mailer.dto.EmailNotification;
import org.acme.mailer.service.MailService;
import org.acme.mailer.template.EmailTemplates;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/mail")
public class MailResource {

    private final MailService mailService;

    public MailResource(MailService mailService) {
        this.mailService = mailService;
    }

    @GET
    @Path("/template")
    public Response sendEmailWithTemplate() {
        mailService.sendTypeSafeTemplate("elamotte7@test.com",
                new String[]{"elamotte7@mail.com", "elamotte7@test.fr"},
                "subject",
                new String[]{"elamotte@cc.fr"},
                EmailTemplates.Templates.emailNotification(
                        EmailNotification.builder()
                                .logoEmailHeader("logoEmailHeader")
                                .logoEmailFooter("logoemailFooter")
                                .contractAdditionalNotes("additionalNotes")
                                .contractId("AZRE-AZRAZR-34124-13143")
                                .contractLink("http://my.contract.org")
                                .senderEmail("test@test.fr")
                                .senderFullName("John Doe")
                                .build())
        );

        return Response.ok().build();
    }
}
