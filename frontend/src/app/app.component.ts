/* eslint-disable prefer-destructuring */
import { Component, OnInit } from '@angular/core';
import { PrimeNGConfig, MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  title: 'Home';

  items: MenuItem[] = [];

  activeItem: Object = this.items[0];

  constructor(private primengConfig: PrimeNGConfig) {}

  ngOnInit() {
    this.primengConfig.ripple = true;

    this.items = [
      { label: 'Home', routerLink: 'home' },
      { label: 'Relatórios', routerLink: 'reports' },
      { label: 'Baias', routerLink: 'stalls' },
      { label: 'Adicionar Baias', routerLink: 'stalls/add' },

      { label: 'Abates', routerLink: 'slaughters' },
      { label: 'Adicionar Abate', routerLink: 'slaughters/add' },

      { label: 'Adicionar Porco', routerLink: 'pigs/add' },
    ];
    this.activeItem = this.items[0];
  }
}
