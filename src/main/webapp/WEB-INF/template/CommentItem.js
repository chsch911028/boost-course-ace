const CommentItem = `<li class="list_item">
         <div>
            <div class="review_area">
            <div class="thumb_area">
                {{#if hasImage}}
                    <a class="thumb" title="이미지 크게 보기"> 
                        <img width="90" height="90" class="img_vertical_top" src="/{{imgSrc}}" alt="리뷰이미지">
                    </a> 
                    <span class="img_count"">{{imgCount}}</span>                    
                {{/if}}                
            </div>
            <h4 class="resoc_name">{{title}}</h4>
            <p class="review">{{comment}}</p>
            </div>
            <div class="info_area">
               <div class="review_info"> <span class="grade">{{score}}</span> <span class="name">{{secretEmail}}</span> <span class="date">{{visitDate}} 방문</span> </div>
            </div>
         </div>
    </li>`;

export default CommentItem;
