<template>
  <div
    class="flex flex-col p-4 bg-white border-r border-solid border-brand-gray-1 w-96 items-center"
  >
    <action-button
      v-for="category in categories"
      :key="category"
      type="searchCategory"
      :text="category"
      @click="changeCategory"
    />
  </div>
</template>

<script>
import ActionButton from "@/components/Shared/ActionButton.vue";

export default {
  name: "ProductFiltersSidebar",
  components: {
    ActionButton,
  },
  data() {
    return {
      categories: [
        "Wszystkie produkty",
        "Warzywa",
        "Owoce",
        "Nabiał",
        "Napoje",
        "Alkohole",
        "Pieczywo",
        "Słodycze",
        "Przekąski",
      ],
    };
  },
  methods: {
    changeCategory(event) {
      let category = event.path[0].innerHTML;
      if (category == "Wszystkie produkty") {
        this.$store.dispatch("changeCategory", "");
      } else {
        this.$store.dispatch("changeCategory", category);
      }
    },
  },
};
</script>
