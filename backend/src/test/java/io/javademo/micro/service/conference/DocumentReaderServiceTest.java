package io.javademo.micro.service.conference;

import io.javademo.micro.documents.DocumentReaderService;
import io.javademo.micro.service.git.GitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class DocumentReaderServiceTest {


    @Test
    public void TestReading() throws IOException {
        GitService documentReaderService = new GitService();

    }

}
