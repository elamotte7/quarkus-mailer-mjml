package org.acme.mailer.resource;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/simple-mail")
public class SimpleMailResource {

    private final Mailer mailer;

    public SimpleMailResource(Mailer mailer) {
        this.mailer = mailer;
    }

    @Inject
    private Template hello;

    @Inject
    @Location("my_sub_directory/hello")
    private Template myTemplate;

    @GET
    public Response sendMailHello() {
        mailer.send(
                Mail.withText(
                        "test@test.com",
                        "Hello Quarkus Mailer",
                        "My first email with Quarkus"
                )
        );

        return Response.ok().build();
    }

    @GET
    @Path("/template")
    public Response sendMailHelloWithTemplate() {
        // use Template /src/main/resources/templates/hello.txt
        mailer.send(
                Mail.withText(
                        "test@test.com",
                        "Hello Quarkus Mailer",
                        hello.data("name", "John Doe").render()
                )
        );
        
        // use Template /src/main/resources/templates/my_sub_directory/hello.txt
        mailer.send(
                Mail.withText(
                        "test@test.com",
                        "Hello Quarkus Mailer",
                        myTemplate.data("name", "John Doe").render()
                )
        );

        return Response.ok().build();
    }
}
