package io.javademo.micro.documents;

import java.io.Serializable;

// The bean has to be Serializable
public class DocumentInfoBean implements Serializable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
