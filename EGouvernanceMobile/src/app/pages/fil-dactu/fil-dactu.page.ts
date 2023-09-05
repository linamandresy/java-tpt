import { Component, OnInit } from '@angular/core';
import { InfiniteScrollCustomEvent } from '@ionic/angular';
import { ActuService } from 'src/app/services/actu.service';

@Component({
  selector: 'app-fil-dactu',
  templateUrl: './fil-dactu.page.html',
  styleUrls: ['./fil-dactu.page.scss'],
})
export class FilDActuPage implements OnInit {
  actus: Array<any> = new Array<any>();
  page: number = 0;
  constructor(
    private actuService: ActuService
  ) { }

  ngOnInit() {
    this.initActu();
  }

  initActu() {
    return new Promise((resolve, reject) => {
      this.actuService.getPaginatedActu(this.page).subscribe(
        (data: any) => {
          if (data.status == 200) {
            for (let index = 0; index < data.content.length; index++) {
              this.actus.push(data.content[index]);
            }
            resolve(true);
          }
          resolve(false);
        }, (err) => {
          resolve(false);
        }
      )
    });
  }

  loadMore(event: any) {
    this.page++;
    this.initActu().then(()=>{
      (event as InfiniteScrollCustomEvent).target.complete();
    });

  }
}
