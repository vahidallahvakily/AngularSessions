import { Injectable } from '@angular/core';
import {Employee} from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
   arrEmployees:Employee[] = [
    new Employee(2806,'vahid','allahvakil','vahidallahvakilY@gmail.com','0935'),
    new Employee(2807,'vahid','allahvakil','vahidallahvakilY@gmail.com','0935')
   ];

  constructor() { }
  
  getAll():Employee[]{
    return this.arrEmployees;
  }

  getById(id:number):Employee
  {
    let employee = this.arrEmployees.filter(q => q.id == id)[0];
    return employee;
  }
  removeItem(id:number){

  }

  editItem(item:Employee){

  }

  addItem(item:Employee){
    
  }
  
}
