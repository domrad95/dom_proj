<template>
  <div class="overflow-y-scroll">
    <ul>
      <li v-for="cartItem in cartItems" :key="cartItem.id" class="inline-block">
        <div class="float-left border-b border-gray-300">
          <div class="float-left w-4 align-top">
            <button @click="incrementProductQuantity(cartItem.id)">
              <font-awesome-icon :icon="['fas', 'angle-up']" class="h-4 w-4" />
            </button>

            <p class="text-center">{{ cartItem.quantity }}</p>

            <button
              :disabled="cartItem.quantity < 2"
              class="disabled:text-gray-300"
              @click="decrementProductQuantity(cartItem.id)"
            >
              <font-awesome-icon
                :icon="['fas', 'angle-down']"
                class="h-4 w-4"
              />
            </button>
          </div>
          <div>
            <img :src="cartItem.image" class="h-10 w-10" />
          </div>
          <div>{{ cartItem.name }}</div>
          <div>{{ (cartItem.quantity * cartItem.price).toFixed(2) }} zł</div>
          <div>
            <action-button
              text="×"
              type="close2"
              @click="removeItemFromCart(cartItem.id)"
            />
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import ActionButton from "@/components/Shared/ActionButton.vue";
import { mapState, mapGetters } from "vuex";

export default {
  name: "ProductListingCart",
  components: {
    ActionButton,
  },
  computed: {
    ...mapGetters(["cartTotal"]),
    ...mapState(["cartItems", "isCartVisible"]),
  },
  methods: {
    incrementProductQuantity(id) {
      this.$store.dispatch("incrementProductQuantity", id);
    },
    decrementProductQuantity(id) {
      this.$store.dispatch("decrementProductQuantity", id);
    },
    removeItemFromCart(id) {
      this.$store.dispatch("removeItemFromCart", id);
    },
  },
};
</script>

<style></style>
