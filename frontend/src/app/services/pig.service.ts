import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { inputPigDto, outputPigDto } from '../dtos/pig.dto';
import { Pig } from '../models/Pig.model';

@Injectable({
  providedIn: 'root',
})
export class PigService {
  constructor(private readonly http: HttpClient) { }

  private url = 'http://localhost:8080/api/v1/pigs';

  getAll(): Observable<outputPigDto[]> {
    return this.http.get<outputPigDto[]>(this.url);
  }

  getOne(id: number): Observable<inputPigDto> {
    return this.http.get<inputPigDto>(`${this.url}/${id}`);
  }

  getPigsForStall(id: number): Observable<outputPigDto[]> {
    return this.http.get<outputPigDto[]>(`${this.url}/stall/${id}`);
  }

  createPig(pig: inputPigDto): Observable<inputPigDto> {
    return this.http.post<inputPigDto>(this.url, pig);
  }

  updatePig(pig: inputPigDto): Observable<Pig> {
    return this.http.put<Pig>(`${this.url}/${pig.id}`, pig);
  }
}
