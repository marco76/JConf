package io.javademo.micro.service.speaker;

import io.javademo.micro.service.git.GitService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class SpeakersListService {

    @Inject
    GitService gitService;

    private static final String urlString = "https://raw.githubusercontent.com/marco76/conferences/master/speakers-list";
    private final String DEFAULT_PATH = "https://raw.githubusercontent.com/marco76/conferences/master/speakers/";


    public List<String> readListFromUrl() throws IOException {
        // create the url
        URL url = new URL(urlString);

        return readSpeakers(url.openStream());
    }

    protected List<String> readSpeakers(InputStream inputStream) throws IOException {

        List<String> speakers = new ArrayList(10);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();
        boolean fileIntroduction = false;
        while (line != null) {
            if ("---".equals(line)) {
                fileIntroduction = !fileIntroduction;
            }
            line = reader.readLine();

            if (!fileIntroduction && line != null) {
                speakers.add(line);
            }
        }

        return speakers;
    }

    public String getSpeaker(String id) throws IOException {
        URL url = new URL(DEFAULT_PATH + id + ".md");

        return gitService.getCloudDocument(url);
    }

}
