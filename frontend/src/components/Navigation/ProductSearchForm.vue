<template>
  <form
    class="flex items-center w-full h-12 border border-solid border-brand-gray-3 rounded-3xl"
    @submit.prevent="searchForProducts"
  >
    <font-awesome-icon :icon="['fas', 'search']" class="ml-4 mr-3" />

    <div class="flex flex-nowrap flex-1 h-full text-base font-light">
      <div class="relative flex items-center flex-1 h-full pr-3">
        <text-input v-model="productName" placeholder="Szukaj produktu" />
      </div>
    </div>

    <action-button text="Szukaj" class="rounded-r-3xl" />
  </form>
</template>

<script>
import ActionButton from "@/components/Shared/ActionButton.vue";
import TextInput from "@/components/Shared/TextInput.vue";

export default {
  name: "ProductSearchForm",
  components: {
    ActionButton,
    TextInput,
  },
  data() {
    return {
      productName: "",
    };
  },
  methods: {
    searchForProducts() {
      this.$store.commit("SET_QUERY_PHRASE_PHRASE", this.productName);
      this.$router.push({ name: "shop", query: { page: 1 } });
    },
  },
};
</script>
