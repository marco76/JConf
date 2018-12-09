package io.javademo.micro.service.conference;


import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Startup
public class ConferenceRepository {

    // todo as property
    private static String urlString = "https://raw.githubusercontent.com/marco76/conferences/master/conferences-list.md";


    private List<Conference> conferenceList = Collections.emptyList();


    @Schedule(minute = "0", hour = "*/4")
    @PostConstruct
    public void importCalendarFromSource() {
        System.out.println("Reading the calendar");
        try {
            conferenceList = readCalendarDataFromUrl();
        } catch (IOException ex) {
            System.out.println("Cannot read the calendar's source");
        }
    }

    public List<Conference> readCalendarDataFromUrl() throws IOException {

        // create the url
        URL url = new URL(urlString);

        return readInputStream(url.openStream());
    }

    public List<Conference> readInputStream(InputStream inputStream) throws IOException {

        List conferenceModelCollection;
        try ( // open the url stream, wrap it an a few "readers"
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            conferenceModelCollection = reader.lines()
                    .skip(4)
                    .map(this::convertToConference)
                    .sorted((f1, f2) -> f1.getBegin().compareTo(f2.getEnd()))
                    .collect(Collectors.toList());
        }

        return conferenceModelCollection;
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public List<Conference> getConferenceList() {
        return conferenceList;
    }

    private Conference convertToConference(String dataLine) {
        String data[] = dataLine.split("\\|");
        int dataPosition = 1;

        Conference conference = new Conference();

        conference.setName(data[dataPosition++]);
        conference.setWebsite(data[dataPosition++]);
        conference.setBegin(LocalDate.parse(data[dataPosition++], DATE_FORMATTER));
        conference.setEnd(LocalDate.parse(data[dataPosition++], DATE_FORMATTER));
        conference.setCity(data[dataPosition++]);
        conference.setCountry(data[dataPosition++]);
        conference.setIsoCountry(data[dataPosition++]);

        if (dataPosition < data.length && data[dataPosition] != null) {
            conference.setCfp(LocalDate.parse(data[dataPosition++]));
        }

        return conference;
    }
}
