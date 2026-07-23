import { Injectable } from '@angular/core';

@Injectable()   // No providedIn: 'root' — available only where explicitly provided
export class NotificationService {
  private messages: string[] = [];

  addMessage(msg: string) {
    this.messages.push(msg);
  }

  getMessages(): string[] {
    return this.messages;
  }
}