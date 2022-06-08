<template>
  <div>
    <main-nav></main-nav>
    <router-view />
    <cart-instance />
  </div>
</template>

<script>
import MainNav from "@/components/Navigation/MainNav.vue";
import CartInstance from "@/components/Cart/CartInstance.vue";

export default {
  name: "App",
  components: {
    MainNav,
    CartInstance,
  },
};
</script>
