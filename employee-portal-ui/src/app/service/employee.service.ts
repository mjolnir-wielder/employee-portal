import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  onEmployeeAddition = new EventEmitter<Employee>();
  constructor(private http: HttpClient) { }

  getAllEmployees(): Observable<any> {
    return this.http.get('/employee-portal/employees');
  }

  addEmployee(employee: Employee): Observable<any> {
    return this.http.post('/employee-portal/employee', employee);
  }

  notifyAddition(employee: Employee): void {
    this.onEmployeeAddition.next(employee);
  }
}
