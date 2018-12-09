package io.javademo.micro.service.speaker;

import io.javademo.micro.service.speaker.SpeakersListService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(JUnit4.class)
public class SpeakersServiceTest {

    private SpeakersListService speakersServiceTest = new SpeakersListService();

    @Test
    public void serviceTest() throws IOException {
        Assert.assertEquals(1, 1);

        List<String> speakers = speakersServiceTest.readSpeakers(data());

        Assert.assertEquals(2, speakers.size());
    }

    private InputStream data() {
        String dataString =
                "---\n"+
                        "bla bla\n"
                        + "---\n"
                        + "marco"
                        + "\n"
        + "micky"
                + "\n";

        InputStream targetStream = new ByteArrayInputStream(dataString.getBytes());
        return targetStream;

    }
}


