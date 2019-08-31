package kr.or.connect.pj3be.dto.product;

public class ProductImage {
    private String contentType; // 파일 확장자
    private String createDate; // ($date-time) 생성일
    private Boolean deleteFlag; // 삭제 여부
    private Integer fileInfoId; // 파일 Id
    private String fileName; // 파일 이름
    private String modifyDate; // ($date-time) 수정일
    private Integer productId; // 상품 Id
    private Integer productImageId; // 상품 이미지 Id
    private String saveFileName; // 파일 저장 위치 이름
    private String type; // 이미지 타입 (main, thumbnail, etc) // Enum: Array [ 3 ] [ ma, th, et ]

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(Integer fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "contentType='" + contentType + '\'' +
                ", createDate='" + createDate + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", fileInfoId=" + fileInfoId +
                ", fileName='" + fileName + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", productId=" + productId +
                ", productImageId=" + productImageId +
                ", saveFileName='" + saveFileName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
