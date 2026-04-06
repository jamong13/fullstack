import React from "react";
import { products } from "./products";
import ProductItem from "./ProductItem";

function App() {
  return (
    <div className="app">
      <div className="container">
        <h2>4번 — 컴포넌트 분리 + props</h2>
        {products.map((product) => (
          <ProductItem key={product.id} product={product} />
        ))}
      </div>
    </div>
  );
}

export default App;
