package io.javademo.micro.documents;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;
import io.javademo.micro.service.git.GitService;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;


public class DocumentReaderService {

    @Inject
    private CacheManager manager;
    @Inject
    private GitService gitService;

    private String DEFAULT_PATH = "https://raw.githubusercontent.com/marco76/marco76.github.io/master/_posts/";
    private String TYPE_MARKDOWN = ".md";


    public String readGitFile(final String documentPath) throws IOException {
        DocumentInfoBean resultDocument = retrieveDocument(documentPath);

        return resultDocument.getContent();
    }


    public void setManager(CacheManager manager) {
        this.manager = manager;
    }

    private DocumentInfoBean retrieveDocument(String documentPath) throws IOException {

        Cache<String, DocumentInfoBean> cache = manager.getCache("documents",
                String.class,
                DocumentInfoBean.class);

        DocumentInfoBean resultDocument;
        if (cache.containsKey(documentPath)) {
            resultDocument = cache.get(documentPath);
        } else {
            resultDocument = new DocumentInfoBean();
            URL url = new URL(DEFAULT_PATH + documentPath + TYPE_MARKDOWN);

            resultDocument.setContent(gitService.getCloudDocument(url));

            cache.put(documentPath, resultDocument);
        }
        return resultDocument;
    }

    public String getGitFileAsHtml(String postName) throws IOException {
        String content = readGitFile(postName);
        return convertMdToHtml(content);

    }

    public String convertMdToHtml(String content) {
        MutableDataSet options = new MutableDataSet();
        options.set(Parser.EXTENSIONS, Collections.singleton(TablesExtension.create()));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(content);
        return renderer.render(document);
    }
}