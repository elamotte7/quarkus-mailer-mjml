package org.acme.mailer.resource;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.MockMailbox;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class MailResourceTest {
    private static final String TO = "elamotte7@mail.com";

    @Inject
    MockMailbox mailbox;

    @BeforeEach
    void init() {
        mailbox.clear();
    }

    @Test
    void testMailTemplate() {
        given()
                .when()
                .get("/mail/mail-template")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());

        // verify that it was sent
        List<Mail> sent = mailbox.getMessagesSentTo(TO);
        assertEquals(1, sent.size());
        Mail actual = sent.get(0);
        assertTrue(actual.getHtml().contains("Your contract"));
        assertTrue(actual.getSubject().equals("subject"));

        assertEquals(3, mailbox.getTotalMessagesSent());
    }

    @Test
    void testTemplate() {
        given()
                .when()
                .get("/mail/template")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());

        // verify that it was sent
        List<Mail> sent = mailbox.getMessagesSentTo(TO);
        assertEquals(1, sent.size());
        Mail actual = sent.get(0);
        assertTrue(actual.getHtml().contains("Your contract"));
        assertTrue(actual.getSubject().equals("subject"));

        assertEquals(3, mailbox.getTotalMessagesSent());
    }
}

