export class Stall {
  constructor(
    public id: number,
    public name: string,
    public weightAverage: number,
    public totalPigs?: number,
    public lastRemoval?: Date,
    public updated_at?,

  ) {}
}
