package org.acme.mailer.template;

import io.quarkus.mailer.MailTemplate;
import io.quarkus.qute.CheckedTemplate;
import org.acme.mailer.dto.EmailNotification;

public class EmailTemplates {
    @CheckedTemplate
    public static class Templates {
        public static native MailTemplate.MailTemplateInstance emailNotification(EmailNotification context);
    }
}
