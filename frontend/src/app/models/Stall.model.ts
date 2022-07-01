export class Stall {
  constructor(
    public id: number,
    public name: string,
    public weightAverage: number,
    public lastRemoval?: Date,
    public createdAt?: Date,
    public updatedAt?: Date,
  ) {}
}
