<template>
  <div class="flex flex-row flex-nowrap w-full">
    <product-filters-sidebar />
    <product-listing :page="page" />
  </div>
</template>

<script>
import ProductFiltersSidebar from "@/components/Product/ProductFiltersSidebar.vue";
import ProductListing from "@/components/Product/ProductListing.vue";

export default {
  name: "ShopView",
  components: {
    ProductFiltersSidebar,
    ProductListing,
  },
  computed: {
    page() {
      return parseInt(this.$route.query.page) || 1;
    },
  },
};
</script>
