import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SondageService {

  constructor(
    private http:HttpClient
  ) { }

  getSondage(id:string){
    return this.http.get(`${environment.url_java}/sondage/${id}`);
  }

  createSondageCitizen(idSondage:string,idOption:string){
    let data:any ={
      idSondage:idSondage,
      idOption:idOption
    };

    return this.http.post(`${environment.url_java}/sondage-citizen`,data,{
      headers:{
        "Authorization":`Bearer ${localStorage.getItem(environment.SESSION_JWT_TOKEN_NAME)}`
      }
    });
  }
}
