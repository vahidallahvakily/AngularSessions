import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  id:number;
  employee:Employee = new Employee();
  employeeForm:FormGroup; 
  submited:boolean=false;

  constructor(
    private route:ActivatedRoute,
    private location:Location,
    private employeeService:EmployeeService,
    private formBuilder:FormBuilder,
  ) { 
    this.employeeForm = this.formBuilder.group({
      id:[''],
      firstName:['', Validators.required],
      lastName:['', Validators.required],
      email:[''],
    })

  }

  //declar get property
  get f()  {return this.employeeForm.controls;}

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get("id");
    if(this.id){
      this.employee = this.employeeService.getById(this.id);
    }

  }

  saveForm(){
    this.submited = true;
    if(!this.employeeForm.valid)
    {
      //alert('invalid forms');
      return;
    }
    alert('succ...');
    if(this.id){
      //update
    } else{
      //insert
    }
  }

  goToBack()
  {
    this.location.back();
  }

}
