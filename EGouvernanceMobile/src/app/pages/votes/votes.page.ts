import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ScannerqrService } from 'src/app/services/scannerqr.service';
import { SondageService } from 'src/app/services/sondage.service';

@Component({
  selector: 'app-votes',
  templateUrl: './votes.page.html',
  styleUrls: ['./votes.page.scss'],
})
export class VotesPage implements OnInit {

  info:any;
  idSondage:string="";
  // idSondage:string="b2b9e5f3-6109-4a2c-b097-a85f999f692a";
  idOption:string ="";
  constructor(
    private scanQrSercive:ScannerqrService,
    private sondageService:SondageService,
    private router:Router
  ) { }

  ngOnInit() {
    this.scanQrSercive.scan().then((data)=>{
      this.idSondage=data;
      this.sondageService.getSondage(this.idSondage).subscribe(
        (data:any)=>{
          if(data.status==200){
            this.info = data.content;
          }
        },(err:any)=>{
          this.router.navigateByUrl('/');
        }
      );

    });
  }

  voter(){
    this.sondageService.createSondageCitizen(this.idSondage,this.idOption).subscribe(
      (data:any)=>{
        this.router.navigateByUrl('/');
      },(err:any)=>{
        this.router.navigateByUrl('/');
      }
    )  
  }
}
