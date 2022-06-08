<template>
  <div class="h-82 rounded shadow-lg text-center">
    <img
      class="w-40 h-40 mr-auto ml-auto"
      :src="productObject.image"
      :alt="productObject.name"
    />
    <div class="px-6 py-4">
      <div class="font-bold text-xl mb-2">
        {{ productObject.name }}
      </div>
      <p class="text-gray-700 text-base">{{ productObject.price }} zł</p>
    </div>
    <div class="px-6 pt-4 pb-2">
      <button
        v-show="product.quantity > 0"
        class="rounded-md bg-red-500 px-1"
        @click="removeFromCart"
      >
        <font-awesome-icon icon="minus" />
      </button>

      <span v-show="product.quantity > 0" class="mx-1">
        {{ product.quantity }} w koszyku
      </span>

      <button
        v-show="product.quantity === 0"
        class="rounded-md px-1 bg-brand-gray-1"
        @click="addToCart"
      >
        <font-awesome-icon icon="shopping-cart" class="mr-1" />Do koszyka
      </button>

      <button
        v-show="product.quantity > 0"
        class="rounded-md bg-green-500 px-1"
        @click="addToCart"
      >
        <font-awesome-icon icon="plus" />
      </button>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ProductInstance",
  props: {
    productObject: {
      type: Object,
      required: true,
    },
  },
  computed: {
    product() {
      const findItem = this.cartItems.find(
        (element) => element.id === this.productObject.id
      );
      if (findItem) {
        return findItem;
      } else {
        return {
          id: this.productObject.id,
          name: this.productObject.name,
          price: this.productObject.price,
          image: this.productObject.image,
          description: this.productObject.description,
          quantity: 0,
        };
      }
    },
    ...mapState(["cartItems"]),
  },
  methods: {
    addToCart() {
      this.$store.dispatch("addProductToCart", this.product);
    },
    removeFromCart() {
      this.$store.dispatch("removeProductFromCart", this.product);
    },
  },
};
</script>
