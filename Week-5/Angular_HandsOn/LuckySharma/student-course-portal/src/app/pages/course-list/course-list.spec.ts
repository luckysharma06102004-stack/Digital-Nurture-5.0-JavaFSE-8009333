import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { ActivatedRoute, Router } from '@angular/router';
import { of } from 'rxjs';
import { describe, it, expect, beforeEach, vi } from 'vitest';
import { CourseList } from './course-list';
import { EnrollmentService } from '../../services/enrollment';

describe('CourseList (NgRx-connected)', () => {
  let component: CourseList;
  let fixture: ComponentFixture<CourseList>;
  let store: MockStore;

  const mockCourses = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Operating Systems', code: 'CS102', credits: 3, gradeStatus: 'failed' },
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseList],
      providers: [
        provideMockStore({
          initialState: { course: { courses: mockCourses, loading: false, error: null } }
        }),
        { provide: EnrollmentService, useValue: { getStudentsByCourse: () => of([]) } },
        { provide: Router, useValue: { navigate: vi.fn() } },
        { provide: ActivatedRoute, useValue: { snapshot: { queryParamMap: { get: () => null } } } }
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseList);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
  });

  it('should render course cards matching the initial state', () => {
    fixture.detectChanges();
    const cards = fixture.debugElement.queryAll(By.css('app-course-card'));
    expect(cards.length).toBe(2);
  });

  it('should show loading indicator when loading state is true', () => {
    store.setState({ course: { courses: [], loading: true, error: null } });
    fixture.detectChanges();
    const loadingEl = fixture.debugElement.query(By.css('p'));
    expect(loadingEl.nativeElement.textContent).toContain('Loading');
  });
});