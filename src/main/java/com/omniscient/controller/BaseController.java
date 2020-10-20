/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omniscient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.forms.PdfAcroForm;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Edwin
 */

@Controller
public class BaseController {
    
    public static final String DEST = "./Filled_Out.pdf";
    Logger l = Logger.getLogger("log");
    
    @RequestMapping("/form")
    public ModelAndView initializer(){
        return new ModelAndView("index");
    }
    
    @RequestMapping("/pdf")   
    @ResponseBody
    public ResponseEntity<byte[]> index( @RequestParam(value="fullName", defaultValue = "Demo Name") String fullName,
            @RequestParam(value = "openingBalance", defaultValue = "$34,093.21") String openingBalance,
            @RequestParam(value = "accountNumber", defaultValue = "0218981212") String accountNumber,
            @RequestParam(value = "withdrawals", defaultValue = "$29,828.20") String withdrawals,
            @RequestParam(value = "deposits", defaultValue = "$38,389.92") String deposits,
            HttpServletResponse response) throws IOException{
        File file = File.createTempFile("demo", "file");
        File fileSrc = new File("./Bank_Statement.pdf");
        String filename = "Bank Statement.pdf";
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(fileSrc), new PdfWriter(file));
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
        form.getField("OpeningBalance").setValue(openingBalance).setReadOnly(true);
        form.getField("CompleteName").setValue(fullName).setReadOnly(true);
        form.getField("AccountNumber").setValue(accountNumber).setReadOnly(true);
        form.getField("Withdrawals").setValue(withdrawals).setReadOnly(true);
        form.getField("Deposits").setValue(deposits).setReadOnly(true);
        form.getField("Date1").setValue("10/09/2020").setReadOnly(true);
        form.getField("Date2").setValue("12/09/2020").setReadOnly(true);
        form.getField("Date3").setValue("18/09/2020").setReadOnly(true);
        form.getField("Date4").setValue("28/09/2020").setReadOnly(true);
        form.getField("Details1").setValue("").setReadOnly(true);
        form.getField("Details2").setValue("").setReadOnly(true);
        form.getField("Details3").setValue("").setReadOnly(true);
        form.getField("Details4").setValue("").setReadOnly(true);
        form.getField("Withdrawals1").setValue("$12,2833.29").setReadOnly(true);
        form.getField("Withdrawals2").setValue("").setReadOnly(true);
        form.getField("Withdrawals3").setValue("$16,299.54").setReadOnly(true);
        form.getField("Withdrawals4").setValue("").setReadOnly(true);
        form.getField("Deposits1").setValue("").setReadOnly(true);
        form.getField("Deposits2").setValue("$23,283.28").setReadOnly(true);
        form.getField("Deposits3").setValue("").setReadOnly(true);
        form.getField("Deposits4").setValue("$14,929.38").setReadOnly(true);
        form.getField("Closing Balance").setValue("$67,293.92").setReadOnly(true);
        pdfDoc.close();
        byte[] contents = Files.readAllBytes(file.toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return responseEntity;
    }
    
}
