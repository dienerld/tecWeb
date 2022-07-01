import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { createStallDto, outputStallDto } from '../dtos/stall.dto';
import { Stall } from '../models/Stall.model';

@Injectable({
  providedIn: 'root',
})
export class StallService {
  constructor(private readonly http: HttpClient) { }

  private url = 'http://localhost:8080/api/v1/stalls';

  getStalls(): Observable<outputStallDto[]> {
    return this.http.get<outputStallDto[]>(this.url);
  }

  getStall(id: number): Observable<outputStallDto> {
    return this.http.get<outputStallDto>(`${this.url}/${id}`);
  }

  createStall(stall: createStallDto): Observable<outputStallDto> {
    return this.http.post<outputStallDto>(this.url, stall);
  }

  updateStall(stall: Stall): Observable<Stall> {
    return this.http.put<outputStallDto>(`${this.url}/${stall.id}`, stall);
  }
}
