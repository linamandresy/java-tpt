import { Component, OnInit } from '@angular/core';
import { InfiniteScrollCustomEvent } from '@ionic/angular';
import { SignalementService } from 'src/app/services/signalement.service';

@Component({
  selector: 'app-signalements',
  templateUrl: './signalements.page.html',
  styleUrls: ['./signalements.page.scss'],
})
export class SignalementsPage implements OnInit {
  signalement: Array<any> = new Array<any>();
  page: number = 0;
  constructor(
    private signalementService: SignalementService
  ) { }

  ngOnInit() {
    this.initSignalement();
  }

  initSignalement() {
    return new Promise((resolve, reject) => {
      this.signalementService.getPaginateSignalement(this.page).subscribe(
        (data: any) => {
          if (data.status == 200) {
            for (let index = 0; index < data.content.length; index++) {
              this.signalement.push(data.content[index]);
            }
            console.log(this.signalement);
            resolve(true);
          }
          resolve(false);
        }, (err) => {
          resolve(false);
        }
      );
    });
  }
  loadMore(event:any){
    this.page++;
    this.initSignalement().then(()=>{
      (event as InfiniteScrollCustomEvent).target.complete();
    });
  }
}
