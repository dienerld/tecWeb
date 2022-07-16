/* eslint-disable no-param-reassign */
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Stall } from 'src/app/models/Stall.model';
import { formatDate } from '@angular/common';
import { StallService } from '&services/stall.service';

@Component({
  selector: 'app-home-stalls',
  templateUrl: './home-stalls.component.html',
  styleUrls: ['./home-stalls.component.scss'],
})
export class HomeStallsComponent implements OnInit {
  title = 'Abates';

  description = 'Ultimo abate de cada baia';

  stalls: Stall[] = [];

  columns = [
    { field: 'id', header: 'Baia' },
    { field: 'name', header: 'Nome da Baia' },
    { field: 'totalPigs', header: 'Total de Porcos' },
    { field: 'weightAverage', header: 'Peso Médio' },
    { field: 'updated_at', header: 'Última Atualização' },

  ];

  constructor(
    private readonly service: StallService,
    private readonly titleService: Title,
  ) {
  }

  ngOnInit(): void {
    this.titleService.setTitle(this.title);
    this.service.getStalls().subscribe((stalls: Stall[]) => {
      stalls.forEach((stall: Stall) => {
        const date = new Date(stall.updated_at);
        const dateFormatted = formatDate(date, 'dd/MM/yyyy HH:mm:ss', 'en-US');
        stall.updated_at = dateFormatted;
        stall.weightAverage = stall.weightAverage ?? 0.0;
        this.stalls.push(stall);
      });
    });
  }
}
