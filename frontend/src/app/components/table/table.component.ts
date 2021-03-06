import { Component, Input, OnInit } from '@angular/core';
import { TPig } from '&services/reports.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})

export class TableComponent implements OnInit {
  @Input()
    pigs: TPig[];

  @Input()
    columns = [];

  @Input()
    description = '';

  constructor() { }

  ngOnInit() {}
}
