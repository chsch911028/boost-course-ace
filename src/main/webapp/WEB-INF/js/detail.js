const getQueryParamsFromUrl = () =>
  window.location.search
    .substring(1)
    .split("&")
    .reduce((param, queryStr) => {
      const [key, value] = queryStr.split("=");
      param[key] = value;
      return param;
    }, {});
