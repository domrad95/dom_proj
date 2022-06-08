<template>
  <div class="absolute bottom-3 border-t border-gray-700 pt-1">
    <div class="text-xl font-bold text-gray-900 mb-10">
      <p class="float-left">Podsuma:</p>
      <p class="float-right">{{ cartTotal }} zł</p>
    </div>
    <action-button text="Zamów" type="order" @click="handleOrder" />
  </div>
</template>

<script>
import ActionButton from "@/components/Shared/ActionButton.vue";
import { mapGetters } from "vuex";

export default {
  name: "CartFooter",
  components: {
    ActionButton,
  },
  computed: {
    ...mapGetters(["cartTotal"]),
  },
  methods: {
    handleOrder() {
      this.$store.dispatch("closeCart");
      this.$router.push({ name: "order" });
    },
  },
};
</script>
