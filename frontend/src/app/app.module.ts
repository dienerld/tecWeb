import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MenubarModule } from 'primeng/menubar';
import { TableModule } from 'primeng/table';
import { MultiSelectModule } from 'primeng/multiselect';
import { DropdownModule } from 'primeng/dropdown';
import { SliderModule } from 'primeng/slider';
import { ProgressBarModule } from 'primeng/progressbar';
import { CardModule } from 'primeng/card';
import { CalendarModule } from 'primeng/calendar';

import { ButtonModule } from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { TableComponent } from './components/table/table.component';
import { ReportsComponent } from './pages/reports/reports.component';
import { AddStallComponent } from './pages/stall/add/add-stall.component';
import { ListAllStallsComponent } from './pages/stall/list/list-all-stalls.component';
import { HomeStallsComponent } from './pages/stall/home/home-stalls.component';
import { AddSlaughterComponent } from './pages/slaughter/add/add-slaughter.component';
import { SlaughterHomeComponent } from './pages/slaughter/index/slaughter-home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ReportsComponent,
    TableComponent,
    SlaughterHomeComponent,
    AddStallComponent,
    ListAllStallsComponent,
    HomeStallsComponent,
    AddSlaughterComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MenubarModule,
    FormsModule,
    ReactiveFormsModule,
    TableModule,
    ButtonModule,
    MultiSelectModule,
    InputTextModule,
    CalendarModule,
    DropdownModule,
    ProgressBarModule,
    SliderModule,
    CardModule,
    InputNumberModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
