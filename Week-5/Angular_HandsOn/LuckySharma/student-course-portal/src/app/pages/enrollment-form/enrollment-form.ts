import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-enrollment-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css',
})
export class EnrollmentForm {
  studentName = '';
  studentEmail = '';
  courseId: number | null = null;
  preferredSemester = 'Odd';
  agreeToTerms = false;

  submitted = false;
  errorMessage: string | null = null;

  constructor(private courseService: CourseService) {}

  onSubmit(form: NgForm) {
    console.log(form.value);
    console.log(form.valid);

    if (form.invalid) return;

    this.courseService.createCourse({
      name: 'New Course from ' + form.value.studentName,
      code: 'C' + form.value.courseId,
      credits: 3,
      gradeStatus: 'pending'
    }).subscribe({
      next: (created) => {
        console.log('Course created:', created);
        this.submitted = true;
        this.errorMessage = null;
        form.resetForm();
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to submit enrollment. Please try again.';
      }
    });
  }
}