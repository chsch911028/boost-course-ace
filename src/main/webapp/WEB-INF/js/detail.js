const getQueryParamsFromUrl = () =>
  window.location.search
    .substring(1)
    .split("&")
    .reduce((param, queryStr) => {
      const [key, value] = queryStr.split("=");
      param[key] = value;
      return param;
    }, {});

window.onload = function() {
  //1. URL Query 가져와서 HTTP GET 요청하기(/api/products/{displayInfoId})
  const params = getQueryParamsFromUrl();

  $.ajax({
    type: "GET",
    url: `${URL}${PRODUCTS_API_PATH}/${params.displayInfoId}`,
    dataType: "JSON",
    success: function(data) {
      console.log(data);
      //productImages

      //productPrices

      //displayInfo

      //averageScore

      //comments
    }
  });
};
