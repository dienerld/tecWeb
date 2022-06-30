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
      { label: 'Home', icon: 'pi pi-fw pi-home', routerLink: 'home' },
      { label: 'Relatórios', icon: 'pi pi-fw pi-calendar', routerLink: 'reports' },
      { label: 'Abates', icon: 'pi pi-fw pi-calendar', routerLink: 'stalls' },
    ];
    this.activeItem = this.items[0];
  }
}
