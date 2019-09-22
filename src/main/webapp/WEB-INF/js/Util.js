import { URL } from "./Constants.js";
import Handlebars from "../lib/handlebars.js";

const getQueryParamsFromUrl = () =>
  window.location.search
    .substring(1)
    .split("&")
    .reduce((param, queryStr) => {
      const [key, value] = queryStr.split("=");
      param[key] = value;
      return param;
    }, {});

const renderWithArrayData = (source, array, parentSelector) => {
  const template = Handlebars.compile(source);
  const html = array.reduce((temp, obj) => {
    return temp + template(obj);
  }, ``);
  const parentElement = document.querySelector(parentSelector);
  parentElement.innerHTML = html;
};

const renderWithObjectData = (source, obj, parentSelector) => {
  const template = Handlebars.compile(source);
  const html = template(obj);
  const parentElement = document.querySelector(parentSelector);
  parentElement.innerHTML = html;
};

const insertWithObjectData = (source, obj, parentSelector) => {
  const template = Handlebars.compile(source);
  const html = template(obj);
  const parentElement = document.querySelector(parentSelector);
  parentElement.insertAdjacentHTML("afterbegin", html);
};

const getRequestWithPathVariable = (path, variable) =>
  fetch(`${URL}${path}/${variable}`).then(response => response.json());

export {
  getQueryParamsFromUrl,
  getRequestWithPathVariable,
  insertWithObjectData,
  renderWithArrayData,
  renderWithObjectData
};
