import { createRouter, createWebHistory } from "vue-router";
import ShopView from "@/views/ShopView.vue";
import OrderView from "@/views/OrderView.vue";

const routes = [
  {
    path: "/",
    name: "shop",
    component: ShopView,
  },
  {
    path: "/order",
    name: "order",
    component: OrderView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior() {
    return {
      top: 0,
      left: 0,
      behavior: "smooth",
    };
  },
});

export default router;
