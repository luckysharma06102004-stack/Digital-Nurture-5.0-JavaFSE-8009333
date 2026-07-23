import { TestBed } from '@angular/core/testing';
import { RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { describe, it, expect } from 'vitest';
import { unsavedChangesGuard, CanComponentDeactivate } from './unsaved-changes-guard';

describe('unsavedChangesGuard', () => {
  it('should be created', () => {
    expect(unsavedChangesGuard).toBeTruthy();
  });

  it('should allow navigation when there are no unsaved changes', () => {
    const mockComponent: CanComponentDeactivate = {
      hasUnsavedChanges: () => false
    };

    TestBed.runInInjectionContext(() => {
      const result = unsavedChangesGuard(
        mockComponent,
        {} as ActivatedRouteSnapshot,
        {} as RouterStateSnapshot,
        {} as RouterStateSnapshot
      );
      expect(result).toBe(true);
    });
  });
});