export class Product{
    Id?: number;
    brand!:string;
    description!:string;
    images!:string;
    name!:string;   
    price!:number;
    category!:number;

    constructor(Id : number,brand : string, description:string,
    images:string,name:string,price:number,category:number){
            this.Id=Id;
            this.brand=brand;
            this.category=category;
            this.description=description;
            this.images=images;
            this.name=name;
            this.price=price;
        }

}


