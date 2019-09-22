const locationInfo = `
<div class="box_store_info no_topline">
<a href="#" class="store_location" title="지도웹으로 연결">
  <img
    class="store_map img_thumb"
    alt="map"
    src="https://simg.pstatic.net/static.map/image?version=1.1&amp;crs=EPSG:4326&amp;baselayer=bl_vc_bg&amp;exception=xml&amp;scale=2&amp;caller=mw_smart_booking&amp;overlayers=ol_vc_an&amp;center=127.0011948,37.5717079&amp;markers=type,default2,127.0011948,37.5717079&amp;level=11&amp;w=340&amp;h=150"
  />
  <span class="img_border"></span>
  <span class="btn_map"
    ><i class="spr_book2 ico_mapview"></i
  ></span>
</a>
<h3 class="store_name">{{productDescription}}</h3>
<div class="store_info">
  <div class="store_addr_wrap">
    <span class="fn fn-pin2"></span>
    <p class="store_addr store_addr_bold">
      {{placeStreet}}
    </p>
    <p class="store_addr">
      <span class="addr_old">지번</span>
      <span class="addr_old_detail">
      {{placeLot}}
      </span>
    </p>
    <p class="store_addr addr_detail">{{placeName}}</p>
  </div>
  <div class="lst_store_info_wrap">
    <ul class="lst_store_info">
      <li class="item">
        <span class="item_lt">
          <i class="fn fn-call2"></i>
          <span class="sr_only">전화번호</span>
        </span>
        <span class="item_rt">
          <a href="tel:{{telephone}}" class="store_tel">
          {{telephone}}</a>
        </span>
      </li>
    </ul>
  </div>
</div>
`;

export default locationInfo;
