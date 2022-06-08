<template>
  <Transition name="fade">
    <div
      v-if="isCartVisible"
      class="fixed inset-0 w-full flex justify-center bg-semi-05"
      @click.self="close"
    >
      <div
        class="absolute right-0 w-full h-full max-w-xs bg-white shadow-lg rounded-lg p-8"
      >
        <cart-header />
        <product-listing-cart />
        <cart-footer />
      </div>
    </div>
  </Transition>
</template>

<script>
import CartHeader from "@/components/Cart/CartHeader.vue";
import CartFooter from "@/components/Cart/CartFooter.vue";
import ProductListingCart from "@/components/Product/ProductListingCart.vue";
import { mapState } from "vuex";

export default {
  name: "CartInstance",
  components: {
    CartHeader,
    ProductListingCart,
    CartFooter,
  },
  computed: {
    ...mapState(["isCartVisible"]),
  },
  watch: {
    isCartVisible(value) {
      if (value) {
        return document.querySelector("body").classList.add("overflow-hidden");
      }

      document.querySelector("body").classList.remove("overflow-hidden");
    },
  },
  methods: {
    close() {
      this.$store.commit("SET_CART_VISIBILITY", false);
    },
  },
};
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: all 0.4s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>
