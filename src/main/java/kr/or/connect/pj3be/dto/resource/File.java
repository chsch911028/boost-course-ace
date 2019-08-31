package kr.or.connect.pj3be.dto.resource;

public class File {
    private Boolean absolute;
    private File absoluteFile;
    private String absolutePath;
    private File canonicalFile;
    private String canonicalPath;
    private Boolean directory;
    private Boolean executable;
    private Boolean file;
    private Integer freeSpace;
    private Boolean hidden;
    private Integer lastModified;
    private String name;
    private String parent;
    private File parentFile;
    private String path;
    private Boolean readable;
    private Integer totalSpace;
    private Integer usableSpace;
    private Boolean writable;

    public Boolean getAbsolute() {
        return absolute;
    }

    public void setAbsolute(Boolean absolute) {
        this.absolute = absolute;
    }

    public File getAbsoluteFile() {
        return absoluteFile;
    }

    public void setAbsoluteFile(File absoluteFile) {
        this.absoluteFile = absoluteFile;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public File getCanonicalFile() {
        return canonicalFile;
    }

    public void setCanonicalFile(File canonicalFile) {
        this.canonicalFile = canonicalFile;
    }

    public String getCanonicalPath() {
        return canonicalPath;
    }

    public void setCanonicalPath(String canonicalPath) {
        this.canonicalPath = canonicalPath;
    }

    public Boolean getDirectory() {
        return directory;
    }

    public void setDirectory(Boolean directory) {
        this.directory = directory;
    }

    public Boolean getExecutable() {
        return executable;
    }

    public void setExecutable(Boolean executable) {
        this.executable = executable;
    }

    public Boolean getFile() {
        return file;
    }

    public void setFile(Boolean file) {
        this.file = file;
    }

    public Integer getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Integer freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getLastModified() {
        return lastModified;
    }

    public void setLastModified(Integer lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public File getParentFile() {
        return parentFile;
    }

    public void setParentFile(File parentFile) {
        this.parentFile = parentFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public Integer getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(Integer totalSpace) {
        this.totalSpace = totalSpace;
    }

    public Integer getUsableSpace() {
        return usableSpace;
    }

    public void setUsableSpace(Integer usableSpace) {
        this.usableSpace = usableSpace;
    }

    public Boolean getWritable() {
        return writable;
    }

    public void setWritable(Boolean writable) {
        this.writable = writable;
    }

    @Override
    public String toString() {
        return "File{" +
                "absolute=" + absolute +
                ", absoluteFile=" + absoluteFile +
                ", absolutePath='" + absolutePath + '\'' +
                ", canonicalFile=" + canonicalFile +
                ", canonicalPath='" + canonicalPath + '\'' +
                ", directory=" + directory +
                ", executable=" + executable +
                ", file=" + file +
                ", freeSpace=" + freeSpace +
                ", hidden=" + hidden +
                ", lastModified=" + lastModified +
                ", name='" + name + '\'' +
                ", parent='" + parent + '\'' +
                ", parentFile=" + parentFile +
                ", path='" + path + '\'' +
                ", readable=" + readable +
                ", totalSpace=" + totalSpace +
                ", usableSpace=" + usableSpace +
                ", writable=" + writable +
                '}';
    }
}
