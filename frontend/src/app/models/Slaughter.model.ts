import { TSlaughter } from '&services/slaughter.service';

export class Slaughter implements TSlaughter {
  constructor(
    public id: number,
    public netWeight: number,
    public date: string,
    public sellPrice: number,
    public stallId: number,
    public pigId: number,
    public stallName: string,
  ) { }
}
