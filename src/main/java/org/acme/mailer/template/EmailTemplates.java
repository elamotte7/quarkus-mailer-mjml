package org.acme.mailer.template;

import io.quarkus.mailer.MailTemplate;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.acme.mailer.dto.EmailNotification;

public class EmailTemplates {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance emailNotificationTemplate(EmailNotification context);
        public static native MailTemplate.MailTemplateInstance emailNotificationMailTemplate(EmailNotification context);
    }
}
