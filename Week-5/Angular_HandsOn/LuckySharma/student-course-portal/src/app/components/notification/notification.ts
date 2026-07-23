import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification';

@Component({
  selector: 'app-notification',
  imports: [CommonModule],
  templateUrl: './notification.html',
  styleUrl: './notification.css',
  // Component-level provider: creates a NEW, separate instance of
  // NotificationService scoped only to this component (and its children).
  // Unlike providedIn: 'root' (one app-wide singleton), each instance of
  // NotificationComponent gets its own isolated NotificationService —
  // useful when state should not leak between multiple usages of the
  // same component (e.g. multiple independent notification panels).
  providers: [NotificationService]
})
export class Notification {
  constructor(private notificationService: NotificationService) {}

  addNotification() {
    this.notificationService.addMessage('Test notification at ' + new Date().toLocaleTimeString());
  }

  get messages() {
    return this.notificationService.getMessages();
  }
}