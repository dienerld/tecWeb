export interface outputPigDto{
  id: number;
}

export interface inputPigDto {
  id: number;
  sex: string;
  lastVermifuge: Date;
  weight: number;
  entryDate: Date;
  birthDate: Date;
  stallName: string;
  stallId: number;
}
