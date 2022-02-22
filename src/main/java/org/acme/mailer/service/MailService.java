package org.acme.mailer.service;

import io.quarkus.mailer.MailTemplate;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
public class MailService {

    /**
     * Send html mail using parameter in async mode with MailTemplate
     *
     * @param from     the email sender
     * @param toEmails the email recipients
     * @param subject  the email subject
     * @param ccEmails the hidden email recipients
     * @param template the html email template
     */
    public void sendTypeSafeTemplate(String from,
                                     String[] toEmails,
                                     String subject,
                                     String[] ccEmails,
                                     MailTemplate.MailTemplateInstance template) {
        logger.info("Sending email to {} from {}",
                String.join(",", toEmails), from);
        template
                .from(from)
                .to(toEmails)
                .subject(subject)
                .cc(ccEmails)
                .send().subscribe().with(
                        it -> logger.info("Email sent"),
                        error -> logger.error("A problem occured when sending email", error)
                );
    }
}
