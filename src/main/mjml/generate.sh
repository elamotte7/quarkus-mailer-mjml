#!/bin/sh
npm install --global mjml;
mjml emailNotificationMailTemplate.mjml -o ../resources/templates/EmailTemplates/emailNotificationMailTemplate.html;
mjml emailNotificationTemplate.mjml -o ../resources/templates/EmailTemplates/emailNotificationTemplate.html;