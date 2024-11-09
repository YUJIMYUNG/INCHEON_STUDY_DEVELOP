import { makePallet } from "./func.js";

const pallete = makePallet();
colors.forEach((v) => {
  pallete.appendChild(makeColor(v));
});
document.body.appendChild(pallete);
