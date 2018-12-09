package io.javademo.micro.api;

import io.javademo.micro.service.conference.Conference;
import io.javademo.micro.service.conference.ConferenceRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("conferences")
public class ConferenceResource {

    @Inject
    ConferenceRepository conferenceRepository;

    @GET
    public List<Conference> getConferences() {
        return conferenceRepository.getConferenceList();
    }

    @Path("reload")
    @GET //todo implement a post when the ui is ready
    public void reload() {
        conferenceRepository.importCalendarFromSource();
    }
}
