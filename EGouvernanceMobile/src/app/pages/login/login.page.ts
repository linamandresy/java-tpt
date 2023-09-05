import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  username: string = "";
  password: string = "";
  error_message: string = "";
  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() { }

  login(): void {
    this.auth.login(this.username, this.password).subscribe(
      (data) => {
        if (data.status == 200) {
          let session = data.content;
          localStorage.setItem(environment.SESSION_JWT_TOKEN_NAME, session);
          this.router.navigate(['/']);
        } else {
          this.error_message = data.content;
        }
      }, (err) => {
        this.error_message = err.content;
      }
    )
  }
}
