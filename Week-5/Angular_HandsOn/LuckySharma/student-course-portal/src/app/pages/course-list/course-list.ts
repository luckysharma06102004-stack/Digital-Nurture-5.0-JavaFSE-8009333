import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable, of } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { CourseCard } from '../../components/course-card/course-card';
import { EnrollmentService } from '../../services/enrollment';
import { Course } from '../../models/course.model';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses, selectCoursesLoading, selectCoursesError } from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, FormsModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {
  courses$: Observable<Course[]>;
  isLoading$: Observable<boolean>;
  errorMessage$: Observable<string | null>;

  selectedCourseId: number | null = null;
  selectedCourseStudents: any[] = [];
  searchTerm = '';

  constructor(
    private store: Store,
    private enrollmentService: EnrollmentService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.courses$ = this.store.select(selectAllCourses);
    this.isLoading$ = this.store.select(selectCoursesLoading);
    this.errorMessage$ = this.store.select(selectCoursesError);
  }

  ngOnInit(): void {
    this.searchTerm = this.route.snapshot.queryParamMap.get('search') || '';
    this.store.dispatch(loadCourses());
  }

  onSearchChange() {
    this.router.navigate(['courses'], { queryParams: { search: this.searchTerm || null } });
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course:', courseId);
    this.selectedCourseId = courseId;

    of(courseId)
      .pipe(switchMap(id => this.enrollmentService.getStudentsByCourse(id)))
      .subscribe(students => (this.selectedCourseStudents = students));
  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }
}