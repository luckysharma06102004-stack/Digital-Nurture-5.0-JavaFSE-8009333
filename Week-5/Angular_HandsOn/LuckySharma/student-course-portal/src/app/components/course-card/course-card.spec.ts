import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { describe, it, expect, beforeEach, vi } from 'vitest';
import { CourseCard } from './course-card';

describe('CourseCard', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;
  let store: MockStore;

  const mockCourse = { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCard],
      providers: [
        provideMockStore({ initialState: { enrollment: { enrolledCourseIds: [] } } })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
  });

  it('should create', () => {
    component.course = mockCourse;
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

  it('should render course name from @Input', () => {
    component.course = mockCourse;
    fixture.detectChanges();
    const h3 = fixture.debugElement.query(By.css('h3'));
    expect(h3.nativeElement.textContent).toContain('Data Structures');
  });

  it('should emit enrollRequested on button click', () => {
    component.course = mockCourse;
    fixture.detectChanges();
    const emitSpy = vi.spyOn(component.enrollRequested, 'emit');
    const button = fixture.debugElement.query(By.css('button'));
    button.nativeElement.click();
    fixture.detectChanges();
    expect(emitSpy).toHaveBeenCalledWith(1);
  });

  it('should log previous and current value on ngOnChanges', () => {
    const logSpy = vi.spyOn(console, 'log');
    component.course = mockCourse;
    component.ngOnChanges({
      course: {
        previousValue: undefined,
        currentValue: mockCourse,
        firstChange: true,
        isFirstChange: () => true
      }
    });
    expect(logSpy).toHaveBeenCalled();
  });

  it('should dispatch enrollInCourse when Enroll is clicked', () => {
    component.course = mockCourse;
    fixture.detectChanges();
    const dispatchSpy = vi.spyOn(store, 'dispatch');
    const button = fixture.debugElement.query(By.css('button'));
    button.nativeElement.click();
    expect(dispatchSpy).toHaveBeenCalled();
  });
});