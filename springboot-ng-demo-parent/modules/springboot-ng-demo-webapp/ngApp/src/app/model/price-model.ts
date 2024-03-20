export class Product {
  productId!: number;
  description!: string;
}

export class Brand {
  brandId!: number;
  brandName!: string;
}

export class Currency {
  iso!: string;
  symbol!: string;
}

export class Price {
  priceList!: number;
  product!: Product;
  brand!: Brand;
  currency!: Currency;
  startDate!: Date;
  endDate!: Date;
  priority!: number;
  price!: number;
}