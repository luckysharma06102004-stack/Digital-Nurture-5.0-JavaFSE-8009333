import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-summary-widget',
  imports: [],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css',
})
export class CourseSummaryWidget implements OnInit {
  count = 0;

  constructor(private courseService: CourseService) {}

  ngOnInit() {
    this.courseService.getCourses().subscribe(courses => {
      this.count = courses.length;
    });
  }

  addTestCourse() {
    this.courseService.createCourse({
      name: 'Test Course', code: 'CS999', credits: 2, gradeStatus: 'pending'
    }).subscribe(() => {
      this.courseService.getCourses().subscribe(courses => {
        this.count = courses.length;
      });
    });
  }
}