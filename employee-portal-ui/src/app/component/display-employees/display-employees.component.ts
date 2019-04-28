import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/service/employee.service';
import { Employee } from 'src/app/model/employee.model';

@Component({
  selector: 'app-display-employees',
  templateUrl: './display-employees.component.html',
  styleUrls: ['./display-employees.component.scss']
})
export class DisplayEmployeesComponent implements OnInit {

  employees: Employee[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.fetchEmployees();
    this.employeeService.onEmployeeAddition.subscribe(
      (employee: Employee) => this.fetchEmployees());
  }

  fetchEmployees(): void {
    this.employeeService.getAllEmployees().subscribe(
      (employees: Employee[]) => {
        this.sortByFirstName(employees);
        this.employees = employees;
    },
    (_error: any) => {
      console.log('error');
    });
  }

  sortByFirstName(employees:Employee[]) {
    employees.sort((emp1: Employee, emp2: Employee) => emp1.firstName.localeCompare(emp2.firstName));
  }

}
