import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

export type TPig = {
  name: string;
  lastRemoval: string;
  id: number;
}

@Injectable({
  providedIn: 'root',
})
export class ReportsService {
  private url = 'http://localhost:8080/api/v1/stalls';

  constructor(private readonly http: HttpClient) { }

  getReports(): Observable<TPig[]> {
    return this.http.get<TPig[]>(this.url);
  }
}
