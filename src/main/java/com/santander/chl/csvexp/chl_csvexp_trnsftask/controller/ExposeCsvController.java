package com.santander.chl.csvexp.chl_csvexp_trnsftask.controller;

import org.springframework.http.HttpStatus;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.santander.chl.csvexp.chl_csvexp_trnsftask.dto.CsvRequest;
import com.santander.chl.csvexp.chl_csvexp_trnsftask.mock.CustomerBean;
import com.santander.chl.csvexp.chl_csvexp_trnsftask.response.GenericResponse;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ExposeCsvController {

	@GetMapping("/getcsv")
	public GenericResponse getCsvMethod() throws Exception {
		GenericResponse response = new GenericResponse();

		final CustomerBean john = new CustomerBean("1", "John", "Dunbar",
				"1600 Amphitheatre Parkway\nMountain View, CA 94043\nUnited States", null, null,
				"\"May the Force be with you.\" - Star Wars", "jdunbar@gmail.com", 0L);

		final CustomerBean bob = new CustomerBean("2", "Bob", "Down",
				"1601 Willow Rd.\nMenlo Park, CA 94025\nUnited States", true, 0,
				"\"Frankly, my dear, I don't give a damn.\" - Gone With The Wind", "bobdown@hotmail.com", 123456L);

		final List<CustomerBean> customers = Arrays.asList(john, bob);

		ICsvBeanWriter beanWriter = null;
		try {
			beanWriter = new CsvBeanWriter(new FileWriter("C:/Users/mauri/Documents/writeWithCsvBeanWriter.csv"),
					CsvPreference.STANDARD_PREFERENCE);

			final String[] header = new String[] { "customerNo", "firstName", "lastName", "mailingAddress", "married",
					"numberOfKids", "favouriteQuote", "email", "loyaltyPoints" };
			final CellProcessor[] processors = getProcessors();

			beanWriter.writeHeader(header);

			for (final CustomerBean customer : customers) {
				beanWriter.write(customer, header, processors);
			}

		} finally {
			if (beanWriter != null) {
				beanWriter.close();
			}
		}

		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new FileReader("C:/Users/mauri/Documents/writeWithCsvBeanWriter.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split("\n");
				records.add(Arrays.asList(values));
			}
		}

		for (int i = 0; i < records.size(); i++) {
			System.out.println(records.get(i));
		}

		response.setStatus(200);
		response.setMessage("ok");
		response.setCsv(null);

		return response;
	}

	@GetMapping("/export-csv-file")
	@ResponseStatus(HttpStatus.OK)
	public void exportCSVFile(HttpServletResponse response)
			throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, URISyntaxException {

		String filename = "test-data.csv";
		List<CsvRequest> requestList = new ArrayList<>();
		requestList.add(new CsvRequest( "User1", "1", "xyz"));
		requestList.add(new CsvRequest("User2", "2", "xgyz"));
		requestList.add(new CsvRequest("User3", "3", "xbyz"));
		requestList.add(new CsvRequest("User4", "4", "xygz"));
		requestList.add(new CsvRequest("User5", "5", "xydz"));
		exportCsv(filename, response, requestList, CsvRequest.class);
	}

	public static <T> void exportCsv(String fileName, HttpServletResponse response, List<T> respList, Class<T> reqClass)
			throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		try {
			StatefulBeanToCsv<T> writer = new StatefulBeanToCsvBuilder<T>(response.getWriter())
					.withQuotechar(CSVWriter.DEFAULT_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
					.withOrderedResults(true).build();
			writer.write(respList);
		} catch (Exception e) {
			throw new RuntimeException("Exception while Exporting csv file");
		}
	}

	private static CellProcessor[] getProcessors() {

		final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an example, not very robust!
		StrRegEx.registerMessage(emailRegex, "must be a valid email address");

		final CellProcessor[] processors = new CellProcessor[] { new UniqueHashCode(), // customerNo (must be unique)
				new NotNull(), // firstName
				new NotNull(), // lastName
				new NotNull(), // mailingAddress
				new Optional(), // married
				new Optional(new ParseInt()), // numberOfKids
				new NotNull(), // favouriteQuote
				new StrRegEx(emailRegex), // email
				new LMinMax(0L, LMinMax.MAX_LONG) // loyaltyPoints
		};

		return processors;
	}
}
