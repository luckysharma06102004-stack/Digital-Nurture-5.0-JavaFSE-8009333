import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
import { Highlight } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnChanges {
  @Input() course!: { id: number; name: string; code: string; credits: number; gradeStatus: string };
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;
  isEnrolled$!: Observable<boolean>;

  constructor(private store: Store, private router: Router) {}

  ngOnChanges(changes: SimpleChanges) {
    this.isEnrolled$ = this.store.select(selectEnrolledIds).pipe(
      map(ids => ids.includes(this.course.id))
    );
    console.log('Previous value:', changes['course']?.previousValue);
    console.log('Current value:', changes['course']?.currentValue);
  }

  toggleExpanded() { this.isExpanded = !this.isExpanded; }

  onEnrollClick(event: Event) {
    event.stopPropagation();
    this.store.select(selectEnrolledIds).pipe(take(1)).subscribe(ids => {
      if (ids.includes(this.course.id)) {
        this.store.dispatch(unenrollFromCourse({ courseId: this.course.id }));
      } else {
        this.store.dispatch(enrollInCourse({ courseId: this.course.id }));
      }
    });
    this.enrollRequested.emit(this.course.id);
  }

  onShowDetailsClick(event: Event) {
    event.stopPropagation();
    this.toggleExpanded();
  }

  onCardClick() {
    this.router.navigate(['courses', this.course.id]);
  }
}