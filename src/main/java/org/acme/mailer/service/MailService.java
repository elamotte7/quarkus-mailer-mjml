package org.acme.mailer.service;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.MailTemplate;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;

@Slf4j
@ApplicationScoped
public class MailService {

    private final Mailer mailer;

    public MailService(Mailer mailer) {
        this.mailer = mailer;
    }

    /**
     * Send html mail using parameter in async mode with MailTemplate
     *
     * @param from     the email sender
     * @param toEmails the email recipients
     * @param subject  the email subject
     * @param ccEmails the hidden email recipients
     * @param template the html email template
     */
    public void sendTypeSafeMailTemplate(String from,
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
                                         TemplateInstance template) {
        logger.info("Sending email to {} from {}",
                String.join(",", toEmails), from);
        mailer.send(Mail.withHtml(
                "",
                subject,
                template.render())
                .setFrom(from)
                .setTo(Arrays.stream(toEmails).toList())
                .setCc(Arrays.stream(ccEmails).toList())
        );
    }
}
