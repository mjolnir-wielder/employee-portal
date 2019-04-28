import { Component, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap';
import { EmployeeService } from 'src/app/service/employee.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Employee } from 'src/app/model/employee.model';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit {

  employeeForm: FormGroup;

  constructor(public bsModalRef: BsModalRef, private employeeService: EmployeeService) {
    this.employeeForm = this.createFormGroup();
  }

  ngOnInit() {
  }

  private createFormGroup(): FormGroup {
    return new FormGroup({
      firstName: new FormControl(),
      lastName: new FormControl(),
      dob: new FormControl(),
      gender: new FormControl(),
      department: new FormControl()
    })
  }

  addEmployee(): void {
    const employee: Employee = Object.assign({}, this.employeeForm.value);
    this.employeeService.addEmployee(employee).subscribe(
      (employee: Employee) => {
        this.bsModalRef.hide();
        this.employeeService.notifyAddition(employee);
      }
    );
  }
}
