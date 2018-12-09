package io.javademo.micro.api;

import io.javademo.micro.documents.DocumentReaderService;
import io.javademo.micro.service.speaker.SpeakersListService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.util.List;

@Path("speaker")
public class SpeakerResource {


    @Inject
    private SpeakersListService speakersListService;
    @Inject
    private DocumentReaderService documentReaderService;

    @GET
    @Path("list")
    public List<String> list() throws IOException {
        return speakersListService.readListFromUrl();
    }

    @GET
    @Path("id/{id}")
    public String getSpeaker(@PathParam("id") String id) throws IOException {
        return documentReaderService.convertMdToHtml(speakersListService.getSpeaker(id));
    }
}
