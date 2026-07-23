import { Directive, HostListener, HostBinding, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class Highlight {
  @Input() appHighlight = 'yellow';

  @HostBinding('style.backgroundColor') bgColor: string = '';

  @HostListener('mouseenter') onMouseEnter() {
    this.bgColor = this.appHighlight;
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.bgColor = '';
  }
}