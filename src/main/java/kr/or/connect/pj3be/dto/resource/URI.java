package kr.or.connect.pj3be.dto.resource;

public class URI {
    private Boolean absolute;
    private String authority;
    private String fragment;
    private String host;
    private Boolean opaque;
    private String path;
    private Integer port;
    private String query;
    private String rawAuthority;
    private String rawFragment;
    private String rawPath;
    private String rawQuery;
    private String rawSchemeSpecificPart;
    private String rawUserInfo;
    private String scheme;
    private String schemeSpecificPart;
    private String userInfo;

    public Boolean getAbsolute() {
        return absolute;
    }

    public void setAbsolute(Boolean absolute) {
        this.absolute = absolute;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Boolean getOpaque() {
        return opaque;
    }

    public void setOpaque(Boolean opaque) {
        this.opaque = opaque;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRawAuthority() {
        return rawAuthority;
    }

    public void setRawAuthority(String rawAuthority) {
        this.rawAuthority = rawAuthority;
    }

    public String getRawFragment() {
        return rawFragment;
    }

    public void setRawFragment(String rawFragment) {
        this.rawFragment = rawFragment;
    }

    public String getRawPath() {
        return rawPath;
    }

    public void setRawPath(String rawPath) {
        this.rawPath = rawPath;
    }

    public String getRawQuery() {
        return rawQuery;
    }

    public void setRawQuery(String rawQuery) {
        this.rawQuery = rawQuery;
    }

    public String getRawSchemeSpecificPart() {
        return rawSchemeSpecificPart;
    }

    public void setRawSchemeSpecificPart(String rawSchemeSpecificPart) {
        this.rawSchemeSpecificPart = rawSchemeSpecificPart;
    }

    public String getRawUserInfo() {
        return rawUserInfo;
    }

    public void setRawUserInfo(String rawUserInfo) {
        this.rawUserInfo = rawUserInfo;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getSchemeSpecificPart() {
        return schemeSpecificPart;
    }

    public void setSchemeSpecificPart(String schemeSpecificPart) {
        this.schemeSpecificPart = schemeSpecificPart;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "URI{" +
                "absolute=" + absolute +
                ", authority='" + authority + '\'' +
                ", fragment='" + fragment + '\'' +
                ", host='" + host + '\'' +
                ", opaque=" + opaque +
                ", path='" + path + '\'' +
                ", port=" + port +
                ", query='" + query + '\'' +
                ", rawAuthority='" + rawAuthority + '\'' +
                ", rawFragment='" + rawFragment + '\'' +
                ", rawPath='" + rawPath + '\'' +
                ", rawQuery='" + rawQuery + '\'' +
                ", rawSchemeSpecificPart='" + rawSchemeSpecificPart + '\'' +
                ", rawUserInfo='" + rawUserInfo + '\'' +
                ", scheme='" + scheme + '\'' +
                ", schemeSpecificPart='" + schemeSpecificPart + '\'' +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}
