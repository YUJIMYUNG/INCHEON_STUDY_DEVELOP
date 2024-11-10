import { data } from "./data.js";
import { makeNameTag } from "./func.js";

const container = document.querySelector(".container");

data.forEach((v) => container.insertAdjacentHTML('beforeend', makeNameTag( v.avatar, v.fullName)));
