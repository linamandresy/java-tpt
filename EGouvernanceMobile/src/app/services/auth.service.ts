import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http:HttpClient
  ) { }

  login(username:string,password:string):Observable<any> {
    let form = new FormData();
    form.append('login',username);
    form.append('password',password);
    console.log(`${environment.url_java}/users/authenticate`)
    return this.http.post(`${environment.url_java}/users/authenticate`,form);
  }

  authValid():Promise<boolean>{
    return new Promise((resolve,reject)=>{
      this.http.get(`${environment.url_java}/users/valid-session`,{
        headers:{
          'Authorization':`Bearer ${localStorage.getItem(environment.SESSION_JWT_TOKEN_NAME)}`
        }
      }).subscribe(
          (data:any)=>{
            if(data.status==200){
              resolve(data.content);
            }else{
              resolve(false);
            }
      },(err:any)=>{
        resolve(false);
      })
    });
  }
}
