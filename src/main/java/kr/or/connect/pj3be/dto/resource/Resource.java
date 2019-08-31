package kr.or.connect.pj3be.dto.resource;

import java.io.InputStream;

public class Resource {
    private File file;
    private String filename;
    private InputStream inputStream;
    private Boolean open;
    private Boolean readable;
    private URI uri;
    private URL url;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "file=" + file +
                ", filename='" + filename + '\'' +
                ", inputStream=" + inputStream +
                ", open=" + open +
                ", readable=" + readable +
                ", uri=" + uri +
                ", url=" + url +
                '}';
    }
}
