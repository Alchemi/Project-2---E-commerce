export interface Product{
    SKU: number;
    name: string;
    price: number;
    description: string;
}

export const products = [
    {
        SKU: 1,
        name: 'Anime fig. test',
        price: 100,
        description: 'best on the market. worth the price'
    },
    {
        SKU: 2,
        name: 'Anime fig test2',
        price:200,
        description: 'worth every penny'
    },

    //find out if this needs to be "zipped up" - sparkey thoughts
]