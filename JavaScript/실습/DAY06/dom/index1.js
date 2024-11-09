const container = document.createElement("section");
container.style.cssText = "display:flex; gap: 10px;";

const makeButton = (coffeeName) => {
  const btn = document.createElement("button");
  btn.innerText = coffeeName;
  return btn;
};
["아메리카노", "라떼", "민트"].forEach((v) =>
  container.appendChild(makeButton(v))
);
document.body.appendChild(container);
