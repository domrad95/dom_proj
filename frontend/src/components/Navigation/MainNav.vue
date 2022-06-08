<template>
  <header class="w-full text-lg h-24">
    <div class="fixed top-0 left-0 w-full h-24 bg-white">
      <div
        class="flex flex-nowrap h-full px-8 mx-auto border-b border-solid border-brand-gray-1"
      >
        <logo-shop />

        <nav class="h-full ml-6">
          <ul class="flex h-full p-0 m-0 list-none text-xl">
            <li class="h-full ml-9" data-test="shop-nav">
              <router-link
                :to="{ name: 'shop' }"
                class="flex items-center h-full py-2.5"
                >Sklep</router-link
              >
            </li>
            <li class="h-full ml-9" data-test="order-nav">
              <router-link
                :to="{ name: 'order' }"
                class="flex items-center h-full py-2.5"
                >Zamówienie</router-link
              >
            </li>
          </ul>
        </nav>

        <div class="flex items-center h-full ml-auto">
          <product-search-form />
        </div>

        <div
          class="relative flex items-center h-full ml-auto hover:cursor-pointer"
          @click="showCart"
        >
          <cart-icon />
          <span
            class="bg-brand-orange-1 text-black text-xs font-semibold px-1 py-0.5 rounded"
            >{{ itemsInCart }}</span
          >
        </div>
      </div>
    </div>
  </header>
</template>

<script>
import ProductSearchForm from "@/components/Navigation/ProductSearchForm.vue";
import LogoShop from "@/components/Navigation/LogoShop.vue";
import CartIcon from "@/components/Cart/CartIcon.vue";
import { mapGetters } from "vuex";

export default {
  name: "MainNav",
  components: {
    ProductSearchForm,
    LogoShop,
    CartIcon,
  },
  computed: {
    ...mapGetters(["itemsInCart"]),
  },
  methods: {
    showCart() {
      this.$store.commit("SET_CART_VISIBILITY", true);
    },
  },
};
</script>

<style scoped>
span {
  position: relative;
  left: -10px;
  top: -10px;
}
</style>
