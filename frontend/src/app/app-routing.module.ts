import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ReportsComponent } from './pages/reports/reports.component';
import { SlaughterHomeComponent } from './pages/Slaughter/index/slaughter-homeabates-home.component';
import { SlaughterListAllComponent } from './pages/Slaughter/listAll/slaughter-list.component';
import { SlaughterListOneComponent } from './pages/Slaughter/listOne/slaughter-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'reports', component: ReportsComponent },
  { path: 'stalls', component: SlaughterHomeComponent },
  { path: 'stalls/all', component: SlaughterListAllComponent },
  { path: 'stalls/:id', component: SlaughterListOneComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
