import { createStore } from "vuex";

import ProductService from "@/services/ProductService";

export const state = () => {
  return {
    products: [],
    product: {},
    cartItems: [],
    totalProducts: 0,
    category: "",
    queryPhrase: "",
    isCartVisible: false,
  };
};

export const mutations = {
  ADD_PRODUCT_TO_CART(state, product) {
    state.cartItems.push({
      id: product.id,
      name: product.name,
      image: product.image,
      price: product.price,
      quantity: 1,
      description: product.description,
    });
  },

  REMOVE_PRODUCT_FROM_CART(state, itemIndex) {
    state.cartItems.splice(itemIndex, 1);
  },

  INCREMENT_ITEM_QUANTITY(state, updateitem) {
    updateitem.quantity++;
  },

  DECREMENT_ITEM_QUANTITY(state, updateitem) {
    updateitem.quantity--;
  },

  SET_PRODUCTS(state, products) {
    state.products = products;
  },

  SET_PRODUCT(state, product) {
    state.product = product;
  },

  SET_PRODUCTS_TOTAL(state, totalProducts) {
    state.totalProducts = totalProducts;
  },

  SET_CATEGORY(state, category) {
    state.category = category;
  },

  SET_QUERY_PHRASE_PHRASE(state, queryPhrase) {
    state.queryPhrase = queryPhrase;
  },

  SET_CART_VISIBILITY(state, isVisible) {
    state.isCartVisible = isVisible;
  },
};

export const getters = {
  itemsInCart: (state) => {
    return state.cartItems.length;
  },

  updateProduct: (state, product) => {
    let findItem = state.cartItems.find((element) => {
      return element.id === product.id;
    });
    if (findItem) {
      if (Object.prototype.hasOwnProperty.call(findItem, "quantity")) {
        return parseInt(state.findItem.quantity);
      }
      return 0;
    } else {
      return 0;
    }
  },

  cartTotal: (state) => {
    let total = 0;
    state.cartItems.forEach((product) => {
      total += product.price * product.quantity;
    });
    return total.toFixed(2);
  },
};

export const actions = {
  addProductToCart({ commit, state }, product) {
    const cartItem = state.cartItems.find(
      (element) => element.id === product.id
    );
    if (!cartItem) {
      commit("ADD_PRODUCT_TO_CART", product);
    } else {
      commit("INCREMENT_ITEM_QUANTITY", cartItem);
    }
  },

  removeProductFromCart({ commit, state }, product) {
    const cartItem = state.cartItems.find(
      (element) => element.id === product.id
    );
    if (cartItem) {
      if (cartItem.quantity <= 1) {
        const itemIndex = state.cartItems.findIndex((x) => x.id === product.id);
        commit("REMOVE_PRODUCT_FROM_CART", itemIndex);
      } else {
        commit("DECREMENT_ITEM_QUANTITY", cartItem);
      }
    }
  },

  removeItemFromCart({ commit, state }, id) {
    const itemIndex = state.cartItems.findIndex((x) => x.id === id);
    commit("REMOVE_PRODUCT_FROM_CART", itemIndex);
  },

  getProducts({ commit }, { perPage, page, category, phrase }) {
    ProductService.getProducts(perPage, page, category, phrase)
      .then((response) => {
        commit(
          "SET_PRODUCTS_TOTAL",
          parseInt(response.headers["x-total-count"])
        );
        commit("SET_PRODUCTS", response.data);
      })
      .catch((error) => {
        window.console.log(error);
      });
  },

  getProduct({ commit }, id) {
    ProductService.getProduct(id)
      .then((response) => {
        commit("SET_PRODUCT", response.data);
      })
      .catch((error) => {
        window.console.log(error);
      });
  },

  incrementProductQuantity({ commit, state }, id) {
    const cartItem = state.cartItems.find((element) => element.id === id);
    if (cartItem) {
      commit("INCREMENT_ITEM_QUANTITY", cartItem);
    }
  },

  decrementProductQuantity({ commit, state }, id) {
    const cartItem = state.cartItems.find((element) => element.id === id);
    if (cartItem) {
      commit("DECREMENT_ITEM_QUANTITY", cartItem);
    }
  },

  changeCategory({ commit }, category) {
    commit("SET_QUERY_PHRASE_PHRASE", "");
    commit("SET_CATEGORY", category);
  },

  closeCart({ state }) {
    state.isCartVisible = false;
  },
};

const store = createStore({
  state,
  mutations,
  getters,
  actions,
});

export default store;
