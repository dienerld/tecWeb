import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export type TSlaughter = {
  id: number,
  netWeight: number,
  date: string,
  sellPrice: number,
  stallId: number,
  pigId: number,
  stallName: string,
}

@Injectable({
  providedIn: 'root',
})
export class SlaughterService {
  constructor(private readonly http: HttpClient) { }

  private url = 'http://localhost:8080/api/v1/slaughters';

  private arr: TSlaughter[] = [];

  // TODO: implementar o serviço de busca de ultimo abate de cada baia
  getLastTenStalls():Observable<TSlaughter[]> {
    return new Observable<TSlaughter[]>((subscriber) => {
      subscriber.next(this.arr);
      subscriber.complete();
    });
  }

  getSlaughter(id: number): Observable<TSlaughter> {
    return this.http.get<TSlaughter>(`${this.url}/${id}`);
  }

  // TODO: implementar o serviço de busca de ultimo abate geral
  getLastSlaughter():Observable<TSlaughter> {
    return new Observable<TSlaughter>((subscriber) => {
      subscriber.next(this.arr[0]);
      subscriber.complete();
    });
  }

  createSlaughter(slaughter: TSlaughter): Observable<TSlaughter> {
    return this.http.post<TSlaughter>(this.url, slaughter);
  }

  updateSlaughter(slaughter: TSlaughter): Observable<TSlaughter> {
    return this.http.put<TSlaughter>(`${this.url}/${slaughter.id}`, slaughter);
  }
}
