import { Component } from '@angular/core';
import {Course} from "../dto/course";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-manage-courses',
  templateUrl: './manage-courses.component.html',
  styleUrls: ['./manage-courses.component.scss']
})
export class ManageCoursesComponent {

  public courseList: Array<Course> = [];

  constructor(private http: HttpClient) {
    http.get<Array<Course>>('http://localhost:8081/app/api/v1/courses')
      .subscribe(courseList => this.courseList = courseList);
  }
}
