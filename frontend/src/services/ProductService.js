import axios from "axios";

const restClient = axios.create({
  baseURL: "http://localhost:3000",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-type": "application/json",
  },
});

export default {
  getProducts(perPage, page, category, phrase) {
    if (category != "") {
      return restClient.get(
        "/products?_limit=" +
          perPage +
          "&_page=" +
          page +
          "&categories=" +
          category
      );
    } else if (phrase != "") {
      return restClient.get(
        "/products?_limit=" + perPage + "&_page=" + page + "&q=" + phrase
      );
    } else {
      return restClient.get("/products?_limit=" + perPage + "&_page=" + page);
    }
  },

  getProduct(id) {
    return restClient.get("/products/" + id);
  },
};
