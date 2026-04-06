import React from "react";

function ProductItem({ product }) {
  return (
    <div>
      <div>
        {product.name} - {product.price}원
      </div>
    </div>
  );
}

export default ProductItem;
