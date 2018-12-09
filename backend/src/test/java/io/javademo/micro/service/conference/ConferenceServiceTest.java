package io.javademo.micro.service.conference;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(JUnit4.class)
public class ConferenceServiceTest {

    ConferenceRepository conferenceRepository = new ConferenceRepository();

    @Test
    public void serviceTest() throws IOException {
        Assert.assertEquals(1, 1);

        List<Conference> conferenceCollection = conferenceRepository.readInputStream(data());

        Assert.assertEquals(2, conferenceCollection.size());

        Assert.assertEquals("Uphill Conf", conferenceCollection.get(0).getName());
    }


    private InputStream data() {
        String dataString =
                "# Dev conferences" + "\n" + "\n"
                        + "|Name|Website|Begin|End|City|Country|ISO_Country|CFP|\n"
                        + "|---|---|---|---|---|---|---|---|\n"
                        + "|J On The Beach|https://jonthebeach.com/|2019-05-23|2019-05-25|Malaga|Spain|es||"
                        + "\n"
                        + "|Uphill Conf|https://uphillconf.com/|2019-05-02|2019-05-03|Bern|Switzerland|ch||";


        InputStream targetStream = new ByteArrayInputStream(dataString.getBytes());
        return targetStream;

    }
}


