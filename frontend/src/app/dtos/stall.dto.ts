export type createStallDto = {
    name: string;
}

export type outputStallDto = {
    id: number;
    name: string;
    weightAverage: number;
    lastRemoval: Date | null;
}
