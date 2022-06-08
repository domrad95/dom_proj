<template>
  <div class="border-b border-gray-700 pb-2">
    <h2 class="text-xl font-bold text-gray-900">
      {{ cartItems.length }} {{ productCaption() }}
    </h2>
    <action-button text="×" type="close" @click="closeCart()" />
  </div>
</template>

<script>
import ActionButton from "@/components/Shared/ActionButton.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "CartHeader",
  components: {
    ActionButton,
  },
  computed: {
    ...mapState(["cartItems"]),
    ...mapActions(["closeCart"]),
  },
  methods: {
    productCaption() {
      if (this.cartItems.length === 1) return "produkt";
      else if (
        this.cartItems.length === 2 ||
        this.cartItems.length === 3 ||
        this.cartItems.length === 4
      )
        return "produkty";
      else return "produtków";
    },
  },
};
</script>
