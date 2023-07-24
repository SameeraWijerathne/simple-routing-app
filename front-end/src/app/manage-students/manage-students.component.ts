import { Component } from '@angular/core';
import {Student} from "../dto/student";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-manage-students',
  templateUrl: './manage-students.component.html',
  styleUrls: ['./manage-students.component.scss']
})
export class ManageStudentsComponent {
  studentList: Array<Student> = [];

  constructor(private http: HttpClient) {
    http.get<Array<Student>>('http://localhost:8080/app/api/v1/students')
      .subscribe(studentList => this.studentList = studentList);
  }
}
