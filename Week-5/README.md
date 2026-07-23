# Digital Nurture 5.0 — Angular  Hands-On Submission
**Track:** JAVA FSE | **Name:** Lucky Sharma | **Superset ID:** 8009333

This folder contains the complete implementation of all 10 hands-on exercises from the *Digital Nurture 5.0 Angular Hands-On Exercise Book*. All exercises build a single, progressively-enhanced application — the **Student Course Portal**.

📁 Project source: `Angular_HandsOn/LuckySharma/student-course-portal/`
📁 Evidence screenshots: `Angular_HandsOn/LuckySharma/Screenshots/`
📄 Detailed step-by-step notes: [`notes.txt`](./Angular_HandsOn/LuckySharma/student-course-portal/notes.txt)

---

## How to Run

```bash
cd Angular_HandsOn/LuckySharma/student-course-portal
npm install

# Terminal 1 — mock backend (required for Hands-On 8 onwards)
json-server --watch db.json --port 3000

# Terminal 2 — Angular dev server
ng serve
```
App runs at `http://localhost:4200`.

**Run tests:**
```bash
ng test                  # run once / watch mode
ng test --code-coverage  # with coverage report
```



## Final Application UI

| Home | Courses |
|---|---|
| ![Home](Angular_HandsOn/LuckySharma/Screenshots/HomeUI.png) | ![Courses](Angular_HandsOn/LuckySharma/Screenshots/CoursesUI.png) |

| Profile | Enrollment (Template-Driven) | Enrollment (Reactive) |
|---|---|---|
| ![Profile](Angular_HandsOn/LuckySharma/Screenshots/profileUI.png) | ![Enrollment Form](Angular_HandsOn/LuckySharma/Screenshots/EnrollmentFormUI.png) | ![Reactive Enrollment](Angular_HandsOn/LuckySharma/Screenshots/ReactiveEnrollmentUI.png) |

**App running end-to-end in the beginning (full view):**
![App running](Angular_HandsOn/LuckySharma/Screenshots/student-course-portal-at-localhost4200.png)

*(UI styling was polished independently after completing all functional requirements — purely presentational, no logic was changed.)*

---

## Hands-On 1 — Environment Setup, Project Structure & First Component

**Task 1 — Scaffold & Explore the Project**

| `ng serve` | `ng build` | `dist/` folder |
|---|---|---|
| ![ng serve](Angular_HandsOn/LuckySharma/Screenshots/handson1-task1-ngserve.png) | ![ng build](Angular_HandsOn/LuckySharma/Screenshots/handson1-task1-ngbuild.png) | ![dist folder](Angular_HandsOn/LuckySharma/Screenshots/handson1-task1-distfolder.png) |

**Build budgets (`angular.json` → `architect.build.configurations.production`):**
![budgets](Angular_HandsOn/LuckySharma/Screenshots/angular.json-budget.png)

**Task 2 — Create & Organise Components** (Header, Home, CourseList, StudentProfile)
![components generated](Angular_HandsOn/LuckySharma/Screenshots/handson1-task2-componentsgenerated.png)

---

## Hands-On 2 — Data Binding, Lifecycle Hooks & Component Communication

**Task 2 — Lifecycle Hooks** (`ngOnInit`, `ngOnDestroy`, `ngOnChanges`)

| ngOnInit console log | ngOnChanges console log | Full lifecycle flow |
|---|---|---|
| ![ngOnInit](Angular_HandsOn/LuckySharma/Screenshots/handson2-task2-ngoninit-console.png) | ![ngOnChanges](Angular_HandsOn/LuckySharma/Screenshots/handson2-task2-ngonchanges-console.png) | ![lifecycle](Angular_HandsOn/LuckySharma/Screenshots/handson2-task2-lifecycle-full-console.png) |

| CourseCard code | CourseList code |
|---|---|
| ![course-card code](Angular_HandsOn/LuckySharma/Screenshots/handson2-task2-coursecardcode.png) | ![course-list code](Angular_HandsOn/LuckySharma/Screenshots/handson2-task2-courselistcode.png) |

**Task 3 — @Input / @Output Parent-Child Communication**

| CourseCard code (`@Input`/`@Output`) | CourseList code (`*ngFor` + event binding) | Output — Enroll click → console + selected ID |
|---|---|---|
| ![course-card code](Angular_HandsOn/LuckySharma/Screenshots/handson2-task3-coursecardcode.png) | ![course-list code](Angular_HandsOn/LuckySharma/Screenshots/handson2-task3-courselistcode.png) | ![output](Angular_HandsOn/LuckySharma/Screenshots/handson2-task3-output.png) |

---

## Hands-On 3 — Directives & Pipes

**Task 1 — Structural Directives** (`*ngIf`, `*ngFor` + `trackBy`, `*ngSwitch`)

| Loading state (`*ngIf`) | Grade status badges (`*ngSwitch`) | Empty array (`*ngIf`/`else`) |
|---|---|---|
| ![loading](Angular_HandsOn/LuckySharma/Screenshots/handson3-task1-loading.png) | ![grade status](Angular_HandsOn/LuckySharma/Screenshots/handson3-task1-gradeStatus.png) | ![empty array](Angular_HandsOn/LuckySharma/Screenshots/handson3-task1-Empty-array.png) |

*A short screen recording of the "Loading courses…" → cards transition (with `trackBy` in effect) is also included in the Screenshots folder: `handson3-task1-loadingCoursesRecording.mp4`*
![loading courses transition](Angular_HandsOn/LuckySharma/Screenshots/ezgif.com-video-to-gif-converter.gif)


**Task 1 — Empty array**
![handson3-task1-loadingCoursesRecording.mp4](Angular_HandsOn/LuckySharma/Screenshots/handson3-task1-Empty-array.png) 

**Task 2 — Attribute Directives** (`[ngClass]`, `[ngStyle]`, `cardClasses` getter)
![ngClass ngStyle](Angular_HandsOn/LuckySharma/Screenshots/handson3-task2-ngclassngstyle.png)

**Task 3 — Custom Directive & Custom Pipe**

| Custom `appHighlight` directive (code) | Custom `creditLabel` pipe |
|---|---|
| ![directive code](Angular_HandsOn/LuckySharma/Screenshots/handson3-task3-directivecode.png) | ![pipe](Angular_HandsOn/LuckySharma/Screenshots/handson3-task3-pipe.png) |

---

## Hands-On 4 — Template-Driven Forms & Validation

**Task 1 — Enrollment Request Form** (`#enrollForm="ngForm"`, `[(ngModel)]`)
![form submit](Angular_HandsOn/LuckySharma/Screenshots/handson4-task1-formsubmit.png)

**Task 2 — Validation & Error Messages**

| Validation errors (`required`/`minlength`/`email`, red/green border states) | Success message on valid submit |
|---|---|
| ![validation errors](Angular_HandsOn/LuckySharma/Screenshots/handson4-task2-validationerrors.png) | ![success message](Angular_HandsOn/LuckySharma/Screenshots/handson4-task2-successmessage.png) |

---

## Hands-On 5 — Reactive Forms

**Task 1 — Reactive Form with FormBuilder**
![reactive form](Angular_HandsOn/LuckySharma/Screenshots/handson5-task1-reactiveform.png)

**Task 2 — Custom Validators & FormArray**

| Custom validators (`noCourseCode` sync + `simulateEmailCheck` async) | `FormArray` — dynamic Additional Courses controls |
|---|---|
| ![custom validators](Angular_HandsOn/LuckySharma/Screenshots/handson5-task2-customvalidators.png) | ![form array](Angular_HandsOn/LuckySharma/Screenshots/handson5-task2-formarray.png) |

---

## Hands-On 6 — Services & Dependency Injection

**Task 1 — CourseService** (`providedIn: 'root'`, shared singleton across `CourseList`, `Home`, `CourseSummaryWidget`) — see [Final Application UI](#final-application-ui) and code walkthrough in `notes.txt`.

**Task 2 — EnrollmentService & Component-Level DI**

| Enroll ↔ Unenroll toggle | Enrolled courses shown on Profile page | Notification component (component-level provider) |
|---|---|---|
| ![toggle](Angular_HandsOn/LuckySharma/Screenshots/handson6-task2-enrolltoggle.png) | ![profile enrolled](Angular_HandsOn/LuckySharma/Screenshots/handson6-task2-profileenrolled.png) | ![notification](Angular_HandsOn/LuckySharma/Screenshots/handson6-task2-notificationcomponent.png) |

---

## Hands-On 7 — Routing, Guards & Lazy Loading

**Task 1 — Route Configuration, Params & Nested Routes**

| Course Detail (`:id` route param) | Search (query param `?search=`) | 404 wildcard page |
|---|---|---|
| ![course detail](Angular_HandsOn/LuckySharma/Screenshots/handson7-task1-coursedetail.png) | ![search](Angular_HandsOn/LuckySharma/Screenshots/handson7-task1-searchqueryparam.png) | ![404](Angular_HandsOn/LuckySharma/Screenshots/handson7-task1-404page.png) |

**Task 2 — Lazy Loading & Route Guards**

| Lazy-loaded `/enroll` chunk (Network tab) | `authGuard` — redirect on unauthenticated access | `CanDeactivate` guard — unsaved changes prompt |
|---|---|---|
| ![lazy chunk](Angular_HandsOn/LuckySharma/Screenshots/handson7-task2-lazychunk.png) | ![auth guard](Angular_HandsOn/LuckySharma/Screenshots/handson7-task2-authguard.png) | ![can deactivate](Angular_HandsOn/LuckySharma/Screenshots/handson7-task2-candeactivate.png) |

---

## Hands-On 8 — HTTP Client, RxJS Operators & Interceptors

**Task 1 — CRUD via HttpClient** (JSON Server mock backend)

| POST — create course (enrollment form) | PUT — update (Postman) | DELETE (Postman) |
|---|---|---|
| ![post](Angular_HandsOn/LuckySharma/Screenshots/handson8-task1-postcreate.png) | ![put](Angular_HandsOn/LuckySharma/Screenshots/handson8-task1-put-postman.png) | ![delete](Angular_HandsOn/LuckySharma/Screenshots/handson8-task1-delete-postman.png.png) |

**Task 2 — RxJS Operators & Error Handling**

| `catchError` — error message on failed load | `retry(2)` — retry attempts (Network tab) | `switchMap` — cancels stale dependent request |
|---|---|---|
| ![error](Angular_HandsOn/LuckySharma/Screenshots/handson8-task2-errorhandling.png) | ![retry](Angular_HandsOn/LuckySharma/Screenshots/handson8-task2-retrynetwork.png) | ![switchmap](Angular_HandsOn/LuckySharma/Screenshots/handson8-task2-switchMap.png) |

**Task 3 — HTTP Interceptors**

`authInterceptor` — `Authorization` header present on every outgoing API request:
![auth header](Angular_HandsOn/LuckySharma/Screenshots/handson8-task3-authheader.png)

*`errorHandlerInterceptor` (401/500 global handling) and `loadingInterceptor` (global loading state via `LoadingService`) are implemented in `src/app/interceptors/` — see `notes.txt` for the code walkthrough.*

---

## Hands-On 9 — NgRx State Management

**Task 1 — Store, Actions, Reducer, Selectors, Effects**

Redux DevTools — `[Course] Load Courses` → `[Course] Load Courses Success` flow, with the resulting state tree (`courses`, `loading`, `error`):
![redux flow](Angular_HandsOn/LuckySharma/Screenshots/handson9-task1-reduxdevtools-flow.png)

**Task 2 — Effects for HTTP + Enrollment Cross-Slice State**

Redux DevTools — `[Enrollment] Enroll In Course` action dispatched on click, with the `enrollment` slice combined against the `course` slice via a cross-slice selector:
![redux toggle](Angular_HandsOn/LuckySharma/Screenshots/handson9-task2-enrolltoggle-redux.png)

---

## Hands-On 10 — Unit Testing (TestBed, MockStore, HttpTestingController)

**Task 1 — CourseCardComponent** (5 tests: creation, `@Input` rendering, `@Output` emission, `ngOnChanges`, NgRx `dispatch` on Enroll click)

**Task 2 — CourseService & NgRx-connected CourseList**
- `CourseService` tested with `HttpClientTestingModule` — GET response assertion + 500 error after `retry(2)`
- `CourseList` tested with `provideMockStore` — rendered cards match initial state + loading indicator visibility

| All tests passing | Code coverage report |
|---|---|
| ![tests passing](Angular_HandsOn/LuckySharma/Screenshots/handson10-alltests-passing.png) | ![coverage](Angular_HandsOn/LuckySharma/Screenshots/handson10-coveragereport.png) |

---

## Summary

| # | Hands-On | Status |
|---|---|---|
| 1 | Environment Setup & First Component | ✅ |
| 2 | Data Binding, Lifecycle Hooks & Communication | ✅ |
| 3 | Directives & Pipes | ✅ |
| 4 | Template-Driven Forms | ✅ |
| 5 | Reactive Forms | ✅ |
| 6 | Services & Dependency Injection | ✅ |
| 7 | Routing, Guards & Lazy Loading | ✅ |
| 8 | HTTP Client, RxJS & Interceptors | ✅ |
| 9 | NgRx State Management | ✅ |
| 10 | Unit Testing | ✅ |

All 10 hands-on exercises are complete and verified through the browser, Redux DevTools, Postman, and an automated test suite. Full step-by-step implementation notes are available in [`notes.txt`](./Angular_HandsOn/LuckySharma/student-course-portal/notes.txt) inside the project folder.