<template>
  <div class="w-full">
    <div class="p-10 grid grid-cols-5 grid-rows-2 gap-x-4 gap-y-4">
      <product-instance
        v-for="product in products"
        :key="product.id"
        :product-object="product"
      />
    </div>

    <div class="flex items-center justify-center">
      <router-link
        v-if="page != 1"
        :to="{ name: 'shop', query: { page: page - 1 } }"
        class="text-xl font-semibold text-brand-green-2 mb-10"
        >Poprzednia strona</router-link
      >
      <router-link
        v-if="hasNextPage"
        :to="{ name: 'shop', query: { page: page + 1 } }"
        class="text-xl font-semibold text-brand-green-2 ml-10 mb-10"
        >Następna strona</router-link
      >
    </div>
  </div>
</template>

<script>
import ProductInstance from "@/components/Product/ProductInstance.vue";
import { mapState } from "vuex";

export default {
  name: "ProductListing",
  components: { ProductInstance },
  props: {
    page: {
      type: Number,
      required: true,
    },
  },
  data() {
    return {
      perPage: 10,
    };
  },
  computed: {
    hasNextPage() {
      return this.totalProducts > this.page * this.perPage;
    },
    ...mapState(["products", "totalProducts", "category", "queryPhrase"]),
  },
  watch: {
    page: {
      handler() {
        this.$store.dispatch("getProducts", {
          perPage: this.perPage,
          page: this.page,
          category: this.category,
          phrase: this.queryPhrase,
        });
      },
      immediate: true,
    },
    category: {
      handler() {
        this.$router.push({ name: "shop", query: { page: 1 } });
        this.$store.dispatch("getProducts", {
          perPage: this.perPage,
          page: 1,
          category: this.category,
          phrase: this.queryPhrase,
        });
      },
      immediate: true,
    },
    queryPhrase: {
      handler() {
        this.$router.push({ name: "shop", query: { page: 1 } });
        this.$store.dispatch("getProducts", {
          perPage: this.perPage,
          page: 1,
          category: "",
          phrase: this.queryPhrase,
        });
      },
      immediate: true,
    },
  },
};
</script>
