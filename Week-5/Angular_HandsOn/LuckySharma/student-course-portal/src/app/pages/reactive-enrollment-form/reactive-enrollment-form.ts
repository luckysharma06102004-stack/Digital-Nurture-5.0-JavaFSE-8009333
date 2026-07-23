import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CanComponentDeactivate } from '../../guards/unsaved-changes-guard';
import {
  FormBuilder, FormGroup, FormArray, FormControl,
  ReactiveFormsModule, Validators, AbstractControl, ValidationErrors
} from '@angular/forms';

// Custom synchronous validator — checks courseId doesn't start with 'XX'
function noCourseCode(control: AbstractControl): ValidationErrors | null {
  if (control.value && typeof control.value === 'string' && control.value.startsWith('XX')) {
    return { noCourseCode: true };
  }
  return null;
}

// Custom async validator — simulates a server check for 'test@' emails
function simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
  return new Promise((resolve) => {
    setTimeout(() => {
      if (control.value && control.value.includes('test@')) {
        resolve({ emailTaken: true });
      } else {
        resolve(null);
      }
    }, 800);
  });
}

@Component({
  selector: 'app-reactive-enrollment-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css',
})
export class ReactiveEnrollmentForm implements OnInit, CanComponentDeactivate {
  enrollForm!: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: this.fb.control('', [Validators.required, Validators.email], [simulateEmailCheck]),
      courseId: ['', [Validators.required, noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  // Typed getter for the FormArray — avoids repeated `as FormArray` casting
  // in the template, keeps template expressions clean, and gives type safety
  // when accessing .controls, .push(), .removeAt() etc. in the component class.
  get additionalCourses() {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourse() {
    this.additionalCourses.push(new FormControl('', Validators.required));
  }

  removeCourse(index: number) {
    this.additionalCourses.removeAt(index);
  }

  onSubmit() {
    console.log('Form value (excludes disabled):', this.enrollForm.value);
    console.log('Raw value (includes all controls):', this.enrollForm.getRawValue());
    // enrollForm.value only includes controls that are NOT disabled.
    // enrollForm.getRawValue() includes every control's value regardless
    // of its disabled state — useful when a field is disabled for display
    // purposes but you still need its value on submit.
    this.submitted = true;
  }

  // Required by CanComponentDeactivate — the unsaved-changes guard calls
  // this before allowing navigation away from this route.
  hasUnsavedChanges(): boolean {
    return this.enrollForm.dirty && !this.submitted;
  }
}