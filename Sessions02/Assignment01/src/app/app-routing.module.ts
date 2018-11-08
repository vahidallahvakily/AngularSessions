import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Route, RouterModule, Routes} from '@angular/router';
import {ProductListComponent} from './product-list/product-list.component';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {EmployeeDetailComponent} from './employee-detail/employee-detail.component';

const routes: Routes= [
  {path:'products',component :ProductListComponent},
  {path:'product/:id',component :ProductDetailsComponent},
  {path:'dashboard',component :DashboardComponent},
  {path:'employees',component:EmployeeListComponent},
  {path:'employees/create',component:EmployeeDetailComponent},
  {path:'employee/edit/:id',component:EmployeeDetailComponent}
];
@NgModule({
  imports: [
    CommonModule,
    [RouterModule.forRoot(routes)
    ]
  ],
  exports:[RouterModule],
  declarations: []
})
export class AppRoutingModule { }
