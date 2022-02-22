package org.acme.mailer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmailNotification {
    private String logoEmailHeader;
    private String logoEmailFooter;
    private String senderEmail;
    private String senderFullName;
    private String contractId;
    private String contractLink;
    private String contractAdditionalNotes;
    private String subject;
}
