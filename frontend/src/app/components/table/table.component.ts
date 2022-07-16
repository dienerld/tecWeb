import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})

export class TableComponent {
  @Input()
    pigs: any[];

  @Input()
    columns = [];

  @Input()
    description = '';

  constructor() { }
}
