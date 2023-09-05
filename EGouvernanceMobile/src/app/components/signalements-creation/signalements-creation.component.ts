import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PhotoService } from 'src/app/services/photo.service';
import { SignalementService } from 'src/app/services/signalement.service';

@Component({
  selector: 'app-signalements-creation',
  templateUrl: './signalements-creation.component.html',
  styleUrls: ['./signalements-creation.component.scss'],
})
export class SignalementsCreationComponent  implements OnInit {
  image:Array<string> = new Array<string>() ;
  title:string="";
  subTitle:string="";
  description:string="";
  constructor(
    private photoService:PhotoService,
    private signalementService:SignalementService,
    private router:Router
  ) { }

  async ngOnInit() {
  }

  takePicture(){
    this.photoService.takePicture().then((img:string)=>{
      if(img!==""){
        this.image.push(img);
      }
    });
  }

  createSignalement(){
    this.signalementService.createSignalement(this.title,this.subTitle,this.description,this.image).subscribe(
      (data:any)=>{
        this.router.navigateByUrl('/signalements')
      },
      (err:any)=>{
        this.router.navigateByUrl('/signalements')
      }
    )
  }
}
