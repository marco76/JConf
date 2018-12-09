package io.javademo.micro.service.git;

import io.javademo.micro.documents.GitHubTextUtil;

import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Stateless
public class GitService {

    private String PATH_RAW = "https://github.com/marco76/marco76.github.io/raw/master";


    public String getCloudDocument(@NotNull final URL url) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder stringBuilder = new StringBuilder(1000);

        reader.lines()
                .forEach(line -> stringBuilder.append(line).append('\n'));

        reader.close();

        return GitHubTextUtil.convertFromJekyllText(stringBuilder.toString(), PATH_RAW);
    }
}
