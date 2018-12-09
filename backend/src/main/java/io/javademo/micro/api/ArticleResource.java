package io.javademo.micro.api;

import io.javademo.micro.documents.DocumentReaderService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;

@Path("post")
public class ArticleResource {

    @Inject
    DocumentReaderService documentReaderService;

    @GET
    @Path("/{postName}")
    public String getPost(@PathParam("postName") final String postName) throws IOException {
        return documentReaderService.readGitFile(postName);
    }

    @GET
    @Path("/html/{postName}")
    public String getHtmlPost(@PathParam("postName") final String postName) throws IOException {
        return documentReaderService.getGitFileAsHtml(postName);
    }
}
