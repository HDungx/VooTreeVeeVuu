package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.dto.EmailReceiptDTO;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class BookingPdfService {
    private static final Color HEADER_COLOR = new DeviceRgb(47, 107, 177);
    private static final Color BORDER_COLOR = new DeviceRgb(64, 64, 64);
    private static final Color WHITE_COLOR = new DeviceRgb(255, 255, 255);

    private static final String BOLD_FONT = "Helvetica-Bold";
    private static final String REGULAR_FONT = "Helvetica";

    public File generateBookingPdf(EmailReceiptDTO dto, Path filePath) throws Exception {
        try (PdfWriter writer = new PdfWriter(filePath.toFile()); PdfDocument pdfDoc = new PdfDocument(writer);
             Document document = new Document(pdfDoc)) {

            // Define fonts
            PdfFont boldFont = PdfFontFactory.createFont(BOLD_FONT);
            PdfFont regularFont = PdfFontFactory.createFont(REGULAR_FONT);

            // Website information
            document.add(createWebsiteInfoTable(boldFont, regularFont));

            // Title
            document.add(createTitle("Booking Information", boldFont));

            // Divider
            document.add(createDivider());

            // Customer information table
            document.add(createCustomerInfoTable(dto, boldFont, regularFont));

            // Booking information table
            document.add(createBookingInfoTable(dto, boldFont, regularFont));

            // Divider
            document.add(createDivider());
        }

        return filePath.toFile();
    }

    private Table createWebsiteInfoTable(PdfFont boldFont, PdfFont regularFont) throws IOException {
        float[] columnWidths = {1, 4}; // Adjust the widths as needed
        Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth().setBorder(Border.NO_BORDER);

        // Add logo
        Image logo = new Image(ImageDataFactory.create("src/main/resources/logo2.png")); // Adjust the path to your logo
        // image
        logo.setWidth(80); // Adjust the size as needed
        Cell logoCell = new Cell().add(logo).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        table.addCell(logoCell);

        // Add website information
        Paragraph websiteInfo = new Paragraph()
                .add(new Text("VooTreeVeeVuu Online Booking Service\n").setFont(boldFont))
                .add(new Text("vootreeveevuu@gmail.com").setFont(regularFont));
        Cell infoCell = new Cell().add(websiteInfo).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
        table.addCell(infoCell);

        table.setMarginBottom(10); // Adjust the margin as needed
        return table;
    }

    private Paragraph createTitle(String titleText, PdfFont font) {
        return new Paragraph(titleText).setFont(font).setFontSize(24).setTextAlignment(
                TextAlignment.CENTER).setMarginBottom(20);
    }

    private Table createCustomerInfoTable(EmailReceiptDTO dto, PdfFont boldFont,
                                          PdfFont regularFont) throws IOException {
        float[] columnWidths = {150f, 300f};
        Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth().setBorder(
                Border.NO_BORDER);
        table.addHeaderCell(createHeaderCell("Customer Information"));
        table.setMarginBottom(20f);
        table.setMarginTop(10f);
        addTableRow(table, "Email", dto.getCusEmail(), boldFont);
        addTableRow(table, "Full Name", dto.getCusFullName(), regularFont);
        addTableRow(table, "Phone Num.", dto.getCusPhoneNum(), boldFont);
        return table;
    }

    private Table createBookingInfoTable(EmailReceiptDTO dto, PdfFont boldFont,
                                         PdfFont regularFont) throws IOException {
        float[] columnWidths = {150f, 300f};
        Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth().setBorder(
                Border.NO_BORDER);
        table.addHeaderCell(createHeaderCell("Booking Information"));
        table.setMarginBottom(20f);
        table.setMarginTop(10f);
        addTableRow(table, "Hotel Name", dto.getHotelName(), boldFont);
        addTableRow(table, "Address", dto.getAddress(), boldFont);
        addTableRow(table, "Hotel Phone", dto.getHotelPhoneNum(), regularFont);
        addTableRow(table, "Check-In Time", formatDateTime(dto.getCheckInTime()), regularFont);
        addTableRow(table, "Check-Out Time", formatDateTime(dto.getCheckOutTime()), regularFont);
        addTableRow(table, "Owner Email", dto.getOwnerEmail(), regularFont);

        // Add gap
        Cell gapCell = new Cell(1, 2)  // Span across two columns
                .setBorder(Border.NO_BORDER).setHeight(20);
        table.addCell(gapCell);

        addTableRow(table, "Room Type", dto.getRoomType(), boldFont);
        addTableRow(table, "Number of Rooms", dto.getNum_of_rooms().toString(), regularFont);
        addTableRow(table, "Number of Guests", dto.getNum_of_guests().toString(), regularFont);
        addTableRow(table, "Check-In Date", formatDate(LocalDate.parse(dto.getCheckInDate())), boldFont);
        addTableRow(table, "Check-Out Date", formatDate(LocalDate.parse(dto.getCheckOutDate())), boldFont);
        addTableRow(table, "Total Price", formatPrice(dto.getTotalPrice()), boldFont);
        return table;
    }

    private void addTableRow(Table table, String fieldName, String fieldValue, PdfFont font) {
        table.addCell(createCell(fieldName, font, TextAlignment.LEFT, null)).setBorder(Border.NO_BORDER);
        table.addCell(createCell(fieldValue, font, TextAlignment.LEFT, null)).setBorder(Border.NO_BORDER);
    }

    private Cell createCell(String content, PdfFont font, TextAlignment alignment, Color backgroundColor) {
        Cell cell = new Cell().add(new Paragraph(content).setFont(font)).setTextAlignment(alignment);
        if (backgroundColor != null) {
            cell.setBackgroundColor(backgroundColor);
        }
        cell.setBorder(new SolidBorder(BORDER_COLOR, 0.5f));
        cell.setPadding(5);
        return cell;
    }

    private Cell createHeaderCell(String content) throws IOException {
        return new Cell().add(
                new Paragraph(content).setFont(PdfFontFactory.createFont(BOLD_FONT)).setFontSize(12).setFontColor(
                        WHITE_COLOR)).setBackgroundColor(HEADER_COLOR).setTextAlignment(TextAlignment.CENTER).setBorder(
                new SolidBorder(BORDER_COLOR, 0.5f)).setPadding(5);
    }

    private Table createDivider() {
        Table divider = new Table(new float[]{1}).useAllAvailableWidth();
        divider.setBorder(new SolidBorder(BORDER_COLOR, 1f));
        divider.setMarginBottom(10);
        return divider;
    }

    private String formatPrice(float price) {
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        return numberFormat.format(price) + " VND";
    }

    private String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    private String formatDateTime(LocalTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return dateTime.format(formatter);
    }
}
