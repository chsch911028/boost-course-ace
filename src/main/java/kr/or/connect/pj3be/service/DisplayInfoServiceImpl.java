package kr.or.connect.pj3be.service;

import kr.or.connect.pj3be.dao.CommentDao;
import kr.or.connect.pj3be.dao.DisplayInfoDao;
import kr.or.connect.pj3be.dao.ProductDao;
import kr.or.connect.pj3be.dto.comment.Comment;
import kr.or.connect.pj3be.dto.comment.CommentImage;
import kr.or.connect.pj3be.dto.displayInfo.DisplayInfo;
import kr.or.connect.pj3be.dto.displayInfo.DisplayInfoImage;
import kr.or.connect.pj3be.dto.displayInfo.DisplayInfoResponse;
import kr.or.connect.pj3be.dto.product.ProductImage;
import kr.or.connect.pj3be.dto.product.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

    @Autowired
    private DisplayInfoDao displayInfoDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CommentDao commentDao;

    @Transactional(readOnly = true)
    @Override
    public DisplayInfoResponse getDisplayInfoResponse(Integer displayInfoId) {

        DisplayInfo displayInfo = displayInfoDao.getDisplayInfo(displayInfoId);
        DisplayInfoImage displayInfoImage = displayInfoDao.getDisplayInfoImage(displayInfo.getDisplayInfoId());
        List<ProductImage> allProductImages = productDao.getAllProductImages(displayInfo.getProductId());
        List<ProductPrice> allProductPrices = productDao.getAllProductPrices(displayInfo.getProductId());
        List<Comment> allComments = commentDao.getAllComments(displayInfo.getProductId());
        //SET CommentImage in Comment
        allComments.stream()
                .forEach(comment -> {
                    List<CommentImage> imageList = commentDao.getAllCommentImagesByComment(comment.getCommentId());
                    comment.setCommentImages(imageList);
                });
        Double averageScore = allComments.stream().mapToDouble(Comment::getScore).average().orElse(0);

        DisplayInfoResponse displayInfoResponse = new DisplayInfoResponse();
        displayInfoResponse.setDisplayInfo(displayInfo);
        displayInfoResponse.setDisplayInfoImage(displayInfoImage);
        displayInfoResponse.setProductImages(allProductImages);
        displayInfoResponse.setProductPrices(allProductPrices);
        displayInfoResponse.setComments(allComments);
        displayInfoResponse.setAverageScore(averageScore);

        return displayInfoResponse;
    }
}
