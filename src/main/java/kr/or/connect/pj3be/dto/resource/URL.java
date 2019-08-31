package kr.or.connect.pj3be.dto.resource;

import java.net.URLStreamHandler;

public class URL {
    private String authority;
    //content
    private Integer efaultPort;
    private URLStreamHandler deserializedFields;
    private String file;
    private String host;
    private String path;
    private Integer ort;
    private String protocol;
    private String query;
    private String ref;
    private Integer serializedHashCode;
    private String userInfo;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getEfaultPort() {
        return efaultPort;
    }

    public void setEfaultPort(Integer efaultPort) {
        this.efaultPort = efaultPort;
    }

    public URLStreamHandler getDeserializedFields() {
        return deserializedFields;
    }

    public void setDeserializedFields(URLStreamHandler deserializedFields) {
        this.deserializedFields = deserializedFields;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getOrt() {
        return ort;
    }

    public void setOrt(Integer ort) {
        this.ort = ort;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getSerializedHashCode() {
        return serializedHashCode;
    }

    public void setSerializedHashCode(Integer serializedHashCode) {
        this.serializedHashCode = serializedHashCode;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "URL{" +
                "authority='" + authority + '\'' +
                ", efaultPort=" + efaultPort +
                ", deserializedFields=" + deserializedFields +
                ", file='" + file + '\'' +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", ort=" + ort +
                ", protocol='" + protocol + '\'' +
                ", query='" + query + '\'' +
                ", ref='" + ref + '\'' +
                ", serializedHashCode=" + serializedHashCode +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}
