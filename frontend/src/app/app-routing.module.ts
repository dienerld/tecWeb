import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ReportsComponent } from './pages/reports/reports.component';
import { AddSlaughterComponent } from './pages/slaughter/add/add-slaughter.component';
import { SlaughterHomeComponent } from './pages/slaughter/index/slaughter-home.component';
import { AddStallComponent } from './pages/stall/add/add-stall.component';
import { HomeStallsComponent } from './pages/stall/home/home-stalls.component';
import { ListAllStallsComponent } from './pages/stall/list/list-all-stalls.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'reports', component: ReportsComponent },

  { path: 'stalls', component: HomeStallsComponent },
  { path: 'stalls/all', component: ListAllStallsComponent },
  { path: 'stalls/add', component: AddStallComponent },
  { path: 'stalls/update/:id', component: AddStallComponent },

  { path: 'slaughter', component: SlaughterHomeComponent },
  { path: 'slaughter/add', component: AddSlaughterComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
