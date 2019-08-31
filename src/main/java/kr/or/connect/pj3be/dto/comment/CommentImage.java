package kr.or.connect.pj3be.dto.comment;

public class CommentImage {
    private String contentType; //파일 확장자
    private String createDate; // ($date-time) 생성일
    private Boolean deleteFlag; // 삭제 여부
    private Integer fileId; //파일 id
    private String fileName; // 파일 이름
    private Integer imageId; //이미지 Id
    private String modifyDate; //($date-time) 수정일
    private Integer reservationInfoId; //예약 Id
    private Integer reservationUserCommentId; //예약자 상품평 Id
    private String saveFileName; //파일 저장 위치 이름

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

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public Integer getReservationUserCommentId() {
        return reservationUserCommentId;
    }

    public void setReservationUserCommentId(Integer reservationUserCommentId) {
        this.reservationUserCommentId = reservationUserCommentId;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    @Override
    public String toString() {
        return "CommentImage{" +
                "contentType='" + contentType + '\'' +
                ", createDate='" + createDate + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", imageId=" + imageId +
                ", modifyDate='" + modifyDate + '\'' +
                ", reservationInfoId=" + reservationInfoId +
                ", reservationUserCommentId=" + reservationUserCommentId +
                ", saveFileName='" + saveFileName + '\'' +
                '}';
    }
}
