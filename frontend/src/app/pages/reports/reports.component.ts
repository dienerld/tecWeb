import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ReportsService, TPig } from '&services/reports.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss'],
})
export class ReportsComponent implements OnInit {
  title = 'Relatórios';

  pigs: TPig[];

  columns = [
    { field: 'id', header: 'Id' },
    { field: 'name', header: 'Name' },
    { field: 'lastRemoval', header: 'LastRemoval' },
    { field: 'totalPigs', header: 'Quantidade' },
  ];

  constructor(
    private readonly service:ReportsService,
    private readonly titleService: Title,
  ) {
    titleService.setTitle(this.title);
  }

  ngOnInit(): void {
    this.service.getReports().subscribe((pigs) => {
      this.pigs = pigs;
    });
  }
}
