import { createApp } from "vue";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { library } from "@fortawesome/fontawesome-svg-core";
import {
  faSearch,
  faCartShopping,
  faPlus,
  faMinus,
  faAngleUp,
  faAngleDown,
} from "@fortawesome/free-solid-svg-icons";

import App from "@/App.vue";
import router from "@/router";
import "@/assets/tailwind.css";
import store from "./store";

library.add(faSearch, faCartShopping, faPlus, faMinus, faAngleUp, faAngleDown);

createApp(App)
  .use(store)
  .use(router)
  .component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");
