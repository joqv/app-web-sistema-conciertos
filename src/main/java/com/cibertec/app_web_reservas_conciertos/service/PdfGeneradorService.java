package com.cibertec.app_web_reservas_conciertos.service;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Map;

@Service
public class PdfGeneradorService {

    @Autowired
    private TemplateEngine templateEngine;

    public byte[] generatePdfFromHtml(String templateName, Map<String, Object> data) throws IOException {

        Context context = new Context();
        context.setVariables(data);
        String processedHtml = templateEngine.process(templateName, context);

        String baseUri = FileSystems.getDefault().getPath("src/main/resources/static/").toUri().toString();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(processedHtml, baseUri);
        builder.toStream(outputStream);
        builder.run();

        return outputStream.toByteArray();
    }
}
