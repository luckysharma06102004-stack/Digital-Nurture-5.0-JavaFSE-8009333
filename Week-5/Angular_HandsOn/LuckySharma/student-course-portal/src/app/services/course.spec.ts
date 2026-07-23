import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { describe, it, expect, beforeEach, afterEach } from 'vitest';
import { CourseService } from './course';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Operating Systems', code: 'CS102', credits: 3, gradeStatus: 'failed' },
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch courses via GET', () => {
    service.getCourses().subscribe(courses => {
      expect(courses.length).toBe(2);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);
  });

  it('should handle a 500 error response after retries', () => {
    service.getCourses().subscribe({
      next: () => { throw new Error('expected an error, not courses'); },
      error: (err) => {
        expect(err.message).toContain('Failed to load courses');
      }
    });

    for (let i = 0; i < 3; i++) {
      const req = httpMock.expectOne('http://localhost:3000/courses');
      req.flush('Server error', { status: 500, statusText: 'Internal Server Error' });
    }
  });
});