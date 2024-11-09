import { palleteStyle } from "./style";

// 리팩토링

export const makeColor = (color) => {
  const color = document.createElement("div");
  color.style.cssText = paint(color);

  return box;
};

export const makePallet = () => {
  const pallete = document.createElement("section");
  pallete.style.cssText = palleteStyle;

  return pallete;
};

const paint = (color) => `width:100%; height:100%; background-color:${color}`;
