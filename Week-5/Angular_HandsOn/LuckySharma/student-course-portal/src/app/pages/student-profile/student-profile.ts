import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { forkJoin, of } from 'rxjs';
import { EnrollmentService } from '../../services/enrollment';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-student-profile',
  imports: [CommonModule],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css',
})
export class StudentProfile implements OnInit {
  enrolledCourses: Course[] = [];

  constructor(
    private enrollmentService: EnrollmentService,
    private courseService: CourseService
  ) {}

  ngOnInit() {
    const ids = this.enrollmentService.getEnrolledCourseIds();
    if (ids.length === 0) {
      this.enrolledCourses = [];
      return;
    }
    const calls = ids.map(id => this.courseService.getCourseById(id));
    forkJoin(calls).subscribe(courses => {
      this.enrolledCourses = courses;
    });
  }
}