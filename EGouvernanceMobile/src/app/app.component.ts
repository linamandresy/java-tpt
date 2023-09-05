import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: `Fil d'actualité`, url: '/fil-dactu', icon: 'home' },
    // { title: 'Calendrier', url: '/folder/outbox', icon: 'calendar-number' },
    { title: 'Signalement', url: '/signalements', icon: 'alert-circle' },
    { title: 'Votes', url: '/votes', icon: 'archive' },
    // { title: 'Trash', url: '/folder/trash', icon: 'trash' },
    // { title: 'Spam', url: '/folder/spam', icon: 'warning' },
  ];
  public labels = ['Family', 'Friends', 'Notes', 'Work', 'Travel', 'Reminders'];
  constructor() {}
}
