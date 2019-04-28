import { Component } from '@angular/core';
import { AddEmployeeComponent } from './component/add-employee/add-employee.component';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'employee-portal-ui';
  bsModalRef: BsModalRef;
  constructor(private modalService: BsModalService) {}

  openAddEmployeeModal(): void {
    this.bsModalRef = this.modalService.show(AddEmployeeComponent, {});
  }
}
