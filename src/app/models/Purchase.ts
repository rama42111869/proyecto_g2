export class Purchase{
    Long!:number;
    date!:Date;
    amount!:number;

    constructor(Long: number,date: Date,amount:number){
    this.Long=Long;
    this.date=date;
    this.amount=amount;
    }
}