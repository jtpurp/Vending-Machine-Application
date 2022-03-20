package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Log {

   // private File log;

   // public Log(String logFile) {
   //     this.log = new File(logFile);
  //  }

    File logFile = new File("Log.txt");

    public void setLog(String audit, BigDecimal money1, BigDecimal money2) {

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(logFile,true),true)) {
            DateTimeFormatter americanDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String americanDate = LocalDate.now().format(americanDateFormat);

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
            String rightFormat = LocalTime.now().format(timeFormatter);

            logWriter.write(americanDate + " " + rightFormat + " " + audit + " " + "$" + money1 + " " + "$" + money2 + "\n");

        } catch (FileNotFoundException fnf){
            System.out.println("Something Went Wrong:" + fnf.getMessage());
        }
    }
}
